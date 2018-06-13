// Generated from FOADA_Parser.g4 by ANTLR 4.7.1

package parser.antlr4_parser.FOADA;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOADA_Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEFAUTO=1, INIT=2, FINAL=3, TRANS=4, TRUE=5, FALSE=6, INT=7, BOOL=8, ID=9, 
		STRING=10, WS=11, LP=12, RP=13;
	public static final int
		RULE_automaton = 0, RULE_title = 1, RULE_initial_def = 2, RULE_list_finals_def = 3, 
		RULE_list_transitions_def = 4, RULE_expression = 5, RULE_list_finals = 6, 
		RULE_list_transitions = 7, RULE_transition = 8, RULE_state = 9, RULE_list_arguments = 10, 
		RULE_argument = 11, RULE_type = 12, RULE_input = 13;
	public static final String[] ruleNames = {
		"automaton", "title", "initial_def", "list_finals_def", "list_transitions_def", 
		"expression", "list_finals", "list_transitions", "transition", "state", 
		"list_arguments", "argument", "type", "input"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'init'", "'final'", "'trans'", "'true'", 
		"'false'", "'Int'", "'Bool'", null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", 
		"ID", "STRING", "WS", "LP", "RP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FOADA_Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOADA_Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode DEFAUTO() { return getToken(FOADA_Parser.DEFAUTO, 0); }
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public Initial_defContext initial_def() {
			return getRuleContext(Initial_defContext.class,0);
		}
		public List_finals_defContext list_finals_def() {
			return getRuleContext(List_finals_defContext.class,0);
		}
		public List_transitions_defContext list_transitions_def() {
			return getRuleContext(List_transitions_defContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public TerminalNode EOF() { return getToken(FOADA_Parser.EOF, 0); }
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitAutomaton(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(LP);
			setState(29);
			match(DEFAUTO);
			setState(30);
			title();
			setState(31);
			initial_def();
			setState(32);
			list_finals_def();
			setState(33);
			list_transitions_def();
			setState(34);
			match(RP);
			setState(35);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initial_defContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode INIT() { return getToken(FOADA_Parser.INIT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public Initial_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterInitial_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitInitial_def(this);
		}
	}

	public final Initial_defContext initial_def() throws RecognitionException {
		Initial_defContext _localctx = new Initial_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_initial_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LP);
			setState(40);
			match(INIT);
			setState(41);
			expression();
			setState(42);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_finals_defContext extends ParserRuleContext {
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode FINAL() { return getToken(FOADA_Parser.FINAL, 0); }
		public List_finalsContext list_finals() {
			return getRuleContext(List_finalsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public List_finals_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_finals_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_finals_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_finals_def(this);
		}
	}

	public final List_finals_defContext list_finals_def() throws RecognitionException {
		List_finals_defContext _localctx = new List_finals_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_list_finals_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(LP);
			setState(45);
			match(FINAL);
			setState(46);
			match(LP);
			setState(47);
			list_finals();
			setState(48);
			match(RP);
			setState(49);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_transitions_defContext extends ParserRuleContext {
		public List_transitionsContext list_transitions() {
			return getRuleContext(List_transitionsContext.class,0);
		}
		public List_transitions_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_transitions_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_transitions_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_transitions_def(this);
		}
	}

	public final List_transitions_defContext list_transitions_def() throws RecognitionException {
		List_transitions_defContext _localctx = new List_transitions_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_list_transitions_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			list_transitions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(FOADA_Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOADA_Parser.FALSE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_finalsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public List_finalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_finals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_finals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_finals(this);
		}
	}

	public final List_finalsContext list_finals() throws RecognitionException {
		List_finalsContext _localctx = new List_finalsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_list_finals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(56);
				match(ID);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_transitionsContext extends ParserRuleContext {
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public List_transitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_transitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_transitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_transitions(this);
		}
	}

	public final List_transitionsContext list_transitions() throws RecognitionException {
		List_transitionsContext _localctx = new List_transitionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list_transitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			transition();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(63);
				transition();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode TRANS() { return getToken(FOADA_Parser.TRANS, 0); }
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(LP);
			setState(70);
			match(TRANS);
			setState(71);
			state();
			setState(72);
			input();
			setState(73);
			expression();
			setState(74);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(LP);
			setState(77);
			match(ID);
			setState(78);
			match(LP);
			setState(79);
			list_arguments();
			setState(80);
			match(RP);
			setState(81);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_argumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_arguments(this);
		}
	}

	public final List_argumentsContext list_arguments() throws RecognitionException {
		List_argumentsContext _localctx = new List_argumentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_list_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			argument();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(84);
				argument();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(LP);
			setState(91);
			match(ID);
			setState(92);
			type();
			setState(93);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FOADA_Parser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOADA_Parser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(LP);
			setState(98);
			match(ID);
			setState(99);
			match(LP);
			setState(100);
			list_arguments();
			setState(101);
			match(RP);
			setState(102);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17k\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\t\3\t\7\tC\n\t\f\t\16\tF\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7"+
		"\fX\n\f\f\f\16\f[\13\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4"+
		"\3\2\7\b\3\2\t\n\2_\2\36\3\2\2\2\4\'\3\2\2\2\6)\3\2\2\2\b.\3\2\2\2\n\65"+
		"\3\2\2\2\f\67\3\2\2\2\169\3\2\2\2\20@\3\2\2\2\22G\3\2\2\2\24N\3\2\2\2"+
		"\26U\3\2\2\2\30\\\3\2\2\2\32a\3\2\2\2\34c\3\2\2\2\36\37\7\16\2\2\37 \7"+
		"\3\2\2 !\5\4\3\2!\"\5\6\4\2\"#\5\b\5\2#$\5\n\6\2$%\7\17\2\2%&\7\2\2\3"+
		"&\3\3\2\2\2\'(\7\13\2\2(\5\3\2\2\2)*\7\16\2\2*+\7\4\2\2+,\5\f\7\2,-\7"+
		"\17\2\2-\7\3\2\2\2./\7\16\2\2/\60\7\5\2\2\60\61\7\16\2\2\61\62\5\16\b"+
		"\2\62\63\7\17\2\2\63\64\7\17\2\2\64\t\3\2\2\2\65\66\5\20\t\2\66\13\3\2"+
		"\2\2\678\t\2\2\28\r\3\2\2\29=\7\13\2\2:<\7\13\2\2;:\3\2\2\2<?\3\2\2\2"+
		"=;\3\2\2\2=>\3\2\2\2>\17\3\2\2\2?=\3\2\2\2@D\5\22\n\2AC\5\22\n\2BA\3\2"+
		"\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\21\3\2\2\2FD\3\2\2\2GH\7\16\2\2HI"+
		"\7\6\2\2IJ\5\24\13\2JK\5\34\17\2KL\5\f\7\2LM\7\17\2\2M\23\3\2\2\2NO\7"+
		"\16\2\2OP\7\13\2\2PQ\7\16\2\2QR\5\26\f\2RS\7\17\2\2ST\7\17\2\2T\25\3\2"+
		"\2\2UY\5\30\r\2VX\5\30\r\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\27"+
		"\3\2\2\2[Y\3\2\2\2\\]\7\16\2\2]^\7\13\2\2^_\5\32\16\2_`\7\17\2\2`\31\3"+
		"\2\2\2ab\t\3\2\2b\33\3\2\2\2cd\7\16\2\2de\7\13\2\2ef\7\16\2\2fg\5\26\f"+
		"\2gh\7\17\2\2hi\7\17\2\2i\35\3\2\2\2\5=DY";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}