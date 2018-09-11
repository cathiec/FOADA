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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PAParserANTLR4 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, FINAL=2, NONE=3, FALSE=4, TRUE=5, FORALL=6, EXISTS=7, TL=8, TR=9, 
		AND=10, OR=11, EQUALS=12, DISTINCTS=13, ID=14, INTEGER=15, FUNCNAME=16, 
		SYMBOL=17, LP=18, RP=19, POINT=20, TWOPOINTS=21, COM=22, WS=23, COMMENT=24;
	public static final int
		RULE_automaton = 0, RULE_final_list = 1, RULE_transition = 2, RULE_expression = 3, 
		RULE_argument_list = 4;
	public static final String[] ruleNames = {
		"automaton", "final_list", "transition", "expression", "argument_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'start'", "'final'", "'none'", "'false'", "'true'", "'forall'", 
		"'exists'", "'--('", "')->'", "'/\\'", "'\\/'", "'='", "'!='", null, null, 
		null, null, "'('", "')'", "'.'", "':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "START", "FINAL", "NONE", "FALSE", "TRUE", "FORALL", "EXISTS", "TL", 
		"TR", "AND", "OR", "EQUALS", "DISTINCTS", "ID", "INTEGER", "FUNCNAME", 
		"SYMBOL", "LP", "RP", "POINT", "TWOPOINTS", "COM", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "PAParserANTLR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PAParserANTLR4(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public Automaton tree;
		public TerminalNode START() { return getToken(PAParserANTLR4.START, 0); }
		public List<TerminalNode> TWOPOINTS() { return getTokens(PAParserANTLR4.TWOPOINTS); }
		public TerminalNode TWOPOINTS(int i) {
			return getToken(PAParserANTLR4.TWOPOINTS, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> POINT() { return getTokens(PAParserANTLR4.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(PAParserANTLR4.POINT, i);
		}
		public TerminalNode FINAL() { return getToken(PAParserANTLR4.FINAL, 0); }
		public Final_listContext final_list() {
			return getRuleContext(Final_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PAParserANTLR4.EOF, 0); }
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitAutomaton(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(START);
			setState(11);
			match(TWOPOINTS);
			setState(12);
			expression(0);
			setState(13);
			match(POINT);
			setState(14);
			match(FINAL);
			setState(15);
			match(TWOPOINTS);
			setState(16);
			final_list();
			setState(17);
			match(POINT);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCNAME) {
				{
				{
				setState(18);
				transition();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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

	public static class Final_listContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(PAParserANTLR4.NONE, 0); }
		public List<TerminalNode> FUNCNAME() { return getTokens(PAParserANTLR4.FUNCNAME); }
		public TerminalNode FUNCNAME(int i) {
			return getToken(PAParserANTLR4.FUNCNAME, i);
		}
		public List<TerminalNode> COM() { return getTokens(PAParserANTLR4.COM); }
		public TerminalNode COM(int i) {
			return getToken(PAParserANTLR4.COM, i);
		}
		public Final_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterFinal_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitFinal_list(this);
		}
	}

	public final Final_listContext final_list() throws RecognitionException {
		Final_listContext _localctx = new Final_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_final_list);
		int _la;
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(NONE);
				}
				break;
			case FUNCNAME:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(27);
				match(FUNCNAME);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(28);
					match(COM);
					setState(29);
					match(FUNCNAME);
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TerminalNode FUNCNAME() { return getToken(PAParserANTLR4.FUNCNAME, 0); }
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public TerminalNode TL() { return getToken(PAParserANTLR4.TL, 0); }
		public TerminalNode SYMBOL() { return getToken(PAParserANTLR4.SYMBOL, 0); }
		public TerminalNode TWOPOINTS() { return getToken(PAParserANTLR4.TWOPOINTS, 0); }
		public TerminalNode ID() { return getToken(PAParserANTLR4.ID, 0); }
		public TerminalNode TR() { return getToken(PAParserANTLR4.TR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode POINT() { return getToken(PAParserANTLR4.POINT, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(FUNCNAME);
			setState(38);
			match(LP);
			setState(39);
			argument_list();
			setState(40);
			match(RP);
			setState(41);
			match(TL);
			setState(42);
			match(SYMBOL);
			setState(43);
			match(TWOPOINTS);
			setState(44);
			match(ID);
			setState(45);
			match(TR);
			setState(46);
			expression(0);
			setState(47);
			match(POINT);
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
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode EXISTS() { return getToken(PAParserANTLR4.EXISTS, 0); }
		public List<TerminalNode> ID() { return getTokens(PAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(PAParserANTLR4.ID, i);
		}
		public TerminalNode POINT() { return getToken(PAParserANTLR4.POINT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FORALL() { return getToken(PAParserANTLR4.FORALL, 0); }
		public TerminalNode FUNCNAME() { return getToken(PAParserANTLR4.FUNCNAME, 0); }
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public TerminalNode EQUALS() { return getToken(PAParserANTLR4.EQUALS, 0); }
		public TerminalNode DISTINCTS() { return getToken(PAParserANTLR4.DISTINCTS, 0); }
		public TerminalNode TRUE() { return getToken(PAParserANTLR4.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PAParserANTLR4.FALSE, 0); }
		public TerminalNode AND() { return getToken(PAParserANTLR4.AND, 0); }
		public TerminalNode OR() { return getToken(PAParserANTLR4.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(50);
				match(EXISTS);
				setState(51);
				match(ID);
				setState(52);
				match(POINT);
				setState(53);
				expression(10);

					
				}
				break;
			case 2:
				{
				setState(56);
				match(FORALL);
				setState(57);
				match(ID);
				setState(58);
				match(POINT);
				setState(59);
				expression(9);

					
				}
				break;
			case 3:
				{
				setState(62);
				match(FUNCNAME);
				setState(63);
				match(LP);
				setState(64);
				argument_list();
				setState(65);
				match(RP);

					
				}
				break;
			case 4:
				{
				setState(68);
				match(ID);
				setState(69);
				match(EQUALS);
				setState(70);
				match(ID);

					
				}
				break;
			case 5:
				{
				setState(72);
				match(ID);
				setState(73);
				match(DISTINCTS);
				setState(74);
				match(ID);

					
				}
				break;
			case 6:
				{
				setState(76);
				match(TRUE);

					
				}
				break;
			case 7:
				{
				setState(78);
				match(FALSE);

					
				}
				break;
			case 8:
				{
				setState(80);
				match(LP);
				setState(81);
				expression(0);
				setState(82);
				match(RP);

					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(97);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(88);
						match(AND);
						setState(89);
						((ExpressionContext)_localctx).e2 = expression(4);

						          	
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(93);
						match(OR);
						setState(94);
						((ExpressionContext)_localctx).e2 = expression(3);

						          	
						}
						break;
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Argument_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(PAParserANTLR4.ID, i);
		}
		public List<TerminalNode> COM() { return getTokens(PAParserANTLR4.COM); }
		public TerminalNode COM(int i) {
			return getToken(PAParserANTLR4.COM, i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterArgument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitArgument_list(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(102);
				match(ID);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(103);
					match(COM);
					setState(104);
					match(ID);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\5\3&\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5X\n"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5d\n\5\f\5\16\5g\13\5\3\6"+
		"\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\5\6q\n\6\3\6\2\3\b\7\2\4\6\b\n\2\2\2"+
		"{\2\f\3\2\2\2\4%\3\2\2\2\6\'\3\2\2\2\bW\3\2\2\2\np\3\2\2\2\f\r\7\3\2\2"+
		"\r\16\7\27\2\2\16\17\5\b\5\2\17\20\7\26\2\2\20\21\7\4\2\2\21\22\7\27\2"+
		"\2\22\23\5\4\3\2\23\27\7\26\2\2\24\26\5\6\4\2\25\24\3\2\2\2\26\31\3\2"+
		"\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\2"+
		"\2\3\33\3\3\2\2\2\34&\7\5\2\2\35\"\7\22\2\2\36\37\7\30\2\2\37!\7\22\2"+
		"\2 \36\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\34"+
		"\3\2\2\2%\35\3\2\2\2&\5\3\2\2\2\'(\7\22\2\2()\7\24\2\2)*\5\n\6\2*+\7\25"+
		"\2\2+,\7\n\2\2,-\7\23\2\2-.\7\27\2\2./\7\20\2\2/\60\7\13\2\2\60\61\5\b"+
		"\5\2\61\62\7\26\2\2\62\7\3\2\2\2\63\64\b\5\1\2\64\65\7\t\2\2\65\66\7\20"+
		"\2\2\66\67\7\26\2\2\678\5\b\5\f89\b\5\1\29X\3\2\2\2:;\7\b\2\2;<\7\20\2"+
		"\2<=\7\26\2\2=>\5\b\5\13>?\b\5\1\2?X\3\2\2\2@A\7\22\2\2AB\7\24\2\2BC\5"+
		"\n\6\2CD\7\25\2\2DE\b\5\1\2EX\3\2\2\2FG\7\20\2\2GH\7\16\2\2HI\7\20\2\2"+
		"IX\b\5\1\2JK\7\20\2\2KL\7\17\2\2LM\7\20\2\2MX\b\5\1\2NO\7\7\2\2OX\b\5"+
		"\1\2PQ\7\6\2\2QX\b\5\1\2RS\7\24\2\2ST\5\b\5\2TU\7\25\2\2UV\b\5\1\2VX\3"+
		"\2\2\2W\63\3\2\2\2W:\3\2\2\2W@\3\2\2\2WF\3\2\2\2WJ\3\2\2\2WN\3\2\2\2W"+
		"P\3\2\2\2WR\3\2\2\2Xe\3\2\2\2YZ\f\5\2\2Z[\7\f\2\2[\\\5\b\5\6\\]\b\5\1"+
		"\2]d\3\2\2\2^_\f\4\2\2_`\7\r\2\2`a\5\b\5\5ab\b\5\1\2bd\3\2\2\2cY\3\2\2"+
		"\2c^\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\t\3\2\2\2ge\3\2\2\2hm\7\20"+
		"\2\2ij\7\30\2\2jl\7\20\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3"+
		"\2\2\2om\3\2\2\2ph\3\2\2\2pq\3\2\2\2q\13\3\2\2\2\n\27\"%Wcemp";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}