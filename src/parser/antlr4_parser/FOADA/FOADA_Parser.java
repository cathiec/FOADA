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

package parser.antlr4_parser.FOADA;

import structure.*;
import structure.Expression.*;
import structure.Transition;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import exception.*;

import java.util.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOADA_Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEFAUTO=1, INIT=2, FINAL=3, TRANS=4, TRUE=5, FALSE=6, INT=7, BOOL=8, EXISTS=9, 
		FORALL=10, NOT=11, AND=12, OR=13, DISTINCT=14, ID=15, INTEGER=16, LP=17, 
		RP=18, PLUS=19, MINUS=20, TIMES=21, SLASH=22, GT=23, LT=24, GEQ=25, LEQ=26, 
		EQUALS=27, WS=28, COMMENT=29;
	public static final int
		RULE_automaton = 0, RULE_initial_def = 1, RULE_list_finals_def = 2, RULE_transition_def = 3, 
		RULE_boolexpr = 4, RULE_intexpr = 5, RULE_list_finals = 6, RULE_list_arguments = 7, 
		RULE_argument = 8, RULE_type = 9, RULE_input = 10;
	public static final String[] ruleNames = {
		"automaton", "initial_def", "list_finals_def", "transition_def", "boolexpr", 
		"intexpr", "list_finals", "list_arguments", "argument", "type", "input"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'init'", "'final'", "'trans'", "'true'", 
		"'false'", "'Int'", "'Bool'", "'exists'", "'forall'", "'not'", "'and'", 
		"'or'", "'distinct'", null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
		"'>'", "'<'", "'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", 
		"EXISTS", "FORALL", "NOT", "AND", "OR", "DISTINCT", "ID", "INTEGER", "LP", 
		"RP", "PLUS", "MINUS", "TIMES", "SLASH", "GT", "LT", "GEQ", "LEQ", "EQUALS", 
		"WS", "COMMENT"
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
		public Automaton tree;
		public Token ID;
		public Initial_defContext initial_def;
		public List_finals_defContext list_finals_def;
		public Transition_defContext transition_def;
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
		public List<Transition_defContext> transition_def() {
			return getRuleContexts(Transition_defContext.class);
		}
		public Transition_defContext transition_def(int i) {
			return getRuleContext(Transition_defContext.class,i);
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

	public final AutomatonContext automaton() throws RecognitionException, InitialRedundancyException, FinalRedundancyException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(LP);
			setState(23);
			match(DEFAUTO);
			setState(24);
			((AutomatonContext)_localctx).ID = match(ID);

					((AutomatonContext)_localctx).tree =  new Automaton((((AutomatonContext)_localctx).ID!=null?((AutomatonContext)_localctx).ID.getText():null));
				
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(26);
					((AutomatonContext)_localctx).initial_def = initial_def();

							_localctx.tree.setInitial(((AutomatonContext)_localctx).initial_def.tree);
						
					}
					break;
				case 2:
					{
					setState(29);
					((AutomatonContext)_localctx).list_finals_def = list_finals_def();

							_localctx.tree.setFinals(((AutomatonContext)_localctx).list_finals_def.tree);
						
					}
					break;
				case 3:
					{
					setState(32);
					((AutomatonContext)_localctx).transition_def = transition_def();

							_localctx.tree.addTransition(((AutomatonContext)_localctx).transition_def.tree);
						
					}
					break;
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(RP);
			setState(41);
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
		public BooleanExpression tree;
		public BoolexprContext boolexpr;
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode INIT() { return getToken(FOADA_Parser.INIT, 0); }
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
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
			setState(43);
			match(LP);
			setState(44);
			match(INIT);
			setState(45);
			((Initial_defContext)_localctx).boolexpr = boolexpr();

					((Initial_defContext)_localctx).tree =  ((Initial_defContext)_localctx).boolexpr.tree;
				
			setState(47);
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
		public List<String> tree;
		public List_finalsContext list_finals;
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
			setState(49);
			match(LP);
			setState(50);
			match(FINAL);
			setState(51);
			match(LP);
			setState(52);
			((List_finals_defContext)_localctx).list_finals = list_finals();

					((List_finals_defContext)_localctx).tree =  ((List_finals_defContext)_localctx).list_finals.tree;
				
			setState(54);
			match(RP);
			setState(55);
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

	public static class Transition_defContext extends ParserRuleContext {
		public Transition tree;
		public InputContext i;
		public InputContext i2;
		public BoolexprContext boolexpr;
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode TRANS() { return getToken(FOADA_Parser.TRANS, 0); }
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public Transition_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterTransition_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitTransition_def(this);
		}
	}

	public final Transition_defContext transition_def() throws RecognitionException {
		Transition_defContext _localctx = new Transition_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_transition_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LP);
			setState(58);
			match(TRANS);
			setState(59);
			((Transition_defContext)_localctx).i = input();
			setState(60);
			((Transition_defContext)_localctx).i2 = input();
			setState(61);
			((Transition_defContext)_localctx).boolexpr = boolexpr();
			setState(62);
			match(RP);

					((Transition_defContext)_localctx).tree =  new Transition(((Transition_defContext)_localctx).i.tree, ((Transition_defContext)_localctx).i2.tree, ((Transition_defContext)_localctx).boolexpr.tree);
				
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

	public static class BoolexprContext extends ParserRuleContext {
		public BooleanExpression tree;
		public BoolexprContext boolexpr;
		public BoolexprContext b;
		public BoolexprContext b2;
		public List_argumentsContext list_arguments;
		public IntexprContext i;
		public IntexprContext i2;
		public Token ID;
		public Token id;
		public Token id2;
		public TerminalNode TRUE() { return getToken(FOADA_Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOADA_Parser.FALSE, 0); }
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode NOT() { return getToken(FOADA_Parser.NOT, 0); }
		public List<BoolexprContext> boolexpr() {
			return getRuleContexts(BoolexprContext.class);
		}
		public BoolexprContext boolexpr(int i) {
			return getRuleContext(BoolexprContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public TerminalNode AND() { return getToken(FOADA_Parser.AND, 0); }
		public TerminalNode OR() { return getToken(FOADA_Parser.OR, 0); }
		public TerminalNode EXISTS() { return getToken(FOADA_Parser.EXISTS, 0); }
		public List_argumentsContext list_arguments() {
			return getRuleContext(List_argumentsContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOADA_Parser.FORALL, 0); }
		public TerminalNode GT() { return getToken(FOADA_Parser.GT, 0); }
		public List<IntexprContext> intexpr() {
			return getRuleContexts(IntexprContext.class);
		}
		public IntexprContext intexpr(int i) {
			return getRuleContext(IntexprContext.class,i);
		}
		public TerminalNode LT() { return getToken(FOADA_Parser.LT, 0); }
		public TerminalNode GEQ() { return getToken(FOADA_Parser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(FOADA_Parser.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(FOADA_Parser.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(FOADA_Parser.DISTINCT, 0); }
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public BoolexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterBoolexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitBoolexpr(this);
		}
	}

	public final BoolexprContext boolexpr() throws RecognitionException {
		BoolexprContext _localctx = new BoolexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_boolexpr);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(TRUE);

						((BoolexprContext)_localctx).tree =  new BooleanConstant(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(FALSE);

						((BoolexprContext)_localctx).tree =  new BooleanConstant(false);
					
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
				((BoolexprContext)_localctx).boolexpr = boolexpr();
				setState(72);
				match(RP);

						((BoolexprContext)_localctx).tree =  new Not(((BoolexprContext)_localctx).boolexpr.tree);
					
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
				((BoolexprContext)_localctx).b = boolexpr();

						((BoolexprContext)_localctx).tree =  ((BoolexprContext)_localctx).b.tree; 
					
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					((BoolexprContext)_localctx).b2 = boolexpr();

							((BoolexprContext)_localctx).tree =  new And(_localctx.tree, ((BoolexprContext)_localctx).b2.tree);
						
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
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
				((BoolexprContext)_localctx).b = boolexpr();

						((BoolexprContext)_localctx).tree =  ((BoolexprContext)_localctx).b.tree;
					
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					((BoolexprContext)_localctx).b2 = boolexpr();

							((BoolexprContext)_localctx).tree =  new Or(_localctx.tree, ((BoolexprContext)_localctx).b2.tree);
						
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << LP))) != 0) );
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
				match(EXISTS);
				setState(103);
				match(LP);
				setState(104);
				((BoolexprContext)_localctx).list_arguments = list_arguments();
				setState(105);
				match(RP);
				setState(106);
				((BoolexprContext)_localctx).boolexpr = boolexpr();
				setState(107);
				match(RP);

						((BoolexprContext)_localctx).tree =  new Exists(((BoolexprContext)_localctx).list_arguments.tree, ((BoolexprContext)_localctx).boolexpr.tree);
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				match(LP);
				setState(111);
				match(FORALL);
				setState(112);
				match(LP);
				setState(113);
				((BoolexprContext)_localctx).list_arguments = list_arguments();
				setState(114);
				match(RP);
				setState(115);
				((BoolexprContext)_localctx).boolexpr = boolexpr();
				setState(116);
				match(RP);

						((BoolexprContext)_localctx).tree =  new Forall(((BoolexprContext)_localctx).list_arguments.tree, ((BoolexprContext)_localctx).boolexpr.tree);
					
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(119);
				match(LP);
				setState(120);
				match(GT);
				setState(121);
				((BoolexprContext)_localctx).i = intexpr();
				setState(122);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(123);
				match(RP);

						((BoolexprContext)_localctx).tree =  new GT(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(126);
				match(LP);
				setState(127);
				match(LT);
				setState(128);
				((BoolexprContext)_localctx).i = intexpr();
				setState(129);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(130);
				match(RP);

						((BoolexprContext)_localctx).tree =  new LT(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(133);
				match(LP);
				setState(134);
				match(GEQ);
				setState(135);
				((BoolexprContext)_localctx).i = intexpr();
				setState(136);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(137);
				match(RP);

						((BoolexprContext)_localctx).tree =  new GEQ(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(140);
				match(LP);
				setState(141);
				match(LEQ);
				setState(142);
				((BoolexprContext)_localctx).i = intexpr();
				setState(143);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(144);
				match(RP);

						((BoolexprContext)_localctx).tree =  new LEQ(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(147);
				match(LP);
				setState(148);
				match(EQUALS);
				setState(149);
				((BoolexprContext)_localctx).i = intexpr();
				setState(150);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(151);
				match(RP);

						((BoolexprContext)_localctx).tree =  new Equals(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(154);
				match(LP);
				setState(155);
				match(DISTINCT);
				setState(156);
				((BoolexprContext)_localctx).i = intexpr();
				setState(157);
				((BoolexprContext)_localctx).i2 = intexpr();
				setState(158);
				match(RP);

						((BoolexprContext)_localctx).tree =  new Distinct(((BoolexprContext)_localctx).i.tree, ((BoolexprContext)_localctx).i2.tree);
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(161);
				((BoolexprContext)_localctx).ID = match(ID);

						((BoolexprContext)_localctx).tree =  new BooleanFunction((((BoolexprContext)_localctx).ID!=null?((BoolexprContext)_localctx).ID.getText():null));
					
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(163);
				match(LP);
				setState(164);
				((BoolexprContext)_localctx).id = match(ID);

						((BoolexprContext)_localctx).tree =  new BooleanFunction((((BoolexprContext)_localctx).id!=null?((BoolexprContext)_localctx).id.getText():null));
					
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					((BoolexprContext)_localctx).id2 = match(ID);

							((BooleanFunction)_localctx.tree).addArgument((((BoolexprContext)_localctx).id2!=null?((BoolexprContext)_localctx).id2.getText():null));
						
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

	public static class IntexprContext extends ParserRuleContext {
		public IntegerExpression tree;
		public Token INTEGER;
		public IntexprContext i;
		public IntexprContext i2;
		public Token ID;
		public TerminalNode INTEGER() { return getToken(FOADA_Parser.INTEGER, 0); }
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode PLUS() { return getToken(FOADA_Parser.PLUS, 0); }
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public List<IntexprContext> intexpr() {
			return getRuleContexts(IntexprContext.class);
		}
		public IntexprContext intexpr(int i) {
			return getRuleContext(IntexprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(FOADA_Parser.TIMES, 0); }
		public TerminalNode MINUS() { return getToken(FOADA_Parser.MINUS, 0); }
		public TerminalNode SLASH() { return getToken(FOADA_Parser.SLASH, 0); }
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public IntexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterIntexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitIntexpr(this);
		}
	}

	public final IntexprContext intexpr() throws RecognitionException {
		IntexprContext _localctx = new IntexprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_intexpr);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				((IntexprContext)_localctx).INTEGER = match(INTEGER);

						((IntexprContext)_localctx).tree =  new IntegerConstant((((IntexprContext)_localctx).INTEGER!=null?((IntexprContext)_localctx).INTEGER.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(LP);
				setState(178);
				match(PLUS);
				setState(179);
				((IntexprContext)_localctx).i = intexpr();

						((IntexprContext)_localctx).tree =  ((IntexprContext)_localctx).i.tree; 
					
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(181);
					((IntexprContext)_localctx).i2 = intexpr();

							((IntexprContext)_localctx).tree =  new Plus(_localctx.tree, ((IntexprContext)_localctx).i2.tree);
						
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(188);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(LP);
				setState(191);
				match(TIMES);
				setState(192);
				((IntexprContext)_localctx).i = intexpr();

						((IntexprContext)_localctx).tree =  ((IntexprContext)_localctx).i.tree; 
					
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(194);
					((IntexprContext)_localctx).i2 = intexpr();

							((IntexprContext)_localctx).tree =  new Times(_localctx.tree, ((IntexprContext)_localctx).i2.tree);
						
					}
					}
					setState(199); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(201);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(LP);
				setState(204);
				match(MINUS);
				setState(205);
				((IntexprContext)_localctx).i = intexpr();
				setState(206);
				((IntexprContext)_localctx).i2 = intexpr();
				setState(207);
				match(RP);

						((IntexprContext)_localctx).tree =  new Minus(((IntexprContext)_localctx).i.tree, ((IntexprContext)_localctx).i2.tree);
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				match(LP);
				setState(211);
				match(SLASH);
				setState(212);
				((IntexprContext)_localctx).i = intexpr();
				setState(213);
				((IntexprContext)_localctx).i2 = intexpr();
				setState(214);
				match(RP);

						((IntexprContext)_localctx).tree =  new Slash(((IntexprContext)_localctx).i.tree, ((IntexprContext)_localctx).i2.tree);
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(217);
				((IntexprContext)_localctx).ID = match(ID);

						((IntexprContext)_localctx).tree =  new IntegerVariable((((IntexprContext)_localctx).ID!=null?((IntexprContext)_localctx).ID.getText():null));
					
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
		public List<String> tree;
		public Token i;
		public Token i2;
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
			setState(221);
			((List_finalsContext)_localctx).i = match(ID);

					((List_finalsContext)_localctx).tree =  new ArrayList<String>();
					_localctx.tree.add((((List_finalsContext)_localctx).i!=null?((List_finalsContext)_localctx).i.getText():null));
				
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(223);
				((List_finalsContext)_localctx).i2 = match(ID);

						_localctx.tree.add((((List_finalsContext)_localctx).i2!=null?((List_finalsContext)_localctx).i2.getText():null));
					
				}
				}
				setState(229);
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

	public static class List_argumentsContext extends ParserRuleContext {
		public List<Argument> tree;
		public ArgumentContext argument;
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
		enterRule(_localctx, 14, RULE_list_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_argumentsContext)_localctx).tree =  new ArrayList<Argument>();
				
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(231);
				((List_argumentsContext)_localctx).argument = argument();

						_localctx.tree.add(((List_argumentsContext)_localctx).argument.tree);
					
				}
				}
				setState(238);
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
		public Argument tree;
		public Token ID;
		public TypeContext type;
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
		enterRule(_localctx, 16, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(LP);
			setState(240);
			((ArgumentContext)_localctx).ID = match(ID);
			setState(241);
			((ArgumentContext)_localctx).type = type();
			setState(242);
			match(RP);

					((ArgumentContext)_localctx).tree =  new Argument((((ArgumentContext)_localctx).ID!=null?((ArgumentContext)_localctx).ID.getText():null), ((ArgumentContext)_localctx).type.tree);
				
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
		public ExpressionClass tree;
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
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(INT);

						((TypeContext)_localctx).tree =  ExpressionClass.Integer;
					
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(BOOL);

						((TypeContext)_localctx).tree =  ExpressionClass.Boolean;
					
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

	public static class InputContext extends ParserRuleContext {
		public Input tree;
		public Token ID;
		public List_argumentsContext list_arguments;
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
		enterRule(_localctx, 20, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(LP);
			setState(252);
			((InputContext)_localctx).ID = match(ID);
			setState(253);
			match(LP);
			setState(254);
			((InputContext)_localctx).list_arguments = list_arguments();
			setState(255);
			match(RP);
			setState(256);
			match(RP);

					((InputContext)_localctx).tree =  new Input((((InputContext)_localctx).ID!=null?((InputContext)_localctx).ID.getText():null), ((InputContext)_localctx).list_arguments.tree);
				
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0106\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6U\n\6\r\6\16\6V\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6b\n\6\r\6\16\6c\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00ab\n\6\r\6\16"+
		"\6\u00ac\3\6\5\6\u00b0\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u00bb"+
		"\n\7\r\7\16\7\u00bc\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u00c8\n\7"+
		"\r\7\16\7\u00c9\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u00de\n\7\3\b\3\b\3\b\3\b\7\b\u00e4\n\b\f\b\16"+
		"\b\u00e7\13\b\3\t\3\t\3\t\3\t\7\t\u00ed\n\t\f\t\16\t\u00f0\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00fc\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2\u0118\2\30"+
		"\3\2\2\2\4-\3\2\2\2\6\63\3\2\2\2\b;\3\2\2\2\n\u00af\3\2\2\2\f\u00dd\3"+
		"\2\2\2\16\u00df\3\2\2\2\20\u00e8\3\2\2\2\22\u00f1\3\2\2\2\24\u00fb\3\2"+
		"\2\2\26\u00fd\3\2\2\2\30\31\7\23\2\2\31\32\7\3\2\2\32\33\7\21\2\2\33\'"+
		"\b\2\1\2\34\35\5\4\3\2\35\36\b\2\1\2\36&\3\2\2\2\37 \5\6\4\2 !\b\2\1\2"+
		"!&\3\2\2\2\"#\5\b\5\2#$\b\2\1\2$&\3\2\2\2%\34\3\2\2\2%\37\3\2\2\2%\"\3"+
		"\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\24\2\2"+
		"+,\7\2\2\3,\3\3\2\2\2-.\7\23\2\2./\7\4\2\2/\60\5\n\6\2\60\61\b\3\1\2\61"+
		"\62\7\24\2\2\62\5\3\2\2\2\63\64\7\23\2\2\64\65\7\5\2\2\65\66\7\23\2\2"+
		"\66\67\5\16\b\2\678\b\4\1\289\7\24\2\29:\7\24\2\2:\7\3\2\2\2;<\7\23\2"+
		"\2<=\7\6\2\2=>\5\26\f\2>?\5\26\f\2?@\5\n\6\2@A\7\24\2\2AB\b\5\1\2B\t\3"+
		"\2\2\2CD\7\7\2\2D\u00b0\b\6\1\2EF\7\b\2\2F\u00b0\b\6\1\2GH\7\23\2\2HI"+
		"\7\r\2\2IJ\5\n\6\2JK\7\24\2\2KL\b\6\1\2L\u00b0\3\2\2\2MN\7\23\2\2NO\7"+
		"\16\2\2OP\5\n\6\2PT\b\6\1\2QR\5\n\6\2RS\b\6\1\2SU\3\2\2\2TQ\3\2\2\2UV"+
		"\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\24\2\2Y\u00b0\3\2\2\2Z[\7\23"+
		"\2\2[\\\7\17\2\2\\]\5\n\6\2]a\b\6\1\2^_\5\n\6\2_`\b\6\1\2`b\3\2\2\2a^"+
		"\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\24\2\2f\u00b0\3\2"+
		"\2\2gh\7\23\2\2hi\7\13\2\2ij\7\23\2\2jk\5\20\t\2kl\7\24\2\2lm\5\n\6\2"+
		"mn\7\24\2\2no\b\6\1\2o\u00b0\3\2\2\2pq\7\23\2\2qr\7\f\2\2rs\7\23\2\2s"+
		"t\5\20\t\2tu\7\24\2\2uv\5\n\6\2vw\7\24\2\2wx\b\6\1\2x\u00b0\3\2\2\2yz"+
		"\7\23\2\2z{\7\31\2\2{|\5\f\7\2|}\5\f\7\2}~\7\24\2\2~\177\b\6\1\2\177\u00b0"+
		"\3\2\2\2\u0080\u0081\7\23\2\2\u0081\u0082\7\32\2\2\u0082\u0083\5\f\7\2"+
		"\u0083\u0084\5\f\7\2\u0084\u0085\7\24\2\2\u0085\u0086\b\6\1\2\u0086\u00b0"+
		"\3\2\2\2\u0087\u0088\7\23\2\2\u0088\u0089\7\33\2\2\u0089\u008a\5\f\7\2"+
		"\u008a\u008b\5\f\7\2\u008b\u008c\7\24\2\2\u008c\u008d\b\6\1\2\u008d\u00b0"+
		"\3\2\2\2\u008e\u008f\7\23\2\2\u008f\u0090\7\34\2\2\u0090\u0091\5\f\7\2"+
		"\u0091\u0092\5\f\7\2\u0092\u0093\7\24\2\2\u0093\u0094\b\6\1\2\u0094\u00b0"+
		"\3\2\2\2\u0095\u0096\7\23\2\2\u0096\u0097\7\35\2\2\u0097\u0098\5\f\7\2"+
		"\u0098\u0099\5\f\7\2\u0099\u009a\7\24\2\2\u009a\u009b\b\6\1\2\u009b\u00b0"+
		"\3\2\2\2\u009c\u009d\7\23\2\2\u009d\u009e\7\20\2\2\u009e\u009f\5\f\7\2"+
		"\u009f\u00a0\5\f\7\2\u00a0\u00a1\7\24\2\2\u00a1\u00a2\b\6\1\2\u00a2\u00b0"+
		"\3\2\2\2\u00a3\u00a4\7\21\2\2\u00a4\u00b0\b\6\1\2\u00a5\u00a6\7\23\2\2"+
		"\u00a6\u00a7\7\21\2\2\u00a7\u00aa\b\6\1\2\u00a8\u00a9\7\21\2\2\u00a9\u00ab"+
		"\b\6\1\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\7\24\2\2\u00afC\3\2\2\2"+
		"\u00afE\3\2\2\2\u00afG\3\2\2\2\u00afM\3\2\2\2\u00afZ\3\2\2\2\u00afg\3"+
		"\2\2\2\u00afp\3\2\2\2\u00afy\3\2\2\2\u00af\u0080\3\2\2\2\u00af\u0087\3"+
		"\2\2\2\u00af\u008e\3\2\2\2\u00af\u0095\3\2\2\2\u00af\u009c\3\2\2\2\u00af"+
		"\u00a3\3\2\2\2\u00af\u00a5\3\2\2\2\u00b0\13\3\2\2\2\u00b1\u00b2\7\22\2"+
		"\2\u00b2\u00de\b\7\1\2\u00b3\u00b4\7\23\2\2\u00b4\u00b5\7\25\2\2\u00b5"+
		"\u00b6\5\f\7\2\u00b6\u00ba\b\7\1\2\u00b7\u00b8\5\f\7\2\u00b8\u00b9\b\7"+
		"\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\24"+
		"\2\2\u00bf\u00de\3\2\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7\27\2\2\u00c2"+
		"\u00c3\5\f\7\2\u00c3\u00c7\b\7\1\2\u00c4\u00c5\5\f\7\2\u00c5\u00c6\b\7"+
		"\1\2\u00c6\u00c8\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7\24"+
		"\2\2\u00cc\u00de\3\2\2\2\u00cd\u00ce\7\23\2\2\u00ce\u00cf\7\26\2\2\u00cf"+
		"\u00d0\5\f\7\2\u00d0\u00d1\5\f\7\2\u00d1\u00d2\7\24\2\2\u00d2\u00d3\b"+
		"\7\1\2\u00d3\u00de\3\2\2\2\u00d4\u00d5\7\23\2\2\u00d5\u00d6\7\30\2\2\u00d6"+
		"\u00d7\5\f\7\2\u00d7\u00d8\5\f\7\2\u00d8\u00d9\7\24\2\2\u00d9\u00da\b"+
		"\7\1\2\u00da\u00de\3\2\2\2\u00db\u00dc\7\21\2\2\u00dc\u00de\b\7\1\2\u00dd"+
		"\u00b1\3\2\2\2\u00dd\u00b3\3\2\2\2\u00dd\u00c0\3\2\2\2\u00dd\u00cd\3\2"+
		"\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\r\3\2\2\2\u00df\u00e0"+
		"\7\21\2\2\u00e0\u00e5\b\b\1\2\u00e1\u00e2\7\21\2\2\u00e2\u00e4\b\b\1\2"+
		"\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\17\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ee\b\t\1\2\u00e9"+
		"\u00ea\5\22\n\2\u00ea\u00eb\b\t\1\2\u00eb\u00ed\3\2\2\2\u00ec\u00e9\3"+
		"\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\21\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\23\2\2\u00f2\u00f3\7\21"+
		"\2\2\u00f3\u00f4\5\24\13\2\u00f4\u00f5\7\24\2\2\u00f5\u00f6\b\n\1\2\u00f6"+
		"\23\3\2\2\2\u00f7\u00f8\7\t\2\2\u00f8\u00fc\b\13\1\2\u00f9\u00fa\7\n\2"+
		"\2\u00fa\u00fc\b\13\1\2\u00fb\u00f7\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\25\3\2\2\2\u00fd\u00fe\7\23\2\2\u00fe\u00ff\7\21\2\2\u00ff\u0100\7\23"+
		"\2\2\u0100\u0101\5\20\t\2\u0101\u0102\7\24\2\2\u0102\u0103\7\24\2\2\u0103"+
		"\u0104\b\f\1\2\u0104\27\3\2\2\2\16%\'Vc\u00ac\u00af\u00bc\u00c9\u00dd"+
		"\u00e5\u00ee\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}