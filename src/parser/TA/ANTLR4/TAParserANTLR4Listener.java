// Generated from TAParserANTLR4.g4 by ANTLR 4.7.1

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

package parser.TA.ANTLR4;

import exception.FOADAException;
import structure.Automaton;
import structure.FOADAExpression;
import structure.FOADAExpression.ExpressionCategory;
import structure.FOADAExpression.ExpressionType;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TAParserANTLR4}.
 */
public interface TAParserANTLR4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TAParserANTLR4#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(TAParserANTLR4.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParserANTLR4#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(TAParserANTLR4.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParserANTLR4#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TAParserANTLR4.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParserANTLR4#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TAParserANTLR4.ExpressionContext ctx);
}