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
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.FormulaType;
import org.sosy_lab.java_smt.api.InterpolatingProverEnvironment;
import org.sosy_lab.java_smt.api.Model.ValueAssignment;
import org.sosy_lab.java_smt.api.ProverEnvironment;
import org.sosy_lab.java_smt.api.QuantifiedFormulaManager;
import org.sosy_lab.java_smt.api.SolverContext;
import org.sosy_lab.java_smt.api.SolverException;
import org.sosy_lab.java_smt.api.UFManager;
import exception.FOADAException;
import exception.InterpolatingProverEnvironmentException;
import exception.JavaSMTInvalidConfigurationException;
import structure.FOADAExpression.ExpressionType;
import utility.Console;
import utility.Console.ConsoleType;

public class Automaton {
	
	/** name of the automaton
	 */
	//private String name;
	
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
	//private IntegerFormulaManager imgr;
	private QuantifiedFormulaManager qmgr;
	private UFManager ufmgr;
	
	/** default constructor
	 * @param	name	name of the automaton
	 * @throws	InvalidConfigurationException 
	 */
	public Automaton(String name)
			throws FOADAException
	{
		//this.name = name;
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
			//imgr = fmgr.getIntegerFormulaManager();
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
	
	/** get predicates (before renaming) from an expression
	 * 
	 */
	private Set<String> getPredicatesBeforeRenaming(FOADAExpression expression)
	{
		Set<String> predicates = new HashSet<String>();
		switch(expression.category)
		{
		case Constant:	break;
		case Function:	if(expression.type == ExpressionType.Boolean) {
							predicates.add(expression.name);
						}
						break;
		case Exists:	predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Forall:	predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Not:		predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;	
		case And:		for(FOADAExpression e : expression.subData) {
							predicates.addAll(getPredicatesBeforeRenaming(e));
						}
						break;
		case Or:		for(FOADAExpression e : expression.subData) {
							predicates.addAll(getPredicatesBeforeRenaming(e));
						}
						break;
		case Equals:	predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(0)));
						predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(1)));
						break;
		case Distincts:	predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(0)));
						predicates.addAll(getPredicatesBeforeRenaming(expression.subData.get(1)));
						break;
		}
		return predicates;
	}
	
	/** get predicates (after renaming) from an expression
	 * 
	 */
	private Set<String> getPredicatesAfterRenaming(FOADAExpression expression)
	{
		Set<String> predicates = new HashSet<String>();
		switch(expression.category)
		{
		case Constant:	break;
		case Function:	if(expression.type == ExpressionType.Boolean && expression.name.charAt(0) == 'q') {
							predicates.add(expression.name);
						}
						break;
		case Exists:	predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Forall:	predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Not:		predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(expression.subData.size() - 1)));
						break;	
		case And:		for(FOADAExpression e : expression.subData) {
							predicates.addAll(getPredicatesAfterRenaming(e));
						}
						break;
		case Or:		for(FOADAExpression e : expression.subData) {
							predicates.addAll(getPredicatesAfterRenaming(e));
						}
						break;
		case Equals:	predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(0)));
						predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(1)));
						break;
		case Distincts:	predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(0)));
						predicates.addAll(getPredicatesAfterRenaming(expression.subData.get(1)));
						break;
		}
		return predicates;
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
		predicatesToBeRenamed.addAll(getPredicatesBeforeRenaming(post));
		for(String s : predicatesToBeRenamed) {
			
			addPredicate(s);
			post.substitue(s, renameMap.get(s));
		}
		// rename event symbols
		addEventSymbol(eventSymbol);
		// rename variables and add variables and their types
		for(int i = 0; i < variables.size(); i++) {
			if(this.variables.isEmpty()) {
				this.variables.add("v" + i + "c");
				variableTypeMap.put("v" + i + "c", variablesTypes.get(i));
			}
			post.substitue(variables.get(i), "v" + i + "c");
		}
		// rename arguments of predicates
		for(int i = 0; i < arguments.size(); i++) {
			post.substitue(arguments.get(i), "a" + i + "c");
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
			String newName = "q" + predicates.size() + "c";
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
	
	/** add time-stamps on the variables and the predicates in a Boolean formula
	 * @param	expression		the original Boolean formula
	 * @param	predicates		the set of predicates in the original Boolean formula
	 * @param	timeStamp		the time-stamp to be added
	 * @return	the Boolean formula after adding time-stamps
	 */
	private BooleanFormula addTimeStamps(BooleanFormula expression, Set<String> predicates, int timeStamp)
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
	private BooleanFormula removeTimeStamps(BooleanFormula expression)
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
	 * @return	<b> true </b> if f1 -> f2 </br>
	 * 			<b> false </b> if f1 doesn't imply f2
	 */
	private boolean implies(BooleanFormula f1, BooleanFormula f2)
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
	
	/** check if a node is covered
	 * @param	node			the node to be checked
	 * @param	beCoveredMap	the map of coverage (covered : coverers)
	 * @return	<b> true </b> if the node is covered </br>
	 * 			<b> false </b> if the node is not covered
	 */
	private boolean isCovered(FOADAConfiguration node, Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap)
	{
		for(FOADAConfiguration current = node; current != null; current = current.father) {
			if(beCoveredMap.containsKey(current)) {
				//System.out.println("\t\t#" + current.number + " $$$ " + beCoveredMap.get(current));
				return true;
			}
		}
		return false;
	}
	
	/** re-enable a node and all its successors (add them back to the work list)
	 * @param	print		the value is set to <b> true </b> if is going to print the important steps
	 * @param	node		the node to be re-enabled
	 * @param	workList	the work list
	 * @throws	FOADAException 
	 */
	private void reEnableWithAllSuccessors(boolean print, FOADAConfiguration node, Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap, List<FOADAConfiguration> workList)
			throws FOADAException
	{
		// re-enable the node
		if(node.successors.isEmpty() && !isCovered(node, beCoveredMap) && !implies(node.expression, bmgr.makeBoolean(false)) && !workList.contains(node)) {
			workList.add(0, node);
			/***************/ if(print) System.out.println("\tAdd back: #" + node.number);
		}
		// re-enable all the successors
		for(FOADAConfiguration successor : node.successors) {
			reEnableWithAllSuccessors(print, successor, beCoveredMap, workList);
		}
	}
	
	/** remove all the invalid coverage of a given node (re-check the previous coverage)
	 * @param	print			the value is set to <b> true </b> if is going to print the important steps
	 * @param	node			the node to be checked
	 * @param	coverOthersMap	the map of coverage (coverer : covered nodes)
	 * @param	beCoveredMap	the map of coverage (covered node : coverers)
	 * @param	workList		the work list
	 * @throws	FOADAException
	 */
	private void removeInvalidCoverage(boolean print, FOADAConfiguration node, Map<FOADAConfiguration, Set<FOADAConfiguration>> coverOthersMap, Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap, List<FOADAConfiguration> workList)
			throws FOADAException
	{
		Set<FOADAConfiguration> previouslyCoveredNodes = coverOthersMap.get(node);
		if(previouslyCoveredNodes != null) {
			List<FOADAConfiguration> toBeRemoved = new ArrayList<FOADAConfiguration>();
			// check all the nodes that are previously covered by the given node
			for(FOADAConfiguration covered : previouslyCoveredNodes) {
				// if a previously covered node (picking node) is not covered by the given node anymore
				if(!implies(covered.expression, node.expression)) {
					// remove the picking node from the set of nodes that are covered by the given node
					toBeRemoved.add(covered);
					// remove the given node from the set of coverers of the picking node
					beCoveredMap.get(covered).remove(node);
					// if the set of coverers of the picking node becomes empty
					if(beCoveredMap.get(covered).isEmpty()) {
						// remove the picking node from the map of coverage (covered node : coverers)
						beCoveredMap.remove(covered);
					}
					/***************/ if(print) System.out.println("\t#" + covered.number + " no longer covered by #" + node.number);
					// re-enable the previous covered node and all its successors
					reEnableWithAllSuccessors(print, covered, beCoveredMap, workList);
				}
			}
			for(FOADAConfiguration c : toBeRemoved) {
				coverOthersMap.get(node).remove(c);
			}
			// if the set of nodes that are covered by given node becomes empty (if the given node does not cover any other node)
			if(coverOthersMap.get(node).isEmpty()) {
				// remove the given node from the map of coverage (coverer : covered nodes)
				coverOthersMap.remove(node);
			}
		}
	}
	
	/** function close for the coverage
	 * @param	print					the value is set to <b> true </b> if is going to print the important steps
	 * @param	currentNodeAlongPath	the node to be closed
	 * @param	allNodes				set of all nodes
	 * @param	coverOthersMap			the map of coverage (coverer : covered nodes)
	 * @param	beCoveredMap			the map of coverage (covered node : coverers)
	 * @param	workList				the work list
	 * @return							<b> true </b> if successfully close the node </br>
	 * 									<b> false </b> if the node is not closed
	 * @throws	FOADAException
	 */
	private boolean close(boolean print, FOADAConfiguration currentNodeAlongPath, Set<FOADAConfiguration> allNodes, Map<FOADAConfiguration, Set<FOADAConfiguration>> coverOthersMap, Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap, List<FOADAConfiguration> workList)
			throws FOADAException
	{
		for(FOADAConfiguration targetNode : allNodes) {
			// pick a target node (which is not covered) from all nodes according to a certain order
			if(targetNode.number < currentNodeAlongPath.number && !isCovered(targetNode, beCoveredMap)) {
				// if the current node along path is covered by the target node
				if(implies(currentNodeAlongPath.expression, targetNode.expression)) {
					// remove all the coverage where the current node along path or any of its successors covers another
					List<FOADAConfiguration> toBeRemoved = new ArrayList<FOADAConfiguration>();
					for(Entry<FOADAConfiguration, Set<FOADAConfiguration>> e : coverOthersMap.entrySet()) {
						FOADAConfiguration coverer = e.getKey();
						if(coverer.isSuccessorOf(currentNodeAlongPath)) {
							for(FOADAConfiguration covered : e.getValue()) {
								beCoveredMap.get(covered).remove(coverer);
								if(beCoveredMap.get(covered).isEmpty()) {
									beCoveredMap.remove(covered);
								}
								/***************/ if(print) System.out.println("\t#" + covered.number + " no longer covered by #" + coverer.number);
								// re-enable the previous covered node and all its successors
								reEnableWithAllSuccessors(print, covered, beCoveredMap, workList);
							}
							toBeRemoved.add(coverer);
						}
					}
					for(FOADAConfiguration c2 : toBeRemoved) {
						coverOthersMap.remove(c2);
					}
					// add coverage where the current node along path is covered
					if(beCoveredMap.containsKey(currentNodeAlongPath)) {
						beCoveredMap.get(currentNodeAlongPath).add(targetNode);
					}
					else {
						Set<FOADAConfiguration> isCoveredBy = new HashSet<FOADAConfiguration>();
						isCoveredBy.add(targetNode);
						beCoveredMap.put(currentNodeAlongPath, isCoveredBy);
					}
					if(coverOthersMap.containsKey(targetNode)) {
						coverOthersMap.get(targetNode).add(currentNodeAlongPath);
					}
					else {
						Set<FOADAConfiguration> covers = new HashSet<FOADAConfiguration>();
						covers.add(currentNodeAlongPath);
						coverOthersMap.put(targetNode, covers);
					}
					/***************/ if(print) System.out.println("\t#" + currentNodeAlongPath.number + " covered by #" + targetNode.number);
					/***************/ if(print) System.out.println("\t#" + currentNodeAlongPath.number + " closed");
					return true;
				}
			}
		}
		return false;
	}
	
	/** check if the automaton is empty / BFS
	 * @param	print	the value is set to <b> true </b> if is going to print the important steps
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty1(boolean print)
			throws FOADAException
	{	
		long begintime = System.currentTimeMillis();
		int nodeVisited = 0;
	// start with the initial state
		// node (configuration) number (starting from 0)
		int configurationNumber = 0;
		// create node(configuration) for the initial state
		FOADAConfiguration initialConfiguration = new FOADAConfiguration(configurationNumber++, (BooleanFormula)initialState.toJavaSMTFormula(fmgr), null, null);
	// initialize the coverage management
		Map<FOADAConfiguration, Set<FOADAConfiguration>> coverOthersMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
		Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
	// initialize the set of nodes
		Set<FOADAConfiguration> allNodes = new HashSet<FOADAConfiguration>();
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
			/***************/ if(print) System.out.println(currentNode);
			// remove the first node from workList
			workList.remove(0);
			nodeVisited++;
			allNodes.add(currentNode);
		// calculate the path from the initial node to the currentNode
			// create a new list for symbols along the path
			List<String> pathFromInitialToCurrent = new ArrayList<String>();
			// create "c" for the loop and initialize it to currentNode
			FOADAConfiguration c = currentNode;
			// looped working for finding the path (end if father node is null)
			while(c.father != null) {
				// add the father symbol in the beginning (position index = 0) of the list
				pathFromInitialToCurrent.add(0, c.fatherSymbol);
				// set "c" to the father node(configuration)
				c = c.father;
			}
			/***************/ if(print) System.out.println("\tpath : " + pathFromInitialToCurrent);
		// determine whether currentNode is accepted
			// create a new list for blocks of time-stamped conjunctions in the path formula
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// make the initial state time-stamped
			BooleanFormula timeStampedInitialState = addTimeStamps(initialConfiguration.expression, getPredicatesAfterRenaming(initialState), 0);
			// add time-stamped initial state into the blocks
			blocks.add(timeStampedInitialState);
			// create a new set for the predicates in the current block
			Set<String> predicatesInCurrentBlock = getPredicatesAfterRenaming(initialState);
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
							argument = ufmgr.declareAndCallUF("a" + argumentIndex + "c", FormulaType.IntegerType);
							argumentIndex++;
						}
						else {
							argument = ufmgr.declareAndCallUF("a" + argumentIndex + "c", FormulaType.BooleanType);
							argumentIndex++;
						}
						arguments.add(argument);
					}
					// create the left part of the universally-quantified implication (with time-stamp)
					BooleanFormula left = ufmgr.declareAndCallUF(s + '_' + currentTimeStamp, FormulaType.BooleanType, arguments);
					// create the right part of the universally-quantified implication without time-stamp
					FOADAExpression rightWithoutTimeStamps = transitions.get(s + '+' + a);
					// if no corresponding transition
					if(rightWithoutTimeStamps == null) {
						rightWithoutTimeStamps = new FOADAExpression(false);
					}
					// create a new set for the predicates in the current part of the new block
					Set<String> predicatesInCurrentPart = getPredicatesAfterRenaming(rightWithoutTimeStamps);
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
						argument = ufmgr.declareAndCallUF("a" + argumentIndex + "c", FormulaType.IntegerType);
						argumentIndex++;
					}
					else {
						argument = ufmgr.declareAndCallUF("a" + argumentIndex + "c", FormulaType.BooleanType);
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
			//***************/ System.out.println("Blocks:");
			//***************/ for(BooleanFormula f : blocks) {
			//***************/ 	System.out.println(f);
			//***************/ }
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
					@SuppressWarnings("unchecked")
					// compute the interpolants (with time-stamps)
					List<BooleanFormula> interpolantsWithTimeStamps = prover.getSeqInterpolants(listPartitions);
					List<BooleanFormula> interpolants = new ArrayList<BooleanFormula>();
					// remove the time-stamps from the interpolants
					for(BooleanFormula f : interpolantsWithTimeStamps) {
						interpolants.add(removeTimeStamps(f));
					}
				// refine the nodes along the path
					// starting from the root node
					FOADAConfiguration currentNodeAlongPath = initialConfiguration;
					int step = 0;
					// loop check the path
					boolean oneNodeIsClosed = false;
					while(true) {
						// get the corresponding interpolant according to the current step
						BooleanFormula interpolant = interpolants.get(step);
						// get the expression in the current node
						BooleanFormula currentExpression = currentNodeAlongPath.expression;
						//***************/ System.out.println("\t\t" + interpolant);
						// check the validity of the implication: current -> interpolant
						boolean implicationIsValid = implies(currentExpression, interpolant);
						//***************/ System.out.println("\t\t\tchecking: " + current + " -> " + interpolant + "   {" + implicationIsValid + '}');
						// if the implication if not valid
						if(!implicationIsValid) {
							// refine the node by making a conjunction
							/***************/ if(print) System.out.print("\t#" + currentNodeAlongPath.number + " refined ");
							currentNodeAlongPath.expression = bmgr.and(currentExpression, interpolant);
							/***************/ if(print) System.out.println(" : " + currentNodeAlongPath.expression);
							// refresh the coverage (maybe the node does not cover another node anymore)
							removeInvalidCoverage(print, currentNodeAlongPath, coverOthersMap, beCoveredMap, workList);
							// close the current node along path
							if(!oneNodeIsClosed) {
								oneNodeIsClosed = close(print, currentNodeAlongPath, allNodes, coverOthersMap, beCoveredMap, workList);
							}
							if(implies(currentNodeAlongPath.expression, bmgr.makeBoolean(false))) {
								workList.remove(currentNodeAlongPath);
								/***************/ if(print) System.out.println("\t#" + currentNodeAlongPath.number + " removed (false node)");
							}
						}
						// if finish looping the path
						if(step >= pathFromInitialToCurrent.size()) {
							break;
						}
						// if not finish looping the path
						else {
							// refresh the current node along path
							int indexOfSuccessor = currentNodeAlongPath.successorSymbolIndexMap.get(pathFromInitialToCurrent.get(step));
							currentNodeAlongPath = currentNodeAlongPath.successors.get(indexOfSuccessor);
							// refresh the current step
							step++;
						}
					}
				}
				// print out the model and return false if it is satisfiable
				else {
					System.out.println("------------------------------\nSAT with sequence:");
					if(pathFromInitialToCurrent.size() == 0) {
						System.out.println("empty trace");
					}
					else {
						Object[][] variablesAssignments = new Object[pathFromInitialToCurrent.size()][variables.size()];
						for(Object a : prover.getModelAssignments()) {
							String expressionString = ((ValueAssignment)a).getKey().toString();
							if(expressionString.charAt(0) == 'v') {
								int lastIndexOfUnderscore = expressionString.lastIndexOf('_');
								int variableStep = Integer.valueOf(expressionString.substring(lastIndexOfUnderscore + 1));
								int variableIndex = Integer.valueOf(expressionString.substring(1, lastIndexOfUnderscore - 1));
								variablesAssignments[variableStep - 1][variableIndex] = ((ValueAssignment)a).getValue();
							}
						}
						for(int i1 = 0; i1 < pathFromInitialToCurrent.size(); i1++) {
							System.out.print(renameMap2.get((pathFromInitialToCurrent.get(i1))) + " \tDATA ::: { ");
							for(int i2 = 0; i2 < variables.size(); i2++) {
								System.out.print(variablesAssignments[i1][i2] == null ? "any " : variablesAssignments[i1][i2] + " ");
							}
							System.out.println('}');
						}
					}
					System.out.println("------------------------------");
					long endtime=System.currentTimeMillis();
					Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
					Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
					Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
					return false;
				}
			// expand the current node if it is not covered
				// check if the current node is covered, if not then expand it
				boolean notGoingToExpand = false;
				if(!currentNode.successors.isEmpty()) {
					/***************/ if(print) System.out.println("\tnot going to expand (already expanded)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand && isCovered(currentNode, beCoveredMap)) {
					/***************/ if(print) System.out.println("\tnot going to expand (covered)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand) {
					// try all the event symbols
					for(String a : eventSymbols) {
						//***************/ System.out.println("\tExpand with " + a + ':');
						FOADAConfiguration newNode = new FOADAConfiguration(configurationNumber++, bmgr.makeBoolean(true), currentNode, a);
						currentNode.addSuccessor(a, newNode);
						//***************/ System.out.println("\t\t" + newNode);
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
		long endtime=System.currentTimeMillis();
		Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
		Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
		Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
		return true;
	}
	
	/** take out all the predicates' occurrences from an expression
	 * @param	expression	the FOADA expression from which we take out the predicates' occurrences
	 * @return	a set containing all the predicates' occurrences
	 */
	Set<FOADAExpression> takePredicatesOccurrences(FOADAExpression expression)
	{
		Set<FOADAExpression> predicatesOccurrences = new HashSet<FOADAExpression>();
		switch(expression.category)
		{
		case Constant:	break;
		case Function:	if(expression.type == ExpressionType.Boolean && expression.name.charAt(0) == 'q') {
							predicatesOccurrences.add(expression);
						}
						break;
		case Exists:	predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Forall:	predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(expression.subData.size() - 1)));
						break;
		case Not:		predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(expression.subData.size() - 1)));
						break;	
		case And:		for(FOADAExpression e : expression.subData) {
							predicatesOccurrences.addAll(takePredicatesOccurrences(e));
						}
						break;
		case Or:		for(FOADAExpression e : expression.subData) {
							predicatesOccurrences.addAll(takePredicatesOccurrences(e));
						}
						break;
		case Equals:	predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(0)));
						predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(1)));
						break;
		case Distincts:	predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(0)));
						predicatesOccurrences.addAll(takePredicatesOccurrences(expression.subData.get(1)));
						break;
		}
		return predicatesOccurrences;
	}
	
	/** check if the automaton is empty using path quantifier elimination / BFS
	 * @param	print	the value is set to <b> true </b> if is going to print the important steps
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty2(boolean print)
			throws FOADAException
	{	
		long begintime = System.currentTimeMillis();
		int nodeVisited = 0;
	// start with the initial state
		// node (configuration) number (starting from 0)
		int configurationNumber = 0;
		// create node(configuration) for the initial state
		FOADAConfiguration initialConfiguration = new FOADAConfiguration(configurationNumber++, (BooleanFormula)initialState.toJavaSMTFormula(fmgr), null, null);
	// initialize the coverage management
		Map<FOADAConfiguration, Set<FOADAConfiguration>> coverOthersMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
		Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
	// initialize the set of nodes
		Set<FOADAConfiguration> allNodes = new HashSet<FOADAConfiguration>();
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
			/***************/ if(print) System.out.println(currentNode);
			// remove the first node from workList
			workList.remove(0);
			nodeVisited++;
			allNodes.add(currentNode);
		// calculate the path from the initial node to the currentNode
			// create a new list for symbols along the path
			List<String> pathFromInitialToCurrent = new ArrayList<String>();
			// create "c" for the loop and initialize it to currentNode
			FOADAConfiguration c = currentNode;
			// looped working for finding the path (end if father node is null)
			while(c.father != null) {
				// add the father symbol in the beginning (position index = 0) of the list
				pathFromInitialToCurrent.add(0, c.fatherSymbol);
				// set "c" to the father node(configuration)
				c = c.father;
			}
			/***************/ if(print) System.out.println("\tpath : " + pathFromInitialToCurrent);
		// determine whether currentNode is accepted
			// create a new list for blocks of time-stamped conjunctions in the path formula
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// make the initial state time-stamped
			FOADAExpression timeStampedInitialState = initialState.copy();
			timeStampedInitialState.addTimeStamps(0);
			// add time-stamped initial state into the blocks
			blocks.add((BooleanFormula)timeStampedInitialState.toJavaSMTFormula(fmgr));
			// create a new set for the predicates' occurrences in the current block
			Set<FOADAExpression> predicatesOccurrencesInCurrentBlock = takePredicatesOccurrences(timeStampedInitialState);
			// create an integer indicating the current time-stamp
			int currentTimeStamp = 0;
			// compute next blocks (except the last block) according to the path
			for(String a : pathFromInitialToCurrent) {
				// create a new list for the small parts (of conjunction) of the new block
				List<BooleanFormula> block = new ArrayList<BooleanFormula>();
				// create a new set for the predicates' occurrences in the new block
				Set<FOADAExpression> predicatesOccurrencesInNewBlock = new HashSet<FOADAExpression>();
				// compute one part of the new block
				for(FOADAExpression anOccurrenceInCurrentBlock : predicatesOccurrencesInCurrentBlock) {
					// create the left part of the implication
					FOADAExpression left = anOccurrenceInCurrentBlock;
					// compute the right part of the implication but without time-stamps
					FOADAExpression rightWithoutTimeStamps = transitions.get(anOccurrenceInCurrentBlock.name.substring(0, anOccurrenceInCurrentBlock.name.indexOf("_")) + '+' + a);
					// if no corresponding transition
					if(rightWithoutTimeStamps == null) {
						rightWithoutTimeStamps = new FOADAExpression(false);
					}
					// create the right part of the implication
					FOADAExpression right = rightWithoutTimeStamps.copy();
					right.addTimeStamps(currentTimeStamp + 1);
					// rename the unrenamed arguments of the predicates in the right part of the implication (like a0, a1, etc.)
					// they must remain the same as in the left part
					for(int i = 0; i < anOccurrenceInCurrentBlock.subData.size(); i++) {
						right.substitue("a" + i + "c", anOccurrenceInCurrentBlock.subData.get(i).name);
					}
					// create the implication without quantifier
					BooleanFormula implication = bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), (BooleanFormula)right.toJavaSMTFormula(fmgr));
					// add the implication into the new block
					block.add(implication);
					// create a new set for the predicates' occurrences in the current part of the new block
					Set<FOADAExpression> predicatesOccurrencesInCurrentPart = takePredicatesOccurrences(right);
					// add the predicates' occurrences in the current part into the set of predicates' occurrences in the new block
					predicatesOccurrencesInNewBlock.addAll(predicatesOccurrencesInCurrentPart);
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
				// refresh
				predicatesOccurrencesInCurrentBlock = predicatesOccurrencesInNewBlock;
				currentTimeStamp++;
			}
		// compute the last block containing the final conjunction according to the set of final states
			// create a new list for the final conjunction
			List<BooleanFormula> finalConjunction = new ArrayList<BooleanFormula>();
			// check all the predicates' occurrences in the current block
			for(FOADAExpression anOccurrenceInCurrentBlock : predicatesOccurrencesInCurrentBlock) {
				FOADAExpression left = anOccurrenceInCurrentBlock;
				// implies true if is final state
				if(finalStates.contains(anOccurrenceInCurrentBlock.name.substring(0, anOccurrenceInCurrentBlock.name.indexOf("_")))) {
					BooleanFormula right = bmgr.makeBoolean(true);
					finalConjunction.add(bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), right));
				}
				else {
					BooleanFormula right = bmgr.makeBoolean(false);
					finalConjunction.add(bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), right));
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
			//***************/ System.out.println("Blocks:");
			//***************/ for(BooleanFormula f : blocks) {
			//***************/ 	System.out.println(f);
			//***************/ }
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
					@SuppressWarnings("unchecked")
					// compute the interpolants (with time-stamps)
					List<BooleanFormula> interpolantsWithTimeStamps = prover.getSeqInterpolants(listPartitions);
					List<BooleanFormula> interpolants = new ArrayList<BooleanFormula>();
					// remove the time-stamps from the interpolants
					for(BooleanFormula f : interpolantsWithTimeStamps) {
						BooleanFormula interpolantWithoutTimeStamps = removeTimeStamps(f);
						List<Formula> arguments = new ArrayList<Formula>();
						for(Formula argument : fmgr.extractVariables(interpolantWithoutTimeStamps).values()) {
							if(argument.toString().charAt(0) == 'v') {
								arguments.add(argument);
							}
						}
						if(arguments.isEmpty()) {
							interpolants.add(interpolantWithoutTimeStamps);
						}
						else {
							BooleanFormula quantifiedInterpolant = qmgr.exists(arguments, interpolantWithoutTimeStamps);
							interpolants.add(quantifiedInterpolant);
						}
					}
				// refine the nodes along the path
					// starting from the root node
					FOADAConfiguration currentNodeAlongPath = initialConfiguration;
					int step = 0;
					// loop check the path
					boolean oneNodeIsClosed = false;
					while(true) {
						// get the corresponding interpolant according to the current step
						BooleanFormula interpolant = interpolants.get(step);
						// get the expression in the current node
						BooleanFormula currentExpression = currentNodeAlongPath.expression;
						// check the validity of the implication: current -> interpolant
						boolean implicationIsValid = implies(currentExpression, interpolant);
						// if the implication if not valid
						if(!implicationIsValid) {
							// refine the node by making a conjunction
							/***************/ if(print) System.out.print("\t#" + currentNodeAlongPath.number + " refined ");
							currentNodeAlongPath.expression = bmgr.and(currentExpression, interpolant);
							/***************/ if(print) System.out.println(" : " + currentNodeAlongPath.expression);
							// refresh the coverage (maybe the node does not cover another node anymore)
							removeInvalidCoverage(print, currentNodeAlongPath, coverOthersMap, beCoveredMap, workList);
							// close the current node along path
							if(!oneNodeIsClosed) {
								oneNodeIsClosed = close(print, currentNodeAlongPath, allNodes, coverOthersMap, beCoveredMap, workList);
							}
							if(implies(currentNodeAlongPath.expression, bmgr.makeBoolean(false))) {
								workList.remove(currentNodeAlongPath);
								/***************/ if(print) System.out.println("\t#" + currentNodeAlongPath.number + " removed (false node)");
							}
						}
						// if finish looping the path
						if(step >= pathFromInitialToCurrent.size()) {
							break;
						}
						// if not finish looping the path
						else {
							// refresh the current node along path
							int indexOfSuccessor = currentNodeAlongPath.successorSymbolIndexMap.get(pathFromInitialToCurrent.get(step));
							currentNodeAlongPath = currentNodeAlongPath.successors.get(indexOfSuccessor);
							// refresh the current step
							step++;
						}
					}
				}
				// print out the model and return false if it is satisfiable
				else {
					System.out.println("------------------------------\nSAT with sequence:");
					if(pathFromInitialToCurrent.size() == 0) {
						System.out.println("empty trace");
					}
					else {
						Object[][] variablesAssignments = new Object[pathFromInitialToCurrent.size()][variables.size()];
						for(Object a : prover.getModelAssignments()) {
							String expressionString = ((ValueAssignment)a).getKey().toString();
							if(expressionString.charAt(0) == 'v') {
								int lastIndexOfUnderscore = expressionString.lastIndexOf('_');
								int variableStep = Integer.valueOf(expressionString.substring(lastIndexOfUnderscore + 1));
								int variableIndex = Integer.valueOf(expressionString.substring(1, lastIndexOfUnderscore - 1));
								variablesAssignments[variableStep - 1][variableIndex] = ((ValueAssignment)a).getValue();
							}
						}
						for(int i1 = 0; i1 < pathFromInitialToCurrent.size(); i1++) {
							System.out.print(renameMap2.get((pathFromInitialToCurrent.get(i1))) + " \tDATA ::: { ");
							for(int i2 = 0; i2 < variables.size(); i2++) {
								System.out.print(variablesAssignments[i1][i2] == null ? "any " : variablesAssignments[i1][i2] + " ");
							}
							System.out.println('}');
						}
					}
					System.out.println("------------------------------");
					long endtime=System.currentTimeMillis();
					Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
					Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
					Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
					return false;
				}
			// expand the current node if it is not covered
				// check if the current node is covered, if not then expand it
				boolean notGoingToExpand = false;
				if(!currentNode.successors.isEmpty()) {
					/***************/ if(print) System.out.println("\tnot going to expand (already expanded)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand && isCovered(currentNode, beCoveredMap)) {
					/***************/ if(print) System.out.println("\tnot going to expand (covered)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand) {
					// try all the event symbols
					for(String a : eventSymbols) {
						//***************/ System.out.println("\tExpand with " + a + ':');
						FOADAConfiguration newNode = new FOADAConfiguration(configurationNumber++, bmgr.makeBoolean(true), currentNode, a);
						currentNode.addSuccessor(a, newNode);
						//***************/ System.out.println("\t\t" + newNode);
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
		long endtime=System.currentTimeMillis();
		Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
		Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
		Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
		return true;
	}
	
	/** check if the automaton is empty using path quantifier elimination / DFS
	 * @param	print	the value is set to <b> true </b> if is going to print the important steps
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty3(boolean print)
			throws FOADAException
	{	
		long begintime = System.currentTimeMillis();
		int nodeVisited = 0;
	// start with the initial state
		// node (configuration) number (starting from 0)
		int configurationNumber = 0;
		// create node(configuration) for the initial state
		FOADAConfiguration initialConfiguration = new FOADAConfiguration(configurationNumber++, (BooleanFormula)initialState.toJavaSMTFormula(fmgr), null, null);
	// initialize the coverage management
		Map<FOADAConfiguration, Set<FOADAConfiguration>> coverOthersMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
		Map<FOADAConfiguration, Set<FOADAConfiguration>> beCoveredMap = new LinkedHashMap<FOADAConfiguration, Set<FOADAConfiguration>>();
	// initialize the set of nodes
		Set<FOADAConfiguration> allNodes = new HashSet<FOADAConfiguration>();
	// start working with workList
		// create workList
		List<FOADAConfiguration> workList = new ArrayList<FOADAConfiguration>();
		// add the initial node(configuration) into workList
		workList.add(initialConfiguration);
		// looped working with workList until it becomes empty
		while(!workList.isEmpty()) {
		// pick the currentNode
			// pick the first node of workList
			FOADAConfiguration currentNode = workList.get(workList.size() - 1);
			/***************/ if(print) System.out.println(currentNode);
			// remove the first node from workList
			workList.remove(workList.size() - 1);
			nodeVisited++;
			allNodes.add(currentNode);
		// calculate the path from the initial node to the currentNode
			// create a new list for symbols along the path
			List<String> pathFromInitialToCurrent = new ArrayList<String>();
			// create "c" for the loop and initialize it to currentNode
			FOADAConfiguration c = currentNode;
			// looped working for finding the path (end if father node is null)
			while(c.father != null) {
				// add the father symbol in the beginning (position index = 0) of the list
				pathFromInitialToCurrent.add(0, c.fatherSymbol);
				// set "c" to the father node(configuration)
				c = c.father;
			}
			/***************/ if(print) System.out.println("\tpath : " + pathFromInitialToCurrent);
		// determine whether currentNode is accepted
			// create a new list for blocks of time-stamped conjunctions in the path formula
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// make the initial state time-stamped
			FOADAExpression timeStampedInitialState = initialState.copy();
			timeStampedInitialState.addTimeStamps(0);
			// add time-stamped initial state into the blocks
			blocks.add((BooleanFormula)timeStampedInitialState.toJavaSMTFormula(fmgr));
			// create a new set for the predicates' occurrences in the current block
			Set<FOADAExpression> predicatesOccurrencesInCurrentBlock = takePredicatesOccurrences(timeStampedInitialState);
			// create an integer indicating the current time-stamp
			int currentTimeStamp = 0;
			// compute next blocks (except the last block) according to the path
			for(String a : pathFromInitialToCurrent) {
				// create a new list for the small parts (of conjunction) of the new block
				List<BooleanFormula> block = new ArrayList<BooleanFormula>();
				// create a new set for the predicates' occurrences in the new block
				Set<FOADAExpression> predicatesOccurrencesInNewBlock = new HashSet<FOADAExpression>();
				// compute one part of the new block
				for(FOADAExpression anOccurrenceInCurrentBlock : predicatesOccurrencesInCurrentBlock) {
					// create the left part of the implication
					FOADAExpression left = anOccurrenceInCurrentBlock;
					// compute the right part of the implication but without time-stamps
					FOADAExpression rightWithoutTimeStamps = transitions.get(anOccurrenceInCurrentBlock.name.substring(0, anOccurrenceInCurrentBlock.name.indexOf("_")) + '+' + a);
					// if no corresponding transition
					if(rightWithoutTimeStamps == null) {
						rightWithoutTimeStamps = new FOADAExpression(false);
					}
					// create the right part of the implication
					FOADAExpression right = rightWithoutTimeStamps.copy();
					right.addTimeStamps(currentTimeStamp + 1);
					// rename the unrenamed arguments of the predicates in the right part of the implication (like a0, a1, etc.)
					// they must remain the same as in the left part
					for(int i = 0; i < anOccurrenceInCurrentBlock.subData.size(); i++) {
						right.substitue("a" + i + "c", anOccurrenceInCurrentBlock.subData.get(i).name);
					}
					// create the implication without quantifier
					BooleanFormula implication = bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), (BooleanFormula)right.toJavaSMTFormula(fmgr));
					// add the implication into the new block
					block.add(implication);
					// create a new set for the predicates' occurrences in the current part of the new block
					Set<FOADAExpression> predicatesOccurrencesInCurrentPart = takePredicatesOccurrences(right);
					// add the predicates' occurrences in the current part into the set of predicates' occurrences in the new block
					predicatesOccurrencesInNewBlock.addAll(predicatesOccurrencesInCurrentPart);
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
				// refresh
				predicatesOccurrencesInCurrentBlock = predicatesOccurrencesInNewBlock;
				currentTimeStamp++;
			}
		// compute the last block containing the final conjunction according to the set of final states
			// create a new list for the final conjunction
			List<BooleanFormula> finalConjunction = new ArrayList<BooleanFormula>();
			// check all the predicates' occurrences in the current block
			for(FOADAExpression anOccurrenceInCurrentBlock : predicatesOccurrencesInCurrentBlock) {
				FOADAExpression left = anOccurrenceInCurrentBlock;
				// implies true if is final state
				if(finalStates.contains(anOccurrenceInCurrentBlock.name.substring(0, anOccurrenceInCurrentBlock.name.indexOf("_")))) {
					BooleanFormula right = bmgr.makeBoolean(true);
					finalConjunction.add(bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), right));
				}
				else {
					BooleanFormula right = bmgr.makeBoolean(false);
					finalConjunction.add(bmgr.implication((BooleanFormula)left.toJavaSMTFormula(fmgr), right));
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
			//***************/ System.out.println("Blocks:");
			//***************/ for(BooleanFormula f : blocks) {
			//***************/ 	System.out.println(f);
			//***************/ }
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
					@SuppressWarnings("unchecked")
					// compute the interpolants (with time-stamps)
					List<BooleanFormula> interpolantsWithTimeStamps = prover.getSeqInterpolants(listPartitions);
					List<BooleanFormula> interpolants = new ArrayList<BooleanFormula>();
					// remove the time-stamps from the interpolants
					for(BooleanFormula f : interpolantsWithTimeStamps) {
						BooleanFormula interpolantWithoutTimeStamps = removeTimeStamps(f);
						List<Formula> arguments = new ArrayList<Formula>();
						for(Formula argument : fmgr.extractVariables(interpolantWithoutTimeStamps).values()) {
							if(argument.toString().charAt(0) == 'v') {
								arguments.add(argument);
							}
						}
						if(arguments.isEmpty()) {
							interpolants.add(interpolantWithoutTimeStamps);
						}
						else {
							BooleanFormula quantifiedInterpolant = qmgr.exists(arguments, interpolantWithoutTimeStamps);
							interpolants.add(quantifiedInterpolant);
						}
					}
				// refine the nodes along the path
					// starting from the root node
					FOADAConfiguration currentNodeAlongPath = initialConfiguration;
					int step = 0;
					// loop check the path
					boolean oneNodeIsClosed = false;
					while(true) {
						// get the corresponding interpolant according to the current step
						BooleanFormula interpolant = interpolants.get(step);
						// get the expression in the current node
						BooleanFormula currentExpression = currentNodeAlongPath.expression;
						// check the validity of the implication: current -> interpolant
						boolean implicationIsValid = implies(currentExpression, interpolant);
						// if the implication if not valid
						if(!implicationIsValid) {
							// refine the node by making a conjunction
							/***************/ if(print) System.out.print("\t#" + currentNodeAlongPath.number + " refined ");
							currentNodeAlongPath.expression = bmgr.and(currentExpression, interpolant);
							/***************/ if(print) System.out.println(" : " + currentNodeAlongPath.expression);
							// refresh the coverage (maybe the node does not cover another node anymore)
							removeInvalidCoverage(print, currentNodeAlongPath, coverOthersMap, beCoveredMap, workList);
							// close the current node along path
							if(!oneNodeIsClosed) {
								oneNodeIsClosed = close(print, currentNodeAlongPath, allNodes, coverOthersMap, beCoveredMap, workList);
							}
							if(implies(currentNodeAlongPath.expression, bmgr.makeBoolean(false))) {
								workList.remove(currentNodeAlongPath);
								/***************/ if(print) System.out.println("\t#" + currentNodeAlongPath.number + " removed (false node)");
							}
						}
						// if finish looping the path
						if(step >= pathFromInitialToCurrent.size()) {
							break;
						}
						// if not finish looping the path
						else {
							// refresh the current node along path
							int indexOfSuccessor = currentNodeAlongPath.successorSymbolIndexMap.get(pathFromInitialToCurrent.get(step));
							currentNodeAlongPath = currentNodeAlongPath.successors.get(indexOfSuccessor);
							// refresh the current step
							step++;
						}
					}
				}
				// print out the model and return false if it is satisfiable
				else {
					System.out.println("------------------------------\nSAT with sequence:");
					if(pathFromInitialToCurrent.size() == 0) {
						System.out.println("empty trace");
					}
					else {
						Object[][] variablesAssignments = new Object[pathFromInitialToCurrent.size()][variables.size()];
						for(Object a : prover.getModelAssignments()) {
							String expressionString = ((ValueAssignment)a).getKey().toString();
							if(expressionString.charAt(0) == 'v') {
								int lastIndexOfUnderscore = expressionString.lastIndexOf('_');
								int variableStep = Integer.valueOf(expressionString.substring(lastIndexOfUnderscore + 1));
								int variableIndex = Integer.valueOf(expressionString.substring(1, lastIndexOfUnderscore - 1));
								variablesAssignments[variableStep - 1][variableIndex] = ((ValueAssignment)a).getValue();
							}
						}
						for(int i1 = 0; i1 < pathFromInitialToCurrent.size(); i1++) {
							System.out.print(renameMap2.get((pathFromInitialToCurrent.get(i1))) + " \tDATA ::: { ");
							for(int i2 = 0; i2 < variables.size(); i2++) {
								System.out.print(variablesAssignments[i1][i2] == null ? "any " : variablesAssignments[i1][i2] + " ");
							}
							System.out.println('}');
						}
					}
					System.out.println("------------------------------");
					long endtime=System.currentTimeMillis();
					Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
					Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
					Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
					return false;
				}
			// expand the current node if it is not covered
				// check if the current node is covered, if not then expand it
				boolean notGoingToExpand = false;
				if(!currentNode.successors.isEmpty()) {
					/***************/ if(print) System.out.println("\tnot going to expand (already expanded)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand && isCovered(currentNode, beCoveredMap)) {
					/***************/ if(print) System.out.println("\tnot going to expand (covered)");
					notGoingToExpand = true;
				}
				if(!notGoingToExpand) {
					// try all the event symbols
					for(String a : eventSymbols) {
						//***************/ System.out.println("\tExpand with " + a + ':');
						FOADAConfiguration newNode = new FOADAConfiguration(configurationNumber++, bmgr.makeBoolean(true), currentNode, a);
						currentNode.addSuccessor(a, newNode);
						//***************/ System.out.println("\t\t" + newNode);
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
		long endtime=System.currentTimeMillis();
		Console.printInfo(ConsoleType.FOADA, "Nodes Expanded : " + (configurationNumber + 1));
		Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nodeVisited);
		Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endtime - begintime) + " ms");
		return true;
	}
	
}