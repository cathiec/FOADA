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

package app;

import org.sosy_lab.common.configuration.InvalidConfigurationException;

import tool.*;
import utility.ConsoleColors;

public class FOADA {
	
	// no argument
	private static void welcome()
	{
		System.out.println("------------------------------");
		System.out.println("      FOADA Version 1.0");
		System.out.println("------------------------------");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "[Options]");
		System.out.println("\t-cs \t\t check all the solvers");
		System.out.println("\t-p <input> \t parse an input file to check its grammar");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// -cs
	private static void checkSolvers() throws InvalidConfigurationException
	{
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Start checking all the solvers...");
		CheckSolver.checkSMTINTERPOL();
		CheckSolver.checkZ3();
		CheckSolver.checkMATHSAT5();
		CheckSolver.checkPRINCESS();
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// -p <input>
	private static void parse(String input) throws Exception
	{
		System.out.println(ConsoleColors.CYAN + "ANTLR4 > " + ConsoleColors.RESET + "Parsing and checking the grammar of the input...");
		parser.ParserFOADA.test(input);
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	public static void main(String[] args) throws Exception
	{
		if(args.length == 0) {
			welcome();
		}
		else if(args[0].equals("-cs")) {
			checkSolvers();
		}
		else if(args[0].equals("-p")) {
			parse(args[1]);
		}
	}
}
