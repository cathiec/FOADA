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

import exception.AmbiguousVariableException;
import exception.FOADAException;
import structure.Expression.*;

public class Transition extends BasicObject {
	
	public String from;
	
	public Map<String, ExpressionType> argumentsOfFrom;
	
	public String event;
	
	public Map<String, ExpressionType> argumentsOfEvent;
	
	public Expression to;
	
	public Transition(String s1, Map<String, ExpressionType> m1, String s2, Map<String, ExpressionType> m2, Expression e)
	{
		from = s1;
		argumentsOfFrom = new LinkedHashMap<String, ExpressionType>();
		argumentsOfFrom.putAll(m1);
		event = s2;
		argumentsOfEvent = new LinkedHashMap<String, ExpressionType>();
		argumentsOfEvent.putAll(m2);
		to = e.copy();
	}
	
	public Transition(Transition another)
	{
		from = another.from;
		argumentsOfFrom = new LinkedHashMap<String, ExpressionType>();
		argumentsOfFrom.putAll(another.argumentsOfFrom);
		event = another.event;
		argumentsOfEvent = new LinkedHashMap<String, ExpressionType>();
		argumentsOfEvent.putAll(another.argumentsOfEvent);
		to = another.to.copy();
	}
	
	public void finishType(Map<String, ExpressionType> variablesTypes, Map<String, List<ExpressionType>> variablesInputTypes)
			throws FOADAException
	{
		Map<String, ExpressionType> copyVariablesTypes = new LinkedHashMap<String, ExpressionType>();
		copyVariablesTypes.putAll(variablesTypes);
		for(String s : argumentsOfFrom.keySet()) {
			if(copyVariablesTypes.containsKey(s)) {
				throw new AmbiguousVariableException(s);
			}
			copyVariablesTypes.put(s, argumentsOfFrom.get(s));
		}
		for(String s : argumentsOfEvent.keySet()) {
			if(copyVariablesTypes.containsKey(s)) {
				throw new AmbiguousVariableException(s);
			}
			copyVariablesTypes.put(s, argumentsOfEvent.get(s));
		}
		to.finishType(copyVariablesTypes, variablesInputTypes);
	}
	
	public void checkType()
			throws FOADAException
	{
		to.checkType(ExpressionType.Boolean);
	}
	
	public Transition copy()
	{
		Transition x = new Transition(this);
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(trans (" + from + " (";
		if(argumentsOfFrom.size() == 0) {
			x = x + ')';
		}
		else {
			for(String s : argumentsOfFrom.keySet()) {
				if(argumentsOfFrom.get(s) == ExpressionType.Boolean) {
					x = x + '(' + s + " Bool) ";
				}
				else if(argumentsOfFrom.get(s) == ExpressionType.Integer) {
					x = x + '(' + s + " Int) ";
				}
			}
			x = x.substring(0, x.length() - 1) + ')';
		}
		x = x + ") (" + event + " (";
		if(argumentsOfEvent.size() == 0) {
			x = x + ')';
		}
		else {
			for(String s : argumentsOfEvent.keySet()) {
				if(argumentsOfEvent.get(s) == ExpressionType.Boolean) {
					x = x + '(' + s + " Bool) ";
				}
				else if(argumentsOfEvent.get(s) == ExpressionType.Integer) {
					x = x + '(' + s + " Int) ";
				}
			}
			x = x.substring(0, x.length() - 1) + ')';
		}
		x = x + ") " + to.toSMTString() + ')';
		return x;
	}

}
