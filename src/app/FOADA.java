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

import exception.*;
import parser.Parser.ParserCategory;
import parser.Parser.ParserType;
import tool.*;
import utility.*;
import utility.ConsolePrint.ConsoleType;

public class FOADA {
	
	private static String version = "1.0";
	
	// no argument
	private static void welcome()
	{
		System.out.println("------------------------------");
		System.out.println("      FOADA Version 1.0");
		System.out.println("------------------------------");
		help();
	}
	
	// -h
	// --help
	// show all the options
	private static void help()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Showing all the options...");
		// -h , --help
		System.out.println("\t-h, --help \t\t show all the options");
		// -c , --check
		System.out.println("\t-c, --check \t\t check all the solvers");
		// -s , --syntax
		System.out.println("\t-s, --syntax <input> \t check syntax errors in an input file");
		// -e, --empty
		System.out.println("\t-e, --empty <input> \t check whether the automaton in an input file is empty");
		// -r , --run
		System.out.println("\t-r, --run <input> \t run a script input file");
		// -v , --version
		System.out.println("\t-v, --version \t\t show the current version of FOADA");
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -c
	// --check
	// check all the solvers
	private static void checkSolvers()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Start checking all the solvers...");
		CheckSolver.checkSMTINTERPOL();
		CheckSolver.checkZ3();
		CheckSolver.checkMATHSAT5();
		CheckSolver.checkPRINCESS();
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -s <input>
	// --syntax <input>
	// check syntax errors in an input file
	private static void checkSyntax(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.Parser p = tool.SelectParser.selectParser(input);
		p.checkSyntax(input);
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -e <input>
	// --empty <input>
	// check whether the automaton in an input file is empty
	private static void checkEmpty(String input)
		throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.Parser p = tool.SelectParser.selectParser(input);
		if(p.category == ParserCategory.Script) {
			throw new InputFileNotAutomatonException(input);
		}
		((parser.AutomatonParser)p).checkEmpty(input);
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -r <input>
	// --run <input>
	// run a script input file
	private static void run(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.Parser p = tool.SelectParser.selectParser(input);
		if(p.category == ParserCategory.Automaton) {
			throw new InputFileNotScriptException(input);
		}
		((parser.ScriptParser)p).run(input);
		ConsolePrint.printFOADAEndOfSession();
	}
		
	// -v
	// --version
	// show the current version of FOADA
	private static void version()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Version " + version);
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// main function
	public static void main(String[] args)
	{
		try {
			// no argument
			if(args.length == 0) {
				welcome();
			}
			// show all the options
			else if(args[0].equals("-h") || args[0].equals("--help")) {
				help();
			}
			// check all the solvers
			else if(args[0].equals("-c") || args[0].equals("--check")) {
				checkSolvers();
			}
			// check syntax errors in an input file
			else if(args[0].equals("-s") || args[0].equals("--syntax")) {
				if(args.length < 2) {
					throw new InputFileNotFoundException(null);
				}
				else {
					checkSyntax(args[1]);
				}
			}
			// check whether the automaton in an input file is empty
			else if(args[0].equals("-e") || args[0].equals("--empty")) {
				if(args.length < 2) {
					throw new InputFileNotFoundException(null);
				}
				else {
					checkEmpty(args[1]);
				}
			}
			// run a script input file
			else if(args[0].equals("-r") || args[0].equals("--run")) {
				if(args.length < 2) {
					throw new InputFileNotFoundException(null);
				}
				else {
					run(args[1]);
				}
			}
			// show the current version of FOADA
			else if(args[0].equals("-v") || args[0].equals("--version")) {
				version();
			}
			// unknown option
			else {
				throw new UnknownConsoleOptionException(args[0]);
			}
		}
		catch(FOADAException e) {
			e.printErrorMessage();
			ConsolePrint.printFOADAEndOfSession();
		}
	}
}
