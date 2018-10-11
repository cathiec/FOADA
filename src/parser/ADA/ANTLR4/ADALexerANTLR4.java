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
		START=1, FINAL=2, NONE=3, FALSE=4, TRUE=5, FORALL=6, EXISTS=7, TL=8, TR=9, 
		AND=10, OR=11, EQUALS=12, DISTINCTS=13, INTEGER=14, ID=15, LP=16, RP=17, 
		POINT=18, TWOPOINTS=19, COM=20, WS=21, COMMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"START", "FINAL", "NONE", "FALSE", "TRUE", "FORALL", "EXISTS", "TL", "TR", 
		"AND", "OR", "EQUALS", "DISTINCTS", "LETTER", "DIGIT", "INTEGER", "ID", 
		"LP", "RP", "POINT", "TWOPOINTS", "COM", "WS", "COMMENT"
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
		case 22:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\7\21x\n\21\f\21\16\21{\13\21\5\21}\n\21\3\22\3\22\3\22\3\22"+
		"\7\22\u0083\n\22\f\22\16\22\u0086\13\22\3\22\3\22\7\22\u008a\n\22\f\22"+
		"\16\22\u008d\13\22\3\22\3\22\3\22\7\22\u0092\n\22\f\22\16\22\u0095\13"+
		"\22\3\22\3\22\3\22\7\22\u009a\n\22\f\22\16\22\u009d\13\22\3\22\3\22\5"+
		"\22\u00a1\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00b4\n\31\f\31\16\31\u00b7\13\31"+
		"\3\31\3\31\3\31\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\2\37\2!\20#\21%\22\'\23)\24+\25-\26/\27\61"+
		"\30\3\2\t\4\2C\\c|\6\2,-//\61\61>@\3\2@@\3\2__\3\2\177\177\5\2\13\f\17"+
		"\17\"\"\3\2\f\f\2\u00c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\3\63\3\2\2\2\59\3\2\2\2\7?\3\2\2\2\tD\3\2\2\2\13J\3\2\2\2"+
		"\rO\3\2\2\2\17V\3\2\2\2\21]\3\2\2\2\23a\3\2\2\2\25e\3\2\2\2\27h\3\2\2"+
		"\2\31k\3\2\2\2\33m\3\2\2\2\35p\3\2\2\2\37r\3\2\2\2!|\3\2\2\2#\u00a0\3"+
		"\2\2\2%\u00a2\3\2\2\2\'\u00a4\3\2\2\2)\u00a6\3\2\2\2+\u00a8\3\2\2\2-\u00aa"+
		"\3\2\2\2/\u00ac\3\2\2\2\61\u00af\3\2\2\2\63\64\7u\2\2\64\65\7v\2\2\65"+
		"\66\7c\2\2\66\67\7t\2\2\678\7v\2\28\4\3\2\2\29:\7h\2\2:;\7k\2\2;<\7p\2"+
		"\2<=\7c\2\2=>\7n\2\2>\6\3\2\2\2?@\7p\2\2@A\7q\2\2AB\7p\2\2BC\7g\2\2C\b"+
		"\3\2\2\2DE\7h\2\2EF\7c\2\2FG\7n\2\2GH\7u\2\2HI\7g\2\2I\n\3\2\2\2JK\7v"+
		"\2\2KL\7t\2\2LM\7w\2\2MN\7g\2\2N\f\3\2\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2"+
		"RS\7c\2\2ST\7n\2\2TU\7n\2\2U\16\3\2\2\2VW\7g\2\2WX\7z\2\2XY\7k\2\2YZ\7"+
		"u\2\2Z[\7v\2\2[\\\7u\2\2\\\20\3\2\2\2]^\7/\2\2^_\7/\2\2_`\7*\2\2`\22\3"+
		"\2\2\2ab\7+\2\2bc\7/\2\2cd\7@\2\2d\24\3\2\2\2ef\7\61\2\2fg\7^\2\2g\26"+
		"\3\2\2\2hi\7^\2\2ij\7\61\2\2j\30\3\2\2\2kl\7?\2\2l\32\3\2\2\2mn\7#\2\2"+
		"no\7?\2\2o\34\3\2\2\2pq\t\2\2\2q\36\3\2\2\2rs\4\62;\2s \3\2\2\2t}\7\62"+
		"\2\2uy\4\63;\2vx\5\37\20\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3"+
		"\2\2\2{y\3\2\2\2|t\3\2\2\2|u\3\2\2\2}\"\3\2\2\2~\u0084\5\35\17\2\177\u0083"+
		"\5\35\17\2\u0080\u0083\5\37\20\2\u0081\u0083\t\3\2\2\u0082\177\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u00a1\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u008b\7>\2\2\u0088\u008a\n\4\2\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u00a1\7@\2\2\u008f\u0093\7]\2\2\u0090\u0092\n\5\2"+
		"\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u00a1\7_\2\2\u0097"+
		"\u009b\7}\2\2\u0098\u009a\n\6\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u00a1\7\177\2\2\u009f\u00a1\7&\2\2\u00a0~\3\2\2\2"+
		"\u00a0\u0087\3\2\2\2\u00a0\u008f\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0\u009f"+
		"\3\2\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3&\3\2\2\2\u00a4\u00a5"+
		"\7+\2\2\u00a5(\3\2\2\2\u00a6\u00a7\7\60\2\2\u00a7*\3\2\2\2\u00a8\u00a9"+
		"\7<\2\2\u00a9,\3\2\2\2\u00aa\u00ab\7.\2\2\u00ab.\3\2\2\2\u00ac\u00ad\t"+
		"\7\2\2\u00ad\u00ae\b\30\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7*\2\2\u00b0"+
		"\u00b1\7,\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4\n\b\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9\u00ba\7+\2"+
		"\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\31\3\2\u00bc\62\3\2\2\2\f\2y|\u0082"+
		"\u0084\u008b\u0093\u009b\u00a0\u00b5\4\3\30\2\3\31\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}