/*
	FOADA
    Copyright (C) 2018  Xiao XU & Radu IOSIF

	This file is part of FOADA.

    FOADA is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    
    If you have any questions, please contact Xiao XU <xiao.xu.cathiec@gmail.com>.
*/

package structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.sosy_lab.common.NativeLibraries;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.FormulaType;
import org.sosy_lab.java_smt.api.FunctionDeclaration;
import org.sosy_lab.java_smt.api.IntegerFormulaManager;
import org.sosy_lab.java_smt.api.InterpolatingProverEnvironment;
import org.sosy_lab.java_smt.api.NumeralFormula.IntegerFormula;
import org.sosy_lab.java_smt.api.ProverEnvironment;
import org.sosy_lab.java_smt.api.QuantifiedFormulaManager;
import org.sosy_lab.java_smt.api.SolverContext;
import org.sosy_lab.java_smt.api.SolverException;
import org.sosy_lab.java_smt.api.UFManager;
import org.sosy_lab.java_smt.api.visitors.FormulaVisitor;

import exception.FOADAException;
import exception.InterpolatingProverEnvironmentException;
import exception.JavaSMTInvalidConfigurationException;
import structure.FOADAExpression.ExpressionType;

public class Automaton {
	
	/** name of the automaton
	 */
	private String name;
	
	/** rename map used for replacing all the variable/function/symbol names by simpler standard names
	 */
	private Map<String, String> renameMap;
	
	/** rename map recording the simpler standard names to their original names
	 */
	private Map<String, String> renameMap2;
	
	/** set of event symbols
	 */
	private List<String> eventSymbols;
	
	/** set of variables
	 */
	private List<String> variables;
	
	/** map of variables to their types
	 */
	private Map<String, ExpressionType> variableTypeMap;
	
	/** set of predicates
	 */
	private List<String> predicates;
	
	/** map of predicates to their arguments' types
	 */
	private Map<String, List<ExpressionType>> predicateArgumentsTypesMap;
	
	/** initial state
	 */
	private FOADAExpression initialState;
	
	/** set of final states
	 */
	private List<String> finalStates;
	
	/** set of transitions (key = predicate + symbol)
	 */
	private Map<String, FOADAExpression> transitions;
	
	/** solver context
	 */
	private SolverContext solverContext;
	private FormulaManager fmgr;
	private BooleanFormulaManager bmgr;
	private IntegerFormulaManager imgr;
	private QuantifiedFormulaManager qmgr;
	private UFManager ufmgr;
	
	/** default constructor
	 * @param	name	name of the automaton
	 * @throws	InvalidConfigurationException 
	 */
	public Automaton(String name)
			throws FOADAException
	{
		this.name = name;
		renameMap = new LinkedHashMap<String, String>();
		renameMap2 = new LinkedHashMap<String, String>();
		eventSymbols = new ArrayList<String>();
		variables = new ArrayList<String>();
		variableTypeMap = new LinkedHashMap<String, ExpressionType>();
		predicates = new ArrayList<String>();
		predicateArgumentsTypesMap = new LinkedHashMap<String, List<ExpressionType>>();
		initialState = null;
		finalStates = new ArrayList<String>();
		transitions = new LinkedHashMap<String, FOADAExpression>();
		try {
			solverContext = SolverContextFactory.createSolverContext(Solvers.Z3);
			fmgr = solverContext.getFormulaManager();
			bmgr = fmgr.getBooleanFormulaManager();
			imgr = fmgr.getIntegerFormulaManager();
			qmgr = fmgr.getQuantifiedFormulaManager();
			ufmgr = fmgr.getUFManager();
		}
		catch(InvalidConfigurationException e)
		{
			throw new JavaSMTInvalidConfigurationException(e);
		}
	}
	
	/** set initial state
	 * @param	initialState	given initial state
	 */
	public void setInitialState(FOADAExpression initialState)
	{
		this.initialState = initialState;
	}
	
	/** set final states
	 * @param	finalStates	given set of final states
	 */
	public void setFinalStates(List<String> finalStates)
	{
		this.finalStates.addAll(finalStates);
	}
	
	/** add a transition
	 * @param	predicate		predicate (left part) in the transition
	 * @param	listOfArguments	list of arguments of left predicate in the transition
	 * @param	symbol			event symbol in the transition
	 * @param	variables		variables' names in the transition
	 * @param	post			post expression (right part) in the transition
	 */
	public void addTransition(String predicate, List<String> arguments, List<ExpressionType> argumentsTypes, String eventSymbol, List<String> variables, List<ExpressionType> variablesTypes, FOADAExpression post)
	{
		// rename predicates
		List<String> predicatesToBeRenamed = new ArrayList<String>();
		predicatesToBeRenamed.add(predicate);
		predicatesToBeRenamed.addAll(post.getPredicates());
		for(String s : predicatesToBeRenamed) {
			
			addPredicate(s);
			post.substitue(s, renameMap.get(s));
		}
		// rename event symbols
		addEventSymbol(eventSymbol);
		// rename variables and add variables and their types
		for(int i = 0; i < variables.size(); i++) {
			if(this.variables.isEmpty()) {
				this.variables.add("v" + i);
				variableTypeMap.put("v" + i, variablesTypes.get(i));
			}
			post.substitue(variables.get(i), "v" + i);
		}
		// rename arguments of predicates
		for(int i = 0; i < arguments.size(); i++) {
			post.substitue(arguments.get(i), "a" + i);
		}
		// add predicate and its arguments' types into map
		String newName = renameMap.get(predicate);
		if(!predicateArgumentsTypesMap.containsKey(newName)) {
			predicateArgumentsTypesMap.put(newName, argumentsTypes);
		}
		// add transition
		transitions.put(renameMap.get(predicate) + '+' + renameMap.get(eventSymbol), post);
		//System.out.println(renameMap.get(predicate) + '+' + renameMap.get(eventSymbol) + "   --->   " + post);
	}
	
	/** rename a predicate and then add it into the set of predicates (do nothing if already added)
	 * @param	predicate	name of the predicate
	 */
	public void addPredicate(String predicate)
	{
		if(!renameMap.containsKey(predicate)) {
			String newName = "q" + predicates.size();
			renameMap.put(predicate, newName);
			renameMap2.put(newName, predicate);
			predicates.add(newName);
			initialState.substitue(predicate, newName);
			for(int i = 0; i < finalStates.size(); i++) {
				if(finalStates.get(i).equals(predicate)) {
					finalStates.set(i, newName);
				}
			}
		}
	}
	
	/** rename a event symbol and then add it into the set of event symbols (do nothing if already added)
	 * @param	eventSymbol	name of the event symbol
	 */
	public void addEventSymbol(String eventSymbol)
	{
		if(!renameMap.containsKey(eventSymbol)) {
			String newName = "s" + eventSymbols.size();
			renameMap.put(eventSymbol, newName);
			renameMap2.put(newName, eventSymbol);
			eventSymbols.add(newName);
		}
	}
	
	/** replace all the event symbols and predicates in a string by their original names
	 * @param	stringWithNewNames	the string to be modified
	 */
	public String toOriginalNames(String stringWithNewNames)
	{
		String result = stringWithNewNames;
		// change event symbols back to the original names
		for(int i = eventSymbols.size() - 1; i >= 0; i--) {
			String eventSymbol = eventSymbols.get(i);
			if(result.contains(eventSymbol)) {
				result = result.replace(eventSymbol, renameMap2.get(eventSymbol));
			}
		}
		// change predicates back to the original names
		for(int i = predicates.size() - 1; i >= 0; i--) {
			String predicate = predicates.get(i);
			if(result.contains(predicate)) {
				result = result.replace(predicate, renameMap2.get(predicate));
			}
		}
		return result;
	}
	
	/** add time-stamps on the variables and the predicates in a Boolean formula
	 * @param	expression		the original Boolean formula
	 * @param	timeStamp		the time-stamp to be added
	 * @param	freeVariables	the free variables in the original Boolean formula
	 * @return	the Boolean formula after adding time-stamps
	 */
	public BooleanFormula addTimeStamps(BooleanFormula expression, Set<String> predicates, int timeStamp)
	{
		BooleanFormula result = expression;
		String resultToString = fmgr.dumpFormula(result).toString();
		// add time-stamps on variables
		for(String s : variables) {
			resultToString = resultToString.replace(s, s + '_' + timeStamp);
		}
		// add time-stamps on predicates
		for(String s : predicates) {
			resultToString = resultToString.replace(s, s + '_' + timeStamp);
		}
		result = fmgr.parse(resultToString);
		return result;
	}
	
	/** remove all the time-stamps on the variables and the predicates in a Boolean formula
	 * @param	expression	the original Boolean formula
	 * @return	the Boolean formula after removing time-stamps
	 */
	public BooleanFormula removeTimeStamps(BooleanFormula expression)
	{
		BooleanFormula result = expression;
		String resultToString = fmgr.dumpFormula(result).toString();
		for(String s : fmgr.extractVariablesAndUFs(result).keySet()) {
			if(s.contains("_") && s.charAt(0) != 'v') {
				resultToString = resultToString.replace(s, s.substring(0, s.indexOf("_")));
			}
		}
		result = fmgr.parse(resultToString);
		return result;
	}
	
	/** check the validity of an implication <b> f1 -> f2 </b>
	 * @param	f1	first Boolean formula
	 * @param	f2	second Boolean formula
	 */
	public boolean implies(BooleanFormula f1, BooleanFormula f2)
			throws FOADAException
	{
		BooleanFormula implication = bmgr.implication(f1, f2);
		ProverEnvironment prover = solverContext.newProverEnvironment();
		BooleanFormula notImplication = bmgr.not(implication);
		prover.addConstraint(notImplication);
		boolean isUnsat;
		boolean implicationIsValid = false;
		try {
			isUnsat = prover.isUnsat();
			if(isUnsat) {
				implicationIsValid = true;
			}
			else {
				implicationIsValid = false;
			}
		}
		catch (SolverException e) {
			throw new InterpolatingProverEnvironmentException(e);
		}
		catch (InterruptedException e) {
			throw new InterpolatingProverEnvironmentException(e);
		}
		prover.close();
		return implicationIsValid;
	}
	
	/** check if the automaton is empty
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty()
			throws FOADAException
	{	
	// start with the initial state
		// configuration number (starting from 0)
		int configurationNumber = 0;
		// create node(configuration) for the initial state
		FOADAConfiguration initialConfiguration = new FOADAConfiguration(configurationNumber++, (BooleanFormula)initialState.toJavaSMTFormula(fmgr), null, null);
	// start working with workList
		// create workList
		List<FOADAConfiguration> workList = new ArrayList<FOADAConfiguration>();
		// add the initial node(configuration) into workList
		workList.add(initialConfiguration);
		// looped working with workList until it becomes empty
		while(!workList.isEmpty()) {
		// pick the currentNode
			// pick the first node of workList
			FOADAConfiguration currentNode = workList.get(0);
			/***************/ System.out.println(currentNode);
			// remove the first node from workList
			workList.remove(0);
		// calculate the path from the initial node to the currentNode
			// create a new list for symbols along the path
			List<String> pathFromInitialToCurrent = new ArrayList<String>();
			// create "c" for the loop and initialize it to currentNode
			FOADAConfiguration c = currentNode;
			// looped working for finding the path (end if father node is null)
			while(c.fatherSymbol != null) {
				// add the father symbol in the beginning (position index = 0) of the list
				pathFromInitialToCurrent.add(0, c.fatherSymbol);
				// set "c" to the father node(configuration)
				c = c.father;
			}
			/***************/ System.out.println("\tpath : " + pathFromInitialToCurrent);
		// determine whether currentNode is accepted
			// create a new list for blocks of time-stamped conjunctions in the path formula
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// make the initial state time-stamped
			BooleanFormula timeStampedInitialState = addTimeStamps(initialConfiguration.expression, initialState.getPredicates(), 0);
			// add time-stamped initial state into the blocks
			blocks.add(timeStampedInitialState);
			// create a new set for the predicates in the current block
			Set<String> predicatesInCurrentBlock = initialState.getPredicates();
			// create an integer indicating the current time-stamp
			int currentTimeStamp = 0;
			// compute next blocks (except the last block) according to the path
			for(String a : pathFromInitialToCurrent) {
				// create a new list for the small parts (of conjunction) of the new block
				List<BooleanFormula> block = new ArrayList<BooleanFormula>();
				// create a new set for the predicates in the new block
				Set<String> predicatesInNewBlock = new HashSet<String>();
				// compute one part of the new block
				for(String s : predicatesInCurrentBlock) {
					// create a new list for the types of the arguments of the predicate
					List<ExpressionType> argumentsTypes = predicateArgumentsTypesMap.get(s);
					// create a new list for the arguments of the predicate
					List<Formula> arguments = new ArrayList<Formula>();
					// compute the list of arguments
					int argumentIndex = 0;
					for(ExpressionType t : argumentsTypes) {
						Formula argument;
						if(t == ExpressionType.Integer) {
							argument = ufmgr.declareAndCallUF("a" + argumentIndex, FormulaType.IntegerType);
							argumentIndex++;
						}
						else {
							argument = ufmgr.declareAndCallUF("a" + argumentIndex, FormulaType.BooleanType);
							argumentIndex++;
						}
						arguments.add(argument);
					}
					// create the left part of the universally-quantified implication (with time-stamp)
					BooleanFormula left = ufmgr.declareAndCallUF(s + '_' + currentTimeStamp, FormulaType.BooleanType, arguments);
					// create the right part of the universally-quantified implication without time-stamp
					FOADAExpression rightWithoutTimeStamps = transitions.get(s + '+' + a);
					// create a new set for the predicates in the current part of the new block
					Set<String> predicatesInCurrentPart = rightWithoutTimeStamps.getPredicates();
					// add the predicates in the current part into the set of predicates in the new block
					for(String s2 : predicatesInCurrentPart) {
						predicatesInNewBlock.add(s2);
					}
					// create the right part of the universally-quantified implication with time-stamp
					BooleanFormula right = addTimeStamps((BooleanFormula)rightWithoutTimeStamps.toJavaSMTFormula(fmgr), predicatesInCurrentPart, currentTimeStamp + 1);
					// create the implication without quantifier
					BooleanFormula implication = bmgr.implication(left, right);
					// directly add the implication into the new block as one part of the conjunction if no argument
					if(arguments.isEmpty()) {
						block.add(implication);
					}
					// add universally-quantified implication into the new block as one part of the conjunction if there're arguments
					else {
						BooleanFormula universallyQuantifiedImplication = qmgr.forall(arguments, implication);
						block.add(universallyQuantifiedImplication);
					}
				}
			// add the new block into the list of blocks
				// add true into the list of blocks if the new block is empty
				if(block.isEmpty()) {
					blocks.add(bmgr.makeBoolean(true));
				}
				// and the new block into the list of blocks if it is not empty
				else {
					blocks.add(bmgr.and(block));
				}
			// refresh for the next round
				// refresh the current time-stamp
				currentTimeStamp++;
				// refresh the set of predicates in the current block
				predicatesInCurrentBlock = predicatesInNewBlock;
			}
		// compute the last block containing the final conjunction according to the set of final states
			// create a new list for the final conjunction
			List<BooleanFormula> finalConjunction = new ArrayList<BooleanFormula>();
			for(String s : predicatesInCurrentBlock) {
				// create a new list for the types of the arguments of the predicate
				List<ExpressionType> argumentsTypes = predicateArgumentsTypesMap.get(s);
				// create a new list for the arguments of the predicate
				List<Formula> arguments = new ArrayList<Formula>();
				// compute the list of arguments
				int argumentIndex = 0;
				for(ExpressionType t : argumentsTypes) {
					Formula argument;
					if(t == ExpressionType.Integer) {
						argument = ufmgr.declareAndCallUF("a" + argumentIndex, FormulaType.IntegerType);
						argumentIndex++;
					}
					else {
						argument = ufmgr.declareAndCallUF("a" + argumentIndex, FormulaType.BooleanType);
						argumentIndex++;
					}
					arguments.add(argument);
				}
				// create the left part of the universally-quantified implication (with time-stamp)
				BooleanFormula left = ufmgr.declareAndCallUF(s + '_' + currentTimeStamp, FormulaType.BooleanType, arguments);
				// implies true if is final state
				if(finalStates.contains(s)) {
					// create the implication without quantifier
					BooleanFormula implication = bmgr.implication(left, bmgr.makeBoolean(true));
					// directly add the implication into the final conjunction if no argument
					if(arguments.isEmpty()) {
						finalConjunction.add(implication);
					}
					// add universally-quantified implication into the final conjunction if there're arguments
					else {
						BooleanFormula universallyQuantifiedImplication = qmgr.forall(arguments, implication);
						finalConjunction.add(universallyQuantifiedImplication);
					}
				}
				// implies false if is final state
				else {
					// create the implication without quantifier
					BooleanFormula implication = bmgr.implication(left, bmgr.makeBoolean(false));
					// directly add the implication into the final conjunction if no argument
					if(arguments.isEmpty()) {
						finalConjunction.add(implication);
					}
					// add universally-quantified implication into the final conjunction if there're arguments
					else {
						BooleanFormula universallyQuantifiedImplication = qmgr.forall(arguments, implication);
						finalConjunction.add(universallyQuantifiedImplication);
					}
				}
			}
		// add the last block into the list of blocks
			// add true into the list of blocks if the final conjunction is empty
			if(finalConjunction.isEmpty()) {
				blocks.add(bmgr.makeBoolean(true));
			}
			// add the final conjunction into the list of blocks if it is not empty
			else {
				blocks.add(bmgr.and(finalConjunction));
			}
		// check if the conjunction of all blocks is satisfiable or compute the interpolants
			/***************/ System.out.println("\tBlocks:");
			/***************/ for(BooleanFormula f : blocks) {
			/***************/ 	System.out.println("\t\t" + f);
			/***************/ }
			@SuppressWarnings("rawtypes")
			// create prover environment for interpolation
			InterpolatingProverEnvironment prover = solverContext.newProverEnvironmentWithInterpolation();
			// create a new list for sets of objects received when pushing different partitions into the prover
			List<Set<Object>> listPartitions = new ArrayList<Set<Object>>();
			// each block is a partition
			for(BooleanFormula f : blocks) {
				// create a set for objects received when pushing different partitions into the prover
				Set<Object> partitionProverPushObjects = new HashSet<Object>();
				// push the partition (block) into the prover and add the received object into the set
				partitionProverPushObjects.add(prover.push(f));
				// add the set into the list
				listPartitions.add(partitionProverPushObjects);
			}
			// check whether the conjunction of all blocks is unsatisfiable
			try {
				// compute the interpolants if it is not satisfiable
				if(prover.isUnsat()) {
					/***************/ System.out.println("\tInterpolants:");
					@SuppressWarnings("unchecked")
					// compute the interpolants (with time-stamps)
					List<BooleanFormula> interpolantsWithTimeStamps = prover.getSeqInterpolants(listPartitions);
					List<BooleanFormula> interpolants = new ArrayList<BooleanFormula>();
					// remove the time-stamps from the interpolants
					for(BooleanFormula f : interpolantsWithTimeStamps) {
						interpolants.add(removeTimeStamps(f));
					}
				// refine the nodes among the path
					// starting from the root node
					FOADAConfiguration currentNodeAmongPath = initialConfiguration;
					int step = 0;
					// loop check the path
					while(true) {
						// get the corresponding interpolant according to the current step
						BooleanFormula interpolant = interpolants.get(step);
						// get the expression in the current node
						BooleanFormula current = currentNodeAmongPath.expression;
						/***************/ System.out.println("\t\t" + interpolant);
						// check the validity of the implication: current -> interpolant
						boolean implicationIsValid = implies(current, interpolant);
						/***************/ System.out.println("\t\t\tchecking: " + current + " -> " + interpolant + "   {" + implicationIsValid + '}');
						// if the implication if not valid
						if(!implicationIsValid) {
							// refine the node by making a conjunction
							currentNodeAmongPath.expression = bmgr.and(current, interpolant);
							// TODO close the node
							
						}
						// if finish looping the path
						if(step >= pathFromInitialToCurrent.size()) {
							break;
						}
						// if not finish looping the path
						else {
							// refresh the current node among the path
							int indexOfSuccessor = currentNodeAmongPath.successorSymbolIndexMap.get(pathFromInitialToCurrent.get(step));
							currentNodeAmongPath = currentNodeAmongPath.successors.get(indexOfSuccessor);
							// refresh the current step
							step++;
						}
					}
				}
				// print out the model and return false if it is satisfiable
				else {
					/***************/ System.out.println("SAT");
					/***************/ System.out.println(toOriginalNames(prover.getModel().toString()));
					///***************/ System.out.println(prover.getModel().toString());
					return false;
				}
			// expand the current node if it is not covered
				// TODO need to add coverage check
				if(true) {
					// try all the event symbols
					for(String a : eventSymbols) {
						///***************/ System.out.println("\tExpand with " + a + ':');
						FOADAConfiguration newNode = new FOADAConfiguration(configurationNumber++, bmgr.makeBoolean(true), currentNode, a);
						currentNode.addSuccessor(a, newNode);
						///***************/ System.out.println("\t\t" + newNode);
						workList.add(newNode);
					}
				}
			}
			catch (SolverException e) {
				throw new InterpolatingProverEnvironmentException(e);
			}
			catch (InterruptedException e) {
				throw new InterpolatingProverEnvironmentException(e);
			}
		}
		return true;
	}

}
