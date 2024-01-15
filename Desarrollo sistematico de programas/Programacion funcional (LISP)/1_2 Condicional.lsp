; 1. Asigne a tres variables 1 lista distinta a cada una con tres variables numéricas.
; 2. Use el condicional COND para que:

; a) Sume los elementos de las tres listas, si la suma de los elementos de las listas son iguales.
; b) Reste la suma de la primer lista menos la suma de la tercer lista si SOLAMENTE la suma de la 
;    primer lista es igual a la suma de la segunda lista pero no a la suma de la tercera
; c) Multiplique el primer elemento de las tres listas en caso contrario.



(SETF A '(2 2 2))
(SETF B '(1 2 3))
(SETF C '(6 0 0))

(COND ( (= (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C)))
      (+ (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C)) ))
      ( (AND( = (EVAL(CONS '+ A))(EVAL(CONS '+ B))) (NOT (= (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))) 
      (- (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))
      (T (* (FIRST A) (FIRST B) (FIRST C) )) 
)

(SETF A '(2 2 2))
(SETF B '(1 2 3))
(SETF C '(6 1 0))

(COND ( (= (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C))) (+ (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C)) ))
      ( (AND( = (EVAL(CONS '+ A))(EVAL(CONS '+ B))) (NOT (= (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))) (- (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))
      (T (* (FIRST A) (FIRST B) (FIRST C) )) 
)

(SETF A '(4 2 2))
(SETF B '(1 2 3))
(SETF C '(6 1 0))

(COND ( (= (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C))) (+ (EVAL(CONS '+ A)) (EVAL(CONS '+ B)) (EVAL(CONS '+ C)) ))
      ( (AND( = (EVAL(CONS '+ A))(EVAL(CONS '+ B))) (NOT (= (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))) (- (EVAL(CONS '+ A)) (EVAL(CONS '+ C))))
      (T (* (FIRST A) (FIRST B) (FIRST C) )) 
)