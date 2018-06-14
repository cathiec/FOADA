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
EXISTS : 'exists';
FORALL : 'forall';
NOT : 'not';
AND : 'and';
OR : 'or';
DISTINCT : 'distinct';

fragment LETTER : 'a' .. 'z' | 'A' .. 'Z';
fragment DIGIT : '0' .. '9';

ID : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
STRING : '"' ('\\"' | '\\\\' | ~('"'|'\n'|'\\'))* '"';
INTEGER : '0' | ('1' .. '9' DIGIT*);

LP : '(';
RP : ')';
PLUS : '+';
MINUS : '-';
TIMES : '*';
SLASH : '/';
GT : '>';
LT : '<';
GEQ : '>=';
LEQ : '<=';
EQUALS : '=';

WS : (' ' | '\t' | '\r' | '\n') {skip();};

COMMENT
: ';' ( ~('\n') )* {skip();}
;
