lexer grammar ADALexerANTLR4;

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

package parser.ADA.ANTLR4;
}

// key words
START : 'start';
FINAL : 'final';
NONE : 'none';
FALSE : 'false';
TRUE : 'true';
FORALL : 'forall';
EXISTS : 'exists';
TL : '--(';
TR : ')->';
AND : '/\\';
OR : '\\/';
EQUALS : '=';
DISTINCTS : '!=';

fragment LETTER : 'a' .. 'z' | 'A' .. 'Z';
fragment DIGIT : '0' .. '9';

INTEGER : '0' | ('1' .. '9' DIGIT*);
ID : (LETTER)(LETTER | DIGIT | '+' | '-' | '*' | '/' | '>' | '<' | '=')*
		|
		('<' (~('>'))* '>')
		|
		('[' (~(']'))* ']')
		|
		('{' (~('}'))* '}')
		|
		'$';

LP : '(';
RP : ')';
POINT : '.';
TWOPOINTS : ':';
COM : ',';

WS : (' ' | '\t' | '\r' | '\n') {skip();};

COMMENT
: '(*' ( ~('\n') )* '*)' {skip();}
;
