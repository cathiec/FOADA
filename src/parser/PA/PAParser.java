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

package parser.PA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import exception.ANTLR4ParseCancellationException;
import exception.FOADAException;
import exception.InputFileNotFoundException;
import exception.JavaIOException;
import parser.PA.ANTLR4.PALexerANTLR4;
import parser.PA.ANTLR4.PAParserANTLR4;
import structure.Automaton;
import utility.Console;
import utility.Console.ConsoleType;

@SuppressWarnings("deprecation")
public class PAParser {

	public static Automaton buildAutomatonFromFile(String filename)
			throws FOADAException
	{
		try {
	        InputStream istream = new FileInputStream(filename);
	        //System.out.println(istream);
	        Console.printInfo(ConsoleType.ANTLR4, "Parsing and checking the syntax in the input...");
			PALexerANTLR4 lexer = new PALexerANTLR4(new ANTLRInputStream(istream));
			lexer.removeErrorListeners();
			lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PAParserANTLR4 parser = new PAParserANTLR4(tokens);
	        parser.removeErrorListeners();
	        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        Console.printInfo(ConsoleType.ANTLR4, "Syntax checking succeeded...");
	        istream.close();
	        return parser.automaton().jData;
		}
		catch(ParseCancellationException e) {
			throw new ANTLR4ParseCancellationException(e);
		}
		catch(FileNotFoundException e) {
			throw new InputFileNotFoundException(filename);
		}
        catch(IOException e) {
        	throw new JavaIOException(e);
        }
	}

}
