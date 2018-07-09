parser grammar FOADA_Parser;

options {
    language = Java;
    tokenVocab = FOADA_Lexer;
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

import java.util.*;
import structure.*;
import structure.Transition;
import structure.Expression.*;
}

automaton returns [Automaton tree]
:
	LP DEFAUTO ID {
		$tree = new Automaton($ID.text);
	}
	(	initial_def {
			$tree.setInitial($initial_def.tree);
		}
		| list_finals_def {
			$tree.setFinals($list_finals_def.tree);
		}
		| transition_def {
			$tree.addTransition($transition_def.tree);
		}
	)*
	RP EOF {
		$tree.finishCategory();
	}
;

initial_def returns [Expression tree]
:
	LP INIT expr {
		$tree = $expr.tree;
	}
	RP
;

list_finals_def returns [List<String> tree]
:
	LP FINAL LP list_finals {
		$tree = $list_finals.tree;
	}
	RP RP
;

transition_def returns [Transition tree]
:
	LP TRANS LP from=ID LP argFrom=list_arguments RP RP LP event=ID LP argEvent=list_arguments RP RP expr RP {
		$tree = new Transition($from.text, $argFrom.tree, $event.text, $argEvent.tree, $expr.tree);
	}
;

expr returns [Expression tree]
:
	TRUE {
		$tree = new Expression(true);
	}
	|
	FALSE {
		$tree = new Expression(false);
	}
	|
	LP NOT expr RP {
		$tree = new Expression(ExpressionType.Not, $expr.tree);
	}
	|
	LP AND e1=expr {
		$tree = $e1.tree; 
	}
	(e2=expr {
		$tree = new Expression(ExpressionType.And, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP OR e1=expr {
		$tree = $e1.tree;
	}
	(e2=expr {
		$tree = new Expression(ExpressionType.Or, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP EXISTS LP list_arguments RP expr RP {
		$tree = new Expression(ExpressionType.Exists, $list_arguments.tree, $expr.tree);
	}
	|
	LP FORALL LP list_arguments RP expr RP {
		$tree = new Expression(ExpressionType.Forall, $list_arguments.tree, $expr.tree);
	}
	|
	LP GT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.GT, $e1.tree, $e2.tree);
	}
	|
	LP LT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.LT, $e1.tree, $e2.tree);
	}
	|
	LP GEQ e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.GEQ, $e1.tree, $e2.tree);
	}
	|
	LP LEQ e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.LEQ, $e1.tree, $e2.tree);
	}
	|
	LP EQUALS e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.Equals, $e1.tree, $e2.tree);
	}
	|
	LP DISTINCT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.Distinct, $e1.tree, $e2.tree);
	}
	|
	ID {
		$tree = new Expression($ID.text);
	}
	|
	LP ID {
		$tree = new Expression($ID.text);
	}
	(expr {
		$tree.addArgument($expr.tree);
	}
	)+
	RP
	|
	INTEGER {
		$tree = new Expression(Integer.parseInt($INTEGER.text));
	}
	|
	LP PLUS e1=expr {
		$tree = $e1.tree; 
	}
	(e2=expr {
		$tree = new Expression(ExpressionType.Plus, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP TIMES e1=expr {
		$tree = $e1.tree; 
	}
	(e2=expr {
		$tree = new Expression(ExpressionType.Times, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP MINUS e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.Minus, $e1.tree, $e2.tree);
	}
	|
	LP SLASH e1=expr e2=expr RP {
		$tree = new Expression(ExpressionType.Slash, $e1.tree, $e2.tree);
	}
;

list_finals returns [List<String> tree]
	: i1=ID {
		$tree = new ArrayList<String>();
		$tree.add($i1.text);
	}
	(i2=ID {
		$tree.add($i2.text);
	}
	)*
;

list_arguments returns [Map<String, ExpressionCategory> tree]
	: {
		$tree = new HashMap<String, ExpressionCategory>();
	}
	(LP ID type RP {
		$tree.put($ID.text, $type.tree);
	}
	)*
;

type returns [ExpressionCategory tree]
	: INT {
		$tree = ExpressionCategory.Integer;
	}
	| BOOL {
		$tree = ExpressionCategory.Boolean;
	}
;
