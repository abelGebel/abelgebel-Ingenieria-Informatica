;10. Realice una función que calcule si un número es primo o no.


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

(primo 0)
(primo 1)
(primo 2)
(primo 4)
(primo 5)
(primo 8)