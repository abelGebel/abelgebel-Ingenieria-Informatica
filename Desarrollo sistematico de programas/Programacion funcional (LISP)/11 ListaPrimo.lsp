;11. Evalúe una lista indicando si sus elementos son números primos.



(defun primo (n)
    (primoAux n (floor n 2))
)

(defun primoAux(n m)
    (if (or(= m 0)(= m 1))
        T
        (if (zerop (mod n m))
            NIL
            (primoAux n (- m 1))
        )
    )
)

(defun primos (lista)
    (if (null lista)
        ()
        (mapcar #'primo lista)
        
    )    
)

(primos'(2 6 2 7 10))
(primos'())
(primos'(0))

