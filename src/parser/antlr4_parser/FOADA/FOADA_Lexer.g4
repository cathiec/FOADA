lexer grammar FOADA_Lexer;

options {
    language = Java;
}

// key words
DEFAUTO : 'define-automaton';
INIT : 'init';
FINAL : 'final';
TRANS : 'trans';
TRUE : 'true';
FALSE : 'false';
INT : 'Int';
BOOL : 'Bool';

fragment LETTER : 'a' .. 'z' | 'A' .. 'Z';
fragment DIGIT : '0' .. '9';

ID : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
STRING : '"' ('\\"' | '\\\\' | ~('"'|'\n'|'\\'))* '"';

WS : (' ' | '\t' | '\r' | '\n') {skip();};

LP : '(';
RP : ')';
