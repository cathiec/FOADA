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
	
	private static void welcome()
	{
		System.out.println("[" + ConsoleColors.CYAN + "FOADA" + ConsoleColors.RESET + "] FOADA Version 1.0" + ConsoleColors.RESET);
	}
	
	private static void checkSolvers() throws InvalidConfigurationException
	{
		CheckSolver.checkSMTINTERPOL();
		CheckSolver.checkZ3();
		CheckSolver.checkMATHSAT5();
		CheckSolver.checkPRINCESS();
	}
	
	private static void parse(String input)
	{
		try {
			parser.ParserFOADA.test(input);
		}
		catch (Exception e) {}
	}
	
	public static void main(String[] args) throws InvalidConfigurationException
	{
		if(args.length == 0) {
			welcome();
		}
		else if(args[0].equals("-cs")) {
			checkSolvers();
		}
		else if(args[0].equals("-p")) {
			parse(args[1]);
		}
	}
}
