;1. Realice la funcion SumaFactorial que reciba com parametro un numero enterno
;   mayor o igual a cero (debe validarse) y calcule la suma de los factoriales 
;   desde 0 hasta ese numero. Si el parametro no es positivo u otro simbolo devolver error.



(defun factorial (n)
    (if (= n 0)
        1
        (* n (factorial (- n 1)))
    )
)

(defun SumaFactorial(n)
    (if (or (not (atom n)) (symbolp n) (< n 0))
        '(E R R O R)
        (if (= 0 n)
            1
            (+ (factorial n) (SumaFactorial(- n 1)))
        )
       
    
    )
    
)
(SumaFactorial 'o)
(SumaFactorial '(3))
(SumaFactorial -3)
(SumaFactorial 0)
(SumaFactorial 1)
(SumaFactorial 3)
(SumaFactorial 4)