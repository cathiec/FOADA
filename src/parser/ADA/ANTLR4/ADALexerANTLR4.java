// Generated from ADALexerANTLR4.g4 by ANTLR 4.7.1

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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ADALexerANTLR4 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STATES=1, INITIAL=2, FINAL=3, SYMBOLS=4, VARIABLES=5, TRANSITIONS=6, TRUE=7, 
		FALSE=8, NOT=9, AND=10, OR=11, DISTINCT=12, ID=13, INTEGER=14, SHARP=15, 
		LP=16, RP=17, PLUS=18, MINUS=19, TIMES=20, SLASH=21, GT=22, LT=23, GEQ=24, 
		LEQ=25, EQUALS=26, WS=27, COMMENT=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STATES", "INITIAL", "FINAL", "SYMBOLS", "VARIABLES", "TRANSITIONS", "TRUE", 
		"FALSE", "NOT", "AND", "OR", "DISTINCT", "LETTER", "DIGIT", "ID", "INTEGER", 
		"SHARP", "LP", "RP", "PLUS", "MINUS", "TIMES", "SLASH", "GT", "LT", "GEQ", 
		"LEQ", "EQUALS", "WS", "COMMENT"
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


	public ADALexerANTLR4(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ADALexerANTLR4.g4"; }

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
		case 28:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00d1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\5\20\u0098\n\20\3\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0"+
		"\13\20\3\21\3\21\3\21\7\21\u00a5\n\21\f\21\16\21\u00a8\13\21\5\21\u00aa"+
		"\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\7\37\u00cb\n\37\f\37\16\37\u00ce\13\37\3\37\3\37"+
		"\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35"+
		"\2\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34"+
		";\35=\36\3\2\6\4\2C\\c|\4\2&&aa\5\2\13\f\17\17\"\"\3\2\f\f\2\u00d5\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5"+
		"F\3\2\2\2\7N\3\2\2\2\tT\3\2\2\2\13\\\3\2\2\2\rf\3\2\2\2\17r\3\2\2\2\21"+
		"w\3\2\2\2\23}\3\2\2\2\25\u0081\3\2\2\2\27\u0085\3\2\2\2\31\u0088\3\2\2"+
		"\2\33\u0091\3\2\2\2\35\u0093\3\2\2\2\37\u0097\3\2\2\2!\u00a9\3\2\2\2#"+
		"\u00ab\3\2\2\2%\u00ad\3\2\2\2\'\u00af\3\2\2\2)\u00b1\3\2\2\2+\u00b3\3"+
		"\2\2\2-\u00b5\3\2\2\2/\u00b7\3\2\2\2\61\u00b9\3\2\2\2\63\u00bb\3\2\2\2"+
		"\65\u00bd\3\2\2\2\67\u00c0\3\2\2\29\u00c3\3\2\2\2;\u00c5\3\2\2\2=\u00c8"+
		"\3\2\2\2?@\7U\2\2@A\7V\2\2AB\7C\2\2BC\7V\2\2CD\7G\2\2DE\7U\2\2E\4\3\2"+
		"\2\2FG\7K\2\2GH\7P\2\2HI\7K\2\2IJ\7V\2\2JK\7K\2\2KL\7C\2\2LM\7N\2\2M\6"+
		"\3\2\2\2NO\7H\2\2OP\7K\2\2PQ\7P\2\2QR\7C\2\2RS\7N\2\2S\b\3\2\2\2TU\7U"+
		"\2\2UV\7[\2\2VW\7O\2\2WX\7D\2\2XY\7Q\2\2YZ\7N\2\2Z[\7U\2\2[\n\3\2\2\2"+
		"\\]\7X\2\2]^\7C\2\2^_\7T\2\2_`\7K\2\2`a\7C\2\2ab\7D\2\2bc\7N\2\2cd\7G"+
		"\2\2de\7U\2\2e\f\3\2\2\2fg\7V\2\2gh\7T\2\2hi\7C\2\2ij\7P\2\2jk\7U\2\2"+
		"kl\7K\2\2lm\7V\2\2mn\7K\2\2no\7Q\2\2op\7P\2\2pq\7U\2\2q\16\3\2\2\2rs\7"+
		"v\2\2st\7t\2\2tu\7w\2\2uv\7g\2\2v\20\3\2\2\2wx\7h\2\2xy\7c\2\2yz\7n\2"+
		"\2z{\7u\2\2{|\7g\2\2|\22\3\2\2\2}~\7p\2\2~\177\7q\2\2\177\u0080\7v\2\2"+
		"\u0080\24\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7p\2\2\u0083\u0084\7"+
		"f\2\2\u0084\26\3\2\2\2\u0085\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087\30"+
		"\3\2\2\2\u0088\u0089\7f\2\2\u0089\u008a\7k\2\2\u008a\u008b\7u\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7e\2\2"+
		"\u008f\u0090\7v\2\2\u0090\32\3\2\2\2\u0091\u0092\t\2\2\2\u0092\34\3\2"+
		"\2\2\u0093\u0094\4\62;\2\u0094\36\3\2\2\2\u0095\u0098\5\33\16\2\u0096"+
		"\u0098\t\3\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u009e\3\2"+
		"\2\2\u0099\u009d\5\33\16\2\u009a\u009d\5\35\17\2\u009b\u009d\t\3\2\2\u009c"+
		"\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f \3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00aa\7\62\2\2\u00a2\u00a6\4\63;\2\u00a3\u00a5\5\35\17"+
		"\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9"+
		"\u00a2\3\2\2\2\u00aa\"\3\2\2\2\u00ab\u00ac\7%\2\2\u00ac$\3\2\2\2\u00ad"+
		"\u00ae\7*\2\2\u00ae&\3\2\2\2\u00af\u00b0\7+\2\2\u00b0(\3\2\2\2\u00b1\u00b2"+
		"\7-\2\2\u00b2*\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4,\3\2\2\2\u00b5\u00b6\7"+
		",\2\2\u00b6.\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\60\3\2\2\2\u00b9\u00ba"+
		"\7@\2\2\u00ba\62\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc\64\3\2\2\2\u00bd\u00be"+
		"\7@\2\2\u00be\u00bf\7?\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c28\3\2\2\2\u00c3\u00c4\7?\2\2\u00c4:\3\2\2\2\u00c5\u00c6\t"+
		"\4\2\2\u00c6\u00c7\b\36\2\2\u00c7<\3\2\2\2\u00c8\u00cc\7=\2\2\u00c9\u00cb"+
		"\n\5\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\b\37"+
		"\3\2\u00d0>\3\2\2\2\t\2\u0097\u009c\u009e\u00a6\u00a9\u00cc\4\3\36\2\3"+
		"\37\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}