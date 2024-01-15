; Implemente la función FACTORIAL en forma recursiva.

(DEFUN FACTORIAL (N)
    (IF (OR(= N 0)(= N 1))
      1
      (* N (FACTORIAL(- N 1)))  
    )
)

(FACTORIAL 0)
(FACTORIAL 1)
(FACTORIAL 2)
(FACTORIAL 3)
(FACTORIAL 4)
(FACTORIAL 5)
