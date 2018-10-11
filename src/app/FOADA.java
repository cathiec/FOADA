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

import exception.FOADAException;
import exception.InputFileNotFoundException;
import exception.UnknownConsoleOptionException;
import parser.ParserTools;
import parser.ParserTools.ParserType;
import structure.Automaton;
import utility.Console;
import utility.Console.ConsoleType;
import utility.Solver;

public class FOADA {
	
	// FOADA Version
	public static final String FOADA_version = "1.0";

	/** < FOADA welcome > </br>
	 * FOADA execution with no argument
	 */
	private static void welcome()
	{
		System.out.println("------------------------------");
		System.out.print("      FOADA Version ");
		System.out.println(FOADA_version);
		System.out.println("------------------------------");
		help();
	}
	
	/** < FOADA help menu > </br>
	 * FOADA execution with argument <b> -h </b> or <b> --help </b>
	 */
	private static void help()
	{
		Console.printInfo(ConsoleType.FOADA, "Showing all the options...");
		// -h , --help
		System.out.println("\t-h, --help \t\thelp menu");
		// -c , --check
		System.out.println("\t-c, --check \t\tsolver checking");
		// -e, --empty
		System.out.println("\t-e, --empty <input> \temptiness checking");
		// -p, --print
		System.out.println("\t\t-p, --print\tadd this option after -e, --empty to print out important steps during emptiness checking");
		// -v , --version
		System.out.println("\t-v, --version \t\tinstalled version");
		Console.printFOADAEndOfSession();
	}
	
	/** < FOADA solver checking > </br>
	 * FOADA execution with argument <b> -c </b> or <b> --check </b>
	 */
	private static void checkSolvers()
	{
		Console.printInfo(ConsoleType.FOADA, "Start checking all the solvers...");
		Solver.checkSMTINTERPOL();
		Solver.checkZ3();
		Solver.checkMATHSAT5();
		Solver.checkPRINCESS();
		Console.printFOADAEndOfSession();
	}
	
	/** < FOADA emptiness checking > </br>
	 * FOADA execution with argument <b> -e </b> or <b> --empty </b>
	 * @param	filename	name of the input file
	 */
	private static void checkEmpty(String filename, boolean print)
			throws FOADAException
	{
		ParserType parserType = ParserTools.selectAccordingToInputFile(filename);
		Automaton automaton = ParserTools.buildAutomatonFromFile(filename, parserType);
		Console.printInfo(ConsoleType.FOADA, "Start checking emptiness...");
		if(automaton.isEmpty(print)) {
			Console.printInfo(ConsoleType.FOADA, "The automaton is empty...");
		}
		else {
			Console.printInfo(ConsoleType.FOADA, "The automaton is not empty...");
		}
		//a.test();
		Console.printFOADAEndOfSession();
	}
	
	/** < FOADA installed version > </br>
	 * FOADA execution with argument <b> -v </b> or <b> --version </b>
	 */
	private static void version()
	{
		Console.printInfo(ConsoleType.FOADA, "Version " + FOADA_version);
		Console.printFOADAEndOfSession();
	}
	
	/** < FOADA execution >
	 * @param	args	command-line arguments
	 */
	public static void main(String[] args)
	{
		try {
			// welcome
			if(args.length == 0) {
				welcome();
			}
			// help menu
			else if(args[0].equals("-h") || args[0].equals("--help")) {
				help();
			}
			// solver checking
			else if(args[0].equals("-c") || args[0].equals("--check")) {
				checkSolvers();
			}
			// emptiness checking
			else if(args[0].equals("-e") || args[0].equals("--empty")) {
				if(args.length < 2) {
					throw new InputFileNotFoundException(null);
				}
				else if(args[1].equals("-p") || args[1].equals("--print")) {
					checkEmpty(args[2], true);
				}
				else {
					checkEmpty(args[1], false);
				}
			}
			// installed version
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
			Console.printFOADAEndOfSession();
		}
	}
	
}
