parser grammar ADAParserANTLR4;

options {
    language = Java;
    tokenVocab = ADALexerANTLR4;
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

import exception.FOADAException;
import structure.Automaton;
import structure.FOADAExpression;
import structure.FOADAExpression.ExpressionCategory;
import structure.FOADAExpression.ExpressionType;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
}

automaton returns [Automaton jData]
:
	{
		$jData = new Automaton("A");
	}
	STATES (i=ID {
		$jData.preDefinePredicate($i.text);
	}
	)*
	INITIAL e=expression {
		$jData.defineFunctionType($e.jData);
		$jData.setInitialState($e.jData);
	}
	FINAL {
		List<String> finalStates = new ArrayList<String>();
	}
	(i=ID {
		finalStates.add($i.text);
	}
	)*
	{
		$jData.setFinalStates(finalStates);
	}
	SYMBOLS (i=ID {
		$jData.addEventSymbol($i.text);
	}
	)*
	VARIABLES (i=ID {
		$jData.addVariable($i.text);
		$jData.setVisibleVariable($i.text);
	}
	)*
	{
		$jData.finaliseADAPredicatesArguments();
		$jData.finaliseADAInitAndFinal();
	}
	TRANSITIONS (i1=ID i2=ID e=expression SHARP {
		$jData.defineFunctionType($e.jData);
		$jData.addADATransition($i2.text, $i1.text, $e.jData);
	}
	)*
;
	
expression returns [FOADAExpression jData]
:
	TRUE {
		$jData = new FOADAExpression(true);
	}
	|
	FALSE {
		$jData = new FOADAExpression(false);
	}
	|
	LP NOT e=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Not, $e.jData);
	}
	|
	LP AND e1=expression {
		$jData = $e1.jData; 
	}
	(e2=expression {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.And, $jData, $e2.jData);
	}
	)+
	RP
	|
	LP OR e1=expression {
		$jData = $e1.jData; 
	}
	(e2=expression {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Or, $jData, $e2.jData);
	}
	)+
	RP
	|
	LP GT e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GT, $e1.jData, $e2.jData);
	}
	|
	LP LT e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LT, $e1.jData, $e2.jData);
	}
	|
	LP GEQ e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.GEQ, $e1.jData, $e2.jData);
	}
	|
	LP LEQ e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.LEQ, $e1.jData, $e2.jData);
	}
	|
	LP EQUALS e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Equals, $e1.jData, $e2.jData);
	}
	|
	LP DISTINCT e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Boolean, ExpressionCategory.Distinct, $e1.jData, $e2.jData);
	}
	|
	i=ID {
		$jData = new FOADAExpression($i.text);
	}
	|
	INTEGER {
		$jData = new FOADAExpression(Integer.parseInt($INTEGER.text));
	}
	|
	LP PLUS e1=expression {
		$jData = $e1.jData; 
	}
	(e2=expression {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, $jData, $e2.jData);
	}
	)+
	RP
	|
	LP TIMES e1=expression {
		$jData = $e1.jData; 
	}
	(e2=expression {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, $jData, $e2.jData);
	}
	)+
	RP
	|
	LP MINUS e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, $e1.jData, $e2.jData);
	}
	|
	LP SLASH e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, $e1.jData, $e2.jData);
	}
;