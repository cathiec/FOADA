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

package tool;

import utility.ConsoleColors;

public class SelectParser {
	
	public static parser.Parser selectParser(String input)
	{
		int strLength = input.length();
		parser.Parser parser;
		if(strLength >= 3 && input.substring(strLength - 3, strLength).equals(".pa")) {
			parser = new parser.ParserPA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.pa" + ConsoleColors.RESET);
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".ada")) {
			parser = new parser.ParserADA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.ada" + ConsoleColors.RESET);
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".smt")) {
			parser = new parser.ParserSMT();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.smt" + ConsoleColors.RESET);
		}
		else if(strLength >= 6 && input.substring(strLength - 6, strLength).equals(".foada")) {
			parser = new parser.ParserFOADA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.foada" + ConsoleColors.RESET);
		}
		else {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " Unknown type of the input file.");
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
			return null;
		}
		return parser;
	}

}
