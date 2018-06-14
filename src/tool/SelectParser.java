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
import parser.Parser.*;

public class SelectParser {
	
	public static ParserType determineType(String input)
	{
		int strLength = input.length();
		if(strLength >= 3 && input.substring(strLength - 3, strLength).equals(".pa")) {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.pa" + ConsoleColors.RESET);
			return ParserType.PA;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".ada")) {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.ada" + ConsoleColors.RESET);
			return ParserType.ADA;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".smt")) {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.smt" + ConsoleColors.RESET);
			return ParserType.SMT;
		}
		else if(strLength >= 6 && input.substring(strLength - 6, strLength).equals(".foada")) {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.foada" + ConsoleColors.RESET);
			return ParserType.FOADA;
		}
		else {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " Unknown type of the input file.");
			return ParserType.UNKNOWN;
		}
	}
	
	public static parser.Parser selectParser(String input)
	{
		ParserType type = determineType(input);
		parser.Parser parser;
		switch(type)
		{
		case PA: parser = new parser.ParserPA(); break;
		case ADA: parser = new parser.ParserADA(); break;
		case SMT: parser = new parser.ParserSMT(); break;
		case FOADA: parser = new parser.ParserFOADA(); break;
		case UNKNOWN: return null;
		default: return null;
		}
		return parser;
	}

}
