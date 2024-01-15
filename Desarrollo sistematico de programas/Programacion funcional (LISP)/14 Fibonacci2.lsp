(defun fibonacci (n)
  (if (= n 0)
      nil
      (if (= n 1)
          '(0)
          (let fibonacci-aux ((n n) (a 0) (b 1) (acc '()))
            (if (= n 2)
                (reverse (cons 1 (cons 0 acc)))
                (fibonacci-aux (- n 1) b (+ a b) (cons a acc))))))))



(fibonacci 0)
(fibonacci 1)
(fibonacci 2)
(fibonacci 3)