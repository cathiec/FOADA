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

import exception.*;
import structure.Expression.ExpressionCategory;
import utility.ConsolePrint;
import utility.ConsolePrint.ConsoleType;

public class Automaton extends BasicObject {
	
	// name(ID) of the automaton
	String id;
	
	// initial configuration
	Expression initial;
	
	// list of names(IDs) of the final states
	List<String> listOfIDFinals;
	
	// list of transitions
	List<Transition> listOfTransitions;
	
	public Automaton(String s)
	{
		id = s;
		initial = null;
		listOfIDFinals = new ArrayList<String>();
		listOfTransitions = new ArrayList<Transition>();
	}
	
	public void setInitial(Expression e)
			throws InitialRedundancyException
	{
		if(initial == null) {
			initial = e;
		}
		else {
			throw new InitialRedundancyException();
		}
	}
	
	public void setFinals(List<String> l)
			throws FinalRedundancyException
	{
		if(listOfIDFinals.size() == 0) {
			listOfIDFinals.addAll(l);
		}
		else {
			throw new FinalRedundancyException();
		}
	}
	
	public void addTransition(Transition t)
	{
		listOfTransitions.add(t.copy());
	}
	
	public void finishCategory()
			throws FOADAException
	{
		Map<String, ExpressionCategory> tableVariables = new HashMap<String, ExpressionCategory>();
		for(Transition t : listOfTransitions) {
			tableVariables.put(t.from, ExpressionCategory.Boolean);
		}
		for(Transition t : listOfTransitions) {
				t.finishCategory(tableVariables);
		}
	}
	
	public void checkCategory()
			throws FOADAException
	{
		for(Transition t : listOfTransitions) {
			try {
				t.checkCategory();
			}
			catch(FOADAException e)
			{
				ConsolePrint.printError(ConsoleType.FOADA, "Type error has been found in the transition rule \"" + t.toSMTString() + "\"");
				throw e;
			}
		}
	}
	
	public boolean checkEmpty()
	{
		return false;
	}
	
	public Automaton copy()
	{
		Automaton x = new Automaton(id);
		x.initial = initial.copy();
		x.listOfIDFinals.addAll(listOfIDFinals);
		for(Transition t : listOfTransitions) {
			x.addTransition(t);
		}
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(define-automaton " + id + "\n";
		if(initial != null) {
			x = x + "\t(init " + initial.toSMTString() + ")\n";
		}
		else {
			x = x + "\t(init)\n";
		}
		if(listOfIDFinals.size() == 0) {
			x = x + "\t(final)\n";
		}
		else {
			x = x + "\t(final (";
			for(String s : listOfIDFinals) {
				x = x + s + " ";
			}
			x = x.substring(0, x.length() - 1) + "))\n";
		}
		for(Transition t : listOfTransitions) {
			x = x + "\t" + t.toSMTString() + "\n";
		}
		x = x + ')';
		return x;
	}

}
