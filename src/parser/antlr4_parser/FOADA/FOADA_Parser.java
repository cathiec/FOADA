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

import java.util.*;
import structure.*;
import structure.Transition;
import structure.Expression.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import exception.FinalRedundancyException;
import exception.InitialRedundancyException;

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
		FORALL=10, NOT=11, AND=12, OR=13, DISTINCT=14, ID=15, INTEGER=16, LP=17, 
		RP=18, PLUS=19, MINUS=20, TIMES=21, SLASH=22, GT=23, LT=24, GEQ=25, LEQ=26, 
		EQUALS=27, WS=28, COMMENT=29;
	public static final int
		RULE_automaton = 0, RULE_initial_def = 1, RULE_list_finals_def = 2, RULE_transition_def = 3, 
		RULE_expr = 4, RULE_list_finals = 5, RULE_list_arguments = 6, RULE_type = 7;
	public static final String[] ruleNames = {
		"automaton", "initial_def", "list_finals_def", "transition_def", "expr", 
		"list_finals", "list_arguments", "type"
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
			setState(16);
			match(LP);
			setState(17);
			match(DEFAUTO);
			setState(18);
			((AutomatonContext)_localctx).ID = match(ID);

					((AutomatonContext)_localctx).tree =  new Automaton((((AutomatonContext)_localctx).ID!=null?((AutomatonContext)_localctx).ID.getText():null));
				
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(29);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(20);
					((AutomatonContext)_localctx).initial_def = initial_def();

								_localctx.tree.setInitial(((AutomatonContext)_localctx).initial_def.tree);
							
					}
					break;
				case 2:
					{
					setState(23);
					((AutomatonContext)_localctx).list_finals_def = list_finals_def();

								_localctx.tree.setFinals(((AutomatonContext)_localctx).list_finals_def.tree);
							
					}
					break;
				case 3:
					{
					setState(26);
					((AutomatonContext)_localctx).transition_def = transition_def();

								_localctx.tree.addTransition(((AutomatonContext)_localctx).transition_def.tree);
							
					}
					break;
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class Initial_defContext extends ParserRuleContext {
		public Expression tree;
		public ExprContext expr;
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode INIT() { return getToken(FOADA_Parser.INIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(37);
			match(LP);
			setState(38);
			match(INIT);
			setState(39);
			((Initial_defContext)_localctx).expr = expr();

					((Initial_defContext)_localctx).tree =  ((Initial_defContext)_localctx).expr.tree;
				
			setState(41);
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
			setState(43);
			match(LP);
			setState(44);
			match(FINAL);
			setState(45);
			match(LP);
			setState(46);
			((List_finals_defContext)_localctx).list_finals = list_finals();

					((List_finals_defContext)_localctx).tree =  ((List_finals_defContext)_localctx).list_finals.tree;
				
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

	public static class Transition_defContext extends ParserRuleContext {
		public Transition tree;
		public Token from;
		public List_argumentsContext argFrom;
		public Token event;
		public List_argumentsContext argEvent;
		public ExprContext expr;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode TRANS() { return getToken(FOADA_Parser.TRANS, 0); }
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public List<List_argumentsContext> list_arguments() {
			return getRuleContexts(List_argumentsContext.class);
		}
		public List_argumentsContext list_arguments(int i) {
			return getRuleContext(List_argumentsContext.class,i);
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
			setState(51);
			match(LP);
			setState(52);
			match(TRANS);
			setState(53);
			match(LP);
			setState(54);
			((Transition_defContext)_localctx).from = match(ID);
			setState(55);
			match(LP);
			setState(56);
			((Transition_defContext)_localctx).argFrom = list_arguments();
			setState(57);
			match(RP);
			setState(58);
			match(RP);
			setState(59);
			match(LP);
			setState(60);
			((Transition_defContext)_localctx).event = match(ID);
			setState(61);
			match(LP);
			setState(62);
			((Transition_defContext)_localctx).argEvent = list_arguments();
			setState(63);
			match(RP);
			setState(64);
			match(RP);
			setState(65);
			((Transition_defContext)_localctx).expr = expr();
			setState(66);
			match(RP);

					((Transition_defContext)_localctx).tree =  new Transition((((Transition_defContext)_localctx).from!=null?((Transition_defContext)_localctx).from.getText():null), ((Transition_defContext)_localctx).argFrom.tree, (((Transition_defContext)_localctx).event!=null?((Transition_defContext)_localctx).event.getText():null), ((Transition_defContext)_localctx).argEvent.tree, ((Transition_defContext)_localctx).expr.tree);
				
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

	public static class ExprContext extends ParserRuleContext {
		public Expression tree;
		public ExprContext expr;
		public ExprContext e1;
		public ExprContext e2;
		public List_argumentsContext list_arguments;
		public Token ID;
		public Token INTEGER;
		public TerminalNode TRUE() { return getToken(FOADA_Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOADA_Parser.FALSE, 0); }
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode NOT() { return getToken(FOADA_Parser.NOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode LT() { return getToken(FOADA_Parser.LT, 0); }
		public TerminalNode GEQ() { return getToken(FOADA_Parser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(FOADA_Parser.LEQ, 0); }
		public TerminalNode EQUALS() { return getToken(FOADA_Parser.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(FOADA_Parser.DISTINCT, 0); }
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(FOADA_Parser.INTEGER, 0); }
		public TerminalNode PLUS() { return getToken(FOADA_Parser.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(FOADA_Parser.TIMES, 0); }
		public TerminalNode MINUS() { return getToken(FOADA_Parser.MINUS, 0); }
		public TerminalNode SLASH() { return getToken(FOADA_Parser.SLASH, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(TRUE);

						((ExprContext)_localctx).tree =  new Expression(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(FALSE);

						((ExprContext)_localctx).tree =  new Expression(false);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(LP);
				setState(74);
				match(NOT);
				setState(75);
				((ExprContext)_localctx).expr = expr();
				setState(76);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Not, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(LP);
				setState(80);
				match(AND);
				setState(81);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(83);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionType.And, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(90);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(LP);
				setState(93);
				match(OR);
				setState(94);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree;
					
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionType.Or, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(103);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				match(LP);
				setState(106);
				match(EXISTS);
				setState(107);
				match(LP);
				setState(108);
				((ExprContext)_localctx).list_arguments = list_arguments();
				setState(109);
				match(RP);
				setState(110);
				((ExprContext)_localctx).expr = expr();
				setState(111);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Exists, ((ExprContext)_localctx).list_arguments.tree, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				match(LP);
				setState(115);
				match(FORALL);
				setState(116);
				match(LP);
				setState(117);
				((ExprContext)_localctx).list_arguments = list_arguments();
				setState(118);
				match(RP);
				setState(119);
				((ExprContext)_localctx).expr = expr();
				setState(120);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Forall, ((ExprContext)_localctx).list_arguments.tree, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(123);
				match(LP);
				setState(124);
				match(GT);
				setState(125);
				((ExprContext)_localctx).e1 = expr();
				setState(126);
				((ExprContext)_localctx).e2 = expr();
				setState(127);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.GT, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
				match(LP);
				setState(131);
				match(LT);
				setState(132);
				((ExprContext)_localctx).e1 = expr();
				setState(133);
				((ExprContext)_localctx).e2 = expr();
				setState(134);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.LT, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(137);
				match(LP);
				setState(138);
				match(GEQ);
				setState(139);
				((ExprContext)_localctx).e1 = expr();
				setState(140);
				((ExprContext)_localctx).e2 = expr();
				setState(141);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.GEQ, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(144);
				match(LP);
				setState(145);
				match(LEQ);
				setState(146);
				((ExprContext)_localctx).e1 = expr();
				setState(147);
				((ExprContext)_localctx).e2 = expr();
				setState(148);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.LEQ, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(151);
				match(LP);
				setState(152);
				match(EQUALS);
				setState(153);
				((ExprContext)_localctx).e1 = expr();
				setState(154);
				((ExprContext)_localctx).e2 = expr();
				setState(155);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Equals, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(158);
				match(LP);
				setState(159);
				match(DISTINCT);
				setState(160);
				((ExprContext)_localctx).e1 = expr();
				setState(161);
				((ExprContext)_localctx).e2 = expr();
				setState(162);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Distinct, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(165);
				((ExprContext)_localctx).ID = match(ID);

						((ExprContext)_localctx).tree =  new Expression((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
					
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(167);
				match(LP);
				setState(168);
				((ExprContext)_localctx).ID = match(ID);

						((ExprContext)_localctx).tree =  new Expression((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
					
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(170);
					((ExprContext)_localctx).expr = expr();

							_localctx.tree.addArgument(((ExprContext)_localctx).expr.tree);
						
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(177);
				match(RP);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(179);
				((ExprContext)_localctx).INTEGER = match(INTEGER);

						((ExprContext)_localctx).tree =  new Expression(Integer.parseInt((((ExprContext)_localctx).INTEGER!=null?((ExprContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(181);
				match(LP);
				setState(182);
				match(PLUS);
				setState(183);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(185);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionType.Plus, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(192);
				match(RP);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(194);
				match(LP);
				setState(195);
				match(TIMES);
				setState(196);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(198);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionType.Times, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(203); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(205);
				match(RP);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(207);
				match(LP);
				setState(208);
				match(MINUS);
				setState(209);
				((ExprContext)_localctx).e1 = expr();
				setState(210);
				((ExprContext)_localctx).e2 = expr();
				setState(211);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Minus, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(214);
				match(LP);
				setState(215);
				match(SLASH);
				setState(216);
				((ExprContext)_localctx).e1 = expr();
				setState(217);
				((ExprContext)_localctx).e2 = expr();
				setState(218);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionType.Slash, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
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
		public Token i1;
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
		enterRule(_localctx, 10, RULE_list_finals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			((List_finalsContext)_localctx).i1 = match(ID);

					((List_finalsContext)_localctx).tree =  new ArrayList<String>();
					_localctx.tree.add((((List_finalsContext)_localctx).i1!=null?((List_finalsContext)_localctx).i1.getText():null));
				
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(225);
				((List_finalsContext)_localctx).i2 = match(ID);

						_localctx.tree.add((((List_finalsContext)_localctx).i2!=null?((List_finalsContext)_localctx).i2.getText():null));
					
				}
				}
				setState(231);
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
		public Map<String, ExpressionCategory> tree;
		public Token ID;
		public TypeContext type;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
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
		enterRule(_localctx, 12, RULE_list_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_argumentsContext)_localctx).tree =  new HashMap<String, ExpressionCategory>();
				
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(233);
				match(LP);
				setState(234);
				((List_argumentsContext)_localctx).ID = match(ID);
				setState(235);
				((List_argumentsContext)_localctx).type = type();
				setState(236);
				match(RP);

						_localctx.tree.put((((List_argumentsContext)_localctx).ID!=null?((List_argumentsContext)_localctx).ID.getText():null), ((List_argumentsContext)_localctx).type.tree);
					
				}
				}
				setState(243);
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
		public ExpressionCategory tree;
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
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(INT);

						((TypeContext)_localctx).tree =  ExpressionCategory.Integer;
					
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(BOOL);

						((TypeContext)_localctx).tree =  ExpressionCategory.Boolean;
					
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00fd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6Y\n\6"+
		"\r\6\16\6Z\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6f\n\6\r\6\16\6g\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6"+
		"\u00b0\n\6\r\6\16\6\u00b1\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\6\6\u00bf\n\6\r\6\16\6\u00c0\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6"+
		"\u00cc\n\6\r\6\16\6\u00cd\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6\u00e0\n\6\3\7\3\7\3\7\3\7\7\7\u00e6\n\7\f\7\16"+
		"\7\u00e9\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f2\n\b\f\b\16\b\u00f5"+
		"\13\b\3\t\3\t\3\t\3\t\5\t\u00fb\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2"+
		"\u0112\2\22\3\2\2\2\4\'\3\2\2\2\6-\3\2\2\2\b\65\3\2\2\2\n\u00df\3\2\2"+
		"\2\f\u00e1\3\2\2\2\16\u00ea\3\2\2\2\20\u00fa\3\2\2\2\22\23\7\23\2\2\23"+
		"\24\7\3\2\2\24\25\7\21\2\2\25!\b\2\1\2\26\27\5\4\3\2\27\30\b\2\1\2\30"+
		" \3\2\2\2\31\32\5\6\4\2\32\33\b\2\1\2\33 \3\2\2\2\34\35\5\b\5\2\35\36"+
		"\b\2\1\2\36 \3\2\2\2\37\26\3\2\2\2\37\31\3\2\2\2\37\34\3\2\2\2 #\3\2\2"+
		"\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\24\2\2%&\7\2\2\3&\3"+
		"\3\2\2\2\'(\7\23\2\2()\7\4\2\2)*\5\n\6\2*+\b\3\1\2+,\7\24\2\2,\5\3\2\2"+
		"\2-.\7\23\2\2./\7\5\2\2/\60\7\23\2\2\60\61\5\f\7\2\61\62\b\4\1\2\62\63"+
		"\7\24\2\2\63\64\7\24\2\2\64\7\3\2\2\2\65\66\7\23\2\2\66\67\7\6\2\2\67"+
		"8\7\23\2\289\7\21\2\29:\7\23\2\2:;\5\16\b\2;<\7\24\2\2<=\7\24\2\2=>\7"+
		"\23\2\2>?\7\21\2\2?@\7\23\2\2@A\5\16\b\2AB\7\24\2\2BC\7\24\2\2CD\5\n\6"+
		"\2DE\7\24\2\2EF\b\5\1\2F\t\3\2\2\2GH\7\7\2\2H\u00e0\b\6\1\2IJ\7\b\2\2"+
		"J\u00e0\b\6\1\2KL\7\23\2\2LM\7\r\2\2MN\5\n\6\2NO\7\24\2\2OP\b\6\1\2P\u00e0"+
		"\3\2\2\2QR\7\23\2\2RS\7\16\2\2ST\5\n\6\2TX\b\6\1\2UV\5\n\6\2VW\b\6\1\2"+
		"WY\3\2\2\2XU\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\24"+
		"\2\2]\u00e0\3\2\2\2^_\7\23\2\2_`\7\17\2\2`a\5\n\6\2ae\b\6\1\2bc\5\n\6"+
		"\2cd\b\6\1\2df\3\2\2\2eb\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2"+
		"\2ij\7\24\2\2j\u00e0\3\2\2\2kl\7\23\2\2lm\7\13\2\2mn\7\23\2\2no\5\16\b"+
		"\2op\7\24\2\2pq\5\n\6\2qr\7\24\2\2rs\b\6\1\2s\u00e0\3\2\2\2tu\7\23\2\2"+
		"uv\7\f\2\2vw\7\23\2\2wx\5\16\b\2xy\7\24\2\2yz\5\n\6\2z{\7\24\2\2{|\b\6"+
		"\1\2|\u00e0\3\2\2\2}~\7\23\2\2~\177\7\31\2\2\177\u0080\5\n\6\2\u0080\u0081"+
		"\5\n\6\2\u0081\u0082\7\24\2\2\u0082\u0083\b\6\1\2\u0083\u00e0\3\2\2\2"+
		"\u0084\u0085\7\23\2\2\u0085\u0086\7\32\2\2\u0086\u0087\5\n\6\2\u0087\u0088"+
		"\5\n\6\2\u0088\u0089\7\24\2\2\u0089\u008a\b\6\1\2\u008a\u00e0\3\2\2\2"+
		"\u008b\u008c\7\23\2\2\u008c\u008d\7\33\2\2\u008d\u008e\5\n\6\2\u008e\u008f"+
		"\5\n\6\2\u008f\u0090\7\24\2\2\u0090\u0091\b\6\1\2\u0091\u00e0\3\2\2\2"+
		"\u0092\u0093\7\23\2\2\u0093\u0094\7\34\2\2\u0094\u0095\5\n\6\2\u0095\u0096"+
		"\5\n\6\2\u0096\u0097\7\24\2\2\u0097\u0098\b\6\1\2\u0098\u00e0\3\2\2\2"+
		"\u0099\u009a\7\23\2\2\u009a\u009b\7\35\2\2\u009b\u009c\5\n\6\2\u009c\u009d"+
		"\5\n\6\2\u009d\u009e\7\24\2\2\u009e\u009f\b\6\1\2\u009f\u00e0\3\2\2\2"+
		"\u00a0\u00a1\7\23\2\2\u00a1\u00a2\7\20\2\2\u00a2\u00a3\5\n\6\2\u00a3\u00a4"+
		"\5\n\6\2\u00a4\u00a5\7\24\2\2\u00a5\u00a6\b\6\1\2\u00a6\u00e0\3\2\2\2"+
		"\u00a7\u00a8\7\21\2\2\u00a8\u00e0\b\6\1\2\u00a9\u00aa\7\23\2\2\u00aa\u00ab"+
		"\7\21\2\2\u00ab\u00af\b\6\1\2\u00ac\u00ad\5\n\6\2\u00ad\u00ae\b\6\1\2"+
		"\u00ae\u00b0\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\24\2\2"+
		"\u00b4\u00e0\3\2\2\2\u00b5\u00b6\7\22\2\2\u00b6\u00e0\b\6\1\2\u00b7\u00b8"+
		"\7\23\2\2\u00b8\u00b9\7\25\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00be\b\6\1\2"+
		"\u00bb\u00bc\5\n\6\2\u00bc\u00bd\b\6\1\2\u00bd\u00bf\3\2\2\2\u00be\u00bb"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\7\24\2\2\u00c3\u00e0\3\2\2\2\u00c4\u00c5\7"+
		"\23\2\2\u00c5\u00c6\7\27\2\2\u00c6\u00c7\5\n\6\2\u00c7\u00cb\b\6\1\2\u00c8"+
		"\u00c9\5\n\6\2\u00c9\u00ca\b\6\1\2\u00ca\u00cc\3\2\2\2\u00cb\u00c8\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\24\2\2\u00d0\u00e0\3\2\2\2\u00d1\u00d2\7"+
		"\23\2\2\u00d2\u00d3\7\26\2\2\u00d3\u00d4\5\n\6\2\u00d4\u00d5\5\n\6\2\u00d5"+
		"\u00d6\7\24\2\2\u00d6\u00d7\b\6\1\2\u00d7\u00e0\3\2\2\2\u00d8\u00d9\7"+
		"\23\2\2\u00d9\u00da\7\30\2\2\u00da\u00db\5\n\6\2\u00db\u00dc\5\n\6\2\u00dc"+
		"\u00dd\7\24\2\2\u00dd\u00de\b\6\1\2\u00de\u00e0\3\2\2\2\u00dfG\3\2\2\2"+
		"\u00dfI\3\2\2\2\u00dfK\3\2\2\2\u00dfQ\3\2\2\2\u00df^\3\2\2\2\u00dfk\3"+
		"\2\2\2\u00dft\3\2\2\2\u00df}\3\2\2\2\u00df\u0084\3\2\2\2\u00df\u008b\3"+
		"\2\2\2\u00df\u0092\3\2\2\2\u00df\u0099\3\2\2\2\u00df\u00a0\3\2\2\2\u00df"+
		"\u00a7\3\2\2\2\u00df\u00a9\3\2\2\2\u00df\u00b5\3\2\2\2\u00df\u00b7\3\2"+
		"\2\2\u00df\u00c4\3\2\2\2\u00df\u00d1\3\2\2\2\u00df\u00d8\3\2\2\2\u00e0"+
		"\13\3\2\2\2\u00e1\u00e2\7\21\2\2\u00e2\u00e7\b\7\1\2\u00e3\u00e4\7\21"+
		"\2\2\u00e4\u00e6\b\7\1\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\r\3\2\2\2\u00e9\u00e7\3\2\2\2"+
		"\u00ea\u00f3\b\b\1\2\u00eb\u00ec\7\23\2\2\u00ec\u00ed\7\21\2\2\u00ed\u00ee"+
		"\5\20\t\2\u00ee\u00ef\7\24\2\2\u00ef\u00f0\b\b\1\2\u00f0\u00f2\3\2\2\2"+
		"\u00f1\u00eb\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\17\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7\t\2\2\u00f7"+
		"\u00fb\b\t\1\2\u00f8\u00f9\7\n\2\2\u00f9\u00fb\b\t\1\2\u00fa\u00f6\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fb\21\3\2\2\2\r\37!Zg\u00b1\u00c0\u00cd\u00df"+
		"\u00e7\u00f3\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}