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

package parser.PA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import structure.Automaton;
import structure.FOADAExpression;
import structure.FOADAExpression.ExpressionType;
import structure.FOADATransition;

public abstract class PAParserFunctions {
	
	public static void setInitial(Automaton automaton, FOADAExpression initial)
	{
		automaton.initial = initial;
	}
	
	public static void setFinal(Automaton automaton, List<String> finalList)
	{
		automaton.namesOfFinalStates.addAll(finalList);
	}
	
	public static void addTransition(Automaton automaton, String left, List<String> argumentList, String event, String inputVarName, FOADAExpression post)
	{
		String newNameLeft;
		if(!automaton.renameMap.containsKey(left.replaceAll("\\s*", ""))) {
			newNameLeft = "q" + automaton.namesOfPredicates.size() + "c";
			automaton.renameMap.put(left.replaceAll("\\s*", ""), newNameLeft);
			automaton.namesOfPredicates.add(newNameLeft);
		}
		else {
			newNameLeft = automaton.renameMap.get(left.replaceAll("\\s*", ""));
		}
		int nbRenamedArguments = 0;
		for(int i = 0; i < argumentList.size(); i++) {
			String original = argumentList.get(i);
			String newNameArgument = "a" + nbRenamedArguments + "c";
			post.substitue(original, newNameArgument);
			nbRenamedArguments++;
			argumentList.set(i, newNameArgument);
		}
		List<ExpressionType> argumentsTypes = new ArrayList<ExpressionType>();
		for(int i = 1; i <= argumentList.size(); i++) {
			argumentsTypes.add(ExpressionType.Integer);
		}
		String newNameEvent;
		if(!automaton.renameMap.containsKey(event.replaceAll("\\s*", ""))) {
			newNameEvent = "e" + automaton.events.size() + "c";
			automaton.renameMap.put(event.replaceAll("\\s*", ""), newNameEvent);
			automaton.events.add(newNameEvent);
		}
		else {
			newNameEvent = automaton.renameMap.get(event.replaceAll("\\s*", ""));
		}
		List<String> inputVarNames = new ArrayList<String>();
		String newNameInputVar = "v0c";
		post.substitue(inputVarName, newNameInputVar);
		inputVarNames.add(newNameInputVar);
		List<ExpressionType> inputVarTypes = new ArrayList<ExpressionType>();
		inputVarTypes.add(ExpressionType.Integer);
		FOADATransition transition = new FOADATransition(newNameLeft, argumentList, argumentsTypes, newNameEvent, inputVarNames, inputVarTypes, post);
		automaton.transitions.put(newNameLeft + "+" + newNameEvent, transition);
	}
	
	public static void finalize(Automaton automaton)
	{
		for(Entry<String, String> e : automaton.renameMap.entrySet()) {
			automaton.initial.substitue(e.getKey(), e.getValue());
			for(int i = 0; i < automaton.namesOfFinalStates.size(); i++) {
				if(automaton.namesOfFinalStates.get(i).equals(e.getKey())) {
					automaton.namesOfFinalStates.set(i, e.getValue());
				}
			}
			for(FOADATransition transition : automaton.transitions.values()) {
				if(transition.event.equals(e.getKey())) {
					transition.event = e.getValue();
				}
				transition.right.substitue(e.getKey(), e.getValue());
			}
		}
		automaton.nbOfVariables = 1;
	}

}
