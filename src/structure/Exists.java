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

public class Exists extends BooleanExpression {
	
	// list of arguments
	public List<Argument> listOfArguments;
	
	// sub-part of the EXISTS expression
	public BooleanExpression sub;

	public Exists(List<Argument> la, BooleanExpression be)
	{
		listOfArguments = new ArrayList<Argument>();
		for(Argument i : la) {
			listOfArguments.add(i.copy());
		}
		sub = be.copy();
		exprType = ExpressionType.Exists;
	}
	
	public Exists copy()
	{
		Exists x = new Exists(listOfArguments, sub);
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(exists (";
		for(Argument i : listOfArguments) {
			x = x + i.toSMTString() + " ";
		}
		x = x.substring(0, x.length() - 1) + ") " + sub.toSMTString() + ')';
		return x;
	}
	
	public String toStandardString()
	{
		String x = "exists ";
		for(Argument i : listOfArguments) {
			x = x + i.toStandardString() + ",";
		}
		x = x.substring(0, x.length() - 1) + " : " + sub.toStandardString();
		return x;
	}

}
