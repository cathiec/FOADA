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

import utility.Console;
import utility.Console.*;

// general structure for FOADA exception (abstract class)
@SuppressWarnings("serial")
public abstract class FOADAException extends Throwable {
	
	public enum ExceptionType {
		ANTLR4ParseCancellation,
		ImplicationProverEnvironment,
		InputFileNotFound,
		InputFileUnsupported,
		InterpolatingProverEnvironment,
		JavaIO,
		JavaSMTInvalidConfiguration,
		UnknownConsoleOption
	};
	
	public ExceptionType type;

	public abstract String getInfo();
	
	public void printErrorMessage()
	{
		Console.printError(ConsoleType.FOADA, getInfo());
	}

}
