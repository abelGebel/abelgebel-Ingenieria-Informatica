;16. Realice una función que reciba como parámetro dos números y devuelva el máximo común
;    divisor de dichos números.


(DEFUN EUCLIDES (A B)
    (IF (ZEROP B)
        A
        (EUCLIDES B (MOD A B))   
    )
)

(EUCLIDES 150 24)
(EUCLIDES 12 4)
(EUCLIDES 15 1)
(EUCLIDES 24 150)
(EUCLIDES 4 12)
(EUCLIDES 1 15)
