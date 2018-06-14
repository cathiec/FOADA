parser grammar SMT_Parser;

options {
    language = Java;
    tokenVocab = SMT_Lexer;
}

run
: (automaton_def | assertion | check_sat | get_model)* EOF
;

assertion
: LP ASSERT expression RP
;

check_sat
: LP CHECKSAT RP
;

get_model
: LP GETMODEL RP
;

automaton_def
: LP DEFAUTO ID (initial_def | list_finals_def | list_transitions_def)* RP
;

initial_def
: LP INIT expression RP
;

list_finals_def
: LP FINAL LP list_finals RP RP
;

list_transitions_def
: list_transitions
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

list_transitions
: transition (transition)*
;

transition
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
