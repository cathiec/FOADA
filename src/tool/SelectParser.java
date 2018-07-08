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

import utility.*;
import utility.ConsolePrint.ConsoleType;
import parser.Parser.*;
import exception.*;

public class SelectParser {
	
	public static ParserCategory determineCategory(String input)
			throws FOADAException
	{
		int strLength = input.length();
		if(strLength >= 3 && input.substring(strLength - 3, strLength).equals(".pa")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.pa" + ConsoleColors.RESET + " >.");
			return ParserCategory.Automaton;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".ada")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.ada" + ConsoleColors.RESET + " >.");
			return ParserCategory.Automaton;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".smt")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.smt" + ConsoleColors.RESET + " >.");
			return ParserCategory.Script;
		}
		else if(strLength >= 6 && input.substring(strLength - 6, strLength).equals(".foada")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.foada" + ConsoleColors.RESET + " >.");
			return ParserCategory.Automaton;
		}
		else {
			throw new UnknownTypeOfInputException();
		}
	}
	
	public static ParserType determineType(String input)
			throws FOADAException
	{
		int strLength = input.length();
		if(strLength >= 3 && input.substring(strLength - 3, strLength).equals(".pa")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.pa" + ConsoleColors.RESET + " >.");
			return ParserType.PA;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".ada")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.ada" + ConsoleColors.RESET + " >.");
			return ParserType.ADA;
		}
		else if(strLength >= 4 && input.substring(strLength - 4, strLength).equals(".smt")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.smt" + ConsoleColors.RESET + " >.");
			return ParserType.SMT;
		}
		else if(strLength >= 6 && input.substring(strLength - 6, strLength).equals(".foada")) {
			ConsolePrint.printInfo(ConsoleType.FOADA, "Type of the input file is < " + ConsoleColors.YELLOW_BRIGHT + "*.foada" + ConsoleColors.RESET + " >.");
			return ParserType.FOADA;
		}
		else {
			throw new UnknownTypeOfInputException();
		}
	}
	
	public static parser.Parser selectParser(String input)
			throws FOADAException
	{
		ParserType type = determineType(input);
		parser.Parser parser = null;
		switch(type)
		{
		case PA:	parser = new parser.ParserPA();	break;
		case ADA:	parser = new parser.ParserADA(); break;
		case SMT:	parser = new parser.ParserSMT(); break;
		case FOADA:	parser = new parser.ParserFOADA(); break;
		}
		return parser;
	}

}
