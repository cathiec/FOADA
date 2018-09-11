parser grammar PAParserANTLR4;

options {
    language = Java;
    tokenVocab = PALexerANTLR4;
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

package parser.PA.ANTLR4;

import java.util.*;
import exception.*;
import structure.*;
}

automaton returns [Automaton tree]
:
	START TWOPOINTS expression POINT FINAL TWOPOINTS final_list POINT (transition)* EOF
;

final_list
:
	NONE
	|
	(FUNCNAME (COM FUNCNAME)*)
;

transition
:
	FUNCNAME LP argument_list RP TL SYMBOL TWOPOINTS ID TR expression POINT
;

expression
:
	EXISTS ID POINT expression {
	}
	|
	FORALL ID POINT expression {
	}
	|
	FUNCNAME LP argument_list RP {
	}
	|
	ID EQUALS ID {
	}
	|
	ID DISTINCTS ID {
	}
	|
	TRUE {
	}
	|
	FALSE {
	}
	|
	e1=expression AND e2=expression {
	}
	|
	e1=expression OR e2=expression {
	}
	|
	LP expression RP {
	}
;

argument_list
:
	(ID (COM ID)*)?
;