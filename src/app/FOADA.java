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
	// show all the options
	private static void help()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Showing all the options...");
		System.out.println("\t-h \t\t show all the options");
		System.out.println("\t-cs \t\t check all the solvers");
		System.out.println("\t-g <input> \t parse an input file to check grammar errors");
		System.out.println("\t-t <input> \t parse an input file to check type errors");
		System.out.println("\t-r <input> \t run an SMT-like input file");
		System.out.println("\t-v \t\t show the version of FOADA");
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -cs
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
	
	// -g <input>
	// check grammar errors in the input file
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
	
	// -t
	// check type errors in the input file
	private static void checkType(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.Parser parser = tool.SelectParser.selectParser(input);
		if(parser != null) {
			parser.checkType(input);
		}
		ConsolePrint.printFOADAEndOfSession();
	}
	
	// -r <input>
	// run the SMT-like input file
	private static void run(String input)
			throws FOADAException
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Reading the input file < " + input + " >...");
		parser.ParserSMT parser = new parser.ParserSMT();
		parser.run(input);
		ConsolePrint.printFOADAEndOfSession();
	}
		
	// -v
	// show the current version of FOADA
	private static void version()
	{
		ConsolePrint.printInfo(ConsoleType.FOADA, "Version " + version);
		ConsolePrint.printFOADAEndOfSession();
	}
	
	public static void main(String[] args)
	{
		try {
			// no argument
			if(args.length == 0) {
				welcome();
			}
			// show all the options
			else if(args[0].equals("-h")) {
				help();
			}
			// check all the solvers
			else if(args[0].equals("-cs")) {
				checkSolvers();
			}
			// check grammar errors in the input file
			else if(args[0].equals("-g")) {
				if(args.length < 2) {
					throw new NoInputFileException();
				}
				else {
					checkGrammar(args[1]);
				}
			}
			// check type errors in the input file
			else if(args[0].equals("-t")) {
				if(args.length < 2) {
					throw new NoInputFileException();
				}
				else {
					checkType(args[1]);
				}
			}
			// run the SMT-like input file
			else if(args[0].equals("-r")) {
				if(args.length < 2) {
					throw new NoInputFileException();
				}
				else {
					run(args[1]);
				}
			}
			// show the current version of FOADA
			else if(args[0].equals("-v")) {
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
