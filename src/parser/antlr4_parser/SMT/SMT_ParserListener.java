// Generated from SMT_Parser.g4 by ANTLR 4.7.1

package parser.antlr4_parser.SMT;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMT_Parser}.
 */
public interface SMT_ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(SMT_Parser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(SMT_Parser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(SMT_Parser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(SMT_Parser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#check_sat}.
	 * @param ctx the parse tree
	 */
	void enterCheck_sat(SMT_Parser.Check_satContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#check_sat}.
	 * @param ctx the parse tree
	 */
	void exitCheck_sat(SMT_Parser.Check_satContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#get_model}.
	 * @param ctx the parse tree
	 */
	void enterGet_model(SMT_Parser.Get_modelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#get_model}.
	 * @param ctx the parse tree
	 */
	void exitGet_model(SMT_Parser.Get_modelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#automaton_def}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton_def(SMT_Parser.Automaton_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#automaton_def}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton_def(SMT_Parser.Automaton_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#initial_def}.
	 * @param ctx the parse tree
	 */
	void enterInitial_def(SMT_Parser.Initial_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#initial_def}.
	 * @param ctx the parse tree
	 */
	void exitInitial_def(SMT_Parser.Initial_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#list_finals_def}.
	 * @param ctx the parse tree
	 */
	void enterList_finals_def(SMT_Parser.List_finals_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#list_finals_def}.
	 * @param ctx the parse tree
	 */
	void exitList_finals_def(SMT_Parser.List_finals_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#list_transitions_def}.
	 * @param ctx the parse tree
	 */
	void enterList_transitions_def(SMT_Parser.List_transitions_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#list_transitions_def}.
	 * @param ctx the parse tree
	 */
	void exitList_transitions_def(SMT_Parser.List_transitions_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SMT_Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SMT_Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(SMT_Parser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(SMT_Parser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#list_finals}.
	 * @param ctx the parse tree
	 */
	void enterList_finals(SMT_Parser.List_finalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#list_finals}.
	 * @param ctx the parse tree
	 */
	void exitList_finals(SMT_Parser.List_finalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#list_transitions}.
	 * @param ctx the parse tree
	 */
	void enterList_transitions(SMT_Parser.List_transitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#list_transitions}.
	 * @param ctx the parse tree
	 */
	void exitList_transitions(SMT_Parser.List_transitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(SMT_Parser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(SMT_Parser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(SMT_Parser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(SMT_Parser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#list_arguments}.
	 * @param ctx the parse tree
	 */
	void enterList_arguments(SMT_Parser.List_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#list_arguments}.
	 * @param ctx the parse tree
	 */
	void exitList_arguments(SMT_Parser.List_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SMT_Parser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SMT_Parser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SMT_Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SMT_Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_Parser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(SMT_Parser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_Parser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(SMT_Parser.InputContext ctx);
}