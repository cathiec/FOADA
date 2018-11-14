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

package utility;

import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import utility.Console.ConsoleType;

public abstract class Solver {
	
	public static void checkZ3()
	{
	    try {
	    	SolverContextFactory.createSolverContext(Solvers.Z3);
	    }
	    catch(Exception e) {
	    	Console.printError(ConsoleType.JavaSMT, "The solver Z3 failed.");
	    	Console.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
	    Console.printInfo(ConsoleType.JavaSMT, "The solver " + Console.GREEN_BRIGHT + "Z3 succeeded" + Console.RESET + ".");
	}
	
	public static void checkMATHSAT5()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.MATHSAT5);
	    }
	    catch(Exception e) {
	    	Console.printError(ConsoleType.JavaSMT, "The solver MATHSAT5 failed.");
	    	Console.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
		Console.printInfo(ConsoleType.JavaSMT, "The solver " + Console.GREEN_BRIGHT + "MATHSAT5 succeeded" + Console.RESET + ".");
	}
	
	public static void checkSMTINTERPOL()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.SMTINTERPOL);
	    }
	    catch(Exception e) {
	    	Console.printError(ConsoleType.JavaSMT, "The solver SMTINTERPOL failed.");
	    	Console.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
		Console.printInfo(ConsoleType.JavaSMT, "The solver " + Console.GREEN_BRIGHT + "SMTINTERPOL succeeded" + Console.RESET + ".");
	}
	
	public static void checkPRINCESS()
	{
		try {
	    	SolverContextFactory.createSolverContext(Solvers.PRINCESS);
	    }
	    catch(Exception e) {
	    	Console.printError(ConsoleType.JavaSMT, "The solver PRINCESS failed.");
	    	Console.printError(ConsoleType.JavaSMT, e.getMessage());
	    	return;
	    }
		Console.printInfo(ConsoleType.JavaSMT, "The solver " + Console.GREEN_BRIGHT + "PRINCESS succeeded" + Console.RESET + ".");
	}

}	
