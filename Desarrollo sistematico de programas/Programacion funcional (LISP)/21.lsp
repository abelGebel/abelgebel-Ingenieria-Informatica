(defun fibonacci (n)

    (if (= 0 n)
        0
        (if (= 1 n)
            1
            (+ (fibonacci (- n 2) (fibonacci (- n 1))))
        )
    )     
)

(defun listaFibonacci (n)

    (if (= 0 n)
        0
        (append (list(fibonacci (- n 1))) (list(listaFibonacci (-n 1))))
    )
    

)

(listaFibonacci 10)