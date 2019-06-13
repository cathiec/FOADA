parser grammar FOADAParserANTLR4;

options {
    language = Java;
    tokenVocab = FOADALexerANTLR4;
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

package parser.FOADA.ANTLR4;

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
		$jData = new Automaton();
	}
	LP PRED LP (nameOfPredicate=ID {
		parser.FOADA.FOADAParserFunctions.addPredicate($jData, $nameOfPredicate.text);
	}
	)*
	RP RP
	LP EVENT LP (nameOfEvent=ID {
		parser.FOADA.FOADAParserFunctions.addEvent($jData, $nameOfEvent.text);
	}
	)*
	RP RP
	LP INITIAL init=expression RP {
		parser.FOADA.FOADAParserFunctions.setInitial($jData, $init.jData);
	}
	LP FINAL LP (nameOfFinal=ID {
		parser.FOADA.FOADAParserFunctions.addFinal($jData, $nameOfFinal.text);
	}
	)*
	RP RP
	(LP TRANS LP nameOfPredicate=ID LP {
			List<String> argumentsNames = new ArrayList<String>();
			List<FOADAExpression.ExpressionType> argumentsTypes = new ArrayList<FOADAExpression.ExpressionType>();
		}
		(LP argumentName=ID argumentType=type RP {
			argumentsNames.add($argumentName.text);
			argumentsTypes.add($argumentType.jData);
		}
		)*
		RP RP
		LP event=ID LP {
			List<String> inputVarNames = new ArrayList<String>();
			List<FOADAExpression.ExpressionType> inputVarTypes = new ArrayList<FOADAExpression.ExpressionType>();
		}
		(LP inputVarName=ID inputVarType=type RP {
			inputVarNames.add($inputVarName.text);
			inputVarTypes.add($inputVarType.jData);
		}
		)*
		RP RP
		post=expression {
			parser.FOADA.FOADAParserFunctions.addTransition($jData, $nameOfPredicate.text, argumentsNames, argumentsTypes, $event.text, inputVarNames, inputVarTypes, $post.jData);
		}
		RP
	)*
;

type returns [FOADAExpression.ExpressionType jData]
:
	INT {
		$jData = FOADAExpression.ExpressionType.Integer;
	}
	|
	BOOL {
		$jData = FOADAExpression.ExpressionType.Boolean;
	}
;
	
expression returns [FOADAExpression jData]
:
	MINUS INTEGER {
		$jData = new FOADAExpression(Integer.parseInt("-" + $INTEGER.text));
	}
	|
	INTEGER {
		$jData = new FOADAExpression(Integer.parseInt($INTEGER.text));
	}
	|
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
	LP PLUS e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Plus, $e1.jData, $e2.jData);
	}
	|
	LP TIMES e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Times, $e1.jData, $e2.jData);
	}
	|
	LP MINUS e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Minus, $e1.jData, $e2.jData);
	}
	|
	LP SLASH e1=expression e2=expression RP {
		$jData = new FOADAExpression(ExpressionType.Integer, ExpressionCategory.Slash, $e1.jData, $e2.jData);
	}
	|
	LP i=ID {
		List<FOADAExpression> arguments = new ArrayList<FOADAExpression>();
	}
	(e=expression {
		$e.jData.type = ExpressionType.Integer;
		arguments.add($e.jData);
	}
	)+
	{
		$jData = new FOADAExpression($i.text, ExpressionType.Boolean, arguments);
	}
	RP
;