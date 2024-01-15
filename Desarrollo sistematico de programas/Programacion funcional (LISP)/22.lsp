(defun buscarlista (l s)
    (cond ((= s 0) ())
          ((= s 1) (first l))
          (t (buscarlista (rest l) (- s 1))) 
    )
)

(defun buscarelemento (a e)
    (cond ((= e 0) ())
          ((= e 1) (first a))
          (t (buscarlista (rest a) (- e 1))) 
    )
)


(defun dame (l s e)
    (setf a (buscarlista l s))
    (buscarelemento a e)
)

(dame '((1 2)(3 4)(5 6 7)) 3 3)