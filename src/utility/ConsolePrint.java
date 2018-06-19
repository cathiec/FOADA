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

import exception.FOADAException;

public class ConsolePrint {
	
	public enum ConsoleType {FOADA, ANTLR4, Java, JavaSMT};
	
	public static void printInfo(ConsoleType t, String m)
	{
		System.out.print(ConsoleColors.CYAN);
		String console = "";
		switch(t)
		{
		case FOADA: console = "FOADA"; break;
		case ANTLR4:console = "ANTLR4"; break;
		case Java:console = "Java"; break;
		case JavaSMT:console = "JavaSMT"; break;
		default:console = "*"; break;
		}
		System.out.println(console + " > " + ConsoleColors.RESET + m);
	}
	
	public static void printError(ConsoleType t, String m)
	{
		System.out.print(ConsoleColors.CYAN);
		String console = "";
		switch(t)
		{
		case FOADA: console = "FOADA"; break;
		case ANTLR4:console = "ANTLR4"; break;
		case Java:console = "Java"; break;
		case JavaSMT:console = "JavaSMT"; break;
		default:console = "*"; break;
		}
		System.out.println(console + " > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " " + m);
	}
	
	// FOADA Special Console Print
	
	public static void printFOADAEndOfSession()
	{
		printInfo(ConsoleType.FOADA, "End of session.\n");
	}
	
	public static void printFOADAException(FOADAException e)
	{
		e.printErrorMessage();
	}
	
	public static void printFOADAHelpInfo()
	{
		printInfo(ConsoleType.FOADA, "Entry " + ConsoleColors.YELLOW + "-h" + ConsoleColors.RESET + " for the help.");
	}
	
}
