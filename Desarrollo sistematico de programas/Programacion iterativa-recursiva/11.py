import os
os.system('cls')
print("Dado un número entero positivo n, calcular la suma de los primeros n números naturales de forma recursiva.")
print("Calcular su factorial")

n=6

print("Valor de n elegido: "+str(n))

def suma(n):
    if n==1:
        return 0
    else:
        return n-1 +suma(n-1)
    
print("Suma: "+str(suma(n)))

def factorial(x):
    if x==0 or x==1:
        resultado=1
    elif x>1:
        resultado=x*factorial(x-1)
    return resultado

print("Factorial: "+str(factorial(n)))

