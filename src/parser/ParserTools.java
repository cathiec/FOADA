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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import exception.ANTLR4ParseCancellationException;
import exception.FOADAException;
import exception.InputFileNotFoundException;
import exception.InputFileUnsupportedException;
import exception.JavaIOException;
import parser.ADA.ANTLR4.ADALexerANTLR4;
import parser.ADA.ANTLR4.ADAParserANTLR4;
import parser.PA.ANTLR4.PALexerANTLR4;
import parser.PA.ANTLR4.PAParserANTLR4;
import parser.TA.ANTLR4.TALexerANTLR4;
import parser.TA.ANTLR4.TAParserANTLR4;
import structure.Automaton;
import utility.Console;
import utility.Console.ConsoleType;

// general structure for Parser (abstract class)
@SuppressWarnings("deprecation")
public abstract class ParserTools {
	
	public enum ParserType {
		PAParser,
		ADAParser,
		TAParser
	};
	
	public static ParserType selectAccordingToInputFile(String filename)
			throws FOADAException
	{
		int strLength = filename.length();
		if(strLength >= 3 && filename.substring(strLength - 3, strLength).equals(".pa")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.pa" + Console.RESET + " >.");
			return ParserType.PAParser;
		}
		else if(strLength >= 4 && filename.substring(strLength - 4, strLength).equals(".ada")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.ada" + Console.RESET + " >.");
			return ParserType.ADAParser;
		}
		else if(strLength >= 3 && filename.substring(strLength - 3, strLength).equals(".ta")) {
			Console.printInfo(ConsoleType.FOADA, "Type of the input file is < " + Console.YELLOW_BRIGHT + "*.ta" + Console.RESET + " >.");
			return ParserType.TAParser;
		}
		else {
			throw new InputFileUnsupportedException(filename);
		}
	}
	
	public static Automaton buildAutomatonFromFile(String filename, ParserType parserType)
			throws FOADAException
	{
		try {
	        InputStream istream = new FileInputStream(filename);
	        //System.out.println(istream);
	        Console.printInfo(ConsoleType.ANTLR4, "Parsing and checking the syntax in the input...");
	        Lexer lexer = null;
	        Parser parser = null;
	        CommonTokenStream tokens = null;
	        Automaton result = null;
	        switch(parserType)
	        {
	        case PAParser:	lexer = new PALexerANTLR4(new ANTLRInputStream(istream));
					        lexer.removeErrorListeners();
							lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        				tokens = new CommonTokenStream(lexer);
	        				parser = new PAParserANTLR4(tokens);
	        		        parser.removeErrorListeners();
	        		        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        		        istream.close();
	        				result = ((PAParserANTLR4)parser).automaton().jData;
	        				break;
	        case ADAParser:	lexer = new ADALexerANTLR4(new ANTLRInputStream(istream));
					        lexer.removeErrorListeners();
							lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        				tokens = new CommonTokenStream(lexer);
	        				parser = new ADAParserANTLR4(tokens);
	        		        parser.removeErrorListeners();
	        		        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
	        		        istream.close();
	        				result = ((ADAParserANTLR4)parser).automaton().jData;
	        				break;
	        case TAParser:	lexer = new TALexerANTLR4(new ANTLRInputStream(istream));
					        lexer.removeErrorListeners();
							lexer.addErrorListener(utility.ErrorListenerWithExceptions.listener);
							tokens = new CommonTokenStream(lexer);
							parser = new TAParserANTLR4(tokens);
					        parser.removeErrorListeners();
					        parser.addErrorListener(utility.ErrorListenerWithExceptions.listener);
					        istream.close();
							result = ((TAParserANTLR4)parser).automaton().jData;
							break;
	        default:		lexer = null;
	        				parser = null;
	        				break;
	        }
	        Console.printInfo(ConsoleType.ANTLR4, "Syntax checking succeeded...");
	        return result;
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
