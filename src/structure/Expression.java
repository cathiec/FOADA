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

public class Expression extends BasicObject {
	
	public enum ExpressionCategory {Boolean, Integer, Unknown};
	
	public enum ExpressionType {Constant, Function, Distinct, Equals, Not, And, Or, Exists, Forall, GT, LT, GEQ, LEQ, Plus, Minus, Times, Slash};
	
	public ExpressionCategory category;
	
	public ExpressionType type;
	
	public List<Expression> sub;
	
	public int intValue;
	
	public boolean boolValue;
	
	public String name;
	
	public Map<String, ExpressionCategory> variablesExistsForall;
	
	// integer constant
	public Expression(int i)
	{
		category = ExpressionCategory.Integer;
		type = ExpressionType.Constant;
		sub = new ArrayList<Expression>();
		intValue = i;
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
	}
	
	// Boolean constant
	public Expression(boolean b)
	{
		category = ExpressionCategory.Boolean;
		type = ExpressionType.Constant;
		sub = new ArrayList<Expression>();
		boolValue = b;
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
	}
	
	// integer/Boolean function
	public Expression(String s, Expression... es)
	{
		category = ExpressionCategory.Unknown;
		type = ExpressionType.Function;
		sub = new ArrayList<Expression>();
		name = s;
		for(Expression e : es) {
			sub.add(e.copy());
		}
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
	}
	
	public void addArgument(Expression e)
	{
		sub.add(e.copy());
	}
	
	// exists/forall
	public Expression(ExpressionType t, Map<String, ExpressionCategory> m, Expression e)
	{
		category = ExpressionCategory.Boolean;
		type = t;
		sub = new ArrayList<Expression>();
		sub.add(e.copy());
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
		variablesExistsForall.putAll(m);
	}
	
	// other kind of expression
	public Expression(ExpressionType t, Expression... es)
	{
		type = t;
		switch(t)
		{
		case Constant:	/* impossible call */ return;
		case Function:	/* impossible call */ return;
		case Distinct:	category = ExpressionCategory.Unknown; break;
		case Equals:	category = ExpressionCategory.Unknown; break;
		case Not:		category = ExpressionCategory.Boolean; break;
		case And:		category = ExpressionCategory.Boolean; break;
		case Or:		category = ExpressionCategory.Boolean; break;
		case Exists:	/* impossible call */ return;
		case Forall:	/* impossible call */ return;
		case GT:		category = ExpressionCategory.Boolean; break;
		case LT:		category = ExpressionCategory.Boolean; break;
		case GEQ:		category = ExpressionCategory.Boolean; break;
		case LEQ:		category = ExpressionCategory.Boolean; break;
		case Plus:		category = ExpressionCategory.Integer; break;
		case Minus:		category = ExpressionCategory.Integer; break;
		case Times:		category = ExpressionCategory.Integer; break;
		case Slash:		category = ExpressionCategory.Integer; break;
		}
		sub = new ArrayList<Expression>();
		for(Expression e : es) {
			sub.add(e.copy());
		}
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
	}
	
	public Expression(Expression another)
	{
		category = another.category;
		type = another.type;
		sub = new ArrayList<Expression>();
		for(Expression e : another.sub) {
			sub.add(e.copy());
		}
		intValue = another.intValue;
		boolValue = another.boolValue;
		name = another.name;
		variablesExistsForall = new HashMap<String, ExpressionCategory>();
		variablesExistsForall.putAll(another.variablesExistsForall);
	}
	
	public Expression copy()
	{
		Expression x = new Expression(this);
		return x;
	}
	
	public String toSMTString()
	{
		String x;
		switch(type)
		{
		case Constant:	if(category == ExpressionCategory.Boolean) {
							return Boolean.toString(boolValue);
						}
						else if(category == ExpressionCategory.Integer) {
							return Integer.toString(intValue);
						}
		case Function:	if(sub.size() > 0) {
							x = '(' + name + ' ';
							for(Expression e : sub) {
								x = x + e.toSMTString() + ' ';
							}
							x = x.substring(0, x.length() - 1) + ')';
						}
						else {
							x = name;
						}
						return x;
		case Distinct:	return "(distinct " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case Equals:	return "(= " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case Not:		return "(not " + sub.get(0).toSMTString() + ')';
		case And:		x = "(and ";
						for(Expression e : sub) {
							x = x + e.toSMTString() + ' ';
						}
						x = x.substring(0, x.length() - 1) + ')';
						return x;
		case Or:		x = "(or ";
						for(Expression e : sub) {
							x = x + e.toSMTString() + ' ';
						}
						x = x.substring(0, x.length() - 1) + ')';
						return x;
		case Exists:	x = "(exists (";
						for(String s : variablesExistsForall.keySet()) {
							if(variablesExistsForall.get(s) == ExpressionCategory.Boolean) {
								x = x + '(' + s + " Bool) ";
							}
							else if(variablesExistsForall.get(s) == ExpressionCategory.Integer) {
								x = x + '(' + s + " Int) ";
							}
						}
						x = x.substring(0, x.length() - 1) + ')' + sub.get(0).toSMTString() + ')';
						return x;
		case Forall:	x = "(forall (";
						for(String s : variablesExistsForall.keySet()) {
							if(variablesExistsForall.get(s) == ExpressionCategory.Boolean) {
								x = x + '(' + s + " Bool) ";
							}
							else if(variablesExistsForall.get(s) == ExpressionCategory.Integer) {
								x = x + '(' + s + " Int) ";
							}
						}
						x = x.substring(0, x.length() - 1) + ')' + sub.get(0).toSMTString() + ')';
						return x;
		case GT:		return "(> " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case LT:		return "(< " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case GEQ:		return "(>= " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case LEQ:		return "(<= " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case Plus:		x = "(+ ";
						for(Expression e : sub) {
							x = x + e.toSMTString() + ' ';
						}
						x = x.substring(0, x.length() - 1) + ')';
						return x;
		case Minus:		return "(- " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		case Times:		x = "(* ";
						for(Expression e : sub) {
							x = x + e.toSMTString() + ' ';
						}
						x = x.substring(0, x.length() - 1) + ')';
						return x;
		case Slash:		return "(/ " + sub.get(0).toSMTString() + ' ' + sub.get(1).toSMTString() + ')';
		}
		/* never reach here */ return "";
	}
	
	public String toStandardString()
	{
		return "";
	}

}
