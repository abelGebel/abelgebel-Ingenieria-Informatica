;15. Implemente una función que reciba como parámetro una lista formada por sublistas, y los
;    parámetros de búsqueda en ella. Por ejemplo: (DAME ‘((1 2 3) (4 5 6) (7 8 9)) 3 2) debe
;    devolver el tercer elemento de la segunda sublista. Realice las validaciones correspondientes
;    (que se traten de sublistas y que los parámetros de búsqueda sean validados), muestre un
;    mensaje en caso contrario.




(DEFUN ENCONTRAR (LISTA A B)
    (ENCONTRAR_AUX LISTA A B 1 1 T)
)


(DEFUN ENCONTRAR_AUX (LISTA A B C D BAND)
    (IF (AND (EQUAL A C) (EQUAL B D))
        (FIRST LISTA)
        
        (IF (NOT(EQUAL B D))
             (ENCONTRAR_AUX (REST LISTA) A B C (+ 1 D) T)
             (IF (EQUAL BAND T)
                (ENCONTRAR_AUX (FIRST LISTA) A B C D NIL)
                (ENCONTRAR_AUX (REST LISTA) A B (+ 1 C) D NIL)
             )    
        )      
     )    
)

(ENCONTRAR '((1 2) (3 5) (7 4 6) (3 3 10 9 5)) 4 4 )

(ENCONTRAR '((2 3)) 3 1 )






(defun buscarlista (l s)
    (cond ((= s 0) ())
        ((= s 1) (first l))
        (t (buscarlista (rest l) (- s 1))) 
    )
)

(defun buscarelemento (a e)
(
cond ((= e 0) ())
((= e 1) (first a))
(t (buscarlista (rest a) (- e 1))) 
)
)


(defun dame (l s e)
(setf a (buscarlista l s))
(buscarelemento a e)

(dame '((1 2)(3 4)'(5 6)) 2 2 )

)