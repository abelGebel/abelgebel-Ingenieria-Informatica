import os
os.system('cls')

print("Dado un vector de caracteres contar los elementos que sean letras del alfabeto.")
V = ['a', 'b', 'c', '1', '2', '3', 'L']
N=len(V)
print()
print("Vector elegido: "+str(V))
print()


def contarLetrasIterativo(V,N):
    cantidadLetras=0
    for i in range(N): 
        if (V[i] >= 'a' and V[i] <= 'z') or (V[i] >= 'A' and V[i] <= 'Z'):
            cantidadLetras = cantidadLetras + 1
    return cantidadLetras

def contarLetrasRecursivo(V, N):
    return contarLetrasAux(V,N,0)


def contarLetrasAux(V,N,i):

    if i >= N:
        return 0
    
    if (V[i] >= 'a' and V[i] <= 'z') or (V[i] >= 'A' and V[i] <= 'Z'):
        return 1 + contarLetrasAux(V, N, i + 1)
    
    return contarLetrasAux(V, N, i + 1)


letras = contarLetrasIterativo(V,N)
print("De forma iterativa:")
print("Hay", letras, "letras del alfabeto en el vector")
print()
letras = contarLetrasRecursivo(V, N)
print("De forma recursiva:")
print("Hay", letras, "letras del alfabeto en el vector")
print()