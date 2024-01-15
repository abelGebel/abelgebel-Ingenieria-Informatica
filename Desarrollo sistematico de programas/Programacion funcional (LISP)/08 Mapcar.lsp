;8. Realice una función que multiplique por 2 y reste 1 a todos los elementos de una lista (use
;   MAPCAR mas las funciones que considere necesario).




(defun multiplicar-por-dos (x)
  (* x 2))


(defun multiplicar (lista)
    (mapcar #'1- (mapcar #'multiplicar-por-dos lista))
    
)

(multiplicar '(2 4 6 8))
(multiplicar '(0 2 3))
(multiplicar '(-1 -2 -3))


(defun operaciones (a) 
	(- (* a 2) 1)
)

(defun puntoocho (x) 
	(mapcar #'operaciones x)
)

(puntoocho '(1 2 3))