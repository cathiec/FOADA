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

package parser.FOADA;

import java.util.List;

import exception.FOADAException;
import structure.Automaton;
import structure.FOADAExpression;
import structure.FOADATransition;

public abstract class FOADAParserFunctions {
	
	public static void addPredicate(Automaton automaton, String nameOfPredicate)
	{
		String newName = "q" + automaton.namesOfPredicates.size() + "c";
		automaton.renameMap.put(nameOfPredicate, newName);
		automaton.namesOfPredicates.add(newName);
	}
	
	public static void addEvent(Automaton automaton, String nameOfEvent)
	{
		String newName = "e" + automaton.events.size() + "c";
		automaton.renameMap.put(nameOfEvent, newName);
		automaton.events.add(newName);
	}
	
	public static void setInitial(Automaton automaton, FOADAExpression initial)
	{
		for(String original : automaton.renameMap.keySet()) {
			initial.substitute(original, automaton.renameMap.get(original));
		}
		automaton.initial = initial;
	}
	
	public static void addFinal(Automaton automaton, String nameOfPredicate)
	{
		automaton.namesOfFinalStates.add(automaton.renameMap.get(nameOfPredicate));
	}
	
	public static void addTransition(Automaton automaton,
										String nameOfPredicate,
										List<String> argumentsNames,
										List<FOADAExpression.ExpressionType> argumentsTypes,
										String event,
										List<String> inputVarNames,
										List<FOADAExpression.ExpressionType> inputVarTypes,
										FOADAExpression post)
			throws FOADAException
	{
		post.finishTypes(argumentsNames, argumentsTypes, inputVarNames, inputVarTypes);
		for(int i = 0; i < inputVarNames.size(); i++) {
			String original = inputVarNames.get(i);
			if(automaton.renameMap.containsKey(original)) {
				inputVarNames.set(i, automaton.renameMap.get(original));
			}
			else {
				String newName = "v" + automaton.nbOfVariables + "c";
				automaton.renameMap.put(original, newName);
				automaton.nbOfVariables = automaton.nbOfVariables + 1;
				inputVarNames.set(i, newName);
			}
		}
		for(String original : automaton.renameMap.keySet()) {
			post.substitute(original, automaton.renameMap.get(original));
		}
		int nbRenamedArguments = 0;
		for(int i = 0; i < argumentsNames.size(); i++) {
			String original = argumentsNames.get(i);
			String newName = "a" + nbRenamedArguments + "c";
			post.substitute(original, newName);
			nbRenamedArguments++;
			argumentsNames.set(i, newName);
		}
		FOADATransition transition = new FOADATransition(automaton.renameMap.get(nameOfPredicate), argumentsNames, argumentsTypes, automaton.renameMap.get(event), inputVarNames, inputVarTypes, post);
		automaton.transitions.put(automaton.renameMap.get(nameOfPredicate) + "+" + automaton.renameMap.get(event), transition);
	}

}
