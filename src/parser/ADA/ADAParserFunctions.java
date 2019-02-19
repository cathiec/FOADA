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

package parser.ADA;

import java.util.ArrayList;
import java.util.List;

import structure.Automaton;
import structure.FOADAExpression;
import structure.FOADAExpression.ExpressionType;
import structure.FOADATransition;

public abstract class ADAParserFunctions {
	
	public static void addPredicate(Automaton automaton, String nameOfPredicate)
	{
		String newName = "q" + automaton.namesOfPredicates.size() + "c";
		automaton.renameMap.put(nameOfPredicate, newName);
		automaton.namesOfPredicates.add(newName);
	}
	
	public static void setInitial(Automaton automaton, FOADAExpression initial)
	{
		for(String original : automaton.renameMap.keySet()) {
			initial.substitue(original, automaton.renameMap.get(original));
		}
		automaton.initial = initial;
	}
	
	public static void addFinal(Automaton automaton, String nameOfPredicate)
	{
		automaton.namesOfFinalStates.add(automaton.renameMap.get(nameOfPredicate));
	}
	
	public static void addEvent(Automaton automaton, String nameOfEvent)
	{
		String newName = "e" + automaton.events.size() + "c";
		automaton.renameMap.put(nameOfEvent, newName);
		automaton.events.add(newName);
	}
	
	public static void addVariable(Automaton automaton, String nameOfVariable)
	{
		String original0 = nameOfVariable + "0";
		String newName0 = "a" + automaton.nbOfVariables + "c";
		String original1 = nameOfVariable + "1";
		String newName1 = "v" + automaton.nbOfVariables + "c";
		automaton.renameMap.put(original0, newName0);
		automaton.renameMap.put(original1, newName1);
		automaton.nbOfVariables = automaton.nbOfVariables + 1;
	}
	
	public static void setInitArguments(Automaton automaton)
	{
		automaton.initial.addInitArguments(automaton.nbOfVariables);
	}
	
	public static void addTransition(Automaton automaton, String nameOfPredicate, String event, FOADAExpression post)
	{
		List<String> argumentsNames = new ArrayList<String>();
		List<ExpressionType> argumentsTypes = new ArrayList<ExpressionType>();
		List<String> inputVarNames = new ArrayList<String>();
		List<ExpressionType> inputVarTypes = new ArrayList<ExpressionType>();
		for(String original : automaton.renameMap.keySet()) {
			post.substitue(original, automaton.renameMap.get(original));
		}
		for(int i = 0; i < automaton.nbOfVariables; i++) {
			argumentsNames.add("a" + i + "c");
			argumentsTypes.add(ExpressionType.Integer);
			inputVarNames.add("v" + i + "c");
			inputVarTypes.add(ExpressionType.Integer);
		}
		FOADATransition transition = new FOADATransition(automaton.renameMap.get(nameOfPredicate), argumentsNames, argumentsTypes, automaton.renameMap.get(event), inputVarNames, inputVarTypes, post);
		transition.right.finishTypes();
		transition.right.addArguments(automaton.nbOfVariables);
		automaton.transitions.put(automaton.renameMap.get(nameOfPredicate) + "+" + automaton.renameMap.get(event), transition);
	}

}
