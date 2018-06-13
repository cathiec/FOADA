// Generated from FOADA_Lexer.g4 by ANTLR 4.7.1

package parser.antlr4_parser.FOADA;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOADA_Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEFAUTO=1, INIT=2, FINAL=3, TRANS=4, TRUE=5, FALSE=6, INT=7, BOOL=8, ID=9, 
		STRING=10, WS=11, LP=12, RP=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", "LETTER", 
		"DIGIT", "ID", "STRING", "WS", "LP", "RP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'define-automaton'", "'init'", "'final'", "'trans'", "'true'", 
		"'false'", "'Int'", "'Bool'", null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEFAUTO", "INIT", "FINAL", "TRANS", "TRUE", "FALSE", "INT", "BOOL", 
		"ID", "STRING", "WS", "LP", "RP"
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


	public FOADA_Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOADA_Lexer.g4"; }

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
		case 12:
			WS_action((RuleContext)_localctx, actionIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17{\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\5\f^\n\f\3\f\3\f\3\f\7\fc\n\f\f\f\16\ff\13\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\rn\n\r\f\r\16\rq\13\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\13\31"+
		"\f\33\r\35\16\37\17\3\2\6\4\2C\\c|\4\2&&aa\5\2\f\f$$^^\5\2\13\f\17\17"+
		"\"\"\2\177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5\62\3\2\2\2\7\67\3\2\2"+
		"\2\t=\3\2\2\2\13C\3\2\2\2\rH\3\2\2\2\17N\3\2\2\2\21R\3\2\2\2\23W\3\2\2"+
		"\2\25Y\3\2\2\2\27]\3\2\2\2\31g\3\2\2\2\33t\3\2\2\2\35w\3\2\2\2\37y\3\2"+
		"\2\2!\"\7f\2\2\"#\7g\2\2#$\7h\2\2$%\7k\2\2%&\7p\2\2&\'\7g\2\2\'(\7/\2"+
		"\2()\7c\2\2)*\7w\2\2*+\7v\2\2+,\7q\2\2,-\7o\2\2-.\7c\2\2./\7v\2\2/\60"+
		"\7q\2\2\60\61\7p\2\2\61\4\3\2\2\2\62\63\7k\2\2\63\64\7p\2\2\64\65\7k\2"+
		"\2\65\66\7v\2\2\66\6\3\2\2\2\678\7h\2\289\7k\2\29:\7p\2\2:;\7c\2\2;<\7"+
		"n\2\2<\b\3\2\2\2=>\7v\2\2>?\7t\2\2?@\7c\2\2@A\7p\2\2AB\7u\2\2B\n\3\2\2"+
		"\2CD\7v\2\2DE\7t\2\2EF\7w\2\2FG\7g\2\2G\f\3\2\2\2HI\7h\2\2IJ\7c\2\2JK"+
		"\7n\2\2KL\7u\2\2LM\7g\2\2M\16\3\2\2\2NO\7K\2\2OP\7p\2\2PQ\7v\2\2Q\20\3"+
		"\2\2\2RS\7D\2\2ST\7q\2\2TU\7q\2\2UV\7n\2\2V\22\3\2\2\2WX\t\2\2\2X\24\3"+
		"\2\2\2YZ\4\62;\2Z\26\3\2\2\2[^\5\23\n\2\\^\t\3\2\2][\3\2\2\2]\\\3\2\2"+
		"\2^d\3\2\2\2_c\5\23\n\2`c\5\25\13\2ac\t\3\2\2b_\3\2\2\2b`\3\2\2\2ba\3"+
		"\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\30\3\2\2\2fd\3\2\2\2go\7$\2\2hi"+
		"\7^\2\2in\7$\2\2jk\7^\2\2kn\7^\2\2ln\n\4\2\2mh\3\2\2\2mj\3\2\2\2ml\3\2"+
		"\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7$\2\2s\32\3"+
		"\2\2\2tu\t\5\2\2uv\b\16\2\2v\34\3\2\2\2wx\7*\2\2x\36\3\2\2\2yz\7+\2\2"+
		"z \3\2\2\2\b\2]bdmo\3\3\16\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}