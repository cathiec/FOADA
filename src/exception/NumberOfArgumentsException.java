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

@SuppressWarnings("serial")
public class NumberOfArgumentsException extends FOADAException {
	
	private String name;
	
	private int shouldBe;
	
	private int is;
	
	public NumberOfArgumentsException(String s, int i1, int i2)
	{
		type = ExceptionType.NumberOfArguments;
		name = s;
		shouldBe = i1;
		is = i2;
	}
	
	public String getInfo()
	{
		if(shouldBe == 0) {
			return "\"" + name + "\" should have no argument but it has " + is + " argument(s).";
		}
		else if(is == 0) {
			return "\"" + name + "\" should have " + shouldBe + " argument(s) but it has no argument.";
		}
		else {
			return "\"" + name + "\" should have " + shouldBe + " argument(s) but it has " + is + " argument(s).";
		}
	}

}
