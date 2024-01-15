(defun primo (n)
    (primoAux n (floor n 2))
)

(defun primoAux (n m)
    (if (or (= m 0) (= m 1))
        T
        (if (= 0 (mod n m))
            nil
            (primoAux n (- m 1))
        ) 
    )
)


(defun noPrimos (lista)
    (if (null lista)
        nil
        (if (and(not(primo (first lista))) (> 10 (first lista)))
            (append (list(first lista)) (noPrimos (rest lista)))
            (noPrimos (rest lista))
        )
    )
)

(noPrimos '())
(noPrimos '(1))
(noPrimos '(1 2 4))
(noPrimos '(1 2 3 4 5 6 7 8 9 10 11 12))