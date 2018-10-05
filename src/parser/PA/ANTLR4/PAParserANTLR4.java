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
public class PAParserANTLR4 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, FINAL=2, NONE=3, FALSE=4, TRUE=5, FORALL=6, EXISTS=7, TL=8, TR=9, 
		AND=10, OR=11, EQUALS=12, DISTINCTS=13, INTEGER=14, ID=15, LP=16, RP=17, 
		POINT=18, TWOPOINTS=19, COM=20, WS=21, COMMENT=22;
	public static final int
		RULE_automaton = 0, RULE_final_list = 1, RULE_expression = 2, RULE_or_expression = 3, 
		RULE_and_expression = 4, RULE_basic_expression = 5, RULE_eq_expression = 6, 
		RULE_argument_list = 7;
	public static final String[] ruleNames = {
		"automaton", "final_list", "expression", "or_expression", "and_expression", 
		"basic_expression", "eq_expression", "argument_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'start'", "'final'", "'none'", "'false'", "'true'", "'forall'", 
		"'exists'", "'--('", "')->'", "'/\\'", "'\\/'", "'='", "'!='", null, null, 
		"'('", "')'", "'.'", "':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "START", "FINAL", "NONE", "FALSE", "TRUE", "FORALL", "EXISTS", "TL", 
		"TR", "AND", "OR", "EQUALS", "DISTINCTS", "INTEGER", "ID", "LP", "RP", 
		"POINT", "TWOPOINTS", "COM", "WS", "COMMENT"
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
		public Automaton jData;
		public ExpressionContext e;
		public Final_listContext fl;
		public Token ID;
		public Argument_listContext al;
		public Token i1;
		public Token i2;
		public TerminalNode START() { return getToken(PAParserANTLR4.START, 0); }
		public List<TerminalNode> TWOPOINTS() { return getTokens(PAParserANTLR4.TWOPOINTS); }
		public TerminalNode TWOPOINTS(int i) {
			return getToken(PAParserANTLR4.TWOPOINTS, i);
		}
		public List<TerminalNode> POINT() { return getTokens(PAParserANTLR4.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(PAParserANTLR4.POINT, i);
		}
		public TerminalNode FINAL() { return getToken(PAParserANTLR4.FINAL, 0); }
		public TerminalNode EOF() { return getToken(PAParserANTLR4.EOF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Final_listContext final_list() {
			return getRuleContext(Final_listContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(PAParserANTLR4.ID, i);
		}
		public List<TerminalNode> LP() { return getTokens(PAParserANTLR4.LP); }
		public TerminalNode LP(int i) {
			return getToken(PAParserANTLR4.LP, i);
		}
		public List<TerminalNode> RP() { return getTokens(PAParserANTLR4.RP); }
		public TerminalNode RP(int i) {
			return getToken(PAParserANTLR4.RP, i);
		}
		public List<TerminalNode> TL() { return getTokens(PAParserANTLR4.TL); }
		public TerminalNode TL(int i) {
			return getToken(PAParserANTLR4.TL, i);
		}
		public List<TerminalNode> TR() { return getTokens(PAParserANTLR4.TR); }
		public TerminalNode TR(int i) {
			return getToken(PAParserANTLR4.TR, i);
		}
		public List<Argument_listContext> argument_list() {
			return getRuleContexts(Argument_listContext.class);
		}
		public Argument_listContext argument_list(int i) {
			return getRuleContext(Argument_listContext.class,i);
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

	public final AutomatonContext automaton() throws RecognitionException, FOADAException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((AutomatonContext)_localctx).jData =  new Automaton("A");
				
			setState(17);
			match(START);
			setState(18);
			match(TWOPOINTS);
			setState(19);
			((AutomatonContext)_localctx).e = expression();

					_localctx.jData.setInitialState(((AutomatonContext)_localctx).e.jData);
				
			setState(21);
			match(POINT);
			setState(22);
			match(FINAL);
			setState(23);
			match(TWOPOINTS);
			setState(24);
			((AutomatonContext)_localctx).fl = final_list();

					_localctx.jData.setFinalStates(((AutomatonContext)_localctx).fl.jData);
				
			setState(26);
			match(POINT);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(27);
				((AutomatonContext)_localctx).ID = match(ID);
				setState(28);
				match(LP);
				setState(29);
				((AutomatonContext)_localctx).al = argument_list();
				setState(30);
				match(RP);
				setState(31);
				match(TL);
				setState(32);
				((AutomatonContext)_localctx).i1 = match(ID);
				setState(33);
				match(TWOPOINTS);
				setState(34);
				((AutomatonContext)_localctx).i2 = match(ID);
				setState(35);
				match(TR);
				setState(36);
				((AutomatonContext)_localctx).e = expression();
				setState(37);
				match(POINT);

						List<String> variables = new ArrayList<String>();
						variables.add((((AutomatonContext)_localctx).i2!=null?((AutomatonContext)_localctx).i2.getText():null));
						List<ExpressionType> variablesTypes = new ArrayList<ExpressionType>();
						variablesTypes.add(ExpressionType.Integer);
						List<ExpressionType> argumentsTypes = new ArrayList<ExpressionType>();
						for(String s : ((AutomatonContext)_localctx).al.jData) {
							argumentsTypes.add(ExpressionType.Integer);
						}
						_localctx.jData.addTransition((((AutomatonContext)_localctx).ID!=null?((AutomatonContext)_localctx).ID.getText():null), ((AutomatonContext)_localctx).al.jData, argumentsTypes, (((AutomatonContext)_localctx).i1!=null?((AutomatonContext)_localctx).i1.getText():null), variables, variablesTypes, ((AutomatonContext)_localctx).e.jData);
					
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		public List<String> jData;
		public Token ID;
		public TerminalNode NONE() { return getToken(PAParserANTLR4.NONE, 0); }
		public List<TerminalNode> ID() { return getTokens(PAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(PAParserANTLR4.ID, i);
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
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(NONE);

						((Final_listContext)_localctx).jData =  new ArrayList<String>();
					
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				((Final_listContext)_localctx).ID = match(ID);

						((Final_listContext)_localctx).jData =  new ArrayList<String>();
						_localctx.jData.add((((Final_listContext)_localctx).ID!=null?((Final_listContext)_localctx).ID.getText():null));		
					
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(51);
					match(COM);
					setState(52);
					((Final_listContext)_localctx).ID = match(ID);

							_localctx.jData.add((((Final_listContext)_localctx).ID!=null?((Final_listContext)_localctx).ID.getText():null));
						
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public Or_expressionContext oe;
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			((ExpressionContext)_localctx).oe = or_expression();

					((ExpressionContext)_localctx).jData =  ((ExpressionContext)_localctx).oe.jData;
				
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

	public static class Or_expressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public And_expressionContext ae1;
		public And_expressionContext ae2;
		public Or_expressionContext oe;
		public List<And_expressionContext> and_expression() {
			return getRuleContexts(And_expressionContext.class);
		}
		public And_expressionContext and_expression(int i) {
			return getRuleContext(And_expressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PAParserANTLR4.OR); }
		public TerminalNode OR(int i) {
			return getToken(PAParserANTLR4.OR, i);
		}
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_or_expression);
		try {
			int _alt;
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((Or_expressionContext)_localctx).ae1 = and_expression();

						((Or_expressionContext)_localctx).jData =  ((Or_expressionContext)_localctx).ae1.jData;
					
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(66);
						match(OR);
						setState(67);
						((Or_expressionContext)_localctx).ae2 = and_expression();

								((Or_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, ((Or_expressionContext)_localctx).ae1.jData, ((Or_expressionContext)_localctx).ae2.jData);
							
						}
						} 
					}
					setState(74);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(LP);
				setState(76);
				((Or_expressionContext)_localctx).oe = or_expression();
				setState(77);
				match(RP);

						((Or_expressionContext)_localctx).jData =  ((Or_expressionContext)_localctx).oe.jData;
					
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

	public static class And_expressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public Basic_expressionContext be;
		public Or_expressionContext oe;
		public Or_expressionContext oe1;
		public Or_expressionContext oe2;
		public Basic_expressionContext basic_expression() {
			return getRuleContext(Basic_expressionContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(PAParserANTLR4.AND); }
		public TerminalNode AND(int i) {
			return getToken(PAParserANTLR4.AND, i);
		}
		public List<Or_expressionContext> or_expression() {
			return getRuleContexts(Or_expressionContext.class);
		}
		public Or_expressionContext or_expression(int i) {
			return getRuleContext(Or_expressionContext.class,i);
		}
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_and_expression);
		try {
			int _alt;
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((And_expressionContext)_localctx).be = basic_expression();

						((And_expressionContext)_localctx).jData =  ((And_expressionContext)_localctx).be.jData;
					
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(84);
						match(AND);
						setState(85);
						((And_expressionContext)_localctx).oe = or_expression();

								((And_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, ((And_expressionContext)_localctx).be.jData, ((And_expressionContext)_localctx).oe.jData);
							
						}
						} 
					}
					setState(92);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(LP);
				setState(94);
				((And_expressionContext)_localctx).oe1 = or_expression();
				setState(95);
				match(RP);

						((And_expressionContext)_localctx).jData =  ((And_expressionContext)_localctx).oe1.jData;
					
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(97);
						match(AND);
						setState(98);
						((And_expressionContext)_localctx).oe2 = or_expression();

								((And_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, ((And_expressionContext)_localctx).oe1.jData, ((And_expressionContext)_localctx).oe2.jData);
							
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
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

	public static class Basic_expressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public Argument_listContext al;
		public ExpressionContext e;
		public Eq_expressionContext ee;
		public Token ID;
		public TerminalNode TRUE() { return getToken(PAParserANTLR4.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PAParserANTLR4.FALSE, 0); }
		public TerminalNode EXISTS() { return getToken(PAParserANTLR4.EXISTS, 0); }
		public TerminalNode POINT() { return getToken(PAParserANTLR4.POINT, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(PAParserANTLR4.FORALL, 0); }
		public Eq_expressionContext eq_expression() {
			return getRuleContext(Eq_expressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(PAParserANTLR4.ID, 0); }
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public Basic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterBasic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitBasic_expression(this);
		}
	}

	public final Basic_expressionContext basic_expression() throws RecognitionException {
		Basic_expressionContext _localctx = new Basic_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_basic_expression);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(TRUE);

						((Basic_expressionContext)_localctx).jData =  new FOADAExpression(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(FALSE);

						((Basic_expressionContext)_localctx).jData =  new FOADAExpression(false);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(EXISTS);
				setState(113);
				((Basic_expressionContext)_localctx).al = argument_list();
				setState(114);
				match(POINT);
				setState(115);
				((Basic_expressionContext)_localctx).e = expression();

						List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
						for(String s : ((Basic_expressionContext)_localctx).al.jData) {
							FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
							subExpressions.add(argument);
						}
						subExpressions.add(((Basic_expressionContext)_localctx).e.jData);
						((Basic_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Exists, subExpressions);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(FORALL);
				setState(119);
				((Basic_expressionContext)_localctx).al = argument_list();
				setState(120);
				match(POINT);
				setState(121);
				((Basic_expressionContext)_localctx).e = expression();

						List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
						for(String s : ((Basic_expressionContext)_localctx).al.jData) {
							FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
							subExpressions.add(argument);
						}
						subExpressions.add(((Basic_expressionContext)_localctx).e.jData);
						((Basic_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Forall, subExpressions);
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				((Basic_expressionContext)_localctx).ee = eq_expression();

						((Basic_expressionContext)_localctx).jData =  ((Basic_expressionContext)_localctx).ee.jData;
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				((Basic_expressionContext)_localctx).ID = match(ID);
				setState(128);
				match(LP);
				setState(129);
				((Basic_expressionContext)_localctx).al = argument_list();
				setState(130);
				match(RP);

						List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
						for(String s : ((Basic_expressionContext)_localctx).al.jData) {
							FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
							subExpressions.add(argument);
						}
						((Basic_expressionContext)_localctx).jData =  new FOADAExpression((((Basic_expressionContext)_localctx).ID!=null?((Basic_expressionContext)_localctx).ID.getText():null), ExpressionType.Boolean, subExpressions);
					
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

	public static class Eq_expressionContext extends ParserRuleContext {
		public FOADAExpression jData;
		public Token i1;
		public Token i2;
		public Eq_expressionContext ee;
		public TerminalNode EQUALS() { return getToken(PAParserANTLR4.EQUALS, 0); }
		public List<TerminalNode> ID() { return getTokens(PAParserANTLR4.ID); }
		public TerminalNode ID(int i) {
			return getToken(PAParserANTLR4.ID, i);
		}
		public TerminalNode DISTINCTS() { return getToken(PAParserANTLR4.DISTINCTS, 0); }
		public TerminalNode LP() { return getToken(PAParserANTLR4.LP, 0); }
		public TerminalNode RP() { return getToken(PAParserANTLR4.RP, 0); }
		public Eq_expressionContext eq_expression() {
			return getRuleContext(Eq_expressionContext.class,0);
		}
		public Eq_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).enterEq_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PAParserANTLR4Listener ) ((PAParserANTLR4Listener)listener).exitEq_expression(this);
		}
	}

	public final Eq_expressionContext eq_expression() throws RecognitionException {
		Eq_expressionContext _localctx = new Eq_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eq_expression);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((Eq_expressionContext)_localctx).i1 = match(ID);
				setState(136);
				match(EQUALS);
				setState(137);
				((Eq_expressionContext)_localctx).i2 = match(ID);

						FOADAExpression left = new FOADAExpression((((Eq_expressionContext)_localctx).i1!=null?((Eq_expressionContext)_localctx).i1.getText():null), ExpressionType.Integer);
						FOADAExpression right = new FOADAExpression((((Eq_expressionContext)_localctx).i2!=null?((Eq_expressionContext)_localctx).i2.getText():null), ExpressionType.Integer);
						((Eq_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, left, right);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				((Eq_expressionContext)_localctx).i1 = match(ID);
				setState(140);
				match(DISTINCTS);
				setState(141);
				((Eq_expressionContext)_localctx).i2 = match(ID);

						FOADAExpression left = new FOADAExpression((((Eq_expressionContext)_localctx).i1!=null?((Eq_expressionContext)_localctx).i1.getText():null), ExpressionType.Integer);
						FOADAExpression right = new FOADAExpression((((Eq_expressionContext)_localctx).i2!=null?((Eq_expressionContext)_localctx).i2.getText():null), ExpressionType.Integer);
						((Eq_expressionContext)_localctx).jData =  new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distincts, left, right);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(LP);
				setState(144);
				((Eq_expressionContext)_localctx).ee = eq_expression();
				setState(145);
				match(RP);

						((Eq_expressionContext)_localctx).jData =  ((Eq_expressionContext)_localctx).ee.jData;
					
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

	public static class Argument_listContext extends ParserRuleContext {
		public List<String> jData;
		public Token i1;
		public Token i2;
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
		enterRule(_localctx, 14, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((Argument_listContext)_localctx).jData =  new ArrayList<String>();
				
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(151);
				((Argument_listContext)_localctx).i1 = match(ID);

						_localctx.jData.add((((Argument_listContext)_localctx).i1!=null?((Argument_listContext)_localctx).i1.getText():null));
					
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(153);
					match(COM);
					setState(154);
					((Argument_listContext)_localctx).i2 = match(ID);

							_localctx.jData.add((((Argument_listContext)_localctx).i2!=null?((Argument_listContext)_localctx).i2.getText():null));
						
					}
					}
					setState(160);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00a6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"h\n\6\f\6\16\6k\13\6\5\6m\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0088"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0097\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009f\n\t\f\t\16\t\u00a2\13\t\5\t\u00a4\n"+
		"\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2\u00ae\2\22\3\2\2\2\4=\3\2\2\2\6?"+
		"\3\2\2\2\bR\3\2\2\2\nl\3\2\2\2\f\u0087\3\2\2\2\16\u0096\3\2\2\2\20\u0098"+
		"\3\2\2\2\22\23\b\2\1\2\23\24\7\3\2\2\24\25\7\25\2\2\25\26\5\6\4\2\26\27"+
		"\b\2\1\2\27\30\7\24\2\2\30\31\7\4\2\2\31\32\7\25\2\2\32\33\5\4\3\2\33"+
		"\34\b\2\1\2\34,\7\24\2\2\35\36\7\21\2\2\36\37\7\22\2\2\37 \5\20\t\2 !"+
		"\7\23\2\2!\"\7\n\2\2\"#\7\21\2\2#$\7\25\2\2$%\7\21\2\2%&\7\13\2\2&\'\5"+
		"\6\4\2\'(\7\24\2\2()\b\2\1\2)+\3\2\2\2*\35\3\2\2\2+.\3\2\2\2,*\3\2\2\2"+
		",-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\7\5\2\2"+
		"\62>\b\3\1\2\63\64\7\21\2\2\64:\b\3\1\2\65\66\7\26\2\2\66\67\7\21\2\2"+
		"\679\b\3\1\28\65\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2"+
		"\2\2=\61\3\2\2\2=\63\3\2\2\2>\5\3\2\2\2?@\5\b\5\2@A\b\4\1\2A\7\3\2\2\2"+
		"BC\5\n\6\2CJ\b\5\1\2DE\7\r\2\2EF\5\n\6\2FG\b\5\1\2GI\3\2\2\2HD\3\2\2\2"+
		"IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KS\3\2\2\2LJ\3\2\2\2MN\7\22\2\2NO\5\b\5"+
		"\2OP\7\23\2\2PQ\b\5\1\2QS\3\2\2\2RB\3\2\2\2RM\3\2\2\2S\t\3\2\2\2TU\5\f"+
		"\7\2U\\\b\6\1\2VW\7\f\2\2WX\5\b\5\2XY\b\6\1\2Y[\3\2\2\2ZV\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]m\3\2\2\2^\\\3\2\2\2_`\7\22\2\2`a\5\b\5\2"+
		"ab\7\23\2\2bi\b\6\1\2cd\7\f\2\2de\5\b\5\2ef\b\6\1\2fh\3\2\2\2gc\3\2\2"+
		"\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2lT\3\2\2\2l_\3\2\2"+
		"\2m\13\3\2\2\2no\7\7\2\2o\u0088\b\7\1\2pq\7\6\2\2q\u0088\b\7\1\2rs\7\t"+
		"\2\2st\5\20\t\2tu\7\24\2\2uv\5\6\4\2vw\b\7\1\2w\u0088\3\2\2\2xy\7\b\2"+
		"\2yz\5\20\t\2z{\7\24\2\2{|\5\6\4\2|}\b\7\1\2}\u0088\3\2\2\2~\177\5\16"+
		"\b\2\177\u0080\b\7\1\2\u0080\u0088\3\2\2\2\u0081\u0082\7\21\2\2\u0082"+
		"\u0083\7\22\2\2\u0083\u0084\5\20\t\2\u0084\u0085\7\23\2\2\u0085\u0086"+
		"\b\7\1\2\u0086\u0088\3\2\2\2\u0087n\3\2\2\2\u0087p\3\2\2\2\u0087r\3\2"+
		"\2\2\u0087x\3\2\2\2\u0087~\3\2\2\2\u0087\u0081\3\2\2\2\u0088\r\3\2\2\2"+
		"\u0089\u008a\7\21\2\2\u008a\u008b\7\16\2\2\u008b\u008c\7\21\2\2\u008c"+
		"\u0097\b\b\1\2\u008d\u008e\7\21\2\2\u008e\u008f\7\17\2\2\u008f\u0090\7"+
		"\21\2\2\u0090\u0097\b\b\1\2\u0091\u0092\7\22\2\2\u0092\u0093\5\16\b\2"+
		"\u0093\u0094\7\23\2\2\u0094\u0095\b\b\1\2\u0095\u0097\3\2\2\2\u0096\u0089"+
		"\3\2\2\2\u0096\u008d\3\2\2\2\u0096\u0091\3\2\2\2\u0097\17\3\2\2\2\u0098"+
		"\u00a3\b\t\1\2\u0099\u009a\7\21\2\2\u009a\u00a0\b\t\1\2\u009b\u009c\7"+
		"\26\2\2\u009c\u009d\7\21\2\2\u009d\u009f\b\t\1\2\u009e\u009b\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u0099\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\21\3\2\2\2\16,:=JR\\il\u0087\u0096\u00a0\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}