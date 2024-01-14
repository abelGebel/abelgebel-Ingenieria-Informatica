import os
os.system('cls')

print("Resolver la multiplicación de dos números A y B pasados como argumentos, sin utilizar el signo de multiplicación.")
A=3
B=7
print("Valor de A: "+str(A))
print("Valor de B: "+str(B))

def multiplicarIterativo(A,B):
    producto=0
    for i in range(1,B+1):
        producto=producto+A
    return producto



def multiplicarRecursivo(A,B):
    if A==0 or B==0:
        return 0
    else:
        if B==1:
            return A
        else:
            return A+multiplicarRecursivo(A,B-1)


resultado=multiplicarIterativo(A,B)
print("De forma iterativa: "+str(resultado))

resultado=multiplicarRecursivo(A,B)
print("De forma recursiva: "+str(resultado))
