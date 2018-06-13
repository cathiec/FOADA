(define-automaton A
	(init true)
	
	(trans (q1 ((x Int))) (a ((y Int))) true)
	(trans (q3 ((x Int))) (a ((y Int))) false)
	(final (q1 q2))
)
