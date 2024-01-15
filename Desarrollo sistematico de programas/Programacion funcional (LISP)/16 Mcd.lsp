(DEFUN MCD (X Y)
    (MCDAUX X Y X)

)

(DEFUN MCDAUX (X Y N)
    (IF (= N 1)
        1
        (IF (AND (ZEROP (MOD X N)) (ZEROP (MOD Y N)))
        N
        (MCDAUX X Y (- N 1))
        )
    
    )
)
(MCD 1 3)
(MCD 8 6)
(MCD 12 4)
(MCD 3 9)
(MCD 7 7)