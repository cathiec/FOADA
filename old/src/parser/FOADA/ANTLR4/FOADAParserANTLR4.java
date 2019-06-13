// Generated from FOADAParserANTLR4.g4 by ANTLR 4.7.1

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

package parser.FOADA.ANTLR4;

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
public class FOADAParserANTLR4 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRED=1, EVENT=2, INITIAL=3, FINAL=4, TRANS=5, TRUE=6, FALSE=7, NOT=8, 
		AND=9, OR=10, DISTINCT=11, INT=12, BOOL=13, ID=14, INTEGER=15, LP=16, 
		RP=17, PLUS=18, MINUS=19, TIMES=20, SLASH=21, GT=22, LT=23, GEQ=24, LEQ=25, 
		EQUALS=26, WS=27, COMMENT=28;
	public static final int
		RULE_automaton = 0, RULE_type = 1, RULE_expression = 2;
	public static final String[] ruleNames = {
		"automaton", "type", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'pred'", "'event'", "'initial'", "'final'", "'trans'", "'true'", 
		"'false'", "'not'", "'and'", "'or'", "'distinct'", "'Int'", "'Bool'", 
		null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", 
		"'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PRED", "EVENT", "INITIAL", "FINAL", "TRANS", "TRUE", "FALSE", "NOT", 
		"AND", "OR", "DISTINCT", "INT", "BOOL", "ID", "INTEGER", "LP", "RP", "PLUS", 
		"MINUS", "TIMES", "SLASH", "GT", "LT", "GEQ", "LEQ", "EQUALS", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "FOADAParserANTLR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOADAParserANTLR4(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public Automaton jData;
		public Token nameOfPredicate;
		public Token nameOfEvent;
		public ExpressionContext init;
		public Token nameOfFinal;
		public Token argumentName;
		public TypeContext argumentType;
		public Token event;
		public Token inputVarName;
		public TypeContext inputVarType;
		public ExpressionContext post;
		public List<TerminalNode> LP() { return getTokens(FOADAParserANTLR4.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADAParserANTLR4.LP, i);
		}
		public TerminalNode PRED() { return getToken(FOADAParserANTLR4.PRED, 0); }
		public List<TerminalNode> RP() { return getTokens(FOADAParserANTLR4.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADAParserANTLR4.RP, i);
		}
		public TerminalNode EVENT() { return getToken(FOADAParserANTLR4.EVENT, 0); }
		public TerminalNode INITIAL() { return getToken(FOADAParserANTLR4.INITIAL, 0); }
		public TerminalNode FINAL() { return getToken(FOADAParserANTLR4.FINAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> TRANS() { return getTokens(FOADAParserANTLR4.TRANS); }
		public TerminalNode TRANS(int i) {
			return getToken(FOADAParserANTLR4.TRANS, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOADAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADAParserANTLR4.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).exitAutomaton(this);
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
				
			setState(7);
			match(LP);
			setState(8);
			match(PRED);
			setState(9);
			match(LP);
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(10);
				((AutomatonContext)_localctx).nameOfPredicate = match(ID);

						parser.FOADA.FOADAParserFunctions.addPredicate(_localctx.jData, (((AutomatonContext)_localctx).nameOfPredicate!=null?((AutomatonContext)_localctx).nameOfPredicate.getText():null));
					
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			match(RP);
			setState(18);
			match(RP);
			setState(19);
			match(LP);
			setState(20);
			match(EVENT);
			setState(21);
			match(LP);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(22);
				((AutomatonContext)_localctx).nameOfEvent = match(ID);

						parser.FOADA.FOADAParserFunctions.addEvent(_localctx.jData, (((AutomatonContext)_localctx).nameOfEvent!=null?((AutomatonContext)_localctx).nameOfEvent.getText():null));
					
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(RP);
			setState(30);
			match(RP);
			setState(31);
			match(LP);
			setState(32);
			match(INITIAL);
			setState(33);
			((AutomatonContext)_localctx).init = expression();
			setState(34);
			match(RP);

					parser.FOADA.FOADAParserFunctions.setInitial(_localctx.jData, ((AutomatonContext)_localctx).init.jData);
				
			setState(36);
			match(LP);
			setState(37);
			match(FINAL);
			setState(38);
			match(LP);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(39);
				((AutomatonContext)_localctx).nameOfFinal = match(ID);

						parser.FOADA.FOADAParserFunctions.addFinal(_localctx.jData, (((AutomatonContext)_localctx).nameOfFinal!=null?((AutomatonContext)_localctx).nameOfFinal.getText():null));
					
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(RP);
			setState(47);
			match(RP);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(48);
				match(LP);
				setState(49);
				match(TRANS);
				setState(50);
				match(LP);
				setState(51);
				((AutomatonContext)_localctx).nameOfPredicate = match(ID);
				setState(52);
				match(LP);

							List<String> argumentsNames = new ArrayList<String>();
							List<FOADAExpression.ExpressionType> argumentsTypes = new ArrayList<FOADAExpression.ExpressionType>();
						
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LP) {
					{
					{
					setState(54);
					match(LP);
					setState(55);
					((AutomatonContext)_localctx).argumentName = match(ID);
					setState(56);
					((AutomatonContext)_localctx).argumentType = type();
					setState(57);
					match(RP);

								argumentsNames.add((((AutomatonContext)_localctx).argumentName!=null?((AutomatonContext)_localctx).argumentName.getText():null));
								argumentsTypes.add(((AutomatonContext)_localctx).argumentType.jData);
							
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(RP);
				setState(66);
				match(RP);
				setState(67);
				match(LP);
				setState(68);
				((AutomatonContext)_localctx).event = match(ID);
				setState(69);
				match(LP);

							List<String> inputVarNames = new ArrayList<String>();
							List<FOADAExpression.ExpressionType> inputVarTypes = new ArrayList<FOADAExpression.ExpressionType>();
						
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LP) {
					{
					{
					setState(71);
					match(LP);
					setState(72);
					((AutomatonContext)_localctx).inputVarName = match(ID);
					setState(73);
					((AutomatonContext)_localctx).inputVarType = type();
					setState(74);
					match(RP);

								inputVarNames.add((((AutomatonContext)_localctx).inputVarName!=null?((AutomatonContext)_localctx).inputVarName.getText():null));
								inputVarTypes.add(((AutomatonContext)_localctx).inputVarType.jData);
							
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				match(RP);
				setState(83);
				match(RP);
				setState(84);
				((AutomatonContext)_localctx).post = expression();

							parser.FOADA.FOADAParserFunctions.addTransition(_localctx.jData, (((AutomatonContext)_localctx).nameOfPredicate!=null?((AutomatonContext)_localctx).nameOfPredicate.getText():null), argumentsNames, argumentsTypes, (((AutomatonContext)_localctx).event!=null?((AutomatonContext)_localctx).event.getText():null), inputVarNames, inputVarTypes, ((AutomatonContext)_localctx).post.jData);
						
				setState(86);
				match(RP);
				}
				}
				setState(92);
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

	public static class TypeContext extends ParserRuleContext {
		public FOADAExpression.ExpressionType jData;
		public TerminalNode INT() { return getToken(FOADAParserANTLR4.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOADAParserANTLR4.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(INT);

						((TypeContext)_localctx).jData =  FOADAExpression.ExpressionType.Integer;
					
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(BOOL);

						((TypeContext)_localctx).jData =  FOADAExpression.ExpressionType.Boolean;
					
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

	public static class ExpressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public Token INTEGER;
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token i;
		public TerminalNode MINUS() { return getToken(FOADAParserANTLR4.MINUS, 0); }
		public TerminalNode INTEGER() { return getToken(FOADAParserANTLR4.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(FOADAParserANTLR4.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOADAParserANTLR4.FALSE, 0); }
		public TerminalNode LP() { return getToken(FOADAParserANTLR4.LP, 0); }
		public TerminalNode NOT() { return getToken(FOADAParserANTLR4.NOT, 0); }
		public TerminalNode RP() { return getToken(FOADAParserANTLR4.RP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(FOADAParserANTLR4.AND, 0); }
		public TerminalNode OR() { return getToken(FOADAParserANTLR4.OR, 0); }
		public TerminalNode GT() { return getToken(FOADAParserANTLR4.GT, 0); }
		public TerminalNode LT() { return getToken(FOADAParserANTLR4.LT, 0); }
		public TerminalNode GEQ() { return getToken(FOADAParserANTLR4.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(FOADAParserANTLR4.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(FOADAParserANTLR4.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(FOADAParserANTLR4.DISTINCT, 0); }
		public TerminalNode ID() { return getToken(FOADAParserANTLR4.ID, 0); }
		public TerminalNode PLUS() { return getToken(FOADAParserANTLR4.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(FOADAParserANTLR4.TIMES, 0); }
		public TerminalNode SLASH() { return getToken(FOADAParserANTLR4.SLASH, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADAParserANTLR4Listener ) ((FOADAParserANTLR4Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(MINUS);
				setState(100);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt("-" + (((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((ExpressionContext)_localctx).INTEGER = match(INTEGER);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(Integer.parseInt((((ExpressionContext)_localctx).INTEGER!=null?((ExpressionContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(TRUE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(true);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(FALSE);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(false);
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				match(LP);
				setState(109);
				match(NOT);
				setState(110);
				((ExpressionContext)_localctx).e = expression();
				setState(111);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Not, ((ExpressionContext)_localctx).e.jData);
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				match(LP);
				setState(115);
				match(AND);
				setState(116);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );
				setState(125);
				match(RP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(127);
				match(LP);
				setState(128);
				match(OR);
				setState(129);
				((ExpressionContext)_localctx).e1 = expression();

						((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).e1.jData; 
					
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					((ExpressionContext)_localctx).e2 = expression();

							((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, _localctx.jData, ((ExpressionContext)_localctx).e2.jData);
						
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );
				setState(138);
				match(RP);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(140);
				match(LP);
				setState(141);
				match(GT);
				setState(142);
				((ExpressionContext)_localctx).e1 = expression();
				setState(143);
				((ExpressionContext)_localctx).e2 = expression();
				setState(144);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(147);
				match(LP);
				setState(148);
				match(LT);
				setState(149);
				((ExpressionContext)_localctx).e1 = expression();
				setState(150);
				((ExpressionContext)_localctx).e2 = expression();
				setState(151);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LT, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(154);
				match(LP);
				setState(155);
				match(GEQ);
				setState(156);
				((ExpressionContext)_localctx).e1 = expression();
				setState(157);
				((ExpressionContext)_localctx).e2 = expression();
				setState(158);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(161);
				match(LP);
				setState(162);
				match(LEQ);
				setState(163);
				((ExpressionContext)_localctx).e1 = expression();
				setState(164);
				((ExpressionContext)_localctx).e2 = expression();
				setState(165);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LEQ, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(168);
				match(LP);
				setState(169);
				match(EQUALS);
				setState(170);
				((ExpressionContext)_localctx).e1 = expression();
				setState(171);
				((ExpressionContext)_localctx).e2 = expression();
				setState(172);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(175);
				match(LP);
				setState(176);
				match(DISTINCT);
				setState(177);
				((ExpressionContext)_localctx).e1 = expression();
				setState(178);
				((ExpressionContext)_localctx).e2 = expression();
				setState(179);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distinct, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(182);
				((ExpressionContext)_localctx).i = match(ID);

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null));
					
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(184);
				match(LP);
				setState(185);
				match(PLUS);
				setState(186);
				((ExpressionContext)_localctx).e1 = expression();
				setState(187);
				((ExpressionContext)_localctx).e2 = expression();
				setState(188);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(191);
				match(LP);
				setState(192);
				match(TIMES);
				setState(193);
				((ExpressionContext)_localctx).e1 = expression();
				setState(194);
				((ExpressionContext)_localctx).e2 = expression();
				setState(195);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(198);
				match(LP);
				setState(199);
				match(MINUS);
				setState(200);
				((ExpressionContext)_localctx).e1 = expression();
				setState(201);
				((ExpressionContext)_localctx).e2 = expression();
				setState(202);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(205);
				match(LP);
				setState(206);
				match(SLASH);
				setState(207);
				((ExpressionContext)_localctx).e1 = expression();
				setState(208);
				((ExpressionContext)_localctx).e2 = expression();
				setState(209);
				match(RP);

						((ExpressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, ((ExpressionContext)_localctx).e1.jData, ((ExpressionContext)_localctx).e2.jData);
					
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(212);
				match(LP);
				setState(213);
				((ExpressionContext)_localctx).i = match(ID);

						List<FOADAExpression> arguments = new ArrayList<FOADAExpression>();
					
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(215);
					((ExpressionContext)_localctx).e = expression();

							((ExpressionContext)_localctx).e.jData.type = ExpressionType.Integer;
							arguments.add(((ExpressionContext)_localctx).e.jData);
						
					}
					}
					setState(220); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP) | (1L << MINUS))) != 0) );

						((ExpressionContext)_localctx).jData =  new FOADAExpression((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null), ExpressionType.Boolean, arguments);
					
				setState(223);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2?\n\2\f\2\16\2B\13\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2P\n\2\f\2\16\2S\13\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\7\2[\n\2\f\2\16\2^\13\2\3\3\3\3\3\3\3\3\5\3d\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\6\4|\n\4\r\4\16\4}\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\6\4\u0089\n\4\r\4\16\4\u008a\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\6\4\u00dd\n\4\r\4\16\4\u00de\3\4\3\4\3\4\5\4\u00e4\n\4\3\4\2\2"+
		"\5\2\4\6\2\2\2\u00fe\2\b\3\2\2\2\4c\3\2\2\2\6\u00e3\3\2\2\2\b\t\b\2\1"+
		"\2\t\n\7\22\2\2\n\13\7\3\2\2\13\20\7\22\2\2\f\r\7\20\2\2\r\17\b\2\1\2"+
		"\16\f\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2"+
		"\22\20\3\2\2\2\23\24\7\23\2\2\24\25\7\23\2\2\25\26\7\22\2\2\26\27\7\4"+
		"\2\2\27\34\7\22\2\2\30\31\7\20\2\2\31\33\b\2\1\2\32\30\3\2\2\2\33\36\3"+
		"\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7\23"+
		"\2\2 !\7\23\2\2!\"\7\22\2\2\"#\7\5\2\2#$\5\6\4\2$%\7\23\2\2%&\b\2\1\2"+
		"&\'\7\22\2\2\'(\7\6\2\2(-\7\22\2\2)*\7\20\2\2*,\b\2\1\2+)\3\2\2\2,/\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\23\2\2\61\\\7"+
		"\23\2\2\62\63\7\22\2\2\63\64\7\7\2\2\64\65\7\22\2\2\65\66\7\20\2\2\66"+
		"\67\7\22\2\2\67@\b\2\1\289\7\22\2\29:\7\20\2\2:;\5\4\3\2;<\7\23\2\2<="+
		"\b\2\1\2=?\3\2\2\2>8\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B"+
		"@\3\2\2\2CD\7\23\2\2DE\7\23\2\2EF\7\22\2\2FG\7\20\2\2GH\7\22\2\2HQ\b\2"+
		"\1\2IJ\7\22\2\2JK\7\20\2\2KL\5\4\3\2LM\7\23\2\2MN\b\2\1\2NP\3\2\2\2OI"+
		"\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\23\2\2"+
		"UV\7\23\2\2VW\5\6\4\2WX\b\2\1\2XY\7\23\2\2Y[\3\2\2\2Z\62\3\2\2\2[^\3\2"+
		"\2\2\\Z\3\2\2\2\\]\3\2\2\2]\3\3\2\2\2^\\\3\2\2\2_`\7\16\2\2`d\b\3\1\2"+
		"ab\7\17\2\2bd\b\3\1\2c_\3\2\2\2ca\3\2\2\2d\5\3\2\2\2ef\7\25\2\2fg\7\21"+
		"\2\2g\u00e4\b\4\1\2hi\7\21\2\2i\u00e4\b\4\1\2jk\7\b\2\2k\u00e4\b\4\1\2"+
		"lm\7\t\2\2m\u00e4\b\4\1\2no\7\22\2\2op\7\n\2\2pq\5\6\4\2qr\7\23\2\2rs"+
		"\b\4\1\2s\u00e4\3\2\2\2tu\7\22\2\2uv\7\13\2\2vw\5\6\4\2w{\b\4\1\2xy\5"+
		"\6\4\2yz\b\4\1\2z|\3\2\2\2{x\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\7\23\2\2\u0080\u00e4\3\2\2\2\u0081\u0082\7\22\2\2\u0082"+
		"\u0083\7\f\2\2\u0083\u0084\5\6\4\2\u0084\u0088\b\4\1\2\u0085\u0086\5\6"+
		"\4\2\u0086\u0087\b\4\1\2\u0087\u0089\3\2\2\2\u0088\u0085\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008d\7\23\2\2\u008d\u00e4\3\2\2\2\u008e\u008f\7\22\2\2\u008f"+
		"\u0090\7\30\2\2\u0090\u0091\5\6\4\2\u0091\u0092\5\6\4\2\u0092\u0093\7"+
		"\23\2\2\u0093\u0094\b\4\1\2\u0094\u00e4\3\2\2\2\u0095\u0096\7\22\2\2\u0096"+
		"\u0097\7\31\2\2\u0097\u0098\5\6\4\2\u0098\u0099\5\6\4\2\u0099\u009a\7"+
		"\23\2\2\u009a\u009b\b\4\1\2\u009b\u00e4\3\2\2\2\u009c\u009d\7\22\2\2\u009d"+
		"\u009e\7\32\2\2\u009e\u009f\5\6\4\2\u009f\u00a0\5\6\4\2\u00a0\u00a1\7"+
		"\23\2\2\u00a1\u00a2\b\4\1\2\u00a2\u00e4\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4"+
		"\u00a5\7\33\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\5\6\4\2\u00a7\u00a8\7"+
		"\23\2\2\u00a8\u00a9\b\4\1\2\u00a9\u00e4\3\2\2\2\u00aa\u00ab\7\22\2\2\u00ab"+
		"\u00ac\7\34\2\2\u00ac\u00ad\5\6\4\2\u00ad\u00ae\5\6\4\2\u00ae\u00af\7"+
		"\23\2\2\u00af\u00b0\b\4\1\2\u00b0\u00e4\3\2\2\2\u00b1\u00b2\7\22\2\2\u00b2"+
		"\u00b3\7\r\2\2\u00b3\u00b4\5\6\4\2\u00b4\u00b5\5\6\4\2\u00b5\u00b6\7\23"+
		"\2\2\u00b6\u00b7\b\4\1\2\u00b7\u00e4\3\2\2\2\u00b8\u00b9\7\20\2\2\u00b9"+
		"\u00e4\b\4\1\2\u00ba\u00bb\7\22\2\2\u00bb\u00bc\7\24\2\2\u00bc\u00bd\5"+
		"\6\4\2\u00bd\u00be\5\6\4\2\u00be\u00bf\7\23\2\2\u00bf\u00c0\b\4\1\2\u00c0"+
		"\u00e4\3\2\2\2\u00c1\u00c2\7\22\2\2\u00c2\u00c3\7\26\2\2\u00c3\u00c4\5"+
		"\6\4\2\u00c4\u00c5\5\6\4\2\u00c5\u00c6\7\23\2\2\u00c6\u00c7\b\4\1\2\u00c7"+
		"\u00e4\3\2\2\2\u00c8\u00c9\7\22\2\2\u00c9\u00ca\7\25\2\2\u00ca\u00cb\5"+
		"\6\4\2\u00cb\u00cc\5\6\4\2\u00cc\u00cd\7\23\2\2\u00cd\u00ce\b\4\1\2\u00ce"+
		"\u00e4\3\2\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\7\27\2\2\u00d1\u00d2\5"+
		"\6\4\2\u00d2\u00d3\5\6\4\2\u00d3\u00d4\7\23\2\2\u00d4\u00d5\b\4\1\2\u00d5"+
		"\u00e4\3\2\2\2\u00d6\u00d7\7\22\2\2\u00d7\u00d8\7\20\2\2\u00d8\u00dc\b"+
		"\4\1\2\u00d9\u00da\5\6\4\2\u00da\u00db\b\4\1\2\u00db\u00dd\3\2\2\2\u00dc"+
		"\u00d9\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\4\1\2\u00e1\u00e2\7\23\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3e\3\2\2\2\u00e3h\3\2\2\2\u00e3j\3\2\2\2\u00e3l\3\2"+
		"\2\2\u00e3n\3\2\2\2\u00e3t\3\2\2\2\u00e3\u0081\3\2\2\2\u00e3\u008e\3\2"+
		"\2\2\u00e3\u0095\3\2\2\2\u00e3\u009c\3\2\2\2\u00e3\u00a3\3\2\2\2\u00e3"+
		"\u00aa\3\2\2\2\u00e3\u00b1\3\2\2\2\u00e3\u00b8\3\2\2\2\u00e3\u00ba\3\2"+
		"\2\2\u00e3\u00c1\3\2\2\2\u00e3\u00c8\3\2\2\2\u00e3\u00cf\3\2\2\2\u00e3"+
		"\u00d6\3\2\2\2\u00e4\7\3\2\2\2\r\20\34-@Q\\c}\u008a\u00de\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}