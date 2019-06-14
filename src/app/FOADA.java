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

import java.util.ArrayList;
import java.util.List;

import exception.FOADAException;
import exception.InputFileNotFoundException;
import exception.UnknownConsoleOptionException;
import parser.ParserTools;
import parser.ParserTools.ParserType;
import structure.Automaton;
import structure.FOADAExpression.ExpressionType;
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
		System.out.println("-h, --help \t\t\thelp menu");
		// -c , --check
		System.out.println("-c, --check \t\t\tsolver checking");
		// -e, --empty
		System.out.println("-e, --empty <input> <options>\temptiness checking using BFS ");
			// additional options for emptiness checking
			System.out.println("\tadditional options:");
			// -d, --dfs
			System.out.println("\t-d, --dfs\t\tusing DFS instead of using BFS");
			// -o, --occurrences
			System.out.println("\t-o, --occurrences\tfinding occurrences of predicates instead of universally quantifying arguments");
		// -i, --inclusion
		System.out.println("-i, --inclusion <input1> <input2> <options>\tinclusion checking using BFS ");
		// additional options for inclusion checking
				System.out.println("\tadditional options:");
				// -d, --dfs
				System.out.println("\t-d, --dfs\t\tusing DFS instead of using BFS");
				// -o, --occurrences
				System.out.println("\t-o, --occurrences\tfinding occurrences of predicates instead of universally quantifying arguments");
		// -v , --version
		System.out.println("-v, --version \t\t\tinstalled version");
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
	 * @param	filename		name of the input file
	 * @param	searchMode		mode of tree search: <b> BFS </b> / <b> DFS </b>
	 * @param	transitionMode	mode of transition rules: <b> universally quantifier arguments </b> / <b> find occurrences </b>
	 */
	private static void checkEmpty(String filename, utility.TreeSearch.Mode searchMode, utility.Impact.Mode transitionMode)
			throws FOADAException
	{
		ParserType parserType = ParserTools.selectAccordingToInputFile(filename);
		Automaton automaton = ParserTools.buildAutomatonFromFile(filename, parserType);
		if(searchMode == utility.TreeSearch.Mode.BFS) {
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (BFS / Universally Quantify Arguments) ... ");
			}
			else if(transitionMode == utility.Impact.Mode.FindOccurrences) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (BFS / Find Occurrences) ... ");
				Console.printInfo(ConsoleType.FOADA, Console.RED_BRIGHT + "WARNING : " + Console.RESET + "This version does not work with transition quantifiers.");
			}
		}
		else if(searchMode == utility.TreeSearch.Mode.DFS) {
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (DFS / Universally Quantify Arguments) ... ");
			}
			else if(transitionMode == utility.Impact.Mode.FindOccurrences) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (DFS / Find Occurrences) ... ");
				Console.printInfo(ConsoleType.FOADA, Console.RED_BRIGHT + "WARNING : " + Console.RESET + "This version does not work with transition quantifiers.");
			}	
		}
		if(automaton.isEmpty(searchMode, transitionMode)) {
			Console.printInfo(ConsoleType.FOADA, "The automaton is empty...");
		}
		else {
			Console.printInfo(ConsoleType.FOADA, "The automaton is not empty...");
		}
		Console.printFOADAEndOfSession();
	}
	
	/** < FOADA inclusion checking > </br>
	 * FOADA execution with argument <b> -i </b> or <b> --inclusion </b>
	 * @param	filename1		name of the input file 1
	 * @param	filename2		name of the input file 2
	 * @param	searchMode		mode of tree search: <b> BFS </b> / <b> DFS </b>
	 * @param	transitionMode	mode of transition rules: <b> universally quantifier arguments </b> / <b> find occurrences </b>
	 */
	private static void checkInclusion(String filename1, String filename2, utility.TreeSearch.Mode searchMode, utility.Impact.Mode transitionMode)
			throws FOADAException
	{
		Console.printInfo(ConsoleType.FOADA, "Building automaton 1 ... ");
		ParserType parser1Type = ParserTools.selectAccordingToInputFile(filename1);
		Automaton automaton1 = ParserTools.buildAutomatonFromFile(filename1, parser1Type);
		/* TODO */
		/*System.out.println("Predicates: " + automaton1.namesOfPredicates);
		System.out.println("Initial: " + automaton1.initial);
		System.out.println("Final: " + automaton1.namesOfFinalStates);
		System.out.println("Events: " + automaton1.events);
		System.out.println("Nb of Variables: " + automaton1.nbOfVariables);
		System.out.println(automaton1.renameMap);
		for(Map.Entry<String, FOADATransition> xx : automaton1.transitions.entrySet()) {
			System.out.println(xx.getValue());
		}
		System.out.println();*/
		Console.printInfo(ConsoleType.FOADA, "Building automaton 2 ... ");
		ParserType parser2Type = ParserTools.selectAccordingToInputFile(filename2);
		Automaton automaton2 = ParserTools.buildAutomatonFromFile(filename2, parser2Type);
		/* TODO */
		/*System.out.println("Predicates: " + automaton2.namesOfPredicates);
		System.out.println("Initial: " + automaton2.initial);
		System.out.println("Final: " + automaton2.namesOfFinalStates);
		System.out.println("Events: " + automaton2.events);
		System.out.println("Nb of Variables: " + automaton2.nbOfVariables);
		System.out.println(automaton2.renameMap);
		for(Map.Entry<String, FOADATransition> xx : automaton2.transitions.entrySet()) {
			System.out.println(xx.getValue());
		}
		System.out.println();*/
		Console.printInfo(ConsoleType.FOADA, "Complementing automaton 2 ... ");
		Automaton complementOfAutomaton2 = automaton2.complements();
		/* TODO */
		/*System.out.println("Predicates: " + complementOfAutomaton2.namesOfPredicates);
		System.out.println("Initial: " + complementOfAutomaton2.initial);
		System.out.println("Final: " + complementOfAutomaton2.namesOfFinalStates);
		System.out.println("Events: " + complementOfAutomaton2.events);
		System.out.println("Nb of Variables: " + complementOfAutomaton2.nbOfVariables);
		System.out.println(complementOfAutomaton2.renameMap);
		for(Map.Entry<String, FOADATransition> xx : complementOfAutomaton2.transitions.entrySet()) {
			System.out.println(xx.getValue());
		}
		System.out.println();*/
		Console.printInfo(ConsoleType.FOADA, "Intersecting automaton 1 with complement of automaton 2 ... ");
		Automaton automaton = automaton1.intersects(complementOfAutomaton2);
		/* TODO */
		/*System.out.println("Predicates: " + automaton.namesOfPredicates);
		System.out.println("Initial: " + automaton.initial);
		System.out.println("Final: " + automaton.namesOfFinalStates);
		System.out.println("Events: " + automaton.events);
		System.out.println("Nb of Variables: " + automaton.nbOfVariables);
		System.out.println(automaton.renameMap);
		for(Map.Entry<String, FOADATransition> xx : automaton.transitions.entrySet()) {
			System.out.println(xx.getValue());
		}
		System.out.println();*/
		if(searchMode == utility.TreeSearch.Mode.BFS) {
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (BFS / Universally Quantify Arguments) ... ");
			}
			else if(transitionMode == utility.Impact.Mode.FindOccurrences) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (BFS / Find Occurrences) ... ");
				Console.printInfo(ConsoleType.FOADA, Console.RED_BRIGHT + "WARNING : " + Console.RESET + "This version does not work with transition quantifiers.");
			}
		}
		else if(searchMode == utility.TreeSearch.Mode.DFS) {
			if(transitionMode == utility.Impact.Mode.UniversallyQuantifyArguments) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (DFS / Universally Quantify Arguments) ... ");
			}
			else if(transitionMode == utility.Impact.Mode.FindOccurrences) {
				Console.printInfo(ConsoleType.FOADA, "Start checking emptiness (DFS / Find Occurrences) ... ");
				Console.printInfo(ConsoleType.FOADA, Console.RED_BRIGHT + "WARNING : " + Console.RESET + "This version does not work with transition quantifiers.");
			}	
		}
		if(automaton.isEmpty(searchMode, transitionMode)) {
			Console.printInfo(ConsoleType.FOADA, "The automaton is empty...");
		}
		else {
			Console.printInfo(ConsoleType.FOADA, "The automaton is not empty...");
		}
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
				//welcome();
				
				/* *********************** */
				Automaton automaton1 = ParserTools.buildAutomatonFromFile("examples/Philo1.foada", ParserType.FOADAParser);
				Automaton automaton2 = ParserTools.buildAutomatonFromFile("examples/Philo2.foada", ParserType.FOADAParser);
				Automaton automaton3 = ParserTools.buildAutomatonFromFile("examples/Philo3.foada", ParserType.FOADAParser);
				//automaton1.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				//automaton2.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				//automaton3.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				Automaton coe = automaton1.intersects(automaton2, "B").intersects(automaton3, "C");
				//coe.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				Automaton acc = ParserTools.buildAutomatonFromFile("examples/PhiloAcc.foada", ParserType.FOADAParser);
				//acc.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				Automaton accCompl = acc.complements();
				//accCompl.isEmpty(utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				Automaton temp = coe.intersects(accCompl, "D");
				//temp.isEmpty(utility.TreeSearch.Mode.BFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				List<String> variablesNames = new ArrayList<String>();
				List<ExpressionType> variablesTypes = new ArrayList<ExpressionType>();
				variablesNames.add("Nf");
				variablesTypes.add(ExpressionType.Integer);
				variablesNames.add("Nb");
				variablesTypes.add(ExpressionType.Integer);
				variablesNames.add("Nw");
				variablesTypes.add(ExpressionType.Integer);
				variablesNames.add("Nh");
				variablesTypes.add(ExpressionType.Integer);
				variablesNames.add("Ne");
				variablesTypes.add(ExpressionType.Integer);
				Automaton tempQtf = temp.quantifies(variablesNames, variablesTypes);
				//tempQtf.isEmpty(utility.TreeSearch.Mode.BFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				Automaton tempQtyCompl = tempQtf.complements();
				tempQtyCompl.isEmpty(utility.TreeSearch.Mode.BFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				/* *********************** */
				
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
				else if(args.length == 2) {
					checkEmpty(args[1], utility.TreeSearch.Mode.BFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				}
				else if(args.length == 3 && (args[2].equals("-d") || args[2].equals("--dfs"))) {
					checkEmpty(args[1], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				}
				else if(args.length == 3 && (args[2].equals("-o") || args[2].equals("--occurrences"))){
					checkEmpty(args[1], utility.TreeSearch.Mode.BFS, utility.Impact.Mode.FindOccurrences);
				}
				else if(args.length == 4 && (args[2].equals("-d") || args[2].equals("--dfs")) && (args[3].equals("-o") || args[3].equals("--occurrences"))) {
					checkEmpty(args[1], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				}
				else if(args.length == 4 && (args[2].equals("-o") || args[2].equals("--occurrences")) && (args[3].equals("-d") || args[3].equals("--dfs"))) {
					checkEmpty(args[1], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				}
			}
			// inclusion checking
			else if(args[0].equals("-i") || args[0].equals("--inclusion")) {
				if(args.length < 3) {
					throw new InputFileNotFoundException(null);
				}
				else if(args.length == 3) {
					checkInclusion(args[1], args[2], utility.TreeSearch.Mode.BFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				}
				else if(args.length == 4 && (args[3].equals("-d") || args[3].equals("--dfs"))) {
					checkInclusion(args[1], args[2], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.UniversallyQuantifyArguments);
				}
				else if(args.length == 4 && (args[3].equals("-o") || args[3].equals("--occurrences"))){
					checkInclusion(args[1], args[2], utility.TreeSearch.Mode.BFS, utility.Impact.Mode.FindOccurrences);
				}
				else if(args.length == 5 && (args[3].equals("-d") || args[3].equals("--dfs")) && (args[4].equals("-o") || args[4].equals("--occurrences"))) {
					checkInclusion(args[1], args[2], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
				}
				else if(args.length == 5 && (args[3].equals("-o") || args[3].equals("--occurrences")) && (args[4].equals("-d") || args[4].equals("--dfs"))) {
					checkInclusion(args[1], args[2], utility.TreeSearch.Mode.DFS, utility.Impact.Mode.FindOccurrences);
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
