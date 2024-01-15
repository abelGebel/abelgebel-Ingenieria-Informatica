;18. Implemente una función que reciba como parámetro una lista formada por 
;    números y devuelva otra de tal manera que los elementos generados sean 
;    cada número de la lista parámetro con la cantidad de veces que se repite.
;    Ejemplo: (2 2 2 2 3) => (2 4 3 1); (2 2 3 5) => (2 2 3 1 5 1)



(defun contar_repeticiones (lista n)
    (if (or(null lista) (not(= (first lista) n)))
        0
        (+ 1 (contar_repeticiones (rest lista) n))
    )
)

(defun elementos_restantes (lista n)
    (if (null lista)
        nil
        (if (= n (first lista))
            (elementos_restantes (rest lista) n)
            lista
        )
    )
)
        
(defun contar_elementos (lista)
    (if (null lista)
        nil
        (append (list(first lista)) (list(contar_repeticiones lista (first lista))) (contar_elementos (elementos_restantes lista (first lista))))

    )
)



(contar_elementos '())
(contar_elementos '(2 2 2 2 3)) ; Devuelve (2 4 3 1)
(contar-elementos '(2 2 3 3 3)) ; Devuelve (2 2 3 1 5 1)