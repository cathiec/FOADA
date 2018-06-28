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

public class BooleanFunction extends BooleanExpression {
	
	// name(ID) of the function
	public String id;
		
	// list of arguments IDs of the function
	public List<String> listOfArgumentsID;
	
	// list of arguments of the function
	public List<Expression> listOfArguments;
	
	public BooleanFunction(String s)
	{
		id = s;
		listOfArgumentsID = new ArrayList<String>();
		exprType = ExpressionType.Function;
	}
	
	public BooleanFunction(String s, List<String> ls)
	{
		id = s;
		listOfArgumentsID = new ArrayList<String>();
		for(String i : ls) {
			listOfArgumentsID.add(i);
		}
		exprType = ExpressionType.Function;
	}
	
	public void addArgument(String... ss)
	{
		for(String i : ss) {
			listOfArgumentsID.add(i);
		}
	}
	
	public void addArgument(List<String> ls)
	{
		for(String i : ls) {
			listOfArgumentsID.add(i);
		}
	}
	
	public BooleanFunction copy()
	{
		BooleanFunction x = new BooleanFunction(id, listOfArgumentsID);
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(" + id + " ";
		for(String i : listOfArgumentsID) {
			x = x + i + " ";
		}
		x = x.substring(0, x.length() - 1) + ')';
		return x;
	}
	
	public String toStandardString()
	{
		String x = id + "(";
		for(String i : listOfArgumentsID) {
			x = x + i + ",";
		}
		x = x.substring(0, x.length() - 1) + ')';
		return x;
	}

}
