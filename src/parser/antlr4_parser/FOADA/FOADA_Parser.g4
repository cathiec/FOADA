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
import exception.*;
}

automaton returns [Automaton tree]
:
	LP DEFAUTO ID {
		$tree = new Automaton($ID.text);
	}
	(	event_def {
			$tree.initializeEvents($event_def.tree);
		}
		|
		var_def {
			$tree.initializeVariables($var_def.tree);
		}
		|
		pred_def {
			$tree.initializePredicates($pred_def.tree);
		}
		|
		init_def {
			$tree.initializeInitial($init_def.tree);
		}
		|
		final_def {
			$tree.initializeFinals($final_def.tree);
		}
		|
		trans_def {
			$tree.addTransition($trans_def.tree);
		}
	)*
	RP EOF
;

event_def returns [List<String> tree]
:
	LP EVENT LP list_events RP RP {
		$tree = $list_events.tree;
	}
;

var_def returns [List<ExpressionType> tree]
:
	LP VAR LP list_types RP RP {
		$tree = $list_types.tree;
	}
;

pred_def returns [Map<String, List<ExpressionType>> tree]
:
	LP PRED LP list_predicates RP RP {
		$tree = $list_predicates.tree;
	}
;

init_def returns [Expression tree]
:
	LP INIT expr RP {
		$tree = $expr.tree;
	}
;

final_def returns [List<String> tree]
:
	LP FINAL LP list_finals RP RP {
		$tree = $list_finals.tree;
	}
;

trans_def returns [Transition tree]
:
	LP TRANS LP from=ID LP argFrom=list_arguments RP RP LP event=ID LP argEvent=list_arguments RP RP expr RP {
		$tree = new Transition($from.text, $argFrom.tree, $event.text, $argEvent.tree, $expr.tree);
	}
;

list_events returns [List<String> tree]
:
	{
		$tree = new ArrayList<String>();
	}
	(ID {
		$tree.add($ID.text);
	}
	)*
;

list_types returns [List<ExpressionType> tree]
:
	{
		$tree = new ArrayList<ExpressionType>();
	}
	(type {
		$tree.add($type.tree);
	}
	)*
;

list_predicates returns [Map<String, List<ExpressionType>> tree]
:
	{
		$tree = new LinkedHashMap<String, List<ExpressionType>>();
	}
	(LP ID LP list_types RP RP {
		$tree.put($ID.text, $list_types.tree);
	}
	)*
;

list_finals returns [List<String> tree]
:
	{
		$tree = new ArrayList<String>();
	}
	(ID {
		$tree.add($ID.text);
	}
	)*
;

list_arguments returns [Map<String, ExpressionType> tree]
:
	{
		$tree = new LinkedHashMap<String, ExpressionType>();
	}
	(LP ID type RP {
		$tree.put($ID.text, $type.tree);
	}
	)*
;

type returns [ExpressionType tree]
:
	INT {
		$tree = ExpressionType.Integer;
	}
	|
	BOOL {
		$tree = ExpressionType.Boolean;
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
		$tree = new Expression(ExpressionSubtype.Not, $expr.tree);
	}
	|
	LP AND e1=expr {
		$tree = $e1.tree; 
	}
	(e2=expr {
		$tree = new Expression(ExpressionSubtype.And, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP OR e1=expr {
		$tree = $e1.tree;
	}
	(e2=expr {
		$tree = new Expression(ExpressionSubtype.Or, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP EXISTS LP list_arguments RP expr RP {
		$tree = new Expression(ExpressionSubtype.Exists, $list_arguments.tree, $expr.tree);
	}
	|
	LP FORALL LP list_arguments RP expr RP {
		$tree = new Expression(ExpressionSubtype.Forall, $list_arguments.tree, $expr.tree);
	}
	|
	LP GT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.GT, $e1.tree, $e2.tree);
	}
	|
	LP LT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.LT, $e1.tree, $e2.tree);
	}
	|
	LP GEQ e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.GEQ, $e1.tree, $e2.tree);
	}
	|
	LP LEQ e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.LEQ, $e1.tree, $e2.tree);
	}
	|
	LP EQUALS e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.Equals, $e1.tree, $e2.tree);
	}
	|
	LP DISTINCT e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.Distinct, $e1.tree, $e2.tree);
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
		$tree = new Expression(ExpressionSubtype.Plus, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP TIMES e1=expr {
		$tree = $e1.tree; 
	}
	(e2=expr {
		$tree = new Expression(ExpressionSubtype.Times, $tree, $e2.tree);
	}
	)+
	RP
	|
	LP MINUS e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.Minus, $e1.tree, $e2.tree);
	}
	|
	LP SLASH e1=expr e2=expr RP {
		$tree = new Expression(ExpressionSubtype.Slash, $e1.tree, $e2.tree);
	}
;