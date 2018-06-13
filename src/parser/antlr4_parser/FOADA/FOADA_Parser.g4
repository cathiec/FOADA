parser grammar FOADA_Parser;

options {
    language = Java;
    tokenVocab = FOADA_Lexer;
}

automaton
: LP DEFAUTO title initial_def list_finals_def list_transitions_def RP EOF
;

title
: ID
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
;

list_finals
: ID ( ID )*
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
