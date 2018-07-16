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
	 * Enter a parse tree produced by {@link FOADA_Parser#event_def}.
	 * @param ctx the parse tree
	 */
	void enterEvent_def(FOADA_Parser.Event_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#event_def}.
	 * @param ctx the parse tree
	 */
	void exitEvent_def(FOADA_Parser.Event_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(FOADA_Parser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(FOADA_Parser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#pred_def}.
	 * @param ctx the parse tree
	 */
	void enterPred_def(FOADA_Parser.Pred_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#pred_def}.
	 * @param ctx the parse tree
	 */
	void exitPred_def(FOADA_Parser.Pred_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#init_def}.
	 * @param ctx the parse tree
	 */
	void enterInit_def(FOADA_Parser.Init_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#init_def}.
	 * @param ctx the parse tree
	 */
	void exitInit_def(FOADA_Parser.Init_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#final_def}.
	 * @param ctx the parse tree
	 */
	void enterFinal_def(FOADA_Parser.Final_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#final_def}.
	 * @param ctx the parse tree
	 */
	void exitFinal_def(FOADA_Parser.Final_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#trans_def}.
	 * @param ctx the parse tree
	 */
	void enterTrans_def(FOADA_Parser.Trans_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#trans_def}.
	 * @param ctx the parse tree
	 */
	void exitTrans_def(FOADA_Parser.Trans_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_events}.
	 * @param ctx the parse tree
	 */
	void enterList_events(FOADA_Parser.List_eventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_events}.
	 * @param ctx the parse tree
	 */
	void exitList_events(FOADA_Parser.List_eventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_types}.
	 * @param ctx the parse tree
	 */
	void enterList_types(FOADA_Parser.List_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_types}.
	 * @param ctx the parse tree
	 */
	void exitList_types(FOADA_Parser.List_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#list_predicates}.
	 * @param ctx the parse tree
	 */
	void enterList_predicates(FOADA_Parser.List_predicatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_predicates}.
	 * @param ctx the parse tree
	 */
	void exitList_predicates(FOADA_Parser.List_predicatesContext ctx);
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
}