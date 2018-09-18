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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.FormulaType;
import org.sosy_lab.java_smt.api.IntegerFormulaManager;
import org.sosy_lab.java_smt.api.NumeralFormula.IntegerFormula;
import org.sosy_lab.java_smt.api.QuantifiedFormulaManager;
import org.sosy_lab.java_smt.api.SolverContext;
import org.sosy_lab.java_smt.api.UFManager;
import org.sosy_lab.java_smt.api.visitors.FormulaVisitor;

import exception.FOADAException;
import exception.JavaSMTInvalidConfigurationException;
import structure.FOADAExpression.ExpressionType;

public class Automaton {
	
	/** name of the automaton
	 */
	private String name;
	
	/** rename map used for replacing all the variable/function/symbol names by simpler standard names
	 */
	private Map<String, String> renameMap;
	
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
		predicatesToBeRenamed.addAll(post.getFreeVariables());
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
	}
	
	/** rename a predicate and then add it into the set of predicates (do nothing if already added)
	 * @param	predicate	name of the predicate
	 */
	public void addPredicate(String predicate)
	{
		if(!renameMap.containsKey(predicate)) {
			String newName = "q" + predicates.size();
			renameMap.put(predicate, newName);
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
			eventSymbols.add(newName);
		}
	}
	
	public BooleanFormula addTimeStamp(BooleanFormula expression, int timeStamp, List<String> freeVariables)
	{
		Map<Formula, Formula> fromToMapping = new LinkedHashMap<Formula, Formula>();
		for(String s : variables) {
			if(variableTypeMap.get(s) == ExpressionType.Integer) {
				fromToMapping.put(imgr.makeVariable(s), imgr.makeVariable(s + '_' + timeStamp));
			}
			else {
				fromToMapping.put(bmgr.makeVariable(s), bmgr.makeVariable(s + '_' + timeStamp));
			}
		}
		for(String s : freeVariables) {
		}
		return fmgr.substitute(expression, fromToMapping);
	}
	
	/** check if the automaton is empty
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty()
	{	
		/*System.out.println("Automaton " + name);
		for(String s : variables) {
			System.out.println(s + " : " + variableTypeMap.get(s));
		}
		for(String s : predicates) {
			System.out.println(s + " : " + predicateArgumentsTypesMap.get(s));
		}
		for(Entry<String, FOADAExpression> e : transitions.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue().toJavaSMTFormula(fmgr));
		}*/
	// start with the initial state
		// create node(configuration) for the initial state
		FOADAConfiguration initialConfiguration = new FOADAConfiguration((BooleanFormula)initialState.toJavaSMTFormula(fmgr), 0, initialState.getFreeVariables(), null, null);
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
			/***************/ System.out.println("\t path : " + pathFromInitialToCurrent);
		// determine whether currentNode is accepted
			// create a new list for blocks of time-stamped conjunctions in the path formula
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// make the initial state time-stamped
			/*IntegerFormula v0 = ufmgr.declareAndCallUF("v0", FormulaType.IntegerType);
			BooleanFormula q2v0 = ufmgr.declareAndCallUF("q2", FormulaType.BooleanType, v0);
			BooleanFormula q1 = ufmgr.declareAndCallUF("q1", FormulaType.BooleanType);
			BooleanFormula expression = bmgr.and(q1, q2v0);
			Map<Formula, Formula> fromToMapping = new LinkedHashMap<Formula, Formula>();
			fromToMapping.put(ufmgr.declareAndCallUF("q1", FormulaType.BooleanType), bmgr.makeVariable("q1_0"));
			fromToMapping.put(ufmgr.declareAndCallUF("q2", FormulaType.BooleanType), bmgr.makeVariable("q2_0"));*/
			IntegerFormula v = ufmgr.declareAndCallUF("v", FormulaType.IntegerType);
			BooleanFormula q = ufmgr.declareAndCallUF("q", FormulaType.BooleanType, v);
			fmgr.extractVariablesAndUFs(q);
			//BooleanFormula result = fmgr.substitute(expression, fromToMapping);
			//System.out.println(result);
			//System.out.println(fmgr.extractVariablesAndUFs(expression));
			//System.out.println(addTimeStamp(initialConfiguration.expression, 1, initialConfiguration.freeVariables));
		}
		return true;
	}

}
