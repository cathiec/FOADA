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

import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;

import utility.ConsoleColors;
import utility.ConsolePrint;
import utility.ConsolePrint.ConsoleType;

public class CheckSolver {
	
	public static void checkZ3()
	{
	    try {
	    	SolverContextFactory.createSolverContext(Solvers.Z3);
	    }
	    catch(Exception e) {
	    	ConsolePrint.printError(ConsoleType.JavaSMT, "The solver Z3 failed.");
	    	ConsolePrint.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
	    ConsolePrint.printInfo(ConsoleType.JavaSMT, "The solver " + ConsoleColors.GREEN_BRIGHT + "Z3 succeeded" + ConsoleColors.RESET + ".");
	}
	
	public static void checkMATHSAT5()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.MATHSAT5);
	    }
	    catch(Exception e) {
	    	ConsolePrint.printError(ConsoleType.JavaSMT, "The solver MATHSAT5 failed.");
	    	ConsolePrint.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
	    ConsolePrint.printInfo(ConsoleType.JavaSMT, "The solver " + ConsoleColors.GREEN_BRIGHT + "MATHSAT5 succeeded" + ConsoleColors.RESET + ".");
	}
	
	public static void checkSMTINTERPOL()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.SMTINTERPOL);
	    }
	    catch(Exception e) {
	    	ConsolePrint.printError(ConsoleType.JavaSMT, "The solver SMTINTERPOL failed.");
	    	ConsolePrint.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
	    ConsolePrint.printInfo(ConsoleType.JavaSMT, "The solver " + ConsoleColors.GREEN_BRIGHT + "SMTINTERPOL succeeded" + ConsoleColors.RESET + ".");
	}
	
	public static void checkPRINCESS()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.PRINCESS);
	    }
	    catch(Exception e) {
	    	ConsolePrint.printError(ConsoleType.JavaSMT, "The solver PRINCESS failed.");
	    	ConsolePrint.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
	    ConsolePrint.printInfo(ConsoleType.JavaSMT, "The solver " + ConsoleColors.GREEN_BRIGHT + "PRINCESS succeeded" + ConsoleColors.RESET + ".");
	}

}	
