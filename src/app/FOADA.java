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

import java.io.IOException;

import exception.*;
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
		System.out.println("\t-h");
		System.out.println("\t--help \t\t\t show all the options");
		// -c , --check
		System.out.println("\t-c");
		System.out.println("\t--check \t\t check all the solvers");
		// -s , --syntax
		System.out.println("\t-s <input> \t\t check syntax errors in an input file");
		System.out.println("\t--syntax <input> \t check syntax errors in an input file");
		// -r , --run
		System.out.println("\t-r <input> \t\t run a SMT-like input file");
		System.out.println("\t--run <input> \t\t run a SMT-like input file");
		// -v , --version
		System.out.println("\t-v \t\t\t show the current version of FOADA");
		System.out.println("\t--version \t\t show the current version of FOADA");
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
	private static void checkGrammar(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.Parser parser = tool.SelectParser.selectParser(input);
		if(parser != null) {
			parser.checkGrammar(input);
		}
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -r <input>
	// --run <input>
	// run a SMT-like input file
	private static void run(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.ParserSMT parser = new parser.ParserSMT();
		parser.run(input);
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
					throw new NoInputFileException();
				}
				else {
					checkGrammar(args[1]);
				}
			}
			// run a SMT-like input file
			else if(args[0].equals("-r") || args[0].equals("--run")) {
				if(args.length < 2) {
					throw new NoInputFileException();
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
