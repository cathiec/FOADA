parser grammar FOADA_Parser;

options {
    language = Java;
    tokenVocab = FOADA_Lexer;
}

@header {
    import structure.*;
    import structure.Expression.*;
}

automaton returns [Automaton tree]
	: LP DEFAUTO ID {
		$tree = new Automaton($ID.text);
	}
	(initial_def {
		$tree.setInitial($initial_def.tree);
	}
	| list_finals_def {
		$tree.setFinals($list_finals_def.tree);
	}
	| transition_def {
		$tree.addTransition($transition_def.tree);
	}
	)*
	RP EOF
;

initial_def returns [BooleanExpression tree]
	: LP INIT boolexpr {
		$tree = $boolexpr.tree;
	}
	RP
;

list_finals_def returns [List<String> tree]
	: LP FINAL LP list_finals {
		$tree = $list_finals.tree;
	}
	RP RP
;

transition_def returns [Transition tree]
	: LP TRANS i=input i2=input boolexpr RP {
		$tree = new Transition($i.tree, $i2.tree, $boolexpr.tree);
	}
;

boolexpr returns [BooleanExpression tree]
	: TRUE {
		$tree = new BooleanConstant(true);
	}
	| FALSE {
		$tree = new BooleanConstant(false);
	}
	| LP NOT boolexpr RP {
		$tree = new Not($boolexpr.tree);
	}
	| LP AND b=boolexpr {
		$tree = $b.tree; 
	}
	(b2=boolexpr {
		$tree = new And($tree, $b2.tree);
	}
	)+
	RP
	| LP OR b=boolexpr {
		$tree = $b.tree;
	}
	(b2=boolexpr {
		$tree = new Or($tree, $b2.tree);
	}
	)+
	RP
	| LP EXISTS LP list_arguments RP boolexpr RP {
		$tree = new Exists($list_arguments.tree, $boolexpr.tree);
	}
	| LP FORALL LP list_arguments RP boolexpr RP {
		$tree = new Forall($list_arguments.tree, $boolexpr.tree);
	}
	| LP GT i=intexpr i2=intexpr RP {
		$tree = new GT($i.tree, $i2.tree);
	}
	| LP LT i=intexpr i2=intexpr RP {
		$tree = new LT($i.tree, $i2.tree);
	}
	| LP GEQ i=intexpr i2=intexpr RP {
		$tree = new GEQ($i.tree, $i2.tree);
	}
	| LP LEQ i=intexpr i2=intexpr RP {
		$tree = new LEQ($i.tree, $i2.tree);
	}
	| LP EQUALS i=intexpr i2=intexpr RP {
		$tree = new Equals($i.tree, $i2.tree);
	}
	| LP DISTINCT i=intexpr i2=intexpr RP {
		$tree = new Distinct($i.tree, $i2.tree);
	}
	| ID {
		$tree = new BooleanFunction($ID.text);
	}
	| LP id=ID {
		$tree = new BooleanFunction($id.text);
	}
	(id2=ID {
		((BooleanFunction)$tree).addArgument($id2.text);
	}
	)+
	RP
;

intexpr returns [IntegerExpression tree]
	: INTEGER {
		$tree = new IntegerConstant($INTEGER.text);
	}
	| LP PLUS i=intexpr {
		$tree = $i.tree; 
	}
	(i2=intexpr {
		$tree = new Plus($tree, $i2.tree);
	}
	)+
	RP
	| LP TIMES i=intexpr {
		$tree = $i.tree; 
	}
	(i2=intexpr {
		$tree = new Times($tree, $i2.tree);
	}
	)+
	RP
	| LP MINUS i=intexpr i2=intexpr RP {
		$tree = new Minus($i.tree, $i2.tree);
	}
	| LP SLASH i=intexpr i2=intexpr RP {
		$tree = new Slash($i.tree, $i2.tree);
	}
	| ID {
		$tree = new IntegerVariable($ID.text);
	}
;

list_finals returns [List<String> tree]
	: i=ID {
		$tree = new ArrayList<String>();
		$tree.add($i.text);
	}
	(i2=ID {
		$tree.add($i2.text);
	}
	)*
;

list_arguments returns [List<Argument> tree]
	: {
		$tree = new ArrayList<Argument>();
	}
	(argument {
		$tree.add($argument.tree);
	}
	)*
;

argument returns [Argument tree]
	: LP ID type RP {
		$tree = new Argument($ID.text, $type.tree);
	}
;

type returns [ExpressionClass tree]
	: INT {
		$tree = ExpressionClass.Integer;
	}
	| BOOL {
		$tree = ExpressionClass.Boolean;
	}
;

input returns [Input tree]
	: LP ID LP list_arguments RP RP {
		$tree = new Input($ID.text, $list_arguments.tree);
	}
;
