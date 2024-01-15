;13. Sin usar la función primitiva LENGHT, realice una función que reciba como parámetro una
;    lista y devuelva la cantidad de elementos de dicha lista.



(DEFUN CANTIDAD(LISTA)
    (IF (NULL LISTA)
    0   
    (+ 1 (CANTIDAD (REST LISTA)))
    )

)
(CANTIDAD ())
(CANTIDAD '(3 2 3 O D))
(CANTIDAD '(3 2 3))

(length ())