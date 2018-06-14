// Generated from SMT_Parser.g4 by ANTLR 4.7.1

package parser.antlr4_parser.SMT;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMT_Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEFAUTO=1, INIT=2, FINAL=3, TRANS=4, TRUE=5, FALSE=6, INT=7, BOOL=8, EXISTS=9, 
		FORALL=10, NOT=11, AND=12, OR=13, DISTINCT=14, ASSERT=15, CHECKSAT=16, 
		GETMODEL=17, ID=18, STRING=19, INTEGER=20, LP=21, RP=22, PLUS=23, MINUS=24, 
		TIMES=25, SLASH=26, GT=27, LT=28, GEQ=29, LEQ=30, EQUALS=31, WS=32, COMMENT=33;
	public static final int
		RULE_run = 0, RULE_assertion = 1, RULE_check_sat = 2, RULE_get_model = 3, 
		RULE_automaton_def = 4, RULE_initial_def = 5, RULE_list_finals_def = 6, 
		RULE_list_transitions_def = 7, RULE_expression = 8, RULE_integer = 9, 
		RULE_list_finals = 10, RULE_list_transitions = 11, RULE_transition = 12, 
		RULE_state = 13, RULE_list_arguments = 14, RULE_argument = 15, RULE_type = 16, 
		RULE_input = 17;
	public static final String[] ruleNames = {
		"run", "assertion", "check_sat", "get_model", "automaton_def", "initial_def", 
		"list_finals_def", "list_transitions_def", "expression", "integer", "list_finals", 
		"list_transitions", "transition", "state", "list_arguments", "argument", 
		"type", "input"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'init'", "'final'", "'trans'", "'true'", 
		"'false'", "'Int'", "'Bool'", "'exists'", "'forall'", "'not'", "'and'", 
		"'or'", "'distinct'", "'assert'", "'check-sat'", "'get-model'", null, 
		null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", 
		"'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", 
		"EXISTS", "FORALL", "NOT", "AND", "OR", "DISTINCT", "ASSERT", "CHECKSAT", 
		"GETMODEL", "ID", "STRING", "INTEGER", "LP", "RP", "PLUS", "MINUS", "TIMES", 
		"SLASH", "GT", "LT", "GEQ", "LEQ", "EQUALS", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "SMT_Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SMT_Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RunContext extends ParserRuleContext {
		public List<Automaton_defContext> automaton_def() {
			return getRuleContexts(Automaton_defContext.class);
		}
		public Automaton_defContext automaton_def(int i) {
			return getRuleContext(Automaton_defContext.class,i);
		}
		public List<AssertionContext> assertion() {
			return getRuleContexts(AssertionContext.class);
		}
		public AssertionContext assertion(int i) {
			return getRuleContext(AssertionContext.class,i);
		}
		public List<Check_satContext> check_sat() {
			return getRuleContexts(Check_satContext.class);
		}
		public Check_satContext check_sat(int i) {
			return getRuleContext(Check_satContext.class,i);
		}
		public List<Get_modelContext> get_model() {
			return getRuleContexts(Get_modelContext.class);
		}
		public Get_modelContext get_model(int i) {
			return getRuleContext(Get_modelContext.class,i);
		}
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitRun(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_run);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(40);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					automaton_def();
					}
					break;
				case 2:
					{
					setState(37);
					assertion();
					}
					break;
				case 3:
					{
					setState(38);
					check_sat();
					}
					break;
				case 4:
					{
					setState(39);
					get_model();
					}
					break;
				}
				}
				setState(44);
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

	public static class AssertionContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode ASSERT() { return getToken(SMT_Parser.ASSERT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitAssertion(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(LP);
			setState(46);
			match(ASSERT);
			setState(47);
			expression();
			setState(48);
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

	public static class Check_satContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode CHECKSAT() { return getToken(SMT_Parser.CHECKSAT, 0); }
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public Check_satContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_sat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterCheck_sat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitCheck_sat(this);
		}
	}

	public final Check_satContext check_sat() throws RecognitionException {
		Check_satContext _localctx = new Check_satContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_check_sat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(LP);
			setState(51);
			match(CHECKSAT);
			setState(52);
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

	public static class Get_modelContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode GETMODEL() { return getToken(SMT_Parser.GETMODEL, 0); }
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public Get_modelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterGet_model(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitGet_model(this);
		}
	}

	public final Get_modelContext get_model() throws RecognitionException {
		Get_modelContext _localctx = new Get_modelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_get_model);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(LP);
			setState(55);
			match(GETMODEL);
			setState(56);
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

	public static class Automaton_defContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode DEFAUTO() { return getToken(SMT_Parser.DEFAUTO, 0); }
		public TerminalNode ID() { return getToken(SMT_Parser.ID, 0); }
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public List<Initial_defContext> initial_def() {
			return getRuleContexts(Initial_defContext.class);
		}
		public Initial_defContext initial_def(int i) {
			return getRuleContext(Initial_defContext.class,i);
		}
		public List<List_finals_defContext> list_finals_def() {
			return getRuleContexts(List_finals_defContext.class);
		}
		public List_finals_defContext list_finals_def(int i) {
			return getRuleContext(List_finals_defContext.class,i);
		}
		public List<List_transitions_defContext> list_transitions_def() {
			return getRuleContexts(List_transitions_defContext.class);
		}
		public List_transitions_defContext list_transitions_def(int i) {
			return getRuleContext(List_transitions_defContext.class,i);
		}
		public Automaton_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterAutomaton_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitAutomaton_def(this);
		}
	}

	public final Automaton_defContext automaton_def() throws RecognitionException {
		Automaton_defContext _localctx = new Automaton_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_automaton_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LP);
			setState(59);
			match(DEFAUTO);
			setState(60);
			match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(61);
					initial_def();
					}
					break;
				case 2:
					{
					setState(62);
					list_finals_def();
					}
					break;
				case 3:
					{
					setState(63);
					list_transitions_def();
					}
					break;
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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

	public static class Initial_defContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode INIT() { return getToken(SMT_Parser.INIT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public Initial_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterInitial_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitInitial_def(this);
		}
	}

	public final Initial_defContext initial_def() throws RecognitionException {
		Initial_defContext _localctx = new Initial_defContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_initial_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(LP);
			setState(72);
			match(INIT);
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

	public static class List_finals_defContext extends ParserRuleContext {
		public List<TerminalNode> LP() { return getTokens(SMT_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(SMT_Parser.LP, i);
		}
		public TerminalNode FINAL() { return getToken(SMT_Parser.FINAL, 0); }
		public List_finalsContext list_finals() {
			return getRuleContext(List_finalsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(SMT_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(SMT_Parser.RP, i);
		}
		public List_finals_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_finals_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterList_finals_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitList_finals_def(this);
		}
	}

	public final List_finals_defContext list_finals_def() throws RecognitionException {
		List_finals_defContext _localctx = new List_finals_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_list_finals_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(LP);
			setState(77);
			match(FINAL);
			setState(78);
			match(LP);
			setState(79);
			list_finals();
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
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterList_transitions_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitList_transitions_def(this);
		}
	}

	public final List_transitions_defContext list_transitions_def() throws RecognitionException {
		List_transitions_defContext _localctx = new List_transitions_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list_transitions_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
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
		public TerminalNode TRUE() { return getToken(SMT_Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SMT_Parser.FALSE, 0); }
		public List<TerminalNode> LP() { return getTokens(SMT_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(SMT_Parser.LP, i);
		}
		public TerminalNode NOT() { return getToken(SMT_Parser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(SMT_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(SMT_Parser.RP, i);
		}
		public TerminalNode DISTINCT() { return getToken(SMT_Parser.DISTINCT, 0); }
		public TerminalNode AND() { return getToken(SMT_Parser.AND, 0); }
		public TerminalNode OR() { return getToken(SMT_Parser.OR, 0); }
		public TerminalNode EXISTS() { return getToken(SMT_Parser.EXISTS, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(SMT_Parser.FORALL, 0); }
		public TerminalNode GT() { return getToken(SMT_Parser.GT, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode LT() { return getToken(SMT_Parser.LT, 0); }
		public TerminalNode GEQ() { return getToken(SMT_Parser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(SMT_Parser.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(SMT_Parser.EQUALS, 0); }
		public List<TerminalNode> ID() { return getTokens(SMT_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SMT_Parser.ID, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(TRUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(FALSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(LP);
				setState(88);
				match(NOT);
				setState(89);
				expression();
				setState(90);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(LP);
				setState(93);
				match(DISTINCT);
				setState(94);
				expression();
				setState(95);
				expression();
				setState(96);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(LP);
				setState(99);
				match(AND);
				setState(100);
				expression();
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					expression();
					}
					}
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
				setState(106);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				match(LP);
				setState(109);
				match(OR);
				setState(110);
				expression();
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					expression();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
				setState(116);
				match(RP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(118);
				match(LP);
				setState(119);
				match(EXISTS);
				setState(120);
				match(LP);
				setState(121);
				list_arguments();
				setState(122);
				match(RP);
				setState(123);
				expression();
				setState(124);
				match(RP);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(126);
				match(LP);
				setState(127);
				match(FORALL);
				setState(128);
				match(LP);
				setState(129);
				list_arguments();
				setState(130);
				match(RP);
				setState(131);
				expression();
				setState(132);
				match(RP);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(134);
				match(LP);
				setState(135);
				match(GT);
				setState(136);
				integer();
				setState(137);
				integer();
				setState(138);
				match(RP);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(140);
				match(LP);
				setState(141);
				match(LT);
				setState(142);
				integer();
				setState(143);
				integer();
				setState(144);
				match(RP);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(146);
				match(LP);
				setState(147);
				match(GEQ);
				setState(148);
				integer();
				setState(149);
				integer();
				setState(150);
				match(RP);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(152);
				match(LP);
				setState(153);
				match(LEQ);
				setState(154);
				integer();
				setState(155);
				integer();
				setState(156);
				match(RP);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(158);
				match(LP);
				setState(159);
				match(EQUALS);
				setState(160);
				integer();
				setState(161);
				integer();
				setState(162);
				match(RP);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(164);
				match(ID);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(165);
				match(LP);
				setState(166);
				match(ID);
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(167);
					match(ID);
					}
					}
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(172);
				match(RP);
				}
				break;
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SMT_Parser.INTEGER, 0); }
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode PLUS() { return getToken(SMT_Parser.PLUS, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public TerminalNode MINUS() { return getToken(SMT_Parser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(SMT_Parser.TIMES, 0); }
		public TerminalNode SLASH() { return getToken(SMT_Parser.SLASH, 0); }
		public TerminalNode ID() { return getToken(SMT_Parser.ID, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_integer);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(LP);
				setState(177);
				match(PLUS);
				setState(178);
				integer();
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(179);
					integer();
					}
					}
					setState(182); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(184);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(LP);
				setState(187);
				match(MINUS);
				setState(188);
				integer();
				setState(189);
				integer();
				setState(190);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(LP);
				setState(193);
				match(TIMES);
				setState(194);
				integer();
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(195);
					integer();
					}
					}
					setState(198); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(200);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				match(LP);
				setState(203);
				match(SLASH);
				setState(204);
				integer();
				setState(205);
				integer();
				setState(206);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(208);
				match(ID);
				}
				break;
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
		public List<TerminalNode> ID() { return getTokens(SMT_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SMT_Parser.ID, i);
		}
		public List_finalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_finals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterList_finals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitList_finals(this);
		}
	}

	public final List_finalsContext list_finals() throws RecognitionException {
		List_finalsContext _localctx = new List_finalsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_list_finals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(ID);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(212);
				match(ID);
				}
				}
				setState(217);
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
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterList_transitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitList_transitions(this);
		}
	}

	public final List_transitionsContext list_transitions() throws RecognitionException {
		List_transitionsContext _localctx = new List_transitionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_list_transitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			transition();
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(219);
					transition();
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode TRANS() { return getToken(SMT_Parser.TRANS, 0); }
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LP);
			setState(226);
			match(TRANS);
			setState(227);
			state();
			setState(228);
			input();
			setState(229);
			expression();
			setState(230);
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
		public List<TerminalNode> LP() { return getTokens(SMT_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(SMT_Parser.LP, i);
		}
		public TerminalNode ID() { return getToken(SMT_Parser.ID, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(SMT_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(SMT_Parser.RP, i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(LP);
			setState(233);
			match(ID);
			setState(234);
			match(LP);
			setState(235);
			list_arguments();
			setState(236);
			match(RP);
			setState(237);
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
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterList_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitList_arguments(this);
		}
	}

	public final List_argumentsContext list_arguments() throws RecognitionException {
		List_argumentsContext _localctx = new List_argumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_list_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			argument();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(240);
				argument();
				}
				}
				setState(245);
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
		public TerminalNode LP() { return getToken(SMT_Parser.LP, 0); }
		public TerminalNode ID() { return getToken(SMT_Parser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RP() { return getToken(SMT_Parser.RP, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(LP);
			setState(247);
			match(ID);
			setState(248);
			type();
			setState(249);
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
		public TerminalNode INT() { return getToken(SMT_Parser.INT, 0); }
		public TerminalNode BOOL() { return getToken(SMT_Parser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
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
		public List<TerminalNode> LP() { return getTokens(SMT_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(SMT_Parser.LP, i);
		}
		public TerminalNode ID() { return getToken(SMT_Parser.ID, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(SMT_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(SMT_Parser.RP, i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_ParserListener ) ((SMT_ParserListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(LP);
			setState(254);
			match(ID);
			setState(255);
			match(LP);
			setState(256);
			list_arguments();
			setState(257);
			match(RP);
			setState(258);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0107\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6C\n\6\f\6"+
		"\16\6F\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\6\ni\n\n\r\n\16\nj\3\n\3\n\3\n\3\n\3\n\3\n\6\ns\n\n\r\n\16\nt\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u00ab"+
		"\n\n\r\n\16\n\u00ac\3\n\5\n\u00b0\n\n\3\13\3\13\3\13\3\13\3\13\6\13\u00b7"+
		"\n\13\r\13\16\13\u00b8\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\6\13\u00c7\n\13\r\13\16\13\u00c8\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00d4\n\13\3\f\3\f\7\f\u00d8\n\f\f\f\16\f\u00db"+
		"\13\f\3\r\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u00f4"+
		"\n\20\f\20\16\20\u00f7\13\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\3\3\2\t\n\2\u0116\2,\3\2\2\2\4/\3\2\2\2\6\64\3\2\2\2\b"+
		"8\3\2\2\2\n<\3\2\2\2\fI\3\2\2\2\16N\3\2\2\2\20U\3\2\2\2\22\u00af\3\2\2"+
		"\2\24\u00d3\3\2\2\2\26\u00d5\3\2\2\2\30\u00dc\3\2\2\2\32\u00e3\3\2\2\2"+
		"\34\u00ea\3\2\2\2\36\u00f1\3\2\2\2 \u00f8\3\2\2\2\"\u00fd\3\2\2\2$\u00ff"+
		"\3\2\2\2&+\5\n\6\2\'+\5\4\3\2(+\5\6\4\2)+\5\b\5\2*&\3\2\2\2*\'\3\2\2\2"+
		"*(\3\2\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\3\3\2\2\2.,\3\2\2"+
		"\2/\60\7\27\2\2\60\61\7\21\2\2\61\62\5\22\n\2\62\63\7\30\2\2\63\5\3\2"+
		"\2\2\64\65\7\27\2\2\65\66\7\22\2\2\66\67\7\30\2\2\67\7\3\2\2\289\7\27"+
		"\2\29:\7\23\2\2:;\7\30\2\2;\t\3\2\2\2<=\7\27\2\2=>\7\3\2\2>D\7\24\2\2"+
		"?C\5\f\7\2@C\5\16\b\2AC\5\20\t\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2CF\3\2\2"+
		"\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\30\2\2H\13\3\2\2\2IJ\7"+
		"\27\2\2JK\7\4\2\2KL\5\22\n\2LM\7\30\2\2M\r\3\2\2\2NO\7\27\2\2OP\7\5\2"+
		"\2PQ\7\27\2\2QR\5\26\f\2RS\7\30\2\2ST\7\30\2\2T\17\3\2\2\2UV\5\30\r\2"+
		"V\21\3\2\2\2W\u00b0\7\7\2\2X\u00b0\7\b\2\2YZ\7\27\2\2Z[\7\r\2\2[\\\5\22"+
		"\n\2\\]\7\30\2\2]\u00b0\3\2\2\2^_\7\27\2\2_`\7\20\2\2`a\5\22\n\2ab\5\22"+
		"\n\2bc\7\30\2\2c\u00b0\3\2\2\2de\7\27\2\2ef\7\16\2\2fh\5\22\n\2gi\5\22"+
		"\n\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\30\2\2m\u00b0"+
		"\3\2\2\2no\7\27\2\2op\7\17\2\2pr\5\22\n\2qs\5\22\n\2rq\3\2\2\2st\3\2\2"+
		"\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\30\2\2w\u00b0\3\2\2\2xy\7\27\2\2"+
		"yz\7\13\2\2z{\7\27\2\2{|\5\36\20\2|}\7\30\2\2}~\5\22\n\2~\177\7\30\2\2"+
		"\177\u00b0\3\2\2\2\u0080\u0081\7\27\2\2\u0081\u0082\7\f\2\2\u0082\u0083"+
		"\7\27\2\2\u0083\u0084\5\36\20\2\u0084\u0085\7\30\2\2\u0085\u0086\5\22"+
		"\n\2\u0086\u0087\7\30\2\2\u0087\u00b0\3\2\2\2\u0088\u0089\7\27\2\2\u0089"+
		"\u008a\7\35\2\2\u008a\u008b\5\24\13\2\u008b\u008c\5\24\13\2\u008c\u008d"+
		"\7\30\2\2\u008d\u00b0\3\2\2\2\u008e\u008f\7\27\2\2\u008f\u0090\7\36\2"+
		"\2\u0090\u0091\5\24\13\2\u0091\u0092\5\24\13\2\u0092\u0093\7\30\2\2\u0093"+
		"\u00b0\3\2\2\2\u0094\u0095\7\27\2\2\u0095\u0096\7\37\2\2\u0096\u0097\5"+
		"\24\13\2\u0097\u0098\5\24\13\2\u0098\u0099\7\30\2\2\u0099\u00b0\3\2\2"+
		"\2\u009a\u009b\7\27\2\2\u009b\u009c\7 \2\2\u009c\u009d\5\24\13\2\u009d"+
		"\u009e\5\24\13\2\u009e\u009f\7\30\2\2\u009f\u00b0\3\2\2\2\u00a0\u00a1"+
		"\7\27\2\2\u00a1\u00a2\7!\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\5\24\13"+
		"\2\u00a4\u00a5\7\30\2\2\u00a5\u00b0\3\2\2\2\u00a6\u00b0\7\24\2\2\u00a7"+
		"\u00a8\7\27\2\2\u00a8\u00aa\7\24\2\2\u00a9\u00ab\7\24\2\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\7\30\2\2\u00afW\3\2\2\2\u00afX\3\2\2\2\u00af"+
		"Y\3\2\2\2\u00af^\3\2\2\2\u00afd\3\2\2\2\u00afn\3\2\2\2\u00afx\3\2\2\2"+
		"\u00af\u0080\3\2\2\2\u00af\u0088\3\2\2\2\u00af\u008e\3\2\2\2\u00af\u0094"+
		"\3\2\2\2\u00af\u009a\3\2\2\2\u00af\u00a0\3\2\2\2\u00af\u00a6\3\2\2\2\u00af"+
		"\u00a7\3\2\2\2\u00b0\23\3\2\2\2\u00b1\u00d4\7\26\2\2\u00b2\u00b3\7\27"+
		"\2\2\u00b3\u00b4\7\31\2\2\u00b4\u00b6\5\24\13\2\u00b5\u00b7\5\24\13\2"+
		"\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\30\2\2\u00bb\u00d4\3\2\2\2"+
		"\u00bc\u00bd\7\27\2\2\u00bd\u00be\7\32\2\2\u00be\u00bf\5\24\13\2\u00bf"+
		"\u00c0\5\24\13\2\u00c0\u00c1\7\30\2\2\u00c1\u00d4\3\2\2\2\u00c2\u00c3"+
		"\7\27\2\2\u00c3\u00c4\7\33\2\2\u00c4\u00c6\5\24\13\2\u00c5\u00c7\5\24"+
		"\13\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\30\2\2\u00cb\u00d4\3"+
		"\2\2\2\u00cc\u00cd\7\27\2\2\u00cd\u00ce\7\34\2\2\u00ce\u00cf\5\24\13\2"+
		"\u00cf\u00d0\5\24\13\2\u00d0\u00d1\7\30\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d4\7\24\2\2\u00d3\u00b1\3\2\2\2\u00d3\u00b2\3\2\2\2\u00d3\u00bc\3"+
		"\2\2\2\u00d3\u00c2\3\2\2\2\u00d3\u00cc\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"\25\3\2\2\2\u00d5\u00d9\7\24\2\2\u00d6\u00d8\7\24\2\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\27\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00e0\5\32\16\2\u00dd\u00df\5\32"+
		"\16\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\31\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\27\2"+
		"\2\u00e4\u00e5\7\6\2\2\u00e5\u00e6\5\34\17\2\u00e6\u00e7\5$\23\2\u00e7"+
		"\u00e8\5\22\n\2\u00e8\u00e9\7\30\2\2\u00e9\33\3\2\2\2\u00ea\u00eb\7\27"+
		"\2\2\u00eb\u00ec\7\24\2\2\u00ec\u00ed\7\27\2\2\u00ed\u00ee\5\36\20\2\u00ee"+
		"\u00ef\7\30\2\2\u00ef\u00f0\7\30\2\2\u00f0\35\3\2\2\2\u00f1\u00f5\5 \21"+
		"\2\u00f2\u00f4\5 \21\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\37\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00f9\7\27\2\2\u00f9\u00fa\7\24\2\2\u00fa\u00fb\5\"\22\2\u00fb\u00fc"+
		"\7\30\2\2\u00fc!\3\2\2\2\u00fd\u00fe\t\2\2\2\u00fe#\3\2\2\2\u00ff\u0100"+
		"\7\27\2\2\u0100\u0101\7\24\2\2\u0101\u0102\7\27\2\2\u0102\u0103\5\36\20"+
		"\2\u0103\u0104\7\30\2\2\u0104\u0105\7\30\2\2\u0105%\3\2\2\2\20*,BDjt\u00ac"+
		"\u00af\u00b8\u00c8\u00d3\u00d9\u00e0\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}