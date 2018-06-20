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

public class GEQ extends BooleanExpression {

	// left part of the GEQ expression
	IntegerExpression left;
	
	// right part of the GEQ expression
	IntegerExpression right;
	
	public GEQ(IntegerExpression ie1, IntegerExpression ie2)
	{
		left = ie1.copy();
		right = ie2.copy();
		exprType = ExpressionType.GEQ;
	}
	
	public GEQ copy()
	{
		GEQ x = new GEQ(left, right);
		return x;
	}
	
	public String toSMTString()
	{	
		return "(>= " + left.toSMTString() + " " + right.toSMTString() + ")";
	}
	
	public String toStandardString()
	{
		return left.toStandardString() + " >= " + right.toStandardString();
	}

}
