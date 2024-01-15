;6. Realice una función (sin usar MAPCAR) que reciba como parámetro una lista y devuelva otra
;   lista en la cual indique si los elementos son números o no.

;7. Realice lo anterior usando MAPCAR.



(DEFUN LISTA_NUMEROS(LISTA)
        (IF (= 0 (LENGTH LISTA))
            NIL
            (IF (NUMBERP (FIRST LISTA)) 
            (APPEND (CONS T '()) (LISTA_NUMEROS(REST LISTA)))
            (APPEND (CONS NIL '()) (LISTA_NUMEROS(REST LISTA)))
            )
        )
)
(LISTA_NUMEROS '(9 L))
(LISTA_NUMEROS '(1 O 2 O))
(LISTA_NUMEROS '())


(DEFUN LISTA_NUMERICA (LISTA)
    (MAPCAR #'NUMBERP LISTA)
)
(LISTA_NUMERICA '(1 L 3))



(MAPCAR #'NUMBERP '(1 P P P P))