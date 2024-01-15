; 4. Implemente la función SUMATORIA de una lista en forma recursiva

(DEFUN SUMATORIA (LISTA)
       (IF (= 0 (LENGTH LISTA))
           0
           (+ (FIRST LISTA) (SUMATORIA(REST LISTA)))
           
       )

)
(SUMATORIA '(1 2 3 4))

(SUMATORIA '(5 5 5 1 1))
