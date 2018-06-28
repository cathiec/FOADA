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

public class Or extends BooleanExpression {
	
	// list of sub-parts of the OR expression
	List<BooleanExpression> sub;
	
	public Or(BooleanExpression... bes)
	{
		sub = new ArrayList<BooleanExpression>();
		for(BooleanExpression i : bes) {
			sub.add(i.copy());
		}
		exprType = ExpressionType.Or;
	}
	
	public Or(List<BooleanExpression> lbe)
	{
		sub = new ArrayList<BooleanExpression>();
		for(BooleanExpression i : lbe) {
			sub.add(i.copy());
		}
		exprType = ExpressionType.Or;
	}
	
	public Or copy()
	{
		Or x = new Or(sub);
		return x;
	}
	
	public String toSMTString()
	{
		String x = "(or ";
		for(BooleanExpression i : sub) {
			x = x + i.toSMTString() + " ";
		}
		x = x.substring(0, x.length() - 1) + ')';
		return x;
	}
	
	public String toStandardString()
	{
		String x = "(";
		for(BooleanExpression i : sub) {
			x = x + i.toStandardString() + " \\/ ";
		}
		x = x.substring(0, x.length() - 4) + ')';
		return x;
	}

}