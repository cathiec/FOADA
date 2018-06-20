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

public class Plus extends IntegerExpression {

	// list of sub-parts of the PLUS expression
	List<IntegerExpression> sub;
	
	public Plus(IntegerExpression... ies)
	{
		sub = new ArrayList<IntegerExpression>();
		for(IntegerExpression i : ies) {
			sub.add(i.copy());
		}
		exprType = ExpressionType.Plus;
	}
	
	public Plus(List<IntegerExpression> lie)
	{
		sub = new ArrayList<IntegerExpression>();
		for(IntegerExpression i : lie) {
			sub.add(i.copy());
		}
		exprType = ExpressionType.Plus;
	}
	
	public Plus copy()
	{
		Plus x = new Plus(sub);
		return x;
	}

}
