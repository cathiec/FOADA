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

import structure.Expression.*;

public class Transition extends BasicObject {
	
	public String from;
	
	public Map<String, ExpressionCategory> argumentsOfFrom;
	
	public String event;
	
	public Map<String, ExpressionCategory> argumentsOfEvent;
	
	public Expression to;
	
	public Transition(String s1, Map<String, ExpressionCategory> m1, String s2, Map<String, ExpressionCategory> m2, Expression e)
	{
		from = s1;
		argumentsOfFrom = new HashMap<String, ExpressionCategory>();
		argumentsOfFrom.putAll(m1);
		event = s2;
		argumentsOfEvent = new HashMap<String, ExpressionCategory>();
		argumentsOfEvent.putAll(m2);
		to = e.copy();
	}
	
	public Transition(Transition another)
	{
		from = another.from;
		argumentsOfFrom = new HashMap<String, ExpressionCategory>();
		argumentsOfFrom.putAll(another.argumentsOfFrom);
		event = another.event;
		argumentsOfEvent = new HashMap<String, ExpressionCategory>();
		argumentsOfEvent.putAll(another.argumentsOfEvent);
		to = another.to.copy();
	}
	
	public Transition copy()
	{
		Transition x = new Transition(this);
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(trans (" + from + " (";
		for(String s : argumentsOfFrom.keySet()) {
			if(argumentsOfFrom.get(s) == ExpressionCategory.Boolean) {
				x = x + '(' + s + " Bool) ";
			}
			else if(argumentsOfFrom.get(s) == ExpressionCategory.Integer) {
				x = x + '(' + s + " Int) ";
			}
		}
		x = x.substring(0, x.length() - 1) + ")) (" + event + " (";
		for(String s : argumentsOfEvent.keySet()) {
			if(argumentsOfEvent.get(s) == ExpressionCategory.Boolean) {
				x = x + '(' + s + " Bool) ";
			}
			else if(argumentsOfEvent.get(s) == ExpressionCategory.Integer) {
				x = x + '(' + s + " Int) ";
			}
		}
		x = x.substring(0, x.length() - 1) + ")) " + to.toSMTString() + ')';
		return x;
	}
	
	public String toStandardString()
	{
		return "";
	}

}
