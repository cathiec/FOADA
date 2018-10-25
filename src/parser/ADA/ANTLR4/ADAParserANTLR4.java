// Generated from ADAParserANTLR4.g4 by ANTLR 4.7.1

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

package parser.ADA.ANTLR4;

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
public class ADAParserANTLR4 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STATES=1, INITIAL=2, FINAL=3, SYMBOLS=4, VARIABLES=5, TRANSITIONS=6, TRUE=7, 
		FALSE=8, NOT=9, AND=10, OR=11, DISTINCT=12, ID=13, INTEGER=14, SHARP=15, 
		LP=16, RP=17, PLUS=18, MINUS=19, TIMES=20, SLASH=21, GT=22, LT=23, GEQ=24, 
		LEQ=25, EQUALS=26, WS=27, COMMENT=28;
	public static final int
		RULE_automaton = 0, RULE_expression = 1;
	public static final String[] ruleNames = {
		"automaton", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'STATES'", "'INITIAL'", "'FINAL'", "'SYMBOLS'", "'VARIABLES'", 
		"'TRANSITIONS'", "'true'", "'false'", "'not'", "'and'", "'or'", "'distinct'", 
		null, null, "'#'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
		"'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STATES", "INITIAL", "FINAL", "SYMBOLS", "VARIABLES", "TRANSITIONS", 
		"TRUE", "FALSE", "NOT", "AND", "OR", "DISTINCT", "ID", "INTEGER", "SHARP", 
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
	public String getGrammarFileName() { return "ADAParserANTLR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ADAParserANTLR4(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public Automaton jData;
		public Token i;
		public ExpressionContext e;
		public Token i1;
		public Token i2;
		public TerminalNode STATES() { return getToken(ADAParserANTLR4.STATES, 0); }
		public TerminalNode INITIAL() { return getToken(ADAParserANTLR4.INITIAL, 0); }
		public TerminalNode FINAL() { return getToken(ADAParserANTLR4.FINAL, 0); }
		public TerminalNode SYMBOLS() { return getToken(ADAParserANTLR4.SYMBOLS, 0); }
		public TerminalNode VARIABLES() { return getToken(ADAParserANTLR4.VARIABLES, 0); }
		public TerminalNode TRANSITIONS() { return getToken(ADAParserANTLR4.TRANSITIONS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SHARP() { return getTokens(ADAParserANTLR4.SHARP); }
		public TerminalNode SHARP(int i) {
			return getToken(ADAParserANTLR4.SHARP, i);
		}
		public List<TerminalNode> ID() { return getTokens(ADAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(ADAParserANTLR4.ID, i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ADAParserANTLR4Listener ) ((ADAParserANTLR4Listener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ADAParserANTLR4Listener ) ((ADAParserANTLR4Listener)listener).exitAutomaton(this);
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
			setState(10);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(6);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.preDefinePredicate((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(12);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(13);
			match(INITIAL);
			setState(14);
			((AutomatonContext)_localctx).e = expression();

					_localctx.jData.defineFunctionType(((AutomatonContext)_localctx).e.jData);
					_localctx.jData.setInitialState(((AutomatonContext)_localctx).e.jData);
				
			setState(16);
			match(FINAL);

					List<String> finalStates = new ArrayList<String>();
				
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(18);
				((AutomatonContext)_localctx).i = match(ID);

						finalStates.add((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					_localctx.jData.setFinalStates(finalStates);
				
			setState(26);
			match(SYMBOLS);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(27);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.addEventSymbol((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(VARIABLES);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(35);
				((AutomatonContext)_localctx).i = match(ID);

						_localctx.jData.addVariable((((AutomatonContext)_localctx).i!=null?((AutomatonContext)_localctx).i.getText():null));
					
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					_localctx.jData.finalisePredicatesArguments();
					_localctx.jData.finaliseInitAndFinal();
				
			setState(43);
			match(TRANSITIONS);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(44);
				((AutomatonContext)_localctx).i1 = match(ID);
				setState(45);
				((AutomatonContext)_localctx).i2 = match(ID);
				setState(46);
				((AutomatonContext)_localctx).e = expression();
				setState(47);
				match(SHARP);

						_localctx.jData.defineFunctionType(((AutomatonContext)_localctx).e.jData);
						_localctx.jData.addADATransition((((AutomatonContext)_localctx).i2!=null?((AutomatonContext)_localctx).i2.getText():null), (((AutomatonContext)_localctx).i1!=null?((AutomatonContext)_localctx).i1.getText():null), ((AutomatonContext)_localctx).e.jData);
					
				}
				}
				setState(54);
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
		public TerminalNode TRUE() { return getToken(ADAParserANTLR4.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ADAParserANTLR4.FALSE, 0); }
		public TerminalNode LP() { return getToken(ADAParserANTLR4.LP, 0); }
		public TerminalNode NOT() { return getToken(ADAParserANTLR4.NOT, 0); }
		public TerminalNode RP() { return getToken(ADAParserANTLR4.RP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(ADAParserANTLR4.AND, 0); }
		public TerminalNode OR() { return getToken(ADAParserANTLR4.OR, 0); }
		public TerminalNode GT() { return getToken(ADAParserANTLR4.GT, 0); }
		public TerminalNode LT() { return getToken(ADAParserANTLR4.LT, 0); }
		public TerminalNode GEQ() { return getToken(ADAParserANTLR4.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(ADAParserANTLR4.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(ADAParserANTLR4.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(ADAParserANTLR4.DISTINCT, 0); }
		public TerminalNode ID() { return getToken(ADAParserANTLR4.ID, 0); }
		public TerminalNode INTEGER() { return getToken(ADAParserANTLR4.INTEGER, 0); }
		public TerminalNode PLUS() { return getToken(ADAParserANTLR4.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(ADAParserANTLR4.TIMES, 0); }
		public TerminalNode MINUS() { return getToken(ADAParserANTLR4.MINUS, 0); }
		public TerminalNode SLASH() { return getToken(ADAParserANTLR4.SLASH, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ADAParserANTLR4Listener ) ((ADAParserANTLR4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ADAParserANTLR4Listener ) ((ADAParserANTLR4Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(TRUE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(FALSE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(false);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(LP);
				setState(60);
				match(NOT);
				setState(61);
				((ExpressionContext)_localctx).e = expression();
				setState(62);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Not, ((ExpressionContext)_localctx).e.jData);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				match(LP);
				setState(66);
				match(AND);
				setState(67);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(76);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(LP);
				setState(79);
				match(OR);
				setState(80);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(87); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(89);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				match(LP);
				setState(92);
				match(GT);
				setState(93);
				((ExpressionContext)_localctx).e1 = expression();
				setState(94);
				((ExpressionContext)_localctx).e2 = expression();
				setState(95);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				match(LP);
				setState(99);
				match(LT);
				setState(100);
				((ExpressionContext)_localctx).e1 = expression();
				setState(101);
				((ExpressionContext)_localctx).e2 = expression();
				setState(102);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				match(LP);
				setState(106);
				match(GEQ);
				setState(107);
				((ExpressionContext)_localctx).e1 = expression();
				setState(108);
				((ExpressionContext)_localctx).e2 = expression();
				setState(109);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(112);
				match(LP);
				setState(113);
				match(LEQ);
				setState(114);
				((ExpressionContext)_localctx).e1 = expression();
				setState(115);
				((ExpressionContext)_localctx).e2 = expression();
				setState(116);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(119);
				match(LP);
				setState(120);
				match(EQUALS);
				setState(121);
				((ExpressionContext)_localctx).e1 = expression();
				setState(122);
				((ExpressionContext)_localctx).e2 = expression();
				setState(123);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(126);
				match(LP);
				setState(127);
				match(DISTINCT);
				setState(128);
				((ExpressionContext)_localctx).e1 = expression();
				setState(129);
				((ExpressionContext)_localctx).e2 = expression();
				setState(130);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distinct, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(133);
				((ExpressionContext)_localctx).i = match(ID);

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null));
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(135);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt((((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(137);
				match(LP);
				setState(138);
				match(PLUS);
				setState(139);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(148);
				match(RP);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(150);
				match(LP);
				setState(151);
				match(TIMES);
				setState(152);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(161);
				match(RP);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(163);
				match(LP);
				setState(164);
				match(MINUS);
				setState(165);
				((ExpressionContext)_localctx).e1 = expression();
				setState(166);
				((ExpressionContext)_localctx).e2 = expression();
				setState(167);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(170);
				match(LP);
				setState(171);
				match(SLASH);
				setState(172);
				((ExpressionContext)_localctx).e1 = expression();
				setState(173);
				((ExpressionContext)_localctx).e2 = expression();
				setState(174);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00b6\4\2\t\2"+
		"\4\3\t\3\3\2\3\2\3\2\3\2\7\2\13\n\2\f\2\16\2\16\13\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\2\3\2\7\2 \n\2\f\2\16"+
		"\2#\13\2\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3K\n\3\r\3\16\3L\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\6\3X\n\3\r\3\16\3Y\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u0093\n\3\r\3\16\3"+
		"\u0094\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u00a0\n\3\r\3\16\3\u00a1"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00b4"+
		"\n\3\3\3\2\2\4\2\4\2\2\2\u00cc\2\6\3\2\2\2\4\u00b3\3\2\2\2\6\7\b\2\1\2"+
		"\7\f\7\3\2\2\b\t\7\17\2\2\t\13\b\2\1\2\n\b\3\2\2\2\13\16\3\2\2\2\f\n\3"+
		"\2\2\2\f\r\3\2\2\2\r\17\3\2\2\2\16\f\3\2\2\2\17\20\7\4\2\2\20\21\5\4\3"+
		"\2\21\22\b\2\1\2\22\23\7\5\2\2\23\30\b\2\1\2\24\25\7\17\2\2\25\27\b\2"+
		"\1\2\26\24\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2"+
		"\2\2\32\30\3\2\2\2\33\34\b\2\1\2\34!\7\6\2\2\35\36\7\17\2\2\36 \b\2\1"+
		"\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2"+
		"$)\7\7\2\2%&\7\17\2\2&(\b\2\1\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*,\3\2\2\2+)\3\2\2\2,-\b\2\1\2-\66\7\b\2\2./\7\17\2\2/\60\7\17\2\2"+
		"\60\61\5\4\3\2\61\62\7\21\2\2\62\63\b\2\1\2\63\65\3\2\2\2\64.\3\2\2\2"+
		"\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\3\3\2\2\28\66\3\2\2\29:\7"+
		"\t\2\2:\u00b4\b\3\1\2;<\7\n\2\2<\u00b4\b\3\1\2=>\7\22\2\2>?\7\13\2\2?"+
		"@\5\4\3\2@A\7\23\2\2AB\b\3\1\2B\u00b4\3\2\2\2CD\7\22\2\2DE\7\f\2\2EF\5"+
		"\4\3\2FJ\b\3\1\2GH\5\4\3\2HI\b\3\1\2IK\3\2\2\2JG\3\2\2\2KL\3\2\2\2LJ\3"+
		"\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\23\2\2O\u00b4\3\2\2\2PQ\7\22\2\2QR\7\r"+
		"\2\2RS\5\4\3\2SW\b\3\1\2TU\5\4\3\2UV\b\3\1\2VX\3\2\2\2WT\3\2\2\2XY\3\2"+
		"\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\23\2\2\\\u00b4\3\2\2\2]^\7\22"+
		"\2\2^_\7\30\2\2_`\5\4\3\2`a\5\4\3\2ab\7\23\2\2bc\b\3\1\2c\u00b4\3\2\2"+
		"\2de\7\22\2\2ef\7\31\2\2fg\5\4\3\2gh\5\4\3\2hi\7\23\2\2ij\b\3\1\2j\u00b4"+
		"\3\2\2\2kl\7\22\2\2lm\7\32\2\2mn\5\4\3\2no\5\4\3\2op\7\23\2\2pq\b\3\1"+
		"\2q\u00b4\3\2\2\2rs\7\22\2\2st\7\33\2\2tu\5\4\3\2uv\5\4\3\2vw\7\23\2\2"+
		"wx\b\3\1\2x\u00b4\3\2\2\2yz\7\22\2\2z{\7\34\2\2{|\5\4\3\2|}\5\4\3\2}~"+
		"\7\23\2\2~\177\b\3\1\2\177\u00b4\3\2\2\2\u0080\u0081\7\22\2\2\u0081\u0082"+
		"\7\16\2\2\u0082\u0083\5\4\3\2\u0083\u0084\5\4\3\2\u0084\u0085\7\23\2\2"+
		"\u0085\u0086\b\3\1\2\u0086\u00b4\3\2\2\2\u0087\u0088\7\17\2\2\u0088\u00b4"+
		"\b\3\1\2\u0089\u008a\7\20\2\2\u008a\u00b4\b\3\1\2\u008b\u008c\7\22\2\2"+
		"\u008c\u008d\7\24\2\2\u008d\u008e\5\4\3\2\u008e\u0092\b\3\1\2\u008f\u0090"+
		"\5\4\3\2\u0090\u0091\b\3\1\2\u0091\u0093\3\2\2\2\u0092\u008f\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\7\23\2\2\u0097\u00b4\3\2\2\2\u0098\u0099\7\22\2\2\u0099"+
		"\u009a\7\26\2\2\u009a\u009b\5\4\3\2\u009b\u009f\b\3\1\2\u009c\u009d\5"+
		"\4\3\2\u009d\u009e\b\3\1\2\u009e\u00a0\3\2\2\2\u009f\u009c\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a4\7\23\2\2\u00a4\u00b4\3\2\2\2\u00a5\u00a6\7\22\2\2\u00a6"+
		"\u00a7\7\25\2\2\u00a7\u00a8\5\4\3\2\u00a8\u00a9\5\4\3\2\u00a9\u00aa\7"+
		"\23\2\2\u00aa\u00ab\b\3\1\2\u00ab\u00b4\3\2\2\2\u00ac\u00ad\7\22\2\2\u00ad"+
		"\u00ae\7\27\2\2\u00ae\u00af\5\4\3\2\u00af\u00b0\5\4\3\2\u00b0\u00b1\7"+
		"\23\2\2\u00b1\u00b2\b\3\1\2\u00b2\u00b4\3\2\2\2\u00b39\3\2\2\2\u00b3;"+
		"\3\2\2\2\u00b3=\3\2\2\2\u00b3C\3\2\2\2\u00b3P\3\2\2\2\u00b3]\3\2\2\2\u00b3"+
		"d\3\2\2\2\u00b3k\3\2\2\2\u00b3r\3\2\2\2\u00b3y\3\2\2\2\u00b3\u0080\3\2"+
		"\2\2\u00b3\u0087\3\2\2\2\u00b3\u0089\3\2\2\2\u00b3\u008b\3\2\2\2\u00b3"+
		"\u0098\3\2\2\2\u00b3\u00a5\3\2\2\2\u00b3\u00ac\3\2\2\2\u00b4\5\3\2\2\2"+
		"\f\f\30!)\66LY\u0094\u00a1\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}