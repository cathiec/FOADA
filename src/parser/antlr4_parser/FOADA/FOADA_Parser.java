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
import exception.*;

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
		DEFAUTO=1, EVENT=2, VAR=3, PRED=4, INIT=5, FINAL=6, TRANS=7, TRUE=8, FALSE=9, 
		INT=10, BOOL=11, EXISTS=12, FORALL=13, NOT=14, AND=15, OR=16, DISTINCT=17, 
		ID=18, INTEGER=19, LP=20, RP=21, PLUS=22, MINUS=23, TIMES=24, SLASH=25, 
		GT=26, LT=27, GEQ=28, LEQ=29, EQUALS=30, WS=31, COMMENT=32;
	public static final int
		RULE_automaton = 0, RULE_event_def = 1, RULE_var_def = 2, RULE_pred_def = 3, 
		RULE_init_def = 4, RULE_final_def = 5, RULE_trans_def = 6, RULE_list_events = 7, 
		RULE_list_types = 8, RULE_list_predicates = 9, RULE_list_finals = 10, 
		RULE_list_arguments = 11, RULE_type = 12, RULE_expr = 13;
	public static final String[] ruleNames = {
		"automaton", "event_def", "var_def", "pred_def", "init_def", "final_def", 
		"trans_def", "list_events", "list_types", "list_predicates", "list_finals", 
		"list_arguments", "type", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'event'", "'var'", "'pred'", "'init'", "'final'", 
		"'trans'", "'true'", "'false'", "'Int'", "'Bool'", "'exists'", "'forall'", 
		"'not'", "'and'", "'or'", "'distinct'", null, null, "'('", "')'", "'+'", 
		"'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "EVENT", "VAR", "PRED", "INIT", "FINAL", "TRANS", "TRUE", 
		"FALSE", "INT", "BOOL", "EXISTS", "FORALL", "NOT", "AND", "OR", "DISTINCT", 
		"ID", "INTEGER", "LP", "RP", "PLUS", "MINUS", "TIMES", "SLASH", "GT", 
		"LT", "GEQ", "LEQ", "EQUALS", "WS", "COMMENT"
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
		public Event_defContext event_def;
		public Var_defContext var_def;
		public Pred_defContext pred_def;
		public Init_defContext init_def;
		public Final_defContext final_def;
		public Trans_defContext trans_def;
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode DEFAUTO() { return getToken(FOADA_Parser.DEFAUTO, 0); }
		public TerminalNode ID() { return getToken(FOADA_Parser.ID, 0); }
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public TerminalNode EOF() { return getToken(FOADA_Parser.EOF, 0); }
		public List<Event_defContext> event_def() {
			return getRuleContexts(Event_defContext.class);
		}
		public Event_defContext event_def(int i) {
			return getRuleContext(Event_defContext.class,i);
		}
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<Pred_defContext> pred_def() {
			return getRuleContexts(Pred_defContext.class);
		}
		public Pred_defContext pred_def(int i) {
			return getRuleContext(Pred_defContext.class,i);
		}
		public List<Init_defContext> init_def() {
			return getRuleContexts(Init_defContext.class);
		}
		public Init_defContext init_def(int i) {
			return getRuleContext(Init_defContext.class,i);
		}
		public List<Final_defContext> final_def() {
			return getRuleContexts(Final_defContext.class);
		}
		public Final_defContext final_def(int i) {
			return getRuleContext(Final_defContext.class,i);
		}
		public List<Trans_defContext> trans_def() {
			return getRuleContexts(Trans_defContext.class);
		}
		public Trans_defContext trans_def(int i) {
			return getRuleContext(Trans_defContext.class,i);
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

	public final AutomatonContext automaton() throws FOADAException, RecognitionException {
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
			((AutomatonContext)_localctx).ID = match(ID);

					((AutomatonContext)_localctx).tree =  new Automaton((((AutomatonContext)_localctx).ID!=null?((AutomatonContext)_localctx).ID.getText():null));
				
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					((AutomatonContext)_localctx).event_def = event_def();

								_localctx.tree.setEvents(((AutomatonContext)_localctx).event_def.tree);
							
					}
					break;
				case 2:
					{
					setState(35);
					((AutomatonContext)_localctx).var_def = var_def();

								_localctx.tree.setVariables(((AutomatonContext)_localctx).var_def.tree);
							
					}
					break;
				case 3:
					{
					setState(38);
					((AutomatonContext)_localctx).pred_def = pred_def();

								_localctx.tree.setPredicates(((AutomatonContext)_localctx).pred_def.tree);
							
					}
					break;
				case 4:
					{
					setState(41);
					((AutomatonContext)_localctx).init_def = init_def();

								_localctx.tree.setInitial(((AutomatonContext)_localctx).init_def.tree);
							
					}
					break;
				case 5:
					{
					setState(44);
					((AutomatonContext)_localctx).final_def = final_def();

								_localctx.tree.setFinals(((AutomatonContext)_localctx).final_def.tree);
							
					}
					break;
				case 6:
					{
					setState(47);
					((AutomatonContext)_localctx).trans_def = trans_def();

								_localctx.tree.addTransition(((AutomatonContext)_localctx).trans_def.tree);
							
					}
					break;
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(RP);
			setState(56);
			match(EOF);

					_localctx.tree.finishType();
				
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

	public static class Event_defContext extends ParserRuleContext {
		public List<String> tree;
		public List_eventsContext list_events;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode EVENT() { return getToken(FOADA_Parser.EVENT, 0); }
		public List_eventsContext list_events() {
			return getRuleContext(List_eventsContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public Event_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterEvent_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitEvent_def(this);
		}
	}

	public final Event_defContext event_def() throws RecognitionException {
		Event_defContext _localctx = new Event_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_event_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LP);
			setState(60);
			match(EVENT);
			setState(61);
			match(LP);
			setState(62);
			((Event_defContext)_localctx).list_events = list_events();
			setState(63);
			match(RP);
			setState(64);
			match(RP);

					((Event_defContext)_localctx).tree =  ((Event_defContext)_localctx).list_events.tree;
				
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

	public static class Var_defContext extends ParserRuleContext {
		public List<ExpressionType> tree;
		public List_typesContext list_types;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode VAR() { return getToken(FOADA_Parser.VAR, 0); }
		public List_typesContext list_types() {
			return getRuleContext(List_typesContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterVar_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitVar_def(this);
		}
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LP);
			setState(68);
			match(VAR);
			setState(69);
			match(LP);
			setState(70);
			((Var_defContext)_localctx).list_types = list_types();
			setState(71);
			match(RP);
			setState(72);
			match(RP);

					((Var_defContext)_localctx).tree =  ((Var_defContext)_localctx).list_types.tree;
				
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

	public static class Pred_defContext extends ParserRuleContext {
		public Map<String, List<ExpressionType>> tree;
		public List_predicatesContext list_predicates;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public TerminalNode PRED() { return getToken(FOADA_Parser.PRED, 0); }
		public List_predicatesContext list_predicates() {
			return getRuleContext(List_predicatesContext.class,0);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public Pred_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterPred_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitPred_def(this);
		}
	}

	public final Pred_defContext pred_def() throws RecognitionException {
		Pred_defContext _localctx = new Pred_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pred_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LP);
			setState(76);
			match(PRED);
			setState(77);
			match(LP);
			setState(78);
			((Pred_defContext)_localctx).list_predicates = list_predicates();
			setState(79);
			match(RP);
			setState(80);
			match(RP);

					((Pred_defContext)_localctx).tree =  ((Pred_defContext)_localctx).list_predicates.tree;
				
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

	public static class Init_defContext extends ParserRuleContext {
		public Expression tree;
		public ExprContext expr;
		public TerminalNode LP() { return getToken(FOADA_Parser.LP, 0); }
		public TerminalNode INIT() { return getToken(FOADA_Parser.INIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(FOADA_Parser.RP, 0); }
		public Init_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterInit_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitInit_def(this);
		}
	}

	public final Init_defContext init_def() throws RecognitionException {
		Init_defContext _localctx = new Init_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_init_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(LP);
			setState(84);
			match(INIT);
			setState(85);
			((Init_defContext)_localctx).expr = expr();
			setState(86);
			match(RP);

					((Init_defContext)_localctx).tree =  ((Init_defContext)_localctx).expr.tree;
				
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

	public static class Final_defContext extends ParserRuleContext {
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
		public Final_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterFinal_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitFinal_def(this);
		}
	}

	public final Final_defContext final_def() throws RecognitionException {
		Final_defContext _localctx = new Final_defContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_final_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(LP);
			setState(90);
			match(FINAL);
			setState(91);
			match(LP);
			setState(92);
			((Final_defContext)_localctx).list_finals = list_finals();
			setState(93);
			match(RP);
			setState(94);
			match(RP);

					((Final_defContext)_localctx).tree =  ((Final_defContext)_localctx).list_finals.tree;
				
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

	public static class Trans_defContext extends ParserRuleContext {
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
		public Trans_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trans_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterTrans_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitTrans_def(this);
		}
	}

	public final Trans_defContext trans_def() throws RecognitionException {
		Trans_defContext _localctx = new Trans_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_trans_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(LP);
			setState(98);
			match(TRANS);
			setState(99);
			match(LP);
			setState(100);
			((Trans_defContext)_localctx).from = match(ID);
			setState(101);
			match(LP);
			setState(102);
			((Trans_defContext)_localctx).argFrom = list_arguments();
			setState(103);
			match(RP);
			setState(104);
			match(RP);
			setState(105);
			match(LP);
			setState(106);
			((Trans_defContext)_localctx).event = match(ID);
			setState(107);
			match(LP);
			setState(108);
			((Trans_defContext)_localctx).argEvent = list_arguments();
			setState(109);
			match(RP);
			setState(110);
			match(RP);
			setState(111);
			((Trans_defContext)_localctx).expr = expr();
			setState(112);
			match(RP);

					((Trans_defContext)_localctx).tree =  new Transition((((Trans_defContext)_localctx).from!=null?((Trans_defContext)_localctx).from.getText():null), ((Trans_defContext)_localctx).argFrom.tree, (((Trans_defContext)_localctx).event!=null?((Trans_defContext)_localctx).event.getText():null), ((Trans_defContext)_localctx).argEvent.tree, ((Trans_defContext)_localctx).expr.tree);
				
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

	public static class List_eventsContext extends ParserRuleContext {
		public List<String> tree;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public List_eventsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_events; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_events(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_events(this);
		}
	}

	public final List_eventsContext list_events() throws RecognitionException {
		List_eventsContext _localctx = new List_eventsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list_events);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_eventsContext)_localctx).tree =  new ArrayList<String>();
				
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(116);
				((List_eventsContext)_localctx).ID = match(ID);

						_localctx.tree.add((((List_eventsContext)_localctx).ID!=null?((List_eventsContext)_localctx).ID.getText():null));
					
				}
				}
				setState(122);
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

	public static class List_typesContext extends ParserRuleContext {
		public List<ExpressionType> tree;
		public TypeContext type;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_types(this);
		}
	}

	public final List_typesContext list_types() throws RecognitionException {
		List_typesContext _localctx = new List_typesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_list_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_typesContext)_localctx).tree =  new ArrayList<ExpressionType>();
				
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==BOOL) {
				{
				{
				setState(124);
				((List_typesContext)_localctx).type = type();

						_localctx.tree.add(((List_typesContext)_localctx).type.tree);
					
				}
				}
				setState(131);
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

	public static class List_predicatesContext extends ParserRuleContext {
		public Map<String, List<ExpressionType>> tree;
		public Token ID;
		public List_typesContext list_types;
		public List<TerminalNode> LP() { return getTokens(FOADA_Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(FOADA_Parser.LP, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOADA_Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOADA_Parser.ID, i);
		}
		public List<List_typesContext> list_types() {
			return getRuleContexts(List_typesContext.class);
		}
		public List_typesContext list_types(int i) {
			return getRuleContext(List_typesContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(FOADA_Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(FOADA_Parser.RP, i);
		}
		public List_predicatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_predicates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).enterList_predicates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOADA_ParserListener ) ((FOADA_ParserListener)listener).exitList_predicates(this);
		}
	}

	public final List_predicatesContext list_predicates() throws RecognitionException {
		List_predicatesContext _localctx = new List_predicatesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_list_predicates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_predicatesContext)_localctx).tree =  new LinkedHashMap<String, List<ExpressionType>>();
				
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(133);
				match(LP);
				setState(134);
				((List_predicatesContext)_localctx).ID = match(ID);
				setState(135);
				match(LP);
				setState(136);
				((List_predicatesContext)_localctx).list_types = list_types();
				setState(137);
				match(RP);
				setState(138);
				match(RP);

						_localctx.tree.put((((List_predicatesContext)_localctx).ID!=null?((List_predicatesContext)_localctx).ID.getText():null), ((List_predicatesContext)_localctx).list_types.tree);
					
				}
				}
				setState(145);
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

	public static class List_finalsContext extends ParserRuleContext {
		public List<String> tree;
		public Token ID;
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
		enterRule(_localctx, 20, RULE_list_finals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_finalsContext)_localctx).tree =  new ArrayList<String>();
				
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(147);
				((List_finalsContext)_localctx).ID = match(ID);

						_localctx.tree.add((((List_finalsContext)_localctx).ID!=null?((List_finalsContext)_localctx).ID.getText():null));
					
				}
				}
				setState(153);
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
		public Map<String, ExpressionType> tree;
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
		enterRule(_localctx, 22, RULE_list_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					((List_argumentsContext)_localctx).tree =  new LinkedHashMap<String, ExpressionType>();
				
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(155);
				match(LP);
				setState(156);
				((List_argumentsContext)_localctx).ID = match(ID);
				setState(157);
				((List_argumentsContext)_localctx).type = type();
				setState(158);
				match(RP);

						_localctx.tree.put((((List_argumentsContext)_localctx).ID!=null?((List_argumentsContext)_localctx).ID.getText():null), ((List_argumentsContext)_localctx).type.tree);
					
				}
				}
				setState(165);
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
		public ExpressionType tree;
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
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(INT);

						((TypeContext)_localctx).tree =  ExpressionType.Integer;
					
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(BOOL);

						((TypeContext)_localctx).tree =  ExpressionType.Boolean;
					
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
		enterRule(_localctx, 26, RULE_expr);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(TRUE);

						((ExprContext)_localctx).tree =  new Expression(true);
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(FALSE);

						((ExprContext)_localctx).tree =  new Expression(false);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(LP);
				setState(177);
				match(NOT);
				setState(178);
				((ExprContext)_localctx).expr = expr();
				setState(179);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Not, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(LP);
				setState(183);
				match(AND);
				setState(184);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.And, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(191); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(193);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(195);
				match(LP);
				setState(196);
				match(OR);
				setState(197);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree;
					
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(199);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Or, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(204); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(206);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(208);
				match(LP);
				setState(209);
				match(EXISTS);
				setState(210);
				match(LP);
				setState(211);
				((ExprContext)_localctx).list_arguments = list_arguments();
				setState(212);
				match(RP);
				setState(213);
				((ExprContext)_localctx).expr = expr();
				setState(214);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Exists, ((ExprContext)_localctx).list_arguments.tree, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(217);
				match(LP);
				setState(218);
				match(FORALL);
				setState(219);
				match(LP);
				setState(220);
				((ExprContext)_localctx).list_arguments = list_arguments();
				setState(221);
				match(RP);
				setState(222);
				((ExprContext)_localctx).expr = expr();
				setState(223);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Forall, ((ExprContext)_localctx).list_arguments.tree, ((ExprContext)_localctx).expr.tree);
					
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(226);
				match(LP);
				setState(227);
				match(GT);
				setState(228);
				((ExprContext)_localctx).e1 = expr();
				setState(229);
				((ExprContext)_localctx).e2 = expr();
				setState(230);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.GT, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(233);
				match(LP);
				setState(234);
				match(LT);
				setState(235);
				((ExprContext)_localctx).e1 = expr();
				setState(236);
				((ExprContext)_localctx).e2 = expr();
				setState(237);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.LT, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(240);
				match(LP);
				setState(241);
				match(GEQ);
				setState(242);
				((ExprContext)_localctx).e1 = expr();
				setState(243);
				((ExprContext)_localctx).e2 = expr();
				setState(244);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.GEQ, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(247);
				match(LP);
				setState(248);
				match(LEQ);
				setState(249);
				((ExprContext)_localctx).e1 = expr();
				setState(250);
				((ExprContext)_localctx).e2 = expr();
				setState(251);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.LEQ, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(254);
				match(LP);
				setState(255);
				match(EQUALS);
				setState(256);
				((ExprContext)_localctx).e1 = expr();
				setState(257);
				((ExprContext)_localctx).e2 = expr();
				setState(258);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Equals, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(261);
				match(LP);
				setState(262);
				match(DISTINCT);
				setState(263);
				((ExprContext)_localctx).e1 = expr();
				setState(264);
				((ExprContext)_localctx).e2 = expr();
				setState(265);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Distinct, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(268);
				((ExprContext)_localctx).ID = match(ID);

						((ExprContext)_localctx).tree =  new Expression((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
					
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(270);
				match(LP);
				setState(271);
				((ExprContext)_localctx).ID = match(ID);

						((ExprContext)_localctx).tree =  new Expression((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
					
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(273);
					((ExprContext)_localctx).expr = expr();

							_localctx.tree.addArgument(((ExprContext)_localctx).expr.tree);
						
					}
					}
					setState(278); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(280);
				match(RP);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(282);
				((ExprContext)_localctx).INTEGER = match(INTEGER);

						((ExprContext)_localctx).tree =  new Expression(Integer.parseInt((((ExprContext)_localctx).INTEGER!=null?((ExprContext)_localctx).INTEGER.getText():null)));
					
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(284);
				match(LP);
				setState(285);
				match(PLUS);
				setState(286);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(291); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(288);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Plus, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(293); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(295);
				match(RP);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(297);
				match(LP);
				setState(298);
				match(TIMES);
				setState(299);
				((ExprContext)_localctx).e1 = expr();

						((ExprContext)_localctx).tree =  ((ExprContext)_localctx).e1.tree; 
					
				setState(304); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(301);
					((ExprContext)_localctx).e2 = expr();

							((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Times, _localctx.tree, ((ExprContext)_localctx).e2.tree);
						
					}
					}
					setState(306); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << LP))) != 0) );
				setState(308);
				match(RP);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(310);
				match(LP);
				setState(311);
				match(MINUS);
				setState(312);
				((ExprContext)_localctx).e1 = expr();
				setState(313);
				((ExprContext)_localctx).e2 = expr();
				setState(314);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Minus, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(317);
				match(LP);
				setState(318);
				match(SLASH);
				setState(319);
				((ExprContext)_localctx).e1 = expr();
				setState(320);
				((ExprContext)_localctx).e2 = expr();
				setState(321);
				match(RP);

						((ExprContext)_localctx).tree =  new Expression(ExpressionSubtype.Slash, ((ExprContext)_localctx).e1.tree, ((ExprContext)_localctx).e2.tree);
					
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0149\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\65\n\2"+
		"\f\2\16\28\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\ty\n\t\f"+
		"\t\16\t|\13\t\3\n\3\n\3\n\3\n\7\n\u0082\n\n\f\n\16\n\u0085\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0090\n\13\f\13\16\13\u0093"+
		"\13\13\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u00a4\n\r\f\r\16\r\u00a7\13\r\3\16\3\16\3\16\3\16\5\16"+
		"\u00ad\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\6\17\u00c0\n\17\r\17\16\17\u00c1\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00cd\n\17\r\17\16\17\u00ce\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17"+
		"\u0117\n\17\r\17\16\17\u0118\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\6\17\u0126\n\17\r\17\16\17\u0127\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\6\17\u0133\n\17\r\17\16\17\u0134\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0147"+
		"\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2\u015e\2\36"+
		"\3\2\2\2\4=\3\2\2\2\6E\3\2\2\2\bM\3\2\2\2\nU\3\2\2\2\f[\3\2\2\2\16c\3"+
		"\2\2\2\20u\3\2\2\2\22}\3\2\2\2\24\u0086\3\2\2\2\26\u0094\3\2\2\2\30\u009c"+
		"\3\2\2\2\32\u00ac\3\2\2\2\34\u0146\3\2\2\2\36\37\7\26\2\2\37 \7\3\2\2"+
		" !\7\24\2\2!\66\b\2\1\2\"#\5\4\3\2#$\b\2\1\2$\65\3\2\2\2%&\5\6\4\2&\'"+
		"\b\2\1\2\'\65\3\2\2\2()\5\b\5\2)*\b\2\1\2*\65\3\2\2\2+,\5\n\6\2,-\b\2"+
		"\1\2-\65\3\2\2\2./\5\f\7\2/\60\b\2\1\2\60\65\3\2\2\2\61\62\5\16\b\2\62"+
		"\63\b\2\1\2\63\65\3\2\2\2\64\"\3\2\2\2\64%\3\2\2\2\64(\3\2\2\2\64+\3\2"+
		"\2\2\64.\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\679\3\2\2\28\66\3\2\2\29:\7\27\2\2:;\7\2\2\3;<\b\2\1\2<\3\3\2\2\2=>\7"+
		"\26\2\2>?\7\4\2\2?@\7\26\2\2@A\5\20\t\2AB\7\27\2\2BC\7\27\2\2CD\b\3\1"+
		"\2D\5\3\2\2\2EF\7\26\2\2FG\7\5\2\2GH\7\26\2\2HI\5\22\n\2IJ\7\27\2\2JK"+
		"\7\27\2\2KL\b\4\1\2L\7\3\2\2\2MN\7\26\2\2NO\7\6\2\2OP\7\26\2\2PQ\5\24"+
		"\13\2QR\7\27\2\2RS\7\27\2\2ST\b\5\1\2T\t\3\2\2\2UV\7\26\2\2VW\7\7\2\2"+
		"WX\5\34\17\2XY\7\27\2\2YZ\b\6\1\2Z\13\3\2\2\2[\\\7\26\2\2\\]\7\b\2\2]"+
		"^\7\26\2\2^_\5\26\f\2_`\7\27\2\2`a\7\27\2\2ab\b\7\1\2b\r\3\2\2\2cd\7\26"+
		"\2\2de\7\t\2\2ef\7\26\2\2fg\7\24\2\2gh\7\26\2\2hi\5\30\r\2ij\7\27\2\2"+
		"jk\7\27\2\2kl\7\26\2\2lm\7\24\2\2mn\7\26\2\2no\5\30\r\2op\7\27\2\2pq\7"+
		"\27\2\2qr\5\34\17\2rs\7\27\2\2st\b\b\1\2t\17\3\2\2\2uz\b\t\1\2vw\7\24"+
		"\2\2wy\b\t\1\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\21\3\2\2\2|z\3"+
		"\2\2\2}\u0083\b\n\1\2~\177\5\32\16\2\177\u0080\b\n\1\2\u0080\u0082\3\2"+
		"\2\2\u0081~\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\23\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0091\b\13\1\2\u0087"+
		"\u0088\7\26\2\2\u0088\u0089\7\24\2\2\u0089\u008a\7\26\2\2\u008a\u008b"+
		"\5\22\n\2\u008b\u008c\7\27\2\2\u008c\u008d\7\27\2\2\u008d\u008e\b\13\1"+
		"\2\u008e\u0090\3\2\2\2\u008f\u0087\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\25\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0099\b\f\1\2\u0095\u0096\7\24\2\2\u0096\u0098\b\f\1\2\u0097\u0095\3"+
		"\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\27\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a5\b\r\1\2\u009d\u009e\7\26\2"+
		"\2\u009e\u009f\7\24\2\2\u009f\u00a0\5\32\16\2\u00a0\u00a1\7\27\2\2\u00a1"+
		"\u00a2\b\r\1\2\u00a2\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00a9\7\f\2\2\u00a9\u00ad\b\16\1\2\u00aa\u00ab\7\r\2\2"+
		"\u00ab\u00ad\b\16\1\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\33"+
		"\3\2\2\2\u00ae\u00af\7\n\2\2\u00af\u0147\b\17\1\2\u00b0\u00b1\7\13\2\2"+
		"\u00b1\u0147\b\17\1\2\u00b2\u00b3\7\26\2\2\u00b3\u00b4\7\20\2\2\u00b4"+
		"\u00b5\5\34\17\2\u00b5\u00b6\7\27\2\2\u00b6\u00b7\b\17\1\2\u00b7\u0147"+
		"\3\2\2\2\u00b8\u00b9\7\26\2\2\u00b9\u00ba\7\21\2\2\u00ba\u00bb\5\34\17"+
		"\2\u00bb\u00bf\b\17\1\2\u00bc\u00bd\5\34\17\2\u00bd\u00be\b\17\1\2\u00be"+
		"\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\27\2\2\u00c4"+
		"\u0147\3\2\2\2\u00c5\u00c6\7\26\2\2\u00c6\u00c7\7\22\2\2\u00c7\u00c8\5"+
		"\34\17\2\u00c8\u00cc\b\17\1\2\u00c9\u00ca\5\34\17\2\u00ca\u00cb\b\17\1"+
		"\2\u00cb\u00cd\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\27\2\2"+
		"\u00d1\u0147\3\2\2\2\u00d2\u00d3\7\26\2\2\u00d3\u00d4\7\16\2\2\u00d4\u00d5"+
		"\7\26\2\2\u00d5\u00d6\5\30\r\2\u00d6\u00d7\7\27\2\2\u00d7\u00d8\5\34\17"+
		"\2\u00d8\u00d9\7\27\2\2\u00d9\u00da\b\17\1\2\u00da\u0147\3\2\2\2\u00db"+
		"\u00dc\7\26\2\2\u00dc\u00dd\7\17\2\2\u00dd\u00de\7\26\2\2\u00de\u00df"+
		"\5\30\r\2\u00df\u00e0\7\27\2\2\u00e0\u00e1\5\34\17\2\u00e1\u00e2\7\27"+
		"\2\2\u00e2\u00e3\b\17\1\2\u00e3\u0147\3\2\2\2\u00e4\u00e5\7\26\2\2\u00e5"+
		"\u00e6\7\34\2\2\u00e6\u00e7\5\34\17\2\u00e7\u00e8\5\34\17\2\u00e8\u00e9"+
		"\7\27\2\2\u00e9\u00ea\b\17\1\2\u00ea\u0147\3\2\2\2\u00eb\u00ec\7\26\2"+
		"\2\u00ec\u00ed\7\35\2\2\u00ed\u00ee\5\34\17\2\u00ee\u00ef\5\34\17\2\u00ef"+
		"\u00f0\7\27\2\2\u00f0\u00f1\b\17\1\2\u00f1\u0147\3\2\2\2\u00f2\u00f3\7"+
		"\26\2\2\u00f3\u00f4\7\36\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6\5\34\17"+
		"\2\u00f6\u00f7\7\27\2\2\u00f7\u00f8\b\17\1\2\u00f8\u0147\3\2\2\2\u00f9"+
		"\u00fa\7\26\2\2\u00fa\u00fb\7\37\2\2\u00fb\u00fc\5\34\17\2\u00fc\u00fd"+
		"\5\34\17\2\u00fd\u00fe\7\27\2\2\u00fe\u00ff\b\17\1\2\u00ff\u0147\3\2\2"+
		"\2\u0100\u0101\7\26\2\2\u0101\u0102\7 \2\2\u0102\u0103\5\34\17\2\u0103"+
		"\u0104\5\34\17\2\u0104\u0105\7\27\2\2\u0105\u0106\b\17\1\2\u0106\u0147"+
		"\3\2\2\2\u0107\u0108\7\26\2\2\u0108\u0109\7\23\2\2\u0109\u010a\5\34\17"+
		"\2\u010a\u010b\5\34\17\2\u010b\u010c\7\27\2\2\u010c\u010d\b\17\1\2\u010d"+
		"\u0147\3\2\2\2\u010e\u010f\7\24\2\2\u010f\u0147\b\17\1\2\u0110\u0111\7"+
		"\26\2\2\u0111\u0112\7\24\2\2\u0112\u0116\b\17\1\2\u0113\u0114\5\34\17"+
		"\2\u0114\u0115\b\17\1\2\u0115\u0117\3\2\2\2\u0116\u0113\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011b\7\27\2\2\u011b\u0147\3\2\2\2\u011c\u011d\7\25\2\2\u011d"+
		"\u0147\b\17\1\2\u011e\u011f\7\26\2\2\u011f\u0120\7\30\2\2\u0120\u0121"+
		"\5\34\17\2\u0121\u0125\b\17\1\2\u0122\u0123\5\34\17\2\u0123\u0124\b\17"+
		"\1\2\u0124\u0126\3\2\2\2\u0125\u0122\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\7\27"+
		"\2\2\u012a\u0147\3\2\2\2\u012b\u012c\7\26\2\2\u012c\u012d\7\32\2\2\u012d"+
		"\u012e\5\34\17\2\u012e\u0132\b\17\1\2\u012f\u0130\5\34\17\2\u0130\u0131"+
		"\b\17\1\2\u0131\u0133\3\2\2\2\u0132\u012f\3\2\2\2\u0133\u0134\3\2\2\2"+
		"\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\7\27\2\2\u0137\u0147\3\2\2\2\u0138\u0139\7\26\2\2\u0139\u013a\7\31\2"+
		"\2\u013a\u013b\5\34\17\2\u013b\u013c\5\34\17\2\u013c\u013d\7\27\2\2\u013d"+
		"\u013e\b\17\1\2\u013e\u0147\3\2\2\2\u013f\u0140\7\26\2\2\u0140\u0141\7"+
		"\33\2\2\u0141\u0142\5\34\17\2\u0142\u0143\5\34\17\2\u0143\u0144\7\27\2"+
		"\2\u0144\u0145\b\17\1\2\u0145\u0147\3\2\2\2\u0146\u00ae\3\2\2\2\u0146"+
		"\u00b0\3\2\2\2\u0146\u00b2\3\2\2\2\u0146\u00b8\3\2\2\2\u0146\u00c5\3\2"+
		"\2\2\u0146\u00d2\3\2\2\2\u0146\u00db\3\2\2\2\u0146\u00e4\3\2\2\2\u0146"+
		"\u00eb\3\2\2\2\u0146\u00f2\3\2\2\2\u0146\u00f9\3\2\2\2\u0146\u0100\3\2"+
		"\2\2\u0146\u0107\3\2\2\2\u0146\u010e\3\2\2\2\u0146\u0110\3\2\2\2\u0146"+
		"\u011c\3\2\2\2\u0146\u011e\3\2\2\2\u0146\u012b\3\2\2\2\u0146\u0138\3\2"+
		"\2\2\u0146\u013f\3\2\2\2\u0147\35\3\2\2\2\20\64\66z\u0083\u0091\u0099"+
		"\u00a5\u00ac\u00c1\u00ce\u0118\u0127\u0134\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}