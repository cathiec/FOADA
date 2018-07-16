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

public class Expression extends BasicObject {
	
	public enum ExpressionType {Boolean, Integer, Unknown};
	
	public enum ExpressionSubtype {Constant, Function, Distinct, Equals, Not, And, Or, Exists, Forall, GT, LT, GEQ, LEQ, Plus, Minus, Times, Slash};
	
	public ExpressionType type;
	public List<ExpressionType> inputTypes;
	
	public ExpressionSubtype subtype;
	
	public List<Expression> sub;
	
	public int intValue;
	
	public boolean boolValue;
	
	public String name;
	
	public Map<String, ExpressionType> variablesExistsForall;
	
	// constructor for integer constants
	public Expression(int i)
	{
		type = ExpressionType.Integer;
		inputTypes = new ArrayList<ExpressionType>();
		subtype = ExpressionSubtype.Constant;
		sub = new ArrayList<Expression>();
		intValue = i;
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
	}
	
	// constructor for Boolean constants
	public Expression(boolean b)
	{
		type = ExpressionType.Boolean;
		inputTypes = new ArrayList<ExpressionType>();
		subtype = ExpressionSubtype.Constant;
		sub = new ArrayList<Expression>();
		boolValue = b;
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
	}
	
	// constructor for integer/Boolean functions
	public Expression(String s, Expression... es)
	{
		type = ExpressionType.Unknown;
		inputTypes = new ArrayList<ExpressionType>();
		subtype = ExpressionSubtype.Function;
		sub = new ArrayList<Expression>();
		name = s;
		for(Expression e : es) {
			sub.add(e.copy());
			inputTypes.add(e.type);
		}
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
	}
	
	// add an argument to an integer/Boolean functions
	public void addArgument(Expression e)
	{
		sub.add(e.copy());
		inputTypes.add(e.type);
	}
	
	// constructor for exists/forall expressions
	public Expression(ExpressionSubtype t, Map<String, ExpressionType> m, Expression e)
	{
		type = ExpressionType.Boolean;
		inputTypes = new ArrayList<ExpressionType>();
		subtype = t;
		sub = new ArrayList<Expression>();
		sub.add(e.copy());
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
		variablesExistsForall.putAll(m);
	}
	
	// constructor for other kind of expressions
	public Expression(ExpressionSubtype t, Expression... es)
	{
		subtype = t;
		switch(t)
		{
		case Constant:	/* impossible call */ return;
		case Function:	/* impossible call */ return;
		case Distinct:	type = ExpressionType.Boolean; break;
		case Equals:	type = ExpressionType.Boolean; break;
		case Not:		type = ExpressionType.Boolean; break;
		case And:		type = ExpressionType.Boolean; break;
		case Or:		type = ExpressionType.Boolean; break;
		case Exists:	/* impossible call */ return;
		case Forall:	/* impossible call */ return;
		case GT:		type = ExpressionType.Boolean; break;
		case LT:		type = ExpressionType.Boolean; break;
		case GEQ:		type = ExpressionType.Boolean; break;
		case LEQ:		type = ExpressionType.Boolean; break;
		case Plus:		type = ExpressionType.Integer; break;
		case Minus:		type = ExpressionType.Integer; break;
		case Times:		type = ExpressionType.Integer; break;
		case Slash:		type = ExpressionType.Integer; break;
		}
		inputTypes = new ArrayList<ExpressionType>();
		sub = new ArrayList<Expression>();
		for(Expression e : es) {
			sub.add(e.copy());
		}
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
	}
	
	// copy constructor
	public Expression(Expression another)
	{
		type = another.type;
		inputTypes = new ArrayList<ExpressionType>();
		for(ExpressionType t : another.inputTypes) {
			inputTypes.add(t);
		}
		subtype = another.subtype;
		sub = new ArrayList<Expression>();
		for(Expression e : another.sub) {
			sub.add(e.copy());
		}
		intValue = another.intValue;
		boolValue = another.boolValue;
		name = another.name;
		variablesExistsForall = new LinkedHashMap<String, ExpressionType>();
		variablesExistsForall.putAll(another.variablesExistsForall);
	}
	
	// finish the type structure
	public void finishType(Map<String, ExpressionType> variablesTypes, Map<String, List<ExpressionType>> variablesInputTypes)
			throws FOADAException
	{
		Map<String, ExpressionType> copyVariablesTypes = new LinkedHashMap<String, ExpressionType>();
		copyVariablesTypes.putAll(variablesTypes);
		if(subtype == ExpressionSubtype.Function) {
			if(variablesTypes.get(name) != null) {
				type = variablesTypes.get(name);
			}
			if(variablesInputTypes.get(name) != null) {
				inputTypes.clear();
				inputTypes.addAll(variablesInputTypes.get(name));
			}
		}
		if(subtype == ExpressionSubtype.Exists || subtype == ExpressionSubtype.Forall) {
			for(String s : variablesExistsForall.keySet()) {
				if(copyVariablesTypes.containsKey(s)) {
					throw new AmbiguousVariableException(s);
				}
				copyVariablesTypes.put(s, variablesExistsForall.get(s));
			}
		}
		for(Expression e : sub) {
			e.finishType(copyVariablesTypes, variablesInputTypes);
		}
	}
	
	// check the type structure
	public void checkType(ExpressionType ec)
			throws FOADAException
	{
		//System.out.println(toSMTString() + ": " + getCompleteTypeString());
		if(type == ExpressionType.Unknown) {
			throw new VariableUndeclaredException(name);
		}
		else if(type != ec) {
			throw new CategoryConflictException(toSMTString(), ec, type);
		}
		ExpressionType subCategory = ExpressionType.Unknown;
		switch(subtype)
		{
		case Constant:	return;
		case Function:	int i = 0;
						if(sub.size() != inputTypes.size()) {
							ArrayList<ExpressionType> is = new ArrayList<ExpressionType>();
							for(Expression e : sub) {
								is.add(e.type);
							}
							throw new VariableOverriddenException(name, inputTypes, is);
						}
						for(Expression e : sub) {
							e.checkType(inputTypes.get(i++));
						}
						return;
		case Distinct:	subCategory = sub.get(0).type;
						break;
		case Equals:	subCategory = sub.get(0).type;
						break;
		case Not:		subCategory = ExpressionType.Boolean;
						break;
		case And:		subCategory = ExpressionType.Boolean;
						break;
		case Or:		subCategory = ExpressionType.Boolean;
						break;
		case Exists:	subCategory = ExpressionType.Boolean;
						break;
		case Forall:	subCategory = ExpressionType.Boolean;
						break;
		case GT:		subCategory = ExpressionType.Integer;
						break;
		case LT:		subCategory = ExpressionType.Integer;
						break;
		case GEQ:		subCategory = ExpressionType.Integer;
						break;
		case LEQ:		subCategory = ExpressionType.Integer;
						break;
		case Plus:		subCategory = ExpressionType.Integer;
						break;
		case Minus:		subCategory = ExpressionType.Integer;
						break;
		case Times:		subCategory = ExpressionType.Integer;
						break;
		case Slash:		subCategory = ExpressionType.Integer;
						break;
		}
		for(Expression e : sub) {
			e.checkType(subCategory);
		}
	}
	
	public Expression copy()
	{
		Expression x = new Expression(this);
		return x;
	}
	
	public String toSMTString()
			throws FOADAException
	{
		String x;
		switch(subtype)
		{
		case Constant:	if(type == ExpressionType.Boolean) {
							return Boolean.toString(boolValue);
						}
						else if(type == ExpressionType.Integer) {
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
							if(variablesExistsForall.get(s) == ExpressionType.Boolean) {
								x = x + '(' + s + " Bool) ";
							}
							else if(variablesExistsForall.get(s) == ExpressionType.Integer) {
								x = x + '(' + s + " Int) ";
							}
						}
						x = x.substring(0, x.length() - 1) + ") " + sub.get(0).toSMTString() + ')';
						return x;
		case Forall:	x = "(forall (";
						for(String s : variablesExistsForall.keySet()) {
							if(variablesExistsForall.get(s) == ExpressionType.Boolean) {
								x = x + '(' + s + " Bool) ";
							}
							else if(variablesExistsForall.get(s) == ExpressionType.Integer) {
								x = x + '(' + s + " Int) ";
							}
						}
						x = x.substring(0, x.length() - 1) + ") " + sub.get(0).toSMTString() + ')';
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

}
