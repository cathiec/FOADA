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

import java.util.*;
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
	
	/** default constructor
	 * @param	name	name of the automaton
	 */
	public Automaton(String name)
	{
		this.name = name;
		renameMap = new LinkedHashMap<String, String>();
		eventSymbols = new ArrayList<String>();
		variables = new ArrayList<String>();
		variableTypeMap = new LinkedHashMap<String, ExpressionType>();
		predicates = new ArrayList<String>();
		initialState = null;
		finalStates = new ArrayList<String>();
		transitions = new LinkedHashMap<String, FOADAExpression>();
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
	 * 
	 */
	public void addTransition(String predicate, List<String> listOfArguments, String symbol, String variable, FOADAExpression post)
	{
		System.out.println(predicate + '(' + listOfArguments + ')' + " : " + symbol + '(' + variable + ')' + " => " + post);
		//System.out.println(post.category +  " => " + post);
	}
	
	/** rename a predicate and then add it into the set of predicates (do nothing if already added)
	 */
	public void addPredicate(String predicate)
	{
		if(!renameMap.containsKey(predicate)) {
			String newName = "q" + predicates.size();
			renameMap.put(predicate, newName);
			predicates.add(newName);
		}
	}
	
	/** check if the automaton is empty
	 * @return	<b> true </b> if the automaton is empty </br>
	 * 			<b> false </b> if the automaton is not empty
	 */
	public boolean isEmpty()
	{
		System.out.println(name);
		System.out.println(initialState);
		System.out.println(finalStates);
		return true;
	}

}
