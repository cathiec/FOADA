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

public class Argument extends Expression {
	
	// name(ID) of the argument
	public String id;
	
	// type of the argument
	public ExpressionClass type;
	
	public Argument(String s, ExpressionClass ec)
	{
		id = s;
		type = ec;
		exprClass = ExpressionClass.Other;
		exprType = ExpressionType.Other;
	}
	
	public Argument copy()
	{
		Argument x = new Argument(id, type);
		return x;
	}
	
	@SuppressWarnings("incomplete-switch")
	public String toSMTString()
	{
		String x = "(" + id;
		switch(type)
		{
		case Integer: x = x + " Int)"; break;
		case Boolean: x = x + " Bool)"; break;
		}
		return x;
	}
	
	@SuppressWarnings("incomplete-switch")
	public String toStandardString()
	{
		String x = "";
		switch(type)
		{
		case Integer: x = "int " + id; break;
		case Boolean: x = "bool " + id; break;
		}
		return x;
	}

}
