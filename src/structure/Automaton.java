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
import exception.FOADAException;
import structure.FOADAExpression.ExpressionCategory;
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
	
	/** number of predicates
	 */
	public int nbOfPredicates;
	
	/** number of events
	 */
	public int nbOfEvents;
	
	/** number of variables
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
		nbOfPredicates = 0;
		nbOfEvents = 0;
		nbOfVariables = 0;
		utility.JavaSMTConfig.initJavaSMT();
	}
	
	public boolean isEmpty(utility.TreeSearch.Mode searchMode, utility.Impact.Mode transitionMode)
	{
		/** TODO **/	System.out.println("INIT : " + initial);
		/** TODO **/	System.out.println("FINAL : " + namesOfFinalStates);
		/** TODO **/	System.out.println("TRANS :");
		/** TODO **/	for(Entry<String, FOADATransition> t : transitions.entrySet()) {
		/** TODO **/		System.out.println(t.getKey() + " ---> " + t.getValue());
		/** TODO **/	}
		/** TODO **/	System.out.println(renameMap);
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
			/** TODO **/	System.out.println(currentNode);
			nbOfNodesVisited++;
			allValidNodes.add(currentNode);
		// calculate the path from the initial node to the current node
			List<String> pathFromInitToCurrent = new ArrayList<String>();
			// loop to find the path
			FOADAConfiguration c = currentNode;
			while(c.father != null) {
				pathFromInitToCurrent.add(0, c.fatherSymbol);
				c = c.father;
			}
			/** TODO **/	System.out.println("\tpath : " + pathFromInitToCurrent);
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
			// get all the occurrences of predicates in the current block
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
				/** TODO **/	System.out.println(predicatesInCurrentBlock);
			}
			else {
				predicatesOccurrencesInCurrentBlock = timeStampedInitial.findPredicatesOccurrences();
				/** TODO **/	System.out.println(predicatesOccurrencesInCurrentBlock);
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
						predicatesInNewBlock.addAll(transition.getPredicates());
						BooleanFormula currentPartOfNewBlock = transition.getUniversallyQuantifiedImplication(currentTimeStamp);
						smallPartsOfNewBlock.add(currentPartOfNewBlock);
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
					//TODO
				}
				currentTimeStamp++;
			}
			// compute the final conjunction (last block)
			List<BooleanFormula> finalConjunction = new ArrayList<BooleanFormula>();
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				for(FOADAExpression predicate : predicatesInCurrentBlock) {
					
				}
			}
			else {
				//TODO
			}
		}
		return true;
	}

}