;19. Realice la funcion Diferencias que reciba como parametro una lita
;    formada por numeros (deben validarse) y devuelva una lista con las 
;    diferencias entre los numeros consecutivos de la lista. En caso de
;    que la lista posea elementos que no son numeros, estos no deben 
;    considerarse.



(defun listaNumeros (lista)
    (if (null lista)
        nil
        (if (numberp (first lista))
            (append (list(first lista)) (listaNumeros(rest lista)))
            (listaNumeros(rest lista))
        )
    )
)

(defun diferenciaAux (lista)
    (if (null lista)
        nil
        (if (= 1 (length lista))
            (list(first lista))
            (if (= 2 (length lista))
                (append (list(- (first lista)(second lista))) (diferenciaAux '()))
                (append (list(- (first lista)(second lista))) (diferenciaAux (rest lista)))
            )
        )
    )
)

(defun diferencias (lista)
    (setf a (listaNumeros lista))
    (diferenciaAux a)
)
(diferencias '())
(diferencias '(1))
(diferencias '(a))
(diferencias '(1 2 3 4 a b 5))    