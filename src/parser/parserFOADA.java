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

package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.*;

import parser.antlr4_parser.FOADA.*;
import utility.*;
import utility.ConsolePrint.ConsoleType;
import exception.*;

public class ParserFOADA extends AutomatonParser {

	public ParserFOADA()
	{
		type = ParserType.FOADA;
	}
	
	@SuppressWarnings("deprecation")
	public void checkSyntax(String input)
			throws FOADAException
	{
		try {
	        InputStream istream = new FileInputStream(input);
	        // Instantiate lexer and parser, connected together:
	        ConsolePrint.printInfo(ConsoleType.ANTLR4, "Parsing and checking the syntax in the input...");
			FOADA_Lexer lexer = new FOADA_Lexer(new ANTLRInputStream(istream));
			lexer.removeErrorListeners();
			lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        FOADA_Parser parser = new FOADA_Parser(tokens);
	        parser.removeErrorListeners();
	        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        // Launch the parser
	        parser.automaton().tree.checkType();
	        istream.close();
		}
		catch(ParseCancellationException e) {
			throw new ANTLR4ParseCancellationException(e);
		}
		catch(FileNotFoundException e) {
			throw new InputFileNotFoundException(input);
		}
        catch(IOException e) {
        	throw new JavaIOException(e);
        }
		ConsolePrint.printInfo(ConsoleType.ANTLR4, "Syntax check has " + ConsoleColors.GREEN_BRIGHT + "succeeded" + ConsoleColors.RESET + ".");
    }
	
	@SuppressWarnings("deprecation")
	public boolean checkEmpty(String input)
			throws FOADAException
	{
		try {
	        InputStream istream = new FileInputStream(input);
	        // Instantiate lexer and parser, connected together:
	        ConsolePrint.printInfo(ConsoleType.ANTLR4, "Parsing and checking the syntax in the input...");
			FOADA_Lexer lexer = new FOADA_Lexer(new ANTLRInputStream(istream));
			lexer.removeErrorListeners();
			lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        FOADA_Parser parser = new FOADA_Parser(tokens);
	        parser.removeErrorListeners();
	        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        // Launch the parser
	        boolean isEmpty = parser.automaton().tree.checkEmpty();
	        istream.close();
	        return isEmpty;
		}
		catch(ParseCancellationException e) {
			throw new ANTLR4ParseCancellationException(e);
		}
		catch(FileNotFoundException e) {
			throw new InputFileNotFoundException(input);
		}
        catch(IOException e) {
        	throw new JavaIOException(e);
        }
    }
	
}
