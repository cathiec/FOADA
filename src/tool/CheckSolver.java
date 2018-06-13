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

import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;

import utility.ConsoleColors;

public class CheckSolver {
	
	public static boolean checkZ3() throws InvalidConfigurationException
	{
	    try {
	    SolverContextFactory.createSolverContext(Solvers.Z3);
	    }
	    catch(Exception e) {
	    	System.out.println("[JavaSMT] Check of the solver < Z3 > has " + ConsoleColors.RED + "failed." + ConsoleColors.RESET);
	    	return false;
	    }
	    System.out.println("[JavaSMT] Check of the solver < Z3 > has " + ConsoleColors.GREEN + "succeeded." + ConsoleColors.RESET);
	    return true;
	}
	
	public static boolean checkMATHSAT5() throws InvalidConfigurationException
	{
	    try {
	    	SolverContextFactory.createSolverContext(Solvers.MATHSAT5);
	    }
	    catch(Exception e) {
	    	System.out.println("[JavaSMT] Check of the solver < MATHSAT5 > has " + ConsoleColors.RED + "failed." + ConsoleColors.RESET);
	    	return false;
	    }
	    System.out.println("[JavaSMT] Check of the solver < MATHSAT5 > has " + ConsoleColors.GREEN + "succeeded." + ConsoleColors.RESET);
	    return true;
	}
	
	public static boolean checkSMTINTERPOL() throws InvalidConfigurationException
	{
	    try {
	    SolverContextFactory.createSolverContext(Solvers.SMTINTERPOL);
	    }
	    catch(Exception e) {
	    	System.out.println("[JavaSMT] Check of the solver < SMTINTERPOL > has " + ConsoleColors.RED + "failed." + ConsoleColors.RESET);
	    	return false;
	    }
	    System.out.println("[JavaSMT] Check of the solver < SMTINTERPOL > has " + ConsoleColors.GREEN + "succeeded." + ConsoleColors.RESET);
	    return true;
	}
	
	public static boolean checkPRINCESS() throws InvalidConfigurationException
	{
	    try {
	    SolverContextFactory.createSolverContext(Solvers.PRINCESS);
	    }
	    catch(Exception e) {
	    	System.out.println("[JavaSMT] Check of the solver < PRINCESS > has " + ConsoleColors.RED + "failed." + ConsoleColors.RESET);
	    	return false;
	    }
	    System.out.println("[JavaSMT] Check of the solver < PRINCESS > has " + ConsoleColors.GREEN + "succeeded." + ConsoleColors.RESET);
	    return true;
	}
	
	public static void main(String[] args) throws InvalidConfigurationException
	{  
		checkZ3();
		checkMATHSAT5();
		checkSMTINTERPOL();
		checkPRINCESS();
	}
}	
