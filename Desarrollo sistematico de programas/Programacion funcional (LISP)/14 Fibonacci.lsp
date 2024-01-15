;14. Sabiendo que la serie Fibonacci es la suma de los 2 números, por ejemplo: 0 1 1 2 3 5 8 13 21
;    34 etc. implemente una función que reciba como parámetro un número y devuelva una lista con
;    dicha serie con esa cantidad de números.



(DEFUN FIBONACCI (N)
    (IF (= N 0)
        0
        (IF (= N 1)
            1
            (+ (FIBONACCI (- N 2)) (FIBONACCI(- N 1)))
        )
    )
)

(DEFUN SERIE_FIBONACCI (N)
    (IF (= N 0)
        NIL
        (APPEND (SERIE_FIBONACCI (- N 1))(LIST(FIBONACCI (- N 1))))
    )
)

(SERIE_FIBONACCI 0)

(SERIE_FIBONACCI 1)
(SERIE_FIBONACCI 2)
(SERIE_FIBONACCI 3)
(SERIE_FIBONACCI 4)
(SERIE_FIBONACCI 5)
(SERIE_FIBONACCI 8)
(SERIE_FIBONACCI 10)