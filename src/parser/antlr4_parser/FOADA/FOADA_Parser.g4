parser grammar FOADA_Parser;

options {
    language = Java;
    tokenVocab = FOADA_Lexer;
}

@header {
    import structure.*;
}

automaton returns [Automaton tree]
: LP DEFAUTO ID {
		$tree = new Automaton($ID.text);
	}
	(initial_def {
		$tree.addInitial($initial_def.tree);
	}
	| list_finals_def {
		$tree.addFinals($list_finals_def.tree);
	}
	| transition_def {
		$tree.addTransition($transition_def.tree);
	}
	)* RP EOF
;

initial_def returns [Expression tree]
: LP INIT expression {
		$tree = $expression.tree;
	}
	RP
;

list_finals_def
: LP FINAL LP list_finals RP RP
;

expression
: TRUE
| FALSE
| LP NOT expression RP
| LP DISTINCT expression expression RP
| LP AND expression (expression)+ RP
| LP OR expression (expression)+ RP
| LP EXISTS LP list_arguments RP expression RP
| LP FORALL LP list_arguments RP expression RP
| LP GT integer integer RP
| LP LT integer integer RP
| LP GEQ integer integer RP
| LP LEQ integer integer RP
| LP EQUALS integer integer RP
| ID
| LP ID (ID)+ RP
;

integer
: INTEGER
| LP PLUS integer (integer)+ RP
| LP MINUS integer integer RP
| LP TIMES integer (integer)+ RP
| LP SLASH integer integer RP
| ID
;

list_finals
: ID (ID)*
;

transition_def
: LP TRANS state input expression RP
;

state
: LP ID LP list_arguments RP RP
;

list_arguments
: argument (argument)*
;

argument
: LP ID type RP
;

type
: INT | BOOL
;

input
: LP ID LP list_arguments RP RP
;
