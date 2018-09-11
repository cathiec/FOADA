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

package parser;

import exception.*;
import utility.Console;
import utility.Console.ConsoleType;

// general structure for Parser (abstract class)
public abstract class Parser {
	
	public enum ParserType {
		PAParser,
		ADAParser,
		SMTParser,
		FOADAParser
	};
	
	public static ParserType selectAccordingToInputFile(String filename)
			throws FOADAException
	{
		int strLength = filename.length();
		if(strLength >= 3 && filename.substring(strLength - 3, strLength).equals(".pa")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.pa" + Console.RESET + " >.");
			return ParserType.PAParser;
		}
		else if(strLength >= 4 && filename.substring(strLength - 4, strLength).equals(".ada")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.ada" + Console.RESET + " >.");
			return ParserType.ADAParser;
		}
		else if(strLength >= 4 && filename.substring(strLength - 4, strLength).equals(".smt")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.smt" + Console.RESET + " >.");
			return ParserType.SMTParser;
		}
		else if(strLength >= 6 && filename.substring(strLength - 6, strLength).equals(".foada")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.foada" + Console.RESET + " >.");
			return ParserType.FOADAParser;
		}
		else {
			throw new InputFileUnsupportedException(filename);
		}
	}

}
