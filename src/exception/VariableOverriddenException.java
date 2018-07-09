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

package exception;

import java.util.*;
import structure.Expression.*;

@SuppressWarnings("serial")
public class VariableOverriddenException extends FOADAException {
	
	private String name;
	
	private List<ExpressionType> shouldBe;
	
	private List<ExpressionType> is;
	
	public VariableOverriddenException(String name, List<ExpressionType> shouldBe, List<ExpressionType> is)
	{
		type = ExceptionType.VariableOverridden;
		this.name = name;
		this.shouldBe = shouldBe;
		this.is = is;
	}
	
	public String getInfo()
	{
		String x = '\"' + name + '(';
		if(is.size() == 0) {
			x = x + ')';
		}
		else {
			for(ExpressionType e : is) {
				x = x + e + ' ';
			}
			x = x.substring(0, x.length() - 1) + ')';
		}
		x = x + "\" is not allowed because \"" + name + '(';
		if(shouldBe.size() == 0) {
			x = x + ')';
		}
		else {
			for(ExpressionType e : shouldBe) {
				x = x + e + ' ';
			}
			x = x.substring(0, x.length() - 1) + ')';
		}
		x = x + "\" was defined previously.";
		return x;
	}

}
