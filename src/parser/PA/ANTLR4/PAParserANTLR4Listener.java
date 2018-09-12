// Generated from PAParserANTLR4.g4 by ANTLR 4.7.1

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

package parser.PA.ANTLR4;

import java.util.*;
import exception.*;
import structure.*;
import structure.FOADAExpression.*;
import org.sosy_lab.java_smt.api.*;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PAParserANTLR4}.
 */
public interface PAParserANTLR4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(PAParserANTLR4.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(PAParserANTLR4.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#final_list}.
	 * @param ctx the parse tree
	 */
	void enterFinal_list(PAParserANTLR4.Final_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#final_list}.
	 * @param ctx the parse tree
	 */
	void exitFinal_list(PAParserANTLR4.Final_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PAParserANTLR4.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PAParserANTLR4.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(PAParserANTLR4.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(PAParserANTLR4.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(PAParserANTLR4.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(PAParserANTLR4.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#basic_expression}.
	 * @param ctx the parse tree
	 */
	void enterBasic_expression(PAParserANTLR4.Basic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#basic_expression}.
	 * @param ctx the parse tree
	 */
	void exitBasic_expression(PAParserANTLR4.Basic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#eq_expression}.
	 * @param ctx the parse tree
	 */
	void enterEq_expression(PAParserANTLR4.Eq_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#eq_expression}.
	 * @param ctx the parse tree
	 */
	void exitEq_expression(PAParserANTLR4.Eq_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PAParserANTLR4#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_list(PAParserANTLR4.Argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PAParserANTLR4#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_list(PAParserANTLR4.Argument_listContext ctx);
}