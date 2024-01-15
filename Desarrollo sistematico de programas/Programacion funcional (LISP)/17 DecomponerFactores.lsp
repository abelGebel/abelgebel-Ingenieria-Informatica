;17. Realice una función que reciba como parámetro un número y devuelva como 
;    resultado una lista cuyos elementos son números enteros que resultan de 
;    descomponer dicho número en sus factores primos, por ejemplo: 
;    N = 48 => (2 2 2 2 3); N = 60 => (2 2 3 5); N = 23 => (23).


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

(defun descomponer (n)
    (descomponerAux n 2)
)

(defun descomponerAux (n i)
    (if (= n 1)
        nil
        (if (and (primo i) (= 0 (mod n i)))
            (append (list i) (descomponerAux (/ n i) i))
            (descomponerAux n (+ i 1))
        )
    
    )


)

(descomponer 6)
(descomponer 7)
(descomponer 8)
(descomponer 48)
(descomponer 100)
(descomponer 23)

