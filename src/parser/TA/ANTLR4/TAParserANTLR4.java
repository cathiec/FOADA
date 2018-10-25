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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TAParserANTLR4 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STATES=1, INITIAL=2, FINAL=3, SYMBOLS=4, VARIABLES=5, VISIBLE=6, TRANSITIONS=7, 
		TRUE=8, FALSE=9, NOT=10, AND=11, OR=12, DISTINCT=13, ID=14, INTEGER=15, 
		TWOPOINTS=16, SHARP=17, LP=18, RP=19, PLUS=20, MINUS=21, TIMES=22, SLASH=23, 
		GT=24, LT=25, GEQ=26, LEQ=27, EQUALS=28, WS=29, COMMENT=30;
	public static final int
		RULE_automaton = 0, RULE_expression = 1;
	public static final String[] ruleNames = {
		"automaton", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'STATES'", "'INITIAL'", "'FINAL'", "'SYMBOLS'", "'VARIABLES'", 
		"'VISIBLE'", "'TRANSITIONS'", "'true'", "'false'", "'not'", "'and'", "'or'", 
		"'distinct'", null, null, "':'", "'#'", "'('", "')'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'<'", "'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STATES", "INITIAL", "FINAL", "SYMBOLS", "VARIABLES", "VISIBLE", 
		"TRANSITIONS", "TRUE", "FALSE", "NOT", "AND", "OR", "DISTINCT", "ID", 
		"INTEGER", "TWOPOINTS", "SHARP", "LP", "RP", "PLUS", "MINUS", "TIMES", 
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
	public String getGrammarFileName() { return "TAParserANTLR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TAParserANTLR4(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public Automaton jData;
		public Token i;
		public Token INTEGER;
		public ExpressionContext e;
		public Token i1;
		public Token i2;
		public TerminalNode STATES() { return getToken(TAParserANTLR4.STATES, 0); }
		public TerminalNode INITIAL() { return getToken(TAParserANTLR4.INITIAL, 0); }
		public TerminalNode FINAL() { return getToken(TAParserANTLR4.FINAL, 0); }
		public TerminalNode SYMBOLS() { return getToken(TAParserANTLR4.SYMBOLS, 0); }
		public TerminalNode VARIABLES() { return getToken(TAParserANTLR4.VARIABLES, 0); }
		public TerminalNode VISIBLE() { return getToken(TAParserANTLR4.VISIBLE, 0); }
		public TerminalNode TRANSITIONS() { return getToken(TAParserANTLR4.TRANSITIONS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> TWOPOINTS() { return getTokens(TAParserANTLR4.TWOPOINTS); }
		public TerminalNode TWOPOINTS(int i) {
			return getToken(TAParserANTLR4.TWOPOINTS, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(TAParserANTLR4.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(TAParserANTLR4.INTEGER, i);
		}
		public List<TerminalNode> SHARP() { return getTokens(TAParserANTLR4.SHARP); }
		public TerminalNode SHARP(int i) {
			return getToken(TAParserANTLR4.SHARP, i);
		}
		public List<TerminalNode> ID() { return getTokens(TAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParserANTLR4.ID, i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAParserANTLR4Listener ) ((TAParserANTLR4Listener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAParserANTLR4Listener ) ((TAParserANTLR4Listener)listener).exitAutomaton(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException, FOADAException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((AutomatonContext)_localctx).jData =  new Automaton("A");
				
			setState(5);
			match(STATES);
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(6);
				((AutomatonContext)_localctx).i = match(ID);
				setState(7);
				match(TWOPOINTS);
				setState(8);
				((AutomatonContext)_localctx).INTEGER = match(INTEGER);

						_localctx.jData.preDefinePredicate((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null), Integer.parseInt((((AutomatonContext)_localctx).INTEGER!=null?((AutomatonContext)_localctx).INTEGER.getText():null)));
					
				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(15);
			match(INITIAL);
			setState(16);
			((AutomatonContext)_localctx).e = expression();

					_localctx.jData.defineFunctionType(((AutomatonContext)_localctx).e.jData);
					_localctx.jData.setInitialState(((AutomatonContext)_localctx).e.jData);
				
			setState(18);
			match(FINAL);

					List<String> finalStates = new ArrayList<String>();
				
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(20);
				((AutomatonContext)_localctx).i = match(ID);

						finalStates.add((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					_localctx.jData.setFinalStates(finalStates);
				
			setState(28);
			match(SYMBOLS);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(29);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.addEventSymbol((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(VARIABLES);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(37);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.addVariable((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					_localctx.jData.finaliseTAInitAndFinal();
				
			setState(45);
			match(VISIBLE);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(46);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.setVisibleVariable((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(TRANSITIONS);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(54);
				((AutomatonContext)_localctx).i1 = match(ID);
				setState(55);
				((AutomatonContext)_localctx).i2 = match(ID);
				setState(56);
				((AutomatonContext)_localctx).e = expression();
				setState(57);
				match(SHARP);

						_localctx.jData.defineFunctionType(((AutomatonContext)_localctx).e.jData);
						_localctx.jData.addTATransition((((AutomatonContext)_localctx).i2!=null?((AutomatonContext)_localctx).i2.getText():null), (((AutomatonContext)_localctx).i1!=null?((AutomatonContext)_localctx).i1.getText():null), ((AutomatonContext)_localctx).e.jData);
					
				}
				}
				setState(64);
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

	public static class ExpressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token i;
		public Token INTEGER;
		public Token i1;
		public Token i2;
		public TerminalNode TRUE() { return getToken(TAParserANTLR4.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TAParserANTLR4.FALSE, 0); }
		public TerminalNode LP() { return getToken(TAParserANTLR4.LP, 0); }
		public TerminalNode NOT() { return getToken(TAParserANTLR4.NOT, 0); }
		public TerminalNode RP() { return getToken(TAParserANTLR4.RP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(TAParserANTLR4.AND, 0); }
		public TerminalNode OR() { return getToken(TAParserANTLR4.OR, 0); }
		public TerminalNode GT() { return getToken(TAParserANTLR4.GT, 0); }
		public TerminalNode LT() { return getToken(TAParserANTLR4.LT, 0); }
		public TerminalNode GEQ() { return getToken(TAParserANTLR4.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(TAParserANTLR4.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(TAParserANTLR4.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(TAParserANTLR4.DISTINCT, 0); }
		public List<TerminalNode> ID() { return getTokens(TAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParserANTLR4.ID, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(TAParserANTLR4.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(TAParserANTLR4.INTEGER, i);
		}
		public TerminalNode PLUS() { return getToken(TAParserANTLR4.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(TAParserANTLR4.TIMES, 0); }
		public TerminalNode MINUS() { return getToken(TAParserANTLR4.MINUS, 0); }
		public TerminalNode SLASH() { return getToken(TAParserANTLR4.SLASH, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAParserANTLR4Listener ) ((TAParserANTLR4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAParserANTLR4Listener ) ((TAParserANTLR4Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(TRUE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(FALSE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(false);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(LP);
				setState(70);
				match(NOT);
				setState(71);
				((ExpressionContext)_localctx).e = expression();
				setState(72);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Not, ((ExpressionContext)_localctx).e.jData);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(LP);
				setState(76);
				match(AND);
				setState(77);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(86);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(LP);
				setState(89);
				match(OR);
				setState(90);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(99);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
				match(LP);
				setState(102);
				match(GT);
				setState(103);
				((ExpressionContext)_localctx).e1 = expression();
				setState(104);
				((ExpressionContext)_localctx).e2 = expression();
				setState(105);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				match(LP);
				setState(109);
				match(LT);
				setState(110);
				((ExpressionContext)_localctx).e1 = expression();
				setState(111);
				((ExpressionContext)_localctx).e2 = expression();
				setState(112);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				match(LP);
				setState(116);
				match(GEQ);
				setState(117);
				((ExpressionContext)_localctx).e1 = expression();
				setState(118);
				((ExpressionContext)_localctx).e2 = expression();
				setState(119);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(122);
				match(LP);
				setState(123);
				match(LEQ);
				setState(124);
				((ExpressionContext)_localctx).e1 = expression();
				setState(125);
				((ExpressionContext)_localctx).e2 = expression();
				setState(126);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(129);
				match(LP);
				setState(130);
				match(EQUALS);
				setState(131);
				((ExpressionContext)_localctx).e1 = expression();
				setState(132);
				((ExpressionContext)_localctx).e2 = expression();
				setState(133);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(136);
				match(LP);
				setState(137);
				match(DISTINCT);
				setState(138);
				((ExpressionContext)_localctx).e1 = expression();
				setState(139);
				((ExpressionContext)_localctx).e2 = expression();
				setState(140);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distinct, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(143);
				((ExpressionContext)_localctx).i = match(ID);

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null));
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(145);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt((((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(147);
				match(LP);
				setState(148);
				match(PLUS);
				setState(149);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(156); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(158);
				match(RP);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(160);
				match(LP);
				setState(161);
				match(TIMES);
				setState(162);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(164);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(171);
				match(RP);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(173);
				match(LP);
				setState(174);
				match(MINUS);
				setState(175);
				((ExpressionContext)_localctx).e1 = expression();
				setState(176);
				((ExpressionContext)_localctx).e2 = expression();
				setState(177);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(180);
				match(LP);
				setState(181);
				match(SLASH);
				setState(182);
				((ExpressionContext)_localctx).e1 = expression();
				setState(183);
				((ExpressionContext)_localctx).e2 = expression();
				setState(184);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(187);
				match(LP);
				setState(188);
				((ExpressionContext)_localctx).i1 = match(ID);

						List<FOADAExpression> arguments = new ArrayList<FOADAExpression>();
					
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(194);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(190);
						((ExpressionContext)_localctx).i2 = match(ID);

								FOADAExpression argument = new FOADAExpression((((ExpressionContext)_localctx).i2!=null?((ExpressionContext)_localctx).i2.getText():null), ExpressionType.Integer);
								arguments.add(argument);
							
						}
						break;
					case INTEGER:
						{
						setState(192);
						((ExpressionContext)_localctx).INTEGER = match(INTEGER);

								FOADAExpression argument = new FOADAExpression(Integer.parseInt((((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
								arguments.add(argument);
							
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID || _la==INTEGER );

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i1!=null?((ExpressionContext)_localctx).i1.getText():null), ExpressionType.Boolean, arguments);
					
				setState(199);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00cd\4\2\t\2\4"+
		"\3\t\3\3\2\3\2\3\2\3\2\3\2\3\2\7\2\r\n\2\f\2\16\2\20\13\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\2\3\2\7\2\"\n\2"+
		"\f\2\16\2%\13\2\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2?\n\2\f\2\16"+
		"\2B\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\6\3U\n\3\r\3\16\3V\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3b\n\3"+
		"\r\3\16\3c\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\6\3\u009d\n\3\r\3\16\3\u009e\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\6\3\u00aa\n\3\r\3\16\3\u00ab\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3\u00c5\n\3\r\3\16\3\u00c6\3\3\3\3\5\3\u00cb\n\3\3\3\2\2\4\2\4\2\2\2"+
		"\u00e7\2\6\3\2\2\2\4\u00ca\3\2\2\2\6\7\b\2\1\2\7\16\7\3\2\2\b\t\7\20\2"+
		"\2\t\n\7\22\2\2\n\13\7\21\2\2\13\r\b\2\1\2\f\b\3\2\2\2\r\20\3\2\2\2\16"+
		"\f\3\2\2\2\16\17\3\2\2\2\17\21\3\2\2\2\20\16\3\2\2\2\21\22\7\4\2\2\22"+
		"\23\5\4\3\2\23\24\b\2\1\2\24\25\7\5\2\2\25\32\b\2\1\2\26\27\7\20\2\2\27"+
		"\31\b\2\1\2\30\26\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33"+
		"\35\3\2\2\2\34\32\3\2\2\2\35\36\b\2\1\2\36#\7\6\2\2\37 \7\20\2\2 \"\b"+
		"\2\1\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2"+
		"&+\7\7\2\2\'(\7\20\2\2(*\b\2\1\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,.\3\2\2\2-+\3\2\2\2./\b\2\1\2/\64\7\b\2\2\60\61\7\20\2\2\61\63\b"+
		"\2\1\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3"+
		"\2\2\2\66\64\3\2\2\2\67@\7\t\2\289\7\20\2\29:\7\20\2\2:;\5\4\3\2;<\7\23"+
		"\2\2<=\b\2\1\2=?\3\2\2\2>8\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\3\3"+
		"\2\2\2B@\3\2\2\2CD\7\n\2\2D\u00cb\b\3\1\2EF\7\13\2\2F\u00cb\b\3\1\2GH"+
		"\7\24\2\2HI\7\f\2\2IJ\5\4\3\2JK\7\25\2\2KL\b\3\1\2L\u00cb\3\2\2\2MN\7"+
		"\24\2\2NO\7\r\2\2OP\5\4\3\2PT\b\3\1\2QR\5\4\3\2RS\b\3\1\2SU\3\2\2\2TQ"+
		"\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\25\2\2Y\u00cb\3\2"+
		"\2\2Z[\7\24\2\2[\\\7\16\2\2\\]\5\4\3\2]a\b\3\1\2^_\5\4\3\2_`\b\3\1\2`"+
		"b\3\2\2\2a^\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\25\2\2"+
		"f\u00cb\3\2\2\2gh\7\24\2\2hi\7\32\2\2ij\5\4\3\2jk\5\4\3\2kl\7\25\2\2l"+
		"m\b\3\1\2m\u00cb\3\2\2\2no\7\24\2\2op\7\33\2\2pq\5\4\3\2qr\5\4\3\2rs\7"+
		"\25\2\2st\b\3\1\2t\u00cb\3\2\2\2uv\7\24\2\2vw\7\34\2\2wx\5\4\3\2xy\5\4"+
		"\3\2yz\7\25\2\2z{\b\3\1\2{\u00cb\3\2\2\2|}\7\24\2\2}~\7\35\2\2~\177\5"+
		"\4\3\2\177\u0080\5\4\3\2\u0080\u0081\7\25\2\2\u0081\u0082\b\3\1\2\u0082"+
		"\u00cb\3\2\2\2\u0083\u0084\7\24\2\2\u0084\u0085\7\36\2\2\u0085\u0086\5"+
		"\4\3\2\u0086\u0087\5\4\3\2\u0087\u0088\7\25\2\2\u0088\u0089\b\3\1\2\u0089"+
		"\u00cb\3\2\2\2\u008a\u008b\7\24\2\2\u008b\u008c\7\17\2\2\u008c\u008d\5"+
		"\4\3\2\u008d\u008e\5\4\3\2\u008e\u008f\7\25\2\2\u008f\u0090\b\3\1\2\u0090"+
		"\u00cb\3\2\2\2\u0091\u0092\7\20\2\2\u0092\u00cb\b\3\1\2\u0093\u0094\7"+
		"\21\2\2\u0094\u00cb\b\3\1\2\u0095\u0096\7\24\2\2\u0096\u0097\7\26\2\2"+
		"\u0097\u0098\5\4\3\2\u0098\u009c\b\3\1\2\u0099\u009a\5\4\3\2\u009a\u009b"+
		"\b\3\1\2\u009b\u009d\3\2\2\2\u009c\u0099\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\25"+
		"\2\2\u00a1\u00cb\3\2\2\2\u00a2\u00a3\7\24\2\2\u00a3\u00a4\7\30\2\2\u00a4"+
		"\u00a5\5\4\3\2\u00a5\u00a9\b\3\1\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\b\3"+
		"\1\2\u00a8\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\25"+
		"\2\2\u00ae\u00cb\3\2\2\2\u00af\u00b0\7\24\2\2\u00b0\u00b1\7\27\2\2\u00b1"+
		"\u00b2\5\4\3\2\u00b2\u00b3\5\4\3\2\u00b3\u00b4\7\25\2\2\u00b4\u00b5\b"+
		"\3\1\2\u00b5\u00cb\3\2\2\2\u00b6\u00b7\7\24\2\2\u00b7\u00b8\7\31\2\2\u00b8"+
		"\u00b9\5\4\3\2\u00b9\u00ba\5\4\3\2\u00ba\u00bb\7\25\2\2\u00bb\u00bc\b"+
		"\3\1\2\u00bc\u00cb\3\2\2\2\u00bd\u00be\7\24\2\2\u00be\u00bf\7\20\2\2\u00bf"+
		"\u00c4\b\3\1\2\u00c0\u00c1\7\20\2\2\u00c1\u00c5\b\3\1\2\u00c2\u00c3\7"+
		"\21\2\2\u00c3\u00c5\b\3\1\2\u00c4\u00c0\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c9\b\3\1\2\u00c9\u00cb\7\25\2\2\u00caC\3\2\2\2\u00caE\3"+
		"\2\2\2\u00caG\3\2\2\2\u00caM\3\2\2\2\u00caZ\3\2\2\2\u00cag\3\2\2\2\u00ca"+
		"n\3\2\2\2\u00cau\3\2\2\2\u00ca|\3\2\2\2\u00ca\u0083\3\2\2\2\u00ca\u008a"+
		"\3\2\2\2\u00ca\u0091\3\2\2\2\u00ca\u0093\3\2\2\2\u00ca\u0095\3\2\2\2\u00ca"+
		"\u00a2\3\2\2\2\u00ca\u00af\3\2\2\2\u00ca\u00b6\3\2\2\2\u00ca\u00bd\3\2"+
		"\2\2\u00cb\5\3\2\2\2\17\16\32#+\64@Vc\u009e\u00ab\u00c4\u00c6\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}