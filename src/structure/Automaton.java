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

import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.FormulaType;
import org.sosy_lab.java_smt.api.InterpolatingProverEnvironment;
import org.sosy_lab.java_smt.api.Model.ValueAssignment;
import org.sosy_lab.java_smt.api.SolverException;
import exception.FOADAException;
import exception.InterpolatingProverEnvironmentException;
import structure.FOADAExpression.ExpressionCategory;
import structure.FOADAExpression.ExpressionType;
import utility.Console;
import utility.Impact;
import utility.Console.ConsoleType;
import utility.JavaSMTConfig;

public class Automaton {
	
	/**
	 * initial state
	 */
	public FOADAExpression initial;
	
	/**
	 * set of names of final states
	 */
	public List<String> namesOfFinalStates;
	
	/**
	 * map (name of predicate + event symbol : transition)
	 */
	public Map<String, FOADATransition> transitions;
	
	/** rename map (original name : new name)
	 */
	public Map<String, String> renameMap;
	
	/** set of names of predicates
	 */
	public List<String> namesOfPredicates;
	
	/** set of events
	 */
	public List<String> events;
	
	/** number of input variables
	 */
	public int nbOfVariables;
	
	/** default constructor
	 * @throws FOADAException
	 */
	public Automaton()
			throws FOADAException
	{
		initial = null;
		namesOfFinalStates = new ArrayList<String>();
		transitions = new LinkedHashMap<String, FOADATransition>();
		renameMap = new LinkedHashMap<String, String>();
		namesOfPredicates = new ArrayList<String>();
		events = new ArrayList<String>();
		nbOfVariables = 0;
	}
	
	public Automaton quantifies(List<String> variablesNames, List<ExpressionType> variablesTypes)
			throws FOADAException
	{
		Automaton newOne = new Automaton();
		// initial state
		newOne.initial = initial;
		// final states
		newOne.namesOfFinalStates = new ArrayList<String>();
		newOne.namesOfFinalStates.addAll(namesOfFinalStates);
		// rename map
		newOne.renameMap = new LinkedHashMap<String, String>();
		newOne.renameMap.putAll(renameMap);
		for(String nameOfQuantifiedInputVariable : variablesNames) {
			newOne.renameMap.remove(nameOfQuantifiedInputVariable);
		}
		// predicates (states)
		newOne.namesOfPredicates = new ArrayList<String>();
		newOne.namesOfPredicates.addAll(namesOfPredicates);
		// event symbols
		newOne.events = new ArrayList<String>();
		newOne.events.addAll(events);
		// transitions
		List<String> originalNamesAfterRenamingOfQuantifiedVariables = new ArrayList<String>();
		List<String> newNamesOfQuantifiedVariables = new ArrayList<String>();
		List<FOADAExpression> quantifiedVariables = new ArrayList<FOADAExpression>();
		for(int i = 0; i < variablesNames.size(); i++) {
			String nameAfterRenamingOfQuantifiedVariable = renameMap.get(variablesNames.get(i));
			originalNamesAfterRenamingOfQuantifiedVariables.add(nameAfterRenamingOfQuantifiedVariable);
			String newNameOfQuantifiedVariable = "i" + i;
			newNamesOfQuantifiedVariables.add(newNameOfQuantifiedVariable);
			FOADAExpression quantifiedVariable = new FOADAExpression(newNameOfQuantifiedVariable, variablesTypes.get(i));
			quantifiedVariables.add(quantifiedVariable);
		}
		Boolean renameMapIsUpdated = false;
		newOne.transitions = new LinkedHashMap<String, FOADATransition>();
		for(Entry<String, FOADATransition> entry : this.transitions.entrySet()) {
			FOADATransition transition = new FOADATransition();
			transition.left = entry.getValue().left.copy();
			transition.event = entry.getValue().event;
			transition.inputVariables = new ArrayList<FOADAExpression>();
			List<String> originalNamesAfterRenamingOfInputVariables = new ArrayList<String>();
			List<String> newNamesOfInputVariables = new ArrayList<String>();
			int orderOfInputVariable = 0;
			for(FOADAExpression expression : entry.getValue().inputVariables) {
				Boolean needToBeQuantified = false;
				for(String nameOfVariable : variablesNames) {
					if(expression.name.equals(renameMap.get(nameOfVariable))) {
						needToBeQuantified = true;
						break;
					}
				}
				if(!needToBeQuantified) {
					originalNamesAfterRenamingOfInputVariables.add(expression.name);
					String newNameOfInputVariable = "v" + orderOfInputVariable + "c";
					orderOfInputVariable++;
					newNamesOfInputVariables.add(newNameOfInputVariable);
					transition.inputVariables.add(new FOADAExpression(newNameOfInputVariable, expression.type));
				}
			}
			transition.right = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Exists, quantifiedVariables);
			transition.right.subData.add(entry.getValue().right.copy());
			for(int i = 0; i < newNamesOfQuantifiedVariables.size(); i++) {
				transition.right.substitute(originalNamesAfterRenamingOfQuantifiedVariables.get(i), newNamesOfQuantifiedVariables.get(i));
			}
			for(int i = 0; i < newNamesOfInputVariables.size(); i++) {
				transition.right.substitute(originalNamesAfterRenamingOfInputVariables.get(i), newNamesOfInputVariables.get(i));
				if(!renameMapIsUpdated) {
					for(Entry<String, String> entry2 : newOne.renameMap.entrySet()) {
						if(entry2.getValue().equals(originalNamesAfterRenamingOfInputVariables.get(i))) {
							entry2.setValue(newNamesOfInputVariables.get(i));
						}
					}
				}
			}
			renameMapIsUpdated = true;
			newOne.transitions.put(entry.getKey(), transition);
		}
		// number of input variables
		//newOne.nbOfVariables = nbOfVariables;
		newOne.nbOfVariables = nbOfVariables - variablesNames.size();
		//System.out.println(newOne.nbOfVariables);
		return newOne;
	}
	
	public Automaton intersects(Automaton automaton, String renameChar)
			throws FOADAException
	{
		Automaton newOne = new Automaton();
		List<String> newNamesOfPredicatesForB = new ArrayList<String>();
		FOADAExpression newInitialForB = automaton.initial.copy();
		List<String> newNamesOfFinalStatesForB = new ArrayList<String>();
		for(int i = automaton.namesOfPredicates.size() - 1; i >= 0; i--) {
			int newNumber = i + namesOfPredicates.size();
			newNamesOfPredicatesForB.add("q" + newNumber + "c");
			newInitialForB.substitute("q" + i + "c", "q" + newNumber + "c");
			for(int j = 0; j < automaton.namesOfFinalStates.size(); j++) {
				if(automaton.namesOfFinalStates.get(j).equals("q" + i + "c")) {
					newNamesOfFinalStatesForB.add("q" + newNumber + "c");
				}
			}
		}
		Map<String, String> newRenameMapForB = new LinkedHashMap<String, String>();
		for(Map.Entry<String, String> entry : automaton.renameMap.entrySet()) {
			String original = entry.getKey();
			String newName = entry.getValue();
			if(newName.charAt(0) == 'q') {
				original = original + "_" + renameChar;
				int newNumber = Integer.parseInt(newName.substring(1).substring(0, newName.length() - 2)) + namesOfPredicates.size();
				newName = "q" + newNumber + "c";
				newRenameMapForB.put(original, newName);
			}
		}
		Map<String, String> eventRenameMapForB = new LinkedHashMap<String, String>();
		List<String> eventsForB = new ArrayList<String>();
		for(Map.Entry<String, String> entry : automaton.renameMap.entrySet()) {
			if(entry.getValue().charAt(0) == 'e') {
				if(!renameMap.containsKey(entry.getKey())) {
					int newNumber = events.size() + eventRenameMapForB.size();
					eventRenameMapForB.put(entry.getKey(), "e" + newNumber + "c");
					newRenameMapForB.put(entry.getKey(), "e" + newNumber + "c");
					eventsForB.add("e" + newNumber + "c");
				}
			}
		}
		newOne.renameMap = new LinkedHashMap<String, String>();
		newOne.renameMap.putAll(renameMap);
		newOne.renameMap.putAll(newRenameMapForB);
		Map<String, FOADATransition> newTransitionsForB = new LinkedHashMap<String, FOADATransition>();
		for(FOADATransition transition : automaton.transitions.values()) {
			// rename predicates in transitions
			FOADAExpression left = transition.left.copy();
			FOADAExpression right = transition.right.copy();
			String event = transition.event;
			for(Map.Entry<String, String> entry : automaton.renameMap.entrySet()) {
				if(entry.getValue().equals(event)) {
					event = entry.getKey();
				}
			}
			List<FOADAExpression> inputVariables = transition.inputVariables;
			for(int i = automaton.namesOfPredicates.size() - 1; i >= 0; i--) {
				int newNumber = i + namesOfPredicates.size();
				left.substitute("q" + i + "c", "q" + newNumber + "c");
				right.substitute("q" + i + "c", "q" + newNumber + "c");
			}
			FOADATransition newTransition = new FOADATransition();
			newTransition.left = left;
			newTransition.event = newOne.renameMap.get(event);
			newTransition.inputVariables = inputVariables;
			newTransition.right = right;
			newTransitionsForB.put(left.name + "+" + newTransition.event, newTransition);
		}	
		newOne.initial = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, initial, newInitialForB);
		newOne.namesOfPredicates = new ArrayList<String>();
		newOne.namesOfPredicates.addAll(namesOfPredicates);
		newOne.namesOfPredicates.addAll(newNamesOfPredicatesForB);
		newOne.namesOfFinalStates = new ArrayList<String>();
		newOne.namesOfFinalStates.addAll(namesOfFinalStates);
		newOne.namesOfFinalStates.addAll(newNamesOfFinalStatesForB);
		newOne.events = new ArrayList<String>();
		newOne.events.addAll(events);
		newOne.events.addAll(eventsForB);
		newOne.nbOfVariables = nbOfVariables;
		newOne.transitions = new LinkedHashMap<String, FOADATransition>();
		newOne.transitions.putAll(transitions);
		newOne.transitions.putAll(newTransitionsForB);
		return newOne;
	}
	
	public Automaton intersects(Automaton automaton)
			throws FOADAException
	{
		return intersects(automaton, "B");
	}
	
	public Automaton complements()
			throws FOADAException
	{
		Automaton newOne = new Automaton();
		newOne.initial = initial.copy();
		newOne.namesOfFinalStates = new ArrayList<String>();
		newOne.namesOfFinalStates.addAll(namesOfPredicates);
		newOne.namesOfFinalStates.removeAll(namesOfFinalStates);
		newOne.transitions = new LinkedHashMap<String, FOADATransition>();
		for(Entry<String, FOADATransition> transitionEntry : transitions.entrySet()) {
			newOne.transitions.put(transitionEntry.getKey(), transitionEntry.getValue().copy());
		}
		for(FOADATransition t : newOne.transitions.values()) {
			t.right.negate();
		}
		Map<String, FOADAExpression> predicatesNameArguments = new LinkedHashMap<String, FOADAExpression>();
		for(FOADATransition transition : transitions.values()) {
			FOADAExpression predicateWithArguments = transition.left;
			String nameOfPredicate = transition.left.name;
			if(!predicatesNameArguments.containsKey(nameOfPredicate)) {
				predicatesNameArguments.put(nameOfPredicate, predicateWithArguments);
			}
		}
		List<FOADAExpression> inputVariables = transitions.values().iterator().next().inputVariables;
		for(String predicate : namesOfPredicates) {
			FOADAExpression left = predicatesNameArguments.get(predicate);
			for(String event : events) {
				if(!transitions.containsKey(predicate + "+" + event)) {
					FOADATransition transition = new FOADATransition();
					if(left != null) {
						transition.left = left.copy();
					}
					else {
						transition.left = new FOADAExpression(predicate, ExpressionType.Boolean);
					}
					transition.event = event;
					transition.inputVariables = inputVariables;
					transition.right = new FOADAExpression(true);
					newOne.transitions.put(predicate + "+" + event, transition);
				}
			}
		}
		newOne.renameMap = new LinkedHashMap<String, String>();
		newOne.renameMap.putAll(renameMap);
		newOne.namesOfPredicates = new ArrayList<String>();
		newOne.namesOfPredicates.addAll(namesOfPredicates);
		newOne.events = new ArrayList<String>();
		newOne.events.addAll(events);
		newOne.nbOfVariables = nbOfVariables;
		return newOne;
	}
	
	public boolean isIncluded(Automaton B, utility.TreeSearch.Mode searchMode, utility.Impact.Mode transitionMode)
			throws FOADAException
	{
		Automaton complementOfB = B.complements();
		Automaton AIntersectsComplementOfB = intersects(complementOfB);
		return AIntersectsComplementOfB.isEmpty(searchMode, transitionMode);
	}
	
	public boolean isEmpty(utility.TreeSearch.Mode searchMode, utility.Impact.Mode transitionMode)
			throws FOADAException
	{
		utility.JavaSMTConfig.initJavaSMT();
		System.out.println(renameMap);
		System.out.println("Predicates : " + namesOfPredicates);
		System.out.println("Initial : " + initial);
		System.out.println("Final : " + namesOfFinalStates);
		System.out.println("Events : " + events);
		for(Entry<String, FOADATransition> entry : transitions.entrySet()) {
			System.out.println(entry.getKey() + "   ###   " + entry.getValue());
		}
		long beginTime = System.currentTimeMillis();
		int nbOfNodesVisited = 0;
		int nbOfNodesCreated = 0;
	// start with the initial state
		// create initial node
		FOADAConfiguration initialNode = new FOADAConfiguration(nbOfNodesCreated++, (BooleanFormula)initial.toJavaSMTFormula(JavaSMTConfig.fmgr), null, null);
		// initialize the set of all valid Nodes
		Set<FOADAConfiguration> allValidNodes = new HashSet<FOADAConfiguration>();
		// initialize the work list
		List<FOADAConfiguration> workList = new ArrayList<FOADAConfiguration>();
		// add the initial node into the work list
		workList.add(initialNode);
	// start working with the work list
		while(!workList.isEmpty()) {
		// pick a node -> the current node
			FOADAConfiguration currentNode = null;
			if(searchMode == utility.TreeSearch.Mode.BFS) {
				currentNode = workList.get(0);
				workList.remove(0);
			}
			else {
				currentNode = workList.get(workList.size() - 1); 
				workList.remove(workList.size() - 1);
			}
			nbOfNodesVisited++;
			allValidNodes.add(currentNode);
			/** TODO **/ //System.out.println(currentNode);
		// calculate the path from the initial node to the current node
			List<String> pathFromInitToCurrent = new ArrayList<String>();
			// loop to find the path
			FOADAConfiguration c = currentNode;
			while(c.father != null) {
				pathFromInitToCurrent.add(0, c.fatherSymbol);
				c = c.father;
			}
			/** TODO **/ //System.out.println(pathFromInitToCurrent);
		// determine whether the current node is accepting
			// create a list of JavaSMT expressions (blocks) for interpolation
			List<BooleanFormula> blocks = new ArrayList<BooleanFormula>();
			// create a time-stamped initial state
			FOADAExpression timeStampedInitial = initial.copy();
			timeStampedInitial.addTimeStamps(0);
			// add the JavaSMT expression of the timed-stamped initial state into list of blocks
			blocks.add((BooleanFormula)timeStampedInitial.toJavaSMTFormula(JavaSMTConfig.fmgr));
			// create a set of all the un-time-stamped predicates in the current block
			// or
			// create a set of all the occurrences of predicates in the current block
			Set<FOADAExpression> predicatesInCurrentBlock = null;
			Set<FOADAExpression> predicatesOccurrencesInCurrentBlock = null;
			// get the names of all the predicates in the initial state
			// or
			// get all the occurrences of predicates in the initial state
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				predicatesInCurrentBlock = new HashSet<FOADAExpression>();
				Set<FOADAExpression> predicatesOccurrencesInUnTimeStampedCurrentBlock = initial.copy().findPredicatesOccurrences();
				for(FOADAExpression o : predicatesOccurrencesInUnTimeStampedCurrentBlock) {
					for(int i = 0; i < o.subData.size(); i++) {
						o.subData.get(i).name = "a" + i + "c";
						o.subData.get(i).category = ExpressionCategory.Function;
						o.subData.get(i).subData = new ArrayList<FOADAExpression>();
					}
					predicatesInCurrentBlock.add(o);
				}
			}
			else {
				predicatesOccurrencesInCurrentBlock = timeStampedInitial.findPredicatesOccurrences();
			}
			// compute next blocks
			int currentTimeStamp = 0;
			for(String a : pathFromInitToCurrent) {
				// create a new list of all the small parts (of conjunction) of the new block
				List<BooleanFormula> smallPartsOfNewBlock = new ArrayList<BooleanFormula>();
				// compute the small parts of the new block
				if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
					Set<FOADAExpression> predicatesInNewBlock = new HashSet<FOADAExpression>();
					// compute one small part of the new block
					for(FOADAExpression predicate : predicatesInCurrentBlock) {
						FOADATransition transition = transitions.get(predicate.name + "+" + a);
						if(transition != null) {
							predicatesInNewBlock.addAll(transition.getPredicates());
							BooleanFormula currentPartOfNewBlock = transition.getUniversallyQuantifiedImplication(currentTimeStamp);
							smallPartsOfNewBlock.add(currentPartOfNewBlock);
						}
						else {
							List<Formula> arguments = new ArrayList<Formula>();
							for(FOADAExpression x : predicate.subData) {
								Formula argument;
								if(x.type == ExpressionType.Integer) {
									argument = JavaSMTConfig.ufmgr.declareAndCallUF(x.name, FormulaType.IntegerType);
								}
								else {
									argument = JavaSMTConfig.ufmgr.declareAndCallUF(x.name, FormulaType.BooleanType);
								}
								arguments.add(argument);
							}
							FOADAExpression timeStampedLeft = predicate.copy();
							timeStampedLeft.addTimeStamps(currentTimeStamp);
							BooleanFormula leftPartOfImplication = (BooleanFormula)timeStampedLeft.toJavaSMTFormula(JavaSMTConfig.fmgr);
							BooleanFormula rightPartOfImplication = JavaSMTConfig.bmgr.makeBoolean(false);
							BooleanFormula implication = JavaSMTConfig.bmgr.implication(leftPartOfImplication, rightPartOfImplication);
							if(arguments.isEmpty()) {
								smallPartsOfNewBlock.add(implication);
							}
							else {
								BooleanFormula universallyQuantifiedImplication = JavaSMTConfig.qmgr.forall(arguments, implication);
								smallPartsOfNewBlock.add(universallyQuantifiedImplication);
							}
						}
					}
					if(smallPartsOfNewBlock.isEmpty()) {
						blocks.add(JavaSMTConfig.bmgr.makeBoolean(true));
					}
					else {
						blocks.add(JavaSMTConfig.bmgr.and(smallPartsOfNewBlock));
					}
					predicatesInCurrentBlock = predicatesInNewBlock;
				}
				else {
					Set<FOADAExpression> predicatesOccurrencesInNewBlock = new HashSet<FOADAExpression>();
					// compute one small part of the new block
					for(FOADAExpression occurrence : predicatesOccurrencesInCurrentBlock) {
						FOADAExpression left = occurrence;
						FOADATransition transition = transitions.get(left.name.substring(0, left.name.indexOf("_")) + "+" + a);
						if(transition != null) {
							predicatesOccurrencesInNewBlock.addAll(transition.getPredicatesOccurrences(currentTimeStamp, left));
							BooleanFormula currentPartOfNewBlock = transition.getImplicationWithOccurrences(currentTimeStamp, left);
							smallPartsOfNewBlock.add(currentPartOfNewBlock);
						}
						else {
							BooleanFormula currentPartOfNewBlock = JavaSMTConfig.bmgr.implication((BooleanFormula)left.toJavaSMTFormula(JavaSMTConfig.fmgr), JavaSMTConfig.bmgr.makeBoolean(false));
							smallPartsOfNewBlock.add(currentPartOfNewBlock);
						}
					}
					if(smallPartsOfNewBlock.isEmpty()) {
						blocks.add(JavaSMTConfig.bmgr.makeBoolean(true));
					}
					else {
						blocks.add(JavaSMTConfig.bmgr.and(smallPartsOfNewBlock));
					}
					predicatesOccurrencesInCurrentBlock = predicatesOccurrencesInNewBlock;
				}
				currentTimeStamp++;
			}
			// compute the final conjunction (last block)
			List<BooleanFormula> finalConjunction = new ArrayList<BooleanFormula>();
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				for(FOADAExpression predicate : predicatesInCurrentBlock) {
					List<Formula> arguments = new ArrayList<Formula>();
					for(FOADAExpression a : predicate.subData) {
						Formula argument;
						if(a.type == ExpressionType.Integer) {
							argument = JavaSMTConfig.ufmgr.declareAndCallUF(a.name, FormulaType.IntegerType);
						}
						else {
							argument = JavaSMTConfig.ufmgr.declareAndCallUF(a.name, FormulaType.BooleanType);
						}
						arguments.add(argument);
					}
					FOADAExpression timeStampedLeft = predicate.copy();
					timeStampedLeft.addTimeStamps(currentTimeStamp);
					BooleanFormula leftPartOfImplication = (BooleanFormula)timeStampedLeft.toJavaSMTFormula(JavaSMTConfig.fmgr);
					BooleanFormula rightPartOfImplication;
					if(namesOfFinalStates.contains(predicate.name)) {
						rightPartOfImplication = JavaSMTConfig.bmgr.makeBoolean(true);
					}
					else {
						rightPartOfImplication = JavaSMTConfig.bmgr.makeBoolean(false);
					}
					BooleanFormula implication = JavaSMTConfig.bmgr.implication(leftPartOfImplication, rightPartOfImplication);
					if(arguments.isEmpty()) {
						finalConjunction.add(implication);
					}
					else {
						BooleanFormula universallyQuantifiedImplication = JavaSMTConfig.qmgr.forall(arguments, implication);
						finalConjunction.add(universallyQuantifiedImplication);
					}
				}
			}
			else {
				for(FOADAExpression occurrence : predicatesOccurrencesInCurrentBlock) {
					FOADAExpression left = occurrence;
					// implies true if is final state
					if(namesOfFinalStates.contains(left.name.substring(0, left.name.indexOf("_")))) {
						BooleanFormula right = JavaSMTConfig.bmgr.makeBoolean(true);
						BooleanFormula implication = JavaSMTConfig.bmgr.implication((BooleanFormula)left.toJavaSMTFormula(JavaSMTConfig.fmgr), right);
						finalConjunction.add(implication);
					}
					// implies false if is not final state
					else {
						BooleanFormula right = JavaSMTConfig.bmgr.makeBoolean(false);
						BooleanFormula implication = JavaSMTConfig.bmgr.implication((BooleanFormula)left.toJavaSMTFormula(JavaSMTConfig.fmgr), right);
						finalConjunction.add(implication);
					}
				}
			}
			// add the last block into the list of blocks
			if(finalConjunction.isEmpty()) {
				blocks.add(JavaSMTConfig.bmgr.makeBoolean(true));
			}
			else {
				blocks.add(JavaSMTConfig.bmgr.and(finalConjunction));
			}
			/** TODO **/
			/*System.out.println("Blocks:");
			for(BooleanFormula b : blocks) {
				System.out.println(b);
			}*/
		// check if the conjunction of all blocks is satisfiable or compute the interpolants
			// create prover environment for interpolation
			@SuppressWarnings("rawtypes")
			InterpolatingProverEnvironment prover = JavaSMTConfig.solverContext.newProverEnvironmentWithInterpolation();
			// create a new list for sets of objects received when pushing different partitions into the prover
			List<Set<Object>> listPartitions = new ArrayList<Set<Object>>();
			// each block is a partition
			for(BooleanFormula f : blocks) {
				// create a set for objects received when pushing different partitions into the prover
				Set<Object> Partition = new HashSet<Object>();
				// push the partition (block) into the prover and add the received object into the set
				Partition.add(prover.push(f));
				// add the set into the list
				listPartitions.add(Partition);
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
						interpolants.add(JavaSMTConfig.removeTimeStamp(f));
					}
				// refine the nodes along the path
					// starting from the root node
					FOADAConfiguration currentNodeAlongPath = initialNode;
					int step = 0;
					// loop check the path
					boolean oneNodeIsClosed = false;
					while(true) {
						// get the corresponding interpolant according to the current step
						BooleanFormula interpolant = interpolants.get(step);
						// check the validity of the implication: current -> interpolant
						boolean implicationIsValid = JavaSMTConfig.checkImplication(currentNodeAlongPath.expression, interpolant);
						// if the implication if not valid
						if(!implicationIsValid) {
							// refine the node by making a conjunction
							currentNodeAlongPath.expression = JavaSMTConfig.bmgr.and(currentNodeAlongPath.expression, interpolant);
							/** TODO **/ //System.out.println("\t#" + currentNodeAlongPath.number + " refined : " + currentNodeAlongPath.expression);
							// remove all the covered relations of the current node along path
							currentNodeAlongPath.removeCoveredRelations(workList);
							// close the current node along path
							if(!oneNodeIsClosed) {
								oneNodeIsClosed = Impact.close(currentNodeAlongPath, workList, allValidNodes);
							}
							if(currentNodeAlongPath.expression.toString().equals("false")) {
								workList.remove(currentNodeAlongPath);
								allValidNodes.remove(currentNodeAlongPath);
							}
						}
						// if finish looping the path
						if(step >= pathFromInitToCurrent.size()) {
							break;
						}
						// if not finish looping the path
						else {
							// refresh the current node along path
							int indexOfSuccessor = currentNodeAlongPath.successorSymbolIndexMap.get(pathFromInitToCurrent.get(step));
							currentNodeAlongPath = currentNodeAlongPath.successors.get(indexOfSuccessor);
							// refresh the current step
							step++;
						}
					}
				}
				// print out the model and return false if it is satisfiable
				else {
					System.out.println("------------------------------");
					long endTime = System.currentTimeMillis();
					if(pathFromInitToCurrent.size() == 0) {
						System.out.println("empty trace");
					}
					else {
						Object[][] variablesAssignments = new Object[pathFromInitToCurrent.size()][nbOfVariables];
						for(Object a : prover.getModelAssignments()) {
							/* TODO */ //System.out.println((ValueAssignment)a);
							String expressionString = ((ValueAssignment)a).getKey().toString();
							if(expressionString.charAt(0) == 'v') {
								int lastIndexOfUnderscore = expressionString.lastIndexOf('_');
								int variableStep = Integer.valueOf(expressionString.substring(lastIndexOfUnderscore + 1));
								if(variableStep > 0) {
									int variableIndex = Integer.valueOf(expressionString.substring(1, lastIndexOfUnderscore - 1));
									variablesAssignments[variableStep - 1][variableIndex] = ((ValueAssignment)a).getValue();
								}
							}
						}
						for(int i1 = 0; i1 < pathFromInitToCurrent.size(); i1++) {
							String newNameEvent = pathFromInitToCurrent.get(i1);
							String oldNameEvent = null;
							for(Entry<String, String> e : renameMap.entrySet()) {
								if(e.getValue().equals(newNameEvent)) {
									oldNameEvent = e.getKey();
									break;
								}
							}
							System.out.print(oldNameEvent + " \t::::: DATA ::::: { ");
							for(int i2 = 0; i2 < nbOfVariables; i2++) {
								System.out.print(variablesAssignments[i1][i2] == null ? "any " : variablesAssignments[i1][i2] + " ");
							}
							System.out.println('}');
						}
					}
					System.out.println("------------------------------");
					Console.printInfo(ConsoleType.FOADA, "Nodes Created : " + nbOfNodesCreated);
					Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nbOfNodesVisited);
					Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endTime - beginTime) + " ms");
					return false;
				}
			}
			catch (SolverException e) {
				throw new InterpolatingProverEnvironmentException(e);
			}
			catch (InterruptedException e) {
				throw new InterpolatingProverEnvironmentException(e);
			}
		// expand the current node if it is not covered
			// check if the current node is covered, if not then expand it
			if(currentNode.successors.isEmpty() && !currentNode.isCovered()) {
				for(String e : events) {
					FOADAConfiguration newNode = new FOADAConfiguration(nbOfNodesCreated++, JavaSMTConfig.bmgr.makeBoolean(true), currentNode, e);
					currentNode.addSuccessor(e, newNode);
					workList.add(newNode);
				}
			}
		}
		System.out.println("------------------------------");
		long endTime = System.currentTimeMillis();
		Console.printInfo(ConsoleType.FOADA, "Nodes Created : " + nbOfNodesCreated);
		Console.printInfo(ConsoleType.FOADA, "Nodes Visited : " + nbOfNodesVisited);
		Console.printInfo(ConsoleType.FOADA, "Time Used : " + (endTime - beginTime) + " ms");
		return true;
	}

}