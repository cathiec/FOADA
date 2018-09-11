// Generated from PALexerANTLR4.g4 by ANTLR 4.7.1

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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PALexerANTLR4 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, FINAL=2, NONE=3, FALSE=4, TRUE=5, FORALL=6, EXISTS=7, TL=8, TR=9, 
		AND=10, OR=11, EQUALS=12, DISTINCTS=13, ID=14, INTEGER=15, FUNCNAME=16, 
		SYMBOL=17, LP=18, RP=19, POINT=20, TWOPOINTS=21, COM=22, WS=23, COMMENT=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"START", "FINAL", "NONE", "FALSE", "TRUE", "FORALL", "EXISTS", "TL", "TR", 
		"AND", "OR", "EQUALS", "DISTINCTS", "LETTER", "DIGIT", "ID", "INTEGER", 
		"FUNCNAME", "SYMBOL", "LP", "RP", "POINT", "TWOPOINTS", "COM", "WS", "COMMENT"
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


	public PALexerANTLR4(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PALexerANTLR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 24:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00c9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\7\21|\n\21\f\21\16\21\177\13\21\3\22\3"+
		"\22\3\22\7\22\u0084\n\22\f\22\16\22\u0087\13\22\5\22\u0089\n\22\3\23\3"+
		"\23\7\23\u008d\n\23\f\23\16\23\u0090\13\23\3\23\3\23\3\23\7\23\u0095\n"+
		"\23\f\23\16\23\u0098\13\23\3\23\5\23\u009b\n\23\3\24\3\24\7\24\u009f\n"+
		"\24\f\24\16\24\u00a2\13\24\3\24\3\24\3\24\3\24\6\24\u00a8\n\24\r\24\16"+
		"\24\u00a9\3\24\5\24\u00ad\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u00c0\n\33\f\33\16"+
		"\33\u00c3\13\33\3\33\3\33\3\33\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\20#\21%\22\'\23)\24"+
		"+\25-\26/\27\61\30\63\31\65\32\3\2\t\4\2C\\c|\4\2\f\f\177\177\4\2\f\f"+
		"@@\4\2\f\f__\b\2##,-//\61\61>@aa\5\2\13\f\17\17\"\"\3\2\f\f\2\u00d4\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\3\67\3\2\2\2\5=\3\2\2\2\7C\3\2\2\2\tH\3\2\2\2\13N\3\2\2"+
		"\2\rS\3\2\2\2\17Z\3\2\2\2\21a\3\2\2\2\23e\3\2\2\2\25i\3\2\2\2\27l\3\2"+
		"\2\2\31o\3\2\2\2\33q\3\2\2\2\35t\3\2\2\2\37v\3\2\2\2!x\3\2\2\2#\u0088"+
		"\3\2\2\2%\u009a\3\2\2\2\'\u00ac\3\2\2\2)\u00ae\3\2\2\2+\u00b0\3\2\2\2"+
		"-\u00b2\3\2\2\2/\u00b4\3\2\2\2\61\u00b6\3\2\2\2\63\u00b8\3\2\2\2\65\u00bb"+
		"\3\2\2\2\678\7u\2\289\7v\2\29:\7c\2\2:;\7t\2\2;<\7v\2\2<\4\3\2\2\2=>\7"+
		"h\2\2>?\7k\2\2?@\7p\2\2@A\7c\2\2AB\7n\2\2B\6\3\2\2\2CD\7p\2\2DE\7q\2\2"+
		"EF\7p\2\2FG\7g\2\2G\b\3\2\2\2HI\7h\2\2IJ\7c\2\2JK\7n\2\2KL\7u\2\2LM\7"+
		"g\2\2M\n\3\2\2\2NO\7v\2\2OP\7t\2\2PQ\7w\2\2QR\7g\2\2R\f\3\2\2\2ST\7h\2"+
		"\2TU\7q\2\2UV\7t\2\2VW\7c\2\2WX\7n\2\2XY\7n\2\2Y\16\3\2\2\2Z[\7g\2\2["+
		"\\\7z\2\2\\]\7k\2\2]^\7u\2\2^_\7v\2\2_`\7u\2\2`\20\3\2\2\2ab\7/\2\2bc"+
		"\7/\2\2cd\7*\2\2d\22\3\2\2\2ef\7+\2\2fg\7/\2\2gh\7@\2\2h\24\3\2\2\2ij"+
		"\7\61\2\2jk\7^\2\2k\26\3\2\2\2lm\7^\2\2mn\7\61\2\2n\30\3\2\2\2op\7?\2"+
		"\2p\32\3\2\2\2qr\7#\2\2rs\7?\2\2s\34\3\2\2\2tu\t\2\2\2u\36\3\2\2\2vw\4"+
		"\62;\2w \3\2\2\2x}\5\35\17\2y|\5\35\17\2z|\5\37\20\2{y\3\2\2\2{z\3\2\2"+
		"\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\"\3\2\2\2\177}\3\2\2\2\u0080\u0089"+
		"\7\62\2\2\u0081\u0085\4\63;\2\u0082\u0084\5\37\20\2\u0083\u0082\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0081\3\2\2\2\u0089"+
		"$\3\2\2\2\u008a\u008e\7}\2\2\u008b\u008d\n\3\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0091\u009b\7\177\2\2\u0092\u0096\7>\2\2\u0093"+
		"\u0095\n\4\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\7@\2\2\u009a\u008a\3\2\2\2\u009a\u0092\3\2\2\2\u009b&\3\2\2\2\u009c"+
		"\u00a0\7]\2\2\u009d\u009f\n\5\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00ad\7_\2\2\u00a4\u00a8\5\35\17\2\u00a5\u00a8\5"+
		"\37\20\2\u00a6\u00a8\t\6\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ad\7&\2\2\u00ac\u009c\3\2\2\2\u00ac"+
		"\u00a7\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad(\3\2\2\2\u00ae\u00af\7*\2\2\u00af"+
		"*\3\2\2\2\u00b0\u00b1\7+\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7\60\2\2\u00b3"+
		".\3\2\2\2\u00b4\u00b5\7<\2\2\u00b5\60\3\2\2\2\u00b6\u00b7\7.\2\2\u00b7"+
		"\62\3\2\2\2\u00b8\u00b9\t\7\2\2\u00b9\u00ba\b\32\2\2\u00ba\64\3\2\2\2"+
		"\u00bb\u00bc\7*\2\2\u00bc\u00bd\7,\2\2\u00bd\u00c1\3\2\2\2\u00be\u00c0"+
		"\n\b\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7,"+
		"\2\2\u00c5\u00c6\7+\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\33\3\2\u00c8"+
		"\66\3\2\2\2\17\2{}\u0085\u0088\u008e\u0096\u009a\u00a0\u00a7\u00a9\u00ac"+
		"\u00c1\4\3\32\2\3\33\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}