;9. Realizar una función que reciba como parámetro un número y devuelva una lista con los
;   números que lo forman en binario por ejemplo para: (binario 10) debe devolver la lista (1 0 1 0)


(defun binario (x)
    (if (= x 0)
        '(0)
        (if (= x 1)
        '(1)
        (append (binario(floor x 2)) (cons (mod x 2) '()))
        )
    )
)

(binario 0)
(binario 1)
(binario 2)
(binario 3)
(binario 5)
(binario 8)
(binario 9)
(binario 10)
(binario 15)


(defun binaux (x)
	(cond ((= x 1) '(1))
	((evenp x) (append  (binaux (/ x 2)) '(0)))
	(T (append (binaux (floor x 2)) '(1)))
	)
)
(binaux 5)