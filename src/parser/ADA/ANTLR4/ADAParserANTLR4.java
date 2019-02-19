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
		public Token nameOfPredicate;
		public ExpressionContext init;
		public Token nameOfFinal;
		public Token nameOfEvent;
		public Token nameOfVariable;
		public ExpressionContext post;
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

					((AutomatonContext)_localctx).jData =  new Automaton();
				
			setState(5);
			match(STATES);
			setState(10);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(6);
				((AutomatonContext)_localctx).nameOfPredicate = match(ID);

						parser.ADA.ADAParserFunctions.addPredicate(_localctx.jData, (((AutomatonContext)_localctx).nameOfPredicate!=null?((AutomatonContext)_localctx).nameOfPredicate.getText():null));
					
				}
				}
				setState(12);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(13);
			match(INITIAL);
			setState(14);
			((AutomatonContext)_localctx).init = expression();

					parser.ADA.ADAParserFunctions.setInitial(_localctx.jData, ((AutomatonContext)_localctx).init.jData);
				
			setState(16);
			match(FINAL);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(17);
				((AutomatonContext)_localctx).nameOfFinal = match(ID);

						parser.ADA.ADAParserFunctions.addFinal(_localctx.jData, (((AutomatonContext)_localctx).nameOfFinal!=null?((AutomatonContext)_localctx).nameOfFinal.getText():null));
					
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(SYMBOLS);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(25);
				((AutomatonContext)_localctx).nameOfEvent = match(ID);

						parser.ADA.ADAParserFunctions.addEvent(_localctx.jData, (((AutomatonContext)_localctx).nameOfEvent!=null?((AutomatonContext)_localctx).nameOfEvent.getText():null));
					
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(VARIABLES);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(33);
				((AutomatonContext)_localctx).nameOfVariable = match(ID);

						parser.ADA.ADAParserFunctions.addVariable(_localctx.jData, (((AutomatonContext)_localctx).nameOfVariable!=null?((AutomatonContext)_localctx).nameOfVariable.getText():null));
					
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					parser.ADA.ADAParserFunctions.setInitArguments(_localctx.jData);
				
			setState(41);
			match(TRANSITIONS);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(42);
				((AutomatonContext)_localctx).nameOfEvent = match(ID);
				setState(43);
				((AutomatonContext)_localctx).nameOfPredicate = match(ID);
				setState(44);
				((AutomatonContext)_localctx).post = expression();
				setState(45);
				match(SHARP);

						parser.ADA.ADAParserFunctions.addTransition(_localctx.jData, (((AutomatonContext)_localctx).nameOfPredicate!=null?((AutomatonContext)_localctx).nameOfPredicate.getText():null), (((AutomatonContext)_localctx).nameOfEvent!=null?((AutomatonContext)_localctx).nameOfEvent.getText():null), ((AutomatonContext)_localctx).post.jData);
					
				}
				}
				setState(52);
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
		public Token INTEGER;
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token i;
		public TerminalNode MINUS() { return getToken(ADAParserANTLR4.MINUS, 0); }
		public TerminalNode INTEGER() { return getToken(ADAParserANTLR4.INTEGER, 0); }
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
		public TerminalNode PLUS() { return getToken(ADAParserANTLR4.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(ADAParserANTLR4.TIMES, 0); }
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(MINUS);
				setState(54);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt("-" + (((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt((((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(TRUE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(true);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(FALSE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(false);
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				match(LP);
				setState(63);
				match(NOT);
				setState(64);
				((ExpressionContext)_localctx).e = expression();
				setState(65);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Not, ((ExpressionContext)_localctx).e.jData);
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				match(LP);
				setState(69);
				match(AND);
				setState(70);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(77); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );
				setState(79);
				match(RP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				match(LP);
				setState(82);
				match(OR);
				setState(83);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );
				setState(92);
				match(RP);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(94);
				match(LP);
				setState(95);
				match(GT);
				setState(96);
				((ExpressionContext)_localctx).e1 = expression();
				setState(97);
				((ExpressionContext)_localctx).e2 = expression();
				setState(98);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(101);
				match(LP);
				setState(102);
				match(LT);
				setState(103);
				((ExpressionContext)_localctx).e1 = expression();
				setState(104);
				((ExpressionContext)_localctx).e2 = expression();
				setState(105);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(108);
				match(LP);
				setState(109);
				match(GEQ);
				setState(110);
				((ExpressionContext)_localctx).e1 = expression();
				setState(111);
				((ExpressionContext)_localctx).e2 = expression();
				setState(112);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(115);
				match(LP);
				setState(116);
				match(LEQ);
				setState(117);
				((ExpressionContext)_localctx).e1 = expression();
				setState(118);
				((ExpressionContext)_localctx).e2 = expression();
				setState(119);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(122);
				match(LP);
				setState(123);
				match(EQUALS);
				setState(124);
				((ExpressionContext)_localctx).e1 = expression();
				setState(125);
				((ExpressionContext)_localctx).e2 = expression();
				setState(126);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(129);
				match(LP);
				setState(130);
				match(DISTINCT);
				setState(131);
				((ExpressionContext)_localctx).e1 = expression();
				setState(132);
				((ExpressionContext)_localctx).e2 = expression();
				setState(133);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distinct, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(136);
				((ExpressionContext)_localctx).i = match(ID);

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null));
					
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(138);
				match(LP);
				setState(139);
				match(PLUS);
				setState(140);
				((ExpressionContext)_localctx).e1 = expression();
				setState(141);
				((ExpressionContext)_localctx).e2 = expression();
				setState(142);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(145);
				match(LP);
				setState(146);
				match(TIMES);
				setState(147);
				((ExpressionContext)_localctx).e1 = expression();
				setState(148);
				((ExpressionContext)_localctx).e2 = expression();
				setState(149);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(152);
				match(LP);
				setState(153);
				match(MINUS);
				setState(154);
				((ExpressionContext)_localctx).e1 = expression();
				setState(155);
				((ExpressionContext)_localctx).e2 = expression();
				setState(156);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(159);
				match(LP);
				setState(160);
				match(SLASH);
				setState(161);
				((ExpressionContext)_localctx).e1 = expression();
				setState(162);
				((ExpressionContext)_localctx).e2 = expression();
				setState(163);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(166);
				match(LP);
				setState(167);
				((ExpressionContext)_localctx).i = match(ID);

						List<FOADAExpression> arguments = new ArrayList<FOADAExpression>();
					
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(169);
					((ExpressionContext)_localctx).e = expression();

							((ExpressionContext)_localctx).e.jData.type = ExpressionType.Integer;
							arguments.add(((ExpressionContext)_localctx).e.jData);
						
					}
					}
					setState(174); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null), ExpressionType.Boolean, arguments);
					
				setState(177);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00b8\4\2\t\2"+
		"\4\3\t\3\3\2\3\2\3\2\3\2\7\2\13\n\2\f\2\16\2\16\13\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\7\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13"+
		"\2\3\2\3\2\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2\63\n\2\f\2\16\2\66\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3N\n\3\r\3\16\3O\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3[\n\3\r\3\16\3\\\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\6\3\u00af\n\3\r\3\16\3\u00b0\3\3\3\3\3\3\5\3\u00b6"+
		"\n\3\3\3\2\2\4\2\4\2\2\2\u00cf\2\6\3\2\2\2\4\u00b5\3\2\2\2\6\7\b\2\1\2"+
		"\7\f\7\3\2\2\b\t\7\17\2\2\t\13\b\2\1\2\n\b\3\2\2\2\13\16\3\2\2\2\f\n\3"+
		"\2\2\2\f\r\3\2\2\2\r\17\3\2\2\2\16\f\3\2\2\2\17\20\7\4\2\2\20\21\5\4\3"+
		"\2\21\22\b\2\1\2\22\27\7\5\2\2\23\24\7\17\2\2\24\26\b\2\1\2\25\23\3\2"+
		"\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2"+
		"\2\2\32\37\7\6\2\2\33\34\7\17\2\2\34\36\b\2\1\2\35\33\3\2\2\2\36!\3\2"+
		"\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"\'\7\7\2\2#$\7"+
		"\17\2\2$&\b\2\1\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2"+
		")\'\3\2\2\2*+\b\2\1\2+\64\7\b\2\2,-\7\17\2\2-.\7\17\2\2./\5\4\3\2/\60"+
		"\7\21\2\2\60\61\b\2\1\2\61\63\3\2\2\2\62,\3\2\2\2\63\66\3\2\2\2\64\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\3\3\2\2\2\66\64\3\2\2\2\678\7\25\2\289\7\20"+
		"\2\29\u00b6\b\3\1\2:;\7\20\2\2;\u00b6\b\3\1\2<=\7\t\2\2=\u00b6\b\3\1\2"+
		">?\7\n\2\2?\u00b6\b\3\1\2@A\7\22\2\2AB\7\13\2\2BC\5\4\3\2CD\7\23\2\2D"+
		"E\b\3\1\2E\u00b6\3\2\2\2FG\7\22\2\2GH\7\f\2\2HI\5\4\3\2IM\b\3\1\2JK\5"+
		"\4\3\2KL\b\3\1\2LN\3\2\2\2MJ\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3"+
		"\2\2\2QR\7\23\2\2R\u00b6\3\2\2\2ST\7\22\2\2TU\7\r\2\2UV\5\4\3\2VZ\b\3"+
		"\1\2WX\5\4\3\2XY\b\3\1\2Y[\3\2\2\2ZW\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2]^\3\2\2\2^_\7\23\2\2_\u00b6\3\2\2\2`a\7\22\2\2ab\7\30\2\2bc\5"+
		"\4\3\2cd\5\4\3\2de\7\23\2\2ef\b\3\1\2f\u00b6\3\2\2\2gh\7\22\2\2hi\7\31"+
		"\2\2ij\5\4\3\2jk\5\4\3\2kl\7\23\2\2lm\b\3\1\2m\u00b6\3\2\2\2no\7\22\2"+
		"\2op\7\32\2\2pq\5\4\3\2qr\5\4\3\2rs\7\23\2\2st\b\3\1\2t\u00b6\3\2\2\2"+
		"uv\7\22\2\2vw\7\33\2\2wx\5\4\3\2xy\5\4\3\2yz\7\23\2\2z{\b\3\1\2{\u00b6"+
		"\3\2\2\2|}\7\22\2\2}~\7\34\2\2~\177\5\4\3\2\177\u0080\5\4\3\2\u0080\u0081"+
		"\7\23\2\2\u0081\u0082\b\3\1\2\u0082\u00b6\3\2\2\2\u0083\u0084\7\22\2\2"+
		"\u0084\u0085\7\16\2\2\u0085\u0086\5\4\3\2\u0086\u0087\5\4\3\2\u0087\u0088"+
		"\7\23\2\2\u0088\u0089\b\3\1\2\u0089\u00b6\3\2\2\2\u008a\u008b\7\17\2\2"+
		"\u008b\u00b6\b\3\1\2\u008c\u008d\7\22\2\2\u008d\u008e\7\24\2\2\u008e\u008f"+
		"\5\4\3\2\u008f\u0090\5\4\3\2\u0090\u0091\7\23\2\2\u0091\u0092\b\3\1\2"+
		"\u0092\u00b6\3\2\2\2\u0093\u0094\7\22\2\2\u0094\u0095\7\26\2\2\u0095\u0096"+
		"\5\4\3\2\u0096\u0097\5\4\3\2\u0097\u0098\7\23\2\2\u0098\u0099\b\3\1\2"+
		"\u0099\u00b6\3\2\2\2\u009a\u009b\7\22\2\2\u009b\u009c\7\25\2\2\u009c\u009d"+
		"\5\4\3\2\u009d\u009e\5\4\3\2\u009e\u009f\7\23\2\2\u009f\u00a0\b\3\1\2"+
		"\u00a0\u00b6\3\2\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3\7\27\2\2\u00a3\u00a4"+
		"\5\4\3\2\u00a4\u00a5\5\4\3\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\b\3\1\2"+
		"\u00a7\u00b6\3\2\2\2\u00a8\u00a9\7\22\2\2\u00a9\u00aa\7\17\2\2\u00aa\u00ae"+
		"\b\3\1\2\u00ab\u00ac\5\4\3\2\u00ac\u00ad\b\3\1\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ab\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\3\1\2\u00b3\u00b4\7\23\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\67\3\2\2\2\u00b5:\3\2\2\2\u00b5<\3\2\2\2\u00b5>\3"+
		"\2\2\2\u00b5@\3\2\2\2\u00b5F\3\2\2\2\u00b5S\3\2\2\2\u00b5`\3\2\2\2\u00b5"+
		"g\3\2\2\2\u00b5n\3\2\2\2\u00b5u\3\2\2\2\u00b5|\3\2\2\2\u00b5\u0083\3\2"+
		"\2\2\u00b5\u008a\3\2\2\2\u00b5\u008c\3\2\2\2\u00b5\u0093\3\2\2\2\u00b5"+
		"\u009a\3\2\2\2\u00b5\u00a1\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b6\5\3\2\2\2"+
		"\13\f\27\37\'\64O\\\u00b0\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}