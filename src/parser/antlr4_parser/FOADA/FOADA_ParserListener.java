// Generated from FOADA_Parser.g4 by ANTLR 4.7.1

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
	 * Enter a parse tree produced by {@link FOADA_Parser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FOADA_Parser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FOADA_Parser.TitleContext ctx);
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
	 * Enter a parse tree produced by {@link FOADA_Parser#list_transitions_def}.
	 * @param ctx the parse tree
	 */
	void enterList_transitions_def(FOADA_Parser.List_transitions_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_transitions_def}.
	 * @param ctx the parse tree
	 */
	void exitList_transitions_def(FOADA_Parser.List_transitions_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FOADA_Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FOADA_Parser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link FOADA_Parser#list_transitions}.
	 * @param ctx the parse tree
	 */
	void enterList_transitions(FOADA_Parser.List_transitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#list_transitions}.
	 * @param ctx the parse tree
	 */
	void exitList_transitions(FOADA_Parser.List_transitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(FOADA_Parser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(FOADA_Parser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOADA_Parser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(FOADA_Parser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(FOADA_Parser.StateContext ctx);
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
	 * Enter a parse tree produced by {@link FOADA_Parser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(FOADA_Parser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(FOADA_Parser.ArgumentContext ctx);
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
	 * Enter a parse tree produced by {@link FOADA_Parser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(FOADA_Parser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOADA_Parser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(FOADA_Parser.InputContext ctx);
}