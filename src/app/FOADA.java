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
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Showing all the options...");
		System.out.println("\t-cs \t\t check all the solvers");
		System.out.println("\t-g <input> \t parse an input file to check its grammar");
		System.out.println("\t-r <input> \t run an SMT-like input file");
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
	
	// -g <input>
	private static void checkGrammar(String input) throws Exception
	{
		int strLength = input.length();
		int inputType = 0;
		parser.Parser parser;
		if(input.substring(strLength - 3, strLength).equals(".pa")) {
			inputType = 1;
			parser = new parser.ParserPA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.pa" + ConsoleColors.RESET);
		}
		else if(input.substring(strLength - 4, strLength).equals(".ada")) {
			inputType = 2;
			parser = new parser.ParserADA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.ada" + ConsoleColors.RESET);
		}
		else if(input.substring(strLength - 4, strLength).equals(".smt")) {
			inputType = 3;
			parser = new parser.ParserSMT();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.smt" + ConsoleColors.RESET);
		}
		else if(input.substring(strLength - 6, strLength).equals(".foada")) {
			inputType = 4;
			parser = new parser.ParserFOADA();
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Type of the input file is " + ConsoleColors.YELLOW + "*.foada" + ConsoleColors.RESET);
		}
		else {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " Unknown type of the input file.");
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
			return;
		}
		parser.checkGrammar(input);
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// -r <input>
		private static void run(String input) throws Exception
		{
			parser.ParserSMT parser = new parser.ParserSMT();
			System.out.println(ConsoleColors.CYAN + "ANTLR4 > " + ConsoleColors.RESET + "Parsing and checking the grammar of the input...");
			parser.run(input);
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
		else if(args[0].equals("-g")) {
			checkGrammar(args[1]);
		}
		else if(args[0].equals("-r")) {
			run(args[1]);
		}
	}
}
