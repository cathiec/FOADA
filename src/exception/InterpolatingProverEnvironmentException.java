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

package exception;

import org.sosy_lab.java_smt.api.SolverException;

import utility.Console;
import utility.Console.ConsoleType;

@SuppressWarnings("serial")
public class InterpolatingProverEnvironmentException extends FOADAException {
	
	private SolverException javaSMTSolverException;
	
	private InterruptedException javaInterruptedException;
	
	public InterpolatingProverEnvironmentException(SolverException javaSMTSolverException)
	{
		type = ExceptionType.InterpolatingProverEnvironment;
		this.javaSMTSolverException = javaSMTSolverException;
		javaInterruptedException = null;
	}
	
	public InterpolatingProverEnvironmentException(InterruptedException javaInterruptedException)
	{
		type = ExceptionType.InterpolatingProverEnvironment;
		this.javaInterruptedException = javaInterruptedException;
		javaSMTSolverException = null;
	}
	
	public String getInfo()
	{
		if(javaSMTSolverException == null) {
			return javaInterruptedException.getMessage();
		}
		else {
			return javaSMTSolverException.getMessage();
		}
	}
	
	public void printErrorMessage()
	{
		if(javaSMTSolverException == null) {
			Console.printError(ConsoleType.Java, getInfo());
		}
		else {
			Console.printError(ConsoleType.JavaSMT, getInfo());
		}
	}

}
