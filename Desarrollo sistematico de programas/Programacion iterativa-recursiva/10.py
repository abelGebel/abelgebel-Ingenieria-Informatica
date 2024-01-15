import os
os.system('cls')
print("Dado un número entero positivo n, calcular el n-ésimo número de la secuencia de Fibonacci. ")
print("Los dos primeros números en la secuencia son 0 y 1.")

n=8
print("Valor de n elegido: "+str(n))

def fibonacciIterativo(n):
    if n==0:
        return 0
    else:
        if n==1:
            return 1
        else:
            a=0
            b=1
            for i in range(2,n+1):
                siguiente=a+b
                a=b
                b=siguiente
            return b


def fibonacciRecursivo(n):   # 0, 1, 1, 2, 3, 5, 8, 13, 21
    if n==0:
        return 0
    else:
        if n==1:
            return 1
        else:
            return fibonacciRecursivo(n-1)+fibonacciRecursivo(n-2)
        

resultado = fibonacciIterativo(n)
print("De forma iterativa: "+str(resultado))       

resultado = fibonacciRecursivo(n)
print("De forma recursiva: "+str(resultado))


