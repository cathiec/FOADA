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
		DEFAUTO=1, INIT=2, FINAL=3, TRANS=4, TRUE=5, FALSE=6, INT=7, BOOL=8, EXISTS=9, 
		FORALL=10, NOT=11, AND=12, OR=13, DISTINCT=14, ID=15, STRING=16, INTEGER=17, 
		LP=18, RP=19, PLUS=20, MINUS=21, TIMES=22, SLASH=23, GT=24, LT=25, GEQ=26, 
		LEQ=27, EQUALS=28, WS=29, COMMENT=30;
	public static final int
		RULE_automaton = 0, RULE_initial_def = 1, RULE_list_finals_def = 2, RULE_list_transitions_def = 3, 
		RULE_expression = 4, RULE_integer = 5, RULE_list_finals = 6, RULE_list_transitions = 7, 
		RULE_transition = 8, RULE_state = 9, RULE_list_arguments = 10, RULE_argument = 11, 
		RULE_type = 12, RULE_input = 13;
	public static final String[] ruleNames = {
		"automaton", "initial_def", "list_finals_def", "list_transitions_def", 
		"expression", "integer", "list_finals", "list_transitions", "transition", 
		"state", "list_arguments", "argument", "type", "input"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'init'", "'final'", "'trans'", "'true'", 
		"'false'", "'Int'", "'Bool'", "'exists'", "'forall'", "'not'", "'and'", 
		"'or'", "'distinct'", null, null, null, "'('", "')'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'<'", "'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", 
		"EXISTS", "FORALL", "NOT", "AND", "OR", "DISTINCT", "ID", "STRING", "INTEGER", 
		"LP", "RP", "PLUS", "MINUS", "TIMES", "SLASH", "GT", "LT", "GEQ", "LEQ", 
		"EQUALS", "WS", "COMMENT"
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
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public TerminalNode EOF() { return getToken(FOADA_Parser.EOF, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(LP);
			setState(29);
			match(DEFAUTO);
			setState(30);
			match(ID);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(34);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(31);
					initial_def();
					}
					break;
				case 2:
					{
					setState(32);
					list_finals_def();
					}
					break;
				case 3:
					{
					setState(33);
					list_transitions_def();
					}
					break;
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(RP);
			setState(40);
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
		enterRule(_localctx, 2, RULE_initial_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(LP);
			setState(43);
			match(INIT);
			setState(44);
			expression();
			setState(45);
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
		enterRule(_localctx, 4, RULE_list_finals_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(LP);
			setState(48);
			match(FINAL);
			setState(49);
			match(LP);
			setState(50);
			list_finals();
			setState(51);
			match(RP);
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
		enterRule(_localctx, 6, RULE_list_transitions_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode NOT() { return getToken(FOADA_Parser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public TerminalNode DISTINCT() { return getToken(FOADA_Parser.DISTINCT, 0); }
		public TerminalNode AND() { return getToken(FOADA_Parser.AND, 0); }
		public TerminalNode OR() { return getToken(FOADA_Parser.OR, 0); }
		public TerminalNode EXISTS() { return getToken(FOADA_Parser.EXISTS, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOADA_Parser.FORALL, 0); }
		public TerminalNode GT() { return getToken(FOADA_Parser.GT, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode LT() { return getToken(FOADA_Parser.LT, 0); }
		public TerminalNode GEQ() { return getToken(FOADA_Parser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(FOADA_Parser.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(FOADA_Parser.EQUALS, 0); }
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
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
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(TRUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(FALSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(LP);
				setState(59);
				match(NOT);
				setState(60);
				expression();
				setState(61);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				match(LP);
				setState(64);
				match(DISTINCT);
				setState(65);
				expression();
				setState(66);
				expression();
				setState(67);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				match(LP);
				setState(70);
				match(AND);
				setState(71);
				expression();
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					expression();
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
				setState(77);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(LP);
				setState(80);
				match(OR);
				setState(81);
				expression();
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					expression();
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
				setState(87);
				match(RP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				match(LP);
				setState(90);
				match(EXISTS);
				setState(91);
				match(LP);
				setState(92);
				list_arguments();
				setState(93);
				match(RP);
				setState(94);
				expression();
				setState(95);
				match(RP);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(97);
				match(LP);
				setState(98);
				match(FORALL);
				setState(99);
				match(LP);
				setState(100);
				list_arguments();
				setState(101);
				match(RP);
				setState(102);
				expression();
				setState(103);
				match(RP);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(105);
				match(LP);
				setState(106);
				match(GT);
				setState(107);
				integer();
				setState(108);
				integer();
				setState(109);
				match(RP);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(111);
				match(LP);
				setState(112);
				match(LT);
				setState(113);
				integer();
				setState(114);
				integer();
				setState(115);
				match(RP);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(117);
				match(LP);
				setState(118);
				match(GEQ);
				setState(119);
				integer();
				setState(120);
				integer();
				setState(121);
				match(RP);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(123);
				match(LP);
				setState(124);
				match(LEQ);
				setState(125);
				integer();
				setState(126);
				integer();
				setState(127);
				match(RP);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(129);
				match(LP);
				setState(130);
				match(EQUALS);
				setState(131);
				integer();
				setState(132);
				integer();
				setState(133);
				match(RP);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(135);
				match(ID);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(136);
				match(LP);
				setState(137);
				match(ID);
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138);
					match(ID);
					}
					}
					setState(141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(143);
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
		public TerminalNode INTEGER() { return getToken(FOADA_Parser.INTEGER, 0); }
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode PLUS() { return getToken(FOADA_Parser.PLUS, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public TerminalNode MINUS() { return getToken(FOADA_Parser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(FOADA_Parser.TIMES, 0); }
		public TerminalNode SLASH() { return getToken(FOADA_Parser.SLASH, 0); }
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_integer);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(LP);
				setState(148);
				match(PLUS);
				setState(149);
				integer();
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					integer();
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(155);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(LP);
				setState(158);
				match(MINUS);
				setState(159);
				integer();
				setState(160);
				integer();
				setState(161);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(LP);
				setState(164);
				match(TIMES);
				setState(165);
				integer();
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					integer();
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(171);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				match(LP);
				setState(174);
				match(SLASH);
				setState(175);
				integer();
				setState(176);
				integer();
				setState(177);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
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
			setState(182);
			match(ID);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(183);
				match(ID);
				}
				}
				setState(188);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			transition();
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					transition();
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
			setState(196);
			match(LP);
			setState(197);
			match(TRANS);
			setState(198);
			state();
			setState(199);
			input();
			setState(200);
			expression();
			setState(201);
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
			setState(203);
			match(LP);
			setState(204);
			match(ID);
			setState(205);
			match(LP);
			setState(206);
			list_arguments();
			setState(207);
			match(RP);
			setState(208);
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
			setState(210);
			argument();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(211);
				argument();
				}
				}
				setState(216);
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
			setState(217);
			match(LP);
			setState(218);
			match(ID);
			setState(219);
			type();
			setState(220);
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
			setState(222);
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
			setState(224);
			match(LP);
			setState(225);
			match(ID);
			setState(226);
			match(LP);
			setState(227);
			list_arguments();
			setState(228);
			match(RP);
			setState(229);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00ea\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\7\2%\n"+
		"\2\f\2\16\2(\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\6\6L\n\6\r\6\16\6M\3\6\3\6\3\6\3\6\3\6\3\6\6\6V\n\6\r\6"+
		"\16\6W\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\6\6\u008e\n\6\r\6\16\6\u008f\3\6\5\6\u0093\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\6\7\u009a\n\7\r\7\16\7\u009b\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\6\7\u00aa\n\7\r\7\16\7\u00ab\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00b7\n\7\3\b\3\b\7\b\u00bb\n\b\f\b\16\b\u00be\13\b\3\t\3\t"+
		"\7\t\u00c2\n\t\f\t\16\t\u00c5\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7\f\u00d7\n\f\f\f\16\f\u00da\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\3\3\2\t\n\2\u00f9\2\36\3"+
		"\2\2\2\4,\3\2\2\2\6\61\3\2\2\2\b8\3\2\2\2\n\u0092\3\2\2\2\f\u00b6\3\2"+
		"\2\2\16\u00b8\3\2\2\2\20\u00bf\3\2\2\2\22\u00c6\3\2\2\2\24\u00cd\3\2\2"+
		"\2\26\u00d4\3\2\2\2\30\u00db\3\2\2\2\32\u00e0\3\2\2\2\34\u00e2\3\2\2\2"+
		"\36\37\7\24\2\2\37 \7\3\2\2 &\7\21\2\2!%\5\4\3\2\"%\5\6\4\2#%\5\b\5\2"+
		"$!\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2"+
		"\2\2(&\3\2\2\2)*\7\25\2\2*+\7\2\2\3+\3\3\2\2\2,-\7\24\2\2-.\7\4\2\2./"+
		"\5\n\6\2/\60\7\25\2\2\60\5\3\2\2\2\61\62\7\24\2\2\62\63\7\5\2\2\63\64"+
		"\7\24\2\2\64\65\5\16\b\2\65\66\7\25\2\2\66\67\7\25\2\2\67\7\3\2\2\289"+
		"\5\20\t\29\t\3\2\2\2:\u0093\7\7\2\2;\u0093\7\b\2\2<=\7\24\2\2=>\7\r\2"+
		"\2>?\5\n\6\2?@\7\25\2\2@\u0093\3\2\2\2AB\7\24\2\2BC\7\20\2\2CD\5\n\6\2"+
		"DE\5\n\6\2EF\7\25\2\2F\u0093\3\2\2\2GH\7\24\2\2HI\7\16\2\2IK\5\n\6\2J"+
		"L\5\n\6\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\25\2\2"+
		"P\u0093\3\2\2\2QR\7\24\2\2RS\7\17\2\2SU\5\n\6\2TV\5\n\6\2UT\3\2\2\2VW"+
		"\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\25\2\2Z\u0093\3\2\2\2[\\\7"+
		"\24\2\2\\]\7\13\2\2]^\7\24\2\2^_\5\26\f\2_`\7\25\2\2`a\5\n\6\2ab\7\25"+
		"\2\2b\u0093\3\2\2\2cd\7\24\2\2de\7\f\2\2ef\7\24\2\2fg\5\26\f\2gh\7\25"+
		"\2\2hi\5\n\6\2ij\7\25\2\2j\u0093\3\2\2\2kl\7\24\2\2lm\7\32\2\2mn\5\f\7"+
		"\2no\5\f\7\2op\7\25\2\2p\u0093\3\2\2\2qr\7\24\2\2rs\7\33\2\2st\5\f\7\2"+
		"tu\5\f\7\2uv\7\25\2\2v\u0093\3\2\2\2wx\7\24\2\2xy\7\34\2\2yz\5\f\7\2z"+
		"{\5\f\7\2{|\7\25\2\2|\u0093\3\2\2\2}~\7\24\2\2~\177\7\35\2\2\177\u0080"+
		"\5\f\7\2\u0080\u0081\5\f\7\2\u0081\u0082\7\25\2\2\u0082\u0093\3\2\2\2"+
		"\u0083\u0084\7\24\2\2\u0084\u0085\7\36\2\2\u0085\u0086\5\f\7\2\u0086\u0087"+
		"\5\f\7\2\u0087\u0088\7\25\2\2\u0088\u0093\3\2\2\2\u0089\u0093\7\21\2\2"+
		"\u008a\u008b\7\24\2\2\u008b\u008d\7\21\2\2\u008c\u008e\7\21\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\7\25\2\2\u0092:\3\2\2\2\u0092;\3"+
		"\2\2\2\u0092<\3\2\2\2\u0092A\3\2\2\2\u0092G\3\2\2\2\u0092Q\3\2\2\2\u0092"+
		"[\3\2\2\2\u0092c\3\2\2\2\u0092k\3\2\2\2\u0092q\3\2\2\2\u0092w\3\2\2\2"+
		"\u0092}\3\2\2\2\u0092\u0083\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008a\3"+
		"\2\2\2\u0093\13\3\2\2\2\u0094\u00b7\7\23\2\2\u0095\u0096\7\24\2\2\u0096"+
		"\u0097\7\26\2\2\u0097\u0099\5\f\7\2\u0098\u009a\5\f\7\2\u0099\u0098\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\7\25\2\2\u009e\u00b7\3\2\2\2\u009f\u00a0\7"+
		"\24\2\2\u00a0\u00a1\7\27\2\2\u00a1\u00a2\5\f\7\2\u00a2\u00a3\5\f\7\2\u00a3"+
		"\u00a4\7\25\2\2\u00a4\u00b7\3\2\2\2\u00a5\u00a6\7\24\2\2\u00a6\u00a7\7"+
		"\30\2\2\u00a7\u00a9\5\f\7\2\u00a8\u00aa\5\f\7\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ae\7\25\2\2\u00ae\u00b7\3\2\2\2\u00af\u00b0\7\24\2\2\u00b0"+
		"\u00b1\7\31\2\2\u00b1\u00b2\5\f\7\2\u00b2\u00b3\5\f\7\2\u00b3\u00b4\7"+
		"\25\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b7\7\21\2\2\u00b6\u0094\3\2\2\2\u00b6"+
		"\u0095\3\2\2\2\u00b6\u009f\3\2\2\2\u00b6\u00a5\3\2\2\2\u00b6\u00af\3\2"+
		"\2\2\u00b6\u00b5\3\2\2\2\u00b7\r\3\2\2\2\u00b8\u00bc\7\21\2\2\u00b9\u00bb"+
		"\7\21\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\17\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c3"+
		"\5\22\n\2\u00c0\u00c2\5\22\n\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2"+
		"\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\21\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c6\u00c7\7\24\2\2\u00c7\u00c8\7\6\2\2\u00c8\u00c9\5\24\13"+
		"\2\u00c9\u00ca\5\34\17\2\u00ca\u00cb\5\n\6\2\u00cb\u00cc\7\25\2\2\u00cc"+
		"\23\3\2\2\2\u00cd\u00ce\7\24\2\2\u00ce\u00cf\7\21\2\2\u00cf\u00d0\7\24"+
		"\2\2\u00d0\u00d1\5\26\f\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3\7\25\2\2\u00d3"+
		"\25\3\2\2\2\u00d4\u00d8\5\30\r\2\u00d5\u00d7\5\30\r\2\u00d6\u00d5\3\2"+
		"\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\27\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\24\2\2\u00dc\u00dd\7\21"+
		"\2\2\u00dd\u00de\5\32\16\2\u00de\u00df\7\25\2\2\u00df\31\3\2\2\2\u00e0"+
		"\u00e1\t\2\2\2\u00e1\33\3\2\2\2\u00e2\u00e3\7\24\2\2\u00e3\u00e4\7\21"+
		"\2\2\u00e4\u00e5\7\24\2\2\u00e5\u00e6\5\26\f\2\u00e6\u00e7\7\25\2\2\u00e7"+
		"\u00e8\7\25\2\2\u00e8\35\3\2\2\2\16$&MW\u008f\u0092\u009b\u00ab\u00b6"+
		"\u00bc\u00c3\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}