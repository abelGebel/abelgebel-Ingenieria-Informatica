; 5. Implemente la función SUMATORIA en la que los parámetros deben ser la lista a analizar y
;    los límites en los cuales se analizará la sumatoria.


(defun sumatoria (lista inicio fin)
    (sumatoriaAux lista inicio fin 1)
)

(defun sumatoriaAux (lista inicio fin i)
      (if (> i fin)
          0   
          (if (< i inicio)
              (sumatoriaAux (rest lista) inicio fin (+ 1 i)) 
              (+ (first lista) (sumatoriaAux (rest lista) inicio fin (+ 1 i)))
          )
          
      )
)
(sumatoria '(9 7 5 1 1 2 4 ) 1 1)
(sumatoria '(9 7 5 1 1 2 4 ) 1 2)
(sumatoria '(9 7 5 1 1 2 4 ) 2 5)
(sumatoria '() 2 5)

