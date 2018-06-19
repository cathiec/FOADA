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

import org.antlr.v4.runtime.misc.ParseCancellationException;

import utility.ConsolePrint;
import utility.ConsolePrint.ConsoleType;

@SuppressWarnings("serial")
public class ANTLR4ParseCancellationException extends FOADAException {
	
	ParseCancellationException ANTLR4Exception;
	
	public ANTLR4ParseCancellationException(ParseCancellationException e)
	{
		type = ExceptionType.ANTLR4ParseCancellation;
		ANTLR4Exception = e;
	}
	
	public String getInfo()
	{
		return ANTLR4Exception.getMessage();
	}
	
	public void printErrorMessage()
	{
		ConsolePrint.printError(ConsoleType.ANTLR4, getInfo());
	}

}