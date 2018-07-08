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

package parser.antlr4_parser.FOADA;

import java.util.*;
import structure.*;
import structure.Transition;
import structure.Expression.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOADA_Parser}.
 */
public interface FOADA_ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(FOADA_Parser.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(FOADA_Parser.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#initial_def}.
	 * @param ctx the parse tree
	 */
	void enterInitial_def(FOADA_Parser.Initial_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#initial_def}.
	 * @param ctx the parse tree
	 */
	void exitInitial_def(FOADA_Parser.Initial_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_finals_def}.
	 * @param ctx the parse tree
	 */
	void enterList_finals_def(FOADA_Parser.List_finals_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_finals_def}.
	 * @param ctx the parse tree
	 */
	void exitList_finals_def(FOADA_Parser.List_finals_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#transition_def}.
	 * @param ctx the parse tree
	 */
	void enterTransition_def(FOADA_Parser.Transition_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#transition_def}.
	 * @param ctx the parse tree
	 */
	void exitTransition_def(FOADA_Parser.Transition_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FOADA_Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FOADA_Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_finals}.
	 * @param ctx the parse tree
	 */
	void enterList_finals(FOADA_Parser.List_finalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_finals}.
	 * @param ctx the parse tree
	 */
	void exitList_finals(FOADA_Parser.List_finalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_arguments}.
	 * @param ctx the parse tree
	 */
	void enterList_arguments(FOADA_Parser.List_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_arguments}.
	 * @param ctx the parse tree
	 */
	void exitList_arguments(FOADA_Parser.List_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FOADA_Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FOADA_Parser.TypeContext ctx);
}