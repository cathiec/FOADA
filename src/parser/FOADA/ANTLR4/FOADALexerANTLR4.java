// Generated from FOADALexerANTLR4.g4 by ANTLR 4.7.1

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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOADALexerANTLR4 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRED=1, EVENT=2, INITIAL=3, FINAL=4, TRANS=5, TRUE=6, FALSE=7, NOT=8, 
		AND=9, OR=10, DISTINCT=11, INT=12, BOOL=13, ITE=14, ID=15, INTEGER=16, 
		LP=17, RP=18, PLUS=19, MINUS=20, TIMES=21, SLASH=22, GT=23, LT=24, GEQ=25, 
		LEQ=26, EQUALS=27, WS=28, COMMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PRED", "EVENT", "INITIAL", "FINAL", "TRANS", "TRUE", "FALSE", "NOT", 
		"AND", "OR", "DISTINCT", "INT", "BOOL", "ITE", "LETTER", "DIGIT", "ID", 
		"INTEGER", "LP", "RP", "PLUS", "MINUS", "TIMES", "SLASH", "GT", "LT", 
		"GEQ", "LEQ", "EQUALS", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'pred'", "'event'", "'initial'", "'final'", "'trans'", "'true'", 
		"'false'", "'not'", "'and'", "'or'", "'distinct'", "'Int'", "'Bool'", 
		"'ite'", null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", 
		"'<'", "'>='", "'<='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PRED", "EVENT", "INITIAL", "FINAL", "TRANS", "TRUE", "FALSE", "NOT", 
		"AND", "OR", "DISTINCT", "INT", "BOOL", "ITE", "ID", "INTEGER", "LP", 
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


	public FOADALexerANTLR4(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOADALexerANTLR4.g4"; }

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
		case 29:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00ca\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\5\22"+
		"\u0093\n\22\3\22\3\22\3\22\7\22\u0098\n\22\f\22\16\22\u009b\13\22\3\23"+
		"\3\23\3\23\7\23\u00a0\n\23\f\23\16\23\u00a3\13\23\5\23\u00a5\n\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \7 "+
		"\u00c4\n \f \16 \u00c7\13 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\21%\22\'\23)\24+\25-\26"+
		"/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37\3\2\6\4\2C\\c|\4\2&&aa\5"+
		"\2\13\f\17\17\"\"\3\2\f\f\2\u00ce\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7L\3\2\2\2"+
		"\tT\3\2\2\2\13Z\3\2\2\2\r`\3\2\2\2\17e\3\2\2\2\21k\3\2\2\2\23o\3\2\2\2"+
		"\25s\3\2\2\2\27v\3\2\2\2\31\177\3\2\2\2\33\u0083\3\2\2\2\35\u0088\3\2"+
		"\2\2\37\u008c\3\2\2\2!\u008e\3\2\2\2#\u0092\3\2\2\2%\u00a4\3\2\2\2\'\u00a6"+
		"\3\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2-\u00ac\3\2\2\2/\u00ae\3\2\2\2\61"+
		"\u00b0\3\2\2\2\63\u00b2\3\2\2\2\65\u00b4\3\2\2\2\67\u00b6\3\2\2\29\u00b9"+
		"\3\2\2\2;\u00bc\3\2\2\2=\u00be\3\2\2\2?\u00c1\3\2\2\2AB\7r\2\2BC\7t\2"+
		"\2CD\7g\2\2DE\7f\2\2E\4\3\2\2\2FG\7g\2\2GH\7x\2\2HI\7g\2\2IJ\7p\2\2JK"+
		"\7v\2\2K\6\3\2\2\2LM\7k\2\2MN\7p\2\2NO\7k\2\2OP\7v\2\2PQ\7k\2\2QR\7c\2"+
		"\2RS\7n\2\2S\b\3\2\2\2TU\7h\2\2UV\7k\2\2VW\7p\2\2WX\7c\2\2XY\7n\2\2Y\n"+
		"\3\2\2\2Z[\7v\2\2[\\\7t\2\2\\]\7c\2\2]^\7p\2\2^_\7u\2\2_\f\3\2\2\2`a\7"+
		"v\2\2ab\7t\2\2bc\7w\2\2cd\7g\2\2d\16\3\2\2\2ef\7h\2\2fg\7c\2\2gh\7n\2"+
		"\2hi\7u\2\2ij\7g\2\2j\20\3\2\2\2kl\7p\2\2lm\7q\2\2mn\7v\2\2n\22\3\2\2"+
		"\2op\7c\2\2pq\7p\2\2qr\7f\2\2r\24\3\2\2\2st\7q\2\2tu\7t\2\2u\26\3\2\2"+
		"\2vw\7f\2\2wx\7k\2\2xy\7u\2\2yz\7v\2\2z{\7k\2\2{|\7p\2\2|}\7e\2\2}~\7"+
		"v\2\2~\30\3\2\2\2\177\u0080\7K\2\2\u0080\u0081\7p\2\2\u0081\u0082\7v\2"+
		"\2\u0082\32\3\2\2\2\u0083\u0084\7D\2\2\u0084\u0085\7q\2\2\u0085\u0086"+
		"\7q\2\2\u0086\u0087\7n\2\2\u0087\34\3\2\2\2\u0088\u0089\7k\2\2\u0089\u008a"+
		"\7v\2\2\u008a\u008b\7g\2\2\u008b\36\3\2\2\2\u008c\u008d\t\2\2\2\u008d"+
		" \3\2\2\2\u008e\u008f\4\62;\2\u008f\"\3\2\2\2\u0090\u0093\5\37\20\2\u0091"+
		"\u0093\t\3\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0099\3\2"+
		"\2\2\u0094\u0098\5\37\20\2\u0095\u0098\5!\21\2\u0096\u0098\t\3\2\2\u0097"+
		"\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a$\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c\u00a5\7\62\2\2\u009d\u00a1\4\63;\2\u009e\u00a0\5!\21\2"+
		"\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u009c\3\2\2\2\u00a4"+
		"\u009d\3\2\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7(\3\2\2\2\u00a8"+
		"\u00a9\7+\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7-\2\2\u00ab,\3\2\2\2\u00ac\u00ad"+
		"\7/\2\2\u00ad.\3\2\2\2\u00ae\u00af\7,\2\2\u00af\60\3\2\2\2\u00b0\u00b1"+
		"\7\61\2\2\u00b1\62\3\2\2\2\u00b2\u00b3\7@\2\2\u00b3\64\3\2\2\2\u00b4\u00b5"+
		"\7>\2\2\u00b5\66\3\2\2\2\u00b6\u00b7\7@\2\2\u00b7\u00b8\7?\2\2\u00b88"+
		"\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bb\7?\2\2\u00bb:\3\2\2\2\u00bc\u00bd"+
		"\7?\2\2\u00bd<\3\2\2\2\u00be\u00bf\t\4\2\2\u00bf\u00c0\b\37\2\2\u00c0"+
		">\3\2\2\2\u00c1\u00c5\7=\2\2\u00c2\u00c4\n\5\2\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\b \3\2\u00c9@\3\2\2\2\t\2\u0092\u0097"+
		"\u0099\u00a1\u00a4\u00c5\4\3\37\2\3 \3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}