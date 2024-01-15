;12. Realice una función que reciba un número y devuelva una lista con esa cantidad de números
;    primos. Por ejemplo para DimePrimos(5) debe devolver (1 2 3 5 7)



(defun primo (n)
    (primoAux n (- n 1))
)

(defun primoAux(n m)
    (if (< m 2)
        T
        (if (zerop (mod n m))
            NIL
            (primoAux n (- m 1))
        )
    )
)

(defun generarPrimos(n)
    (generarPrimosAux n 1)
)


(defun generarPrimosAux(n m)
      (if (zerop n)
          ()
          (if (primo m)
              (append (cons m ()) (generarPrimosAux (- n 1) (+ m 1)))
              (generarPrimosAux n (+ m 1))
          
          )
      
      )
)

(generarPrimos 0)
(generarPrimos 2)
(generarPrimos 5)
(generarPrimos 12)



