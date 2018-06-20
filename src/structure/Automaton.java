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
import utility.ConsolePrint;
import utility.ConsolePrint.ConsoleType;

public class Automaton {
	
	// name(ID) of the automaton
	String id;
	
	// initial configuration
	BooleanExpression initial;
	
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
	
	public void setInitial(BooleanExpression e)
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
	
	public void checkType()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, " $$$$$$$$$$ ");
	}

}
