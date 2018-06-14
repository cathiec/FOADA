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
	
	private static String version = "1.0";
	
	// no argument
	private static void welcome()
	{
		System.out.println("------------------------------");
		System.out.println("      FOADA Version 1.0");
		System.out.println("------------------------------");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Showing all the options...");
		System.out.println("\t-h \t\t show all the options");
		System.out.println("\t-cs \t\t check all the solvers");
		System.out.println("\t-g <input> \t parse an input file to check its grammar");
		System.out.println("\t-r <input> \t run an SMT-like input file");
		System.out.println("\t-v \t\t show the version of FOADA");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// -h
	private static void help()
	{
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Showing all the options...");
		System.out.println("\t-h \t\t show all the options");
		System.out.println("\t-cs \t\t check all the solvers");
		System.out.println("\t-g <input> \t parse an input file to check its grammar");
		System.out.println("\t-r <input> \t run an SMT-like input file");
		System.out.println("\t-v \t\t show the version of FOADA");
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
		parser.Parser parser = tool.SelectParser.selectParser(input);
		if(parser != null) {
			parser.checkGrammar(input);
		}
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// -r <input>
	private static void run(String input) throws Exception
	{
		parser.ParserSMT parser = new parser.ParserSMT();
		parser.run(input);
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
		
	// -v
	private static void version()
	{
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Version " + version);
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
	}
	
	// unknown
	private static void unknown()
	{
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " Unknown option.");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Entry " + ConsoleColors.YELLOW + "-h" + ConsoleColors.RESET + " for the help.");
		System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");	
	}
	
	public static void main(String[] args) throws Exception
	{
		if(args.length == 0) {
			welcome();
		}
		else if(args[0].equals("-h")) {
			help();
		}
		else if(args[0].equals("-cs")) {
			checkSolvers();
		}
		else if(args[0].equals("-g")) {
			if(args.length < 2) {
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " No input file.");
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Entry " + ConsoleColors.YELLOW + "-h" + ConsoleColors.RESET + " for the help.");
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
			}
			else {
				checkGrammar(args[1]);
			}
		}
		else if(args[0].equals("-r")) {
			if(args.length < 2) {
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " No input file.");
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "Entry " + ConsoleColors.YELLOW + "-h" + ConsoleColors.RESET + " for the help.");
				System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RESET + "End of session.\n");
			}
			else {
				run(args[1]);
			}
		}
		else if(args[0].equals("-v")) {
			version();
		}
		else {
			unknown();
		}
	}
}
