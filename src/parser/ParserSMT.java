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
import java.io.*;

import parser.antlr4_parser.SMT.*;
import utility.ConsoleColors;

public class ParserSMT extends Parser {
	
	public void checkGrammar(String input) {
		try {
	        InputStream istream = new FileInputStream(input);
	        // Instantiate lexer and parser, connected together:
	        System.out.println(ConsoleColors.CYAN + "ANTLR4 > " + ConsoleColors.RESET + "Parsing and checking the grammar of the input...");
	        SMT_Lexer lexer = new SMT_Lexer(new ANTLRInputStream(istream));
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        SMT_Parser parser = new SMT_Parser(tokens);
	        // Launch the parser
	        parser.run();
		}
		catch(FileNotFoundException e) {
			System.out.println(ConsoleColors.CYAN + "FOADA > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " Input file cannot be found.");
		}
        catch(IOException e) {
        	System.out.println(ConsoleColors.CYAN + "Java > " + ConsoleColors.RED + "Error:" + ConsoleColors.RESET + " IO Exception.");
        }
    }
	
	public void run(String input) throws Exception {

        InputStream istream = new FileInputStream(input);
        
        // Instantiate lexer and parser, connected together:
        SMT_Lexer lexer = new SMT_Lexer(new ANTLRInputStream(istream));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SMT_Parser parser = new SMT_Parser(tokens);
        
        // Launch the parser
        parser.run();
        
    }

}
