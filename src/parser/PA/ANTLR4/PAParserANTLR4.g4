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
import structure.FOADAExpression.*;
import org.sosy_lab.java_smt.api.*;

}

automaton returns [Automaton jData]
:
	{
		$jData = new Automaton("A");
	}
	START TWOPOINTS e=expression {
		$jData.setInitialState($e.jData);
	}
	POINT FINAL TWOPOINTS fl=final_list {
		$jData.setFinalStates($fl.jData);
	}
	POINT (FUNCNAME LP al=argument_list RP TL SYMBOL TWOPOINTS ID TR e=expression POINT {
		$jData.addTransition($FUNCNAME.text, $al.jData, $SYMBOL.text, $ID.text, $e.jData);
	}
	)* EOF
;

final_list returns [List<String> jData]
:
	NONE {
		$jData = new ArrayList<String>();
	}
	|
	FUNCNAME {
		$jData = new ArrayList<String>();
		$jData.add($FUNCNAME.text);		
	}
	(COM FUNCNAME {
		$jData.add($FUNCNAME.text);
	}
	)*
;

expression returns [FOADAExpression jData]
:
	oe=or_expression {
		$jData = $oe.jData;
	}
;

or_expression returns [FOADAExpression jData]
:
	ae1=and_expression {
		$jData = $ae1.jData;
	}
	(OR ae2=and_expression {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, $ae1.jData, $ae2.jData);
	}
	)*
	|
	LP oe=or_expression RP {
		$jData = $oe.jData;
	}
;

and_expression returns [FOADAExpression jData]
:
	be=basic_expression {
		$jData = $be.jData;
	}
	(AND oe=or_expression {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, $be.jData, $oe.jData);
	}
	)*
	|
	LP oe1=or_expression RP {
		$jData = $oe1.jData;
	}
	(AND oe2=or_expression {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, $oe1.jData, $oe2.jData);
	}
	)*
;

basic_expression returns [FOADAExpression jData]
:
	TRUE {
		$jData = new FOADAExpression(true);
	}
	|
	FALSE {
		$jData = new FOADAExpression(false);
	}
	|
	EXISTS al=argument_list POINT e=expression {
		List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
		for(String s : $al.jData) {
			FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
			subExpressions.add(argument);
		}
		subExpressions.add($e.jData);
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Exists, subExpressions);
	}
	|
	FORALL al=argument_list POINT e=expression {
		List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
		for(String s : $al.jData) {
			FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
			subExpressions.add(argument);
		}
		subExpressions.add($e.jData);
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Forall, subExpressions);
	}
	|
	ee=eq_expression {
		$jData = $ee.jData;
	}
	|
	FUNCNAME LP al=argument_list RP {
		List<FOADAExpression> subExpressions = new ArrayList<FOADAExpression>();
		for(String s : $al.jData) {
			FOADAExpression argument = new FOADAExpression(s, ExpressionType.Integer);
			subExpressions.add(argument);
		}
		$jData = new FOADAExpression($FUNCNAME.text, ExpressionType.Boolean, subExpressions);
	}
;

eq_expression returns [FOADAExpression jData]
:
	i1=ID EQUALS i2=ID {
		FOADAExpression left = new FOADAExpression($i1.text, ExpressionType.Integer);
		FOADAExpression right = new FOADAExpression($i2.text, ExpressionType.Integer);
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, left, right);
	}
	|
	i1=ID DISTINCTS i2=ID {
		FOADAExpression left = new FOADAExpression($i1.text, ExpressionType.Integer);
		FOADAExpression right = new FOADAExpression($i2.text, ExpressionType.Integer);
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distincts, left, right);
	}
	|
	LP ee=eq_expression RP {
		$jData = $ee.jData;
	}
;

argument_list returns [List<String> jData]
:
	{
		$jData = new ArrayList<String>();
	}
	(i1=ID {
		$jData.add($i1.text);
	}
	(COM i2=ID {
		$jData.add($i2.text);
	}
	)*
	)?
;