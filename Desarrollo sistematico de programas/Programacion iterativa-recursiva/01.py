import os
os.system('cls')

print("Sumar los elementos pares de un vector de números de dimensión N. No se puede usar una función Par().")
print()

vector=[1,2,3,4,5,6,7,8]
N=len(vector)

print("Lista utilizada: "+str(vector))


def sumarListaIterativo(vector,N):
    suma=0
    for i in range(N):
        if vector[i]%2==0:
            suma=suma+vector[i]
    return suma


def sumarListaRecursivo(vector,N):
    if N==-1:
        return 0
    else:
        if vector[N]%2==0:
            return vector[N]+sumarListaRecursivo(vector,N-1)
        else:
            return sumarListaRecursivo(vector,N-1)


resultado=sumarListaIterativo(vector,N)
print("De forma iterativa: " + str(resultado))

resultado=sumarListaRecursivo(vector,N-1)
print("De forma recursiva: " + str(resultado))