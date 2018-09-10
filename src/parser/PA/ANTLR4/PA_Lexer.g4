lexer grammar FOADA_Lexer;

options {
    language = Java;
}

@header {
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
}

// key words
DEFAUTO : 'define-automaton';
EVENT : 'event';
VAR : 'var';
PRED : 'pred';
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
