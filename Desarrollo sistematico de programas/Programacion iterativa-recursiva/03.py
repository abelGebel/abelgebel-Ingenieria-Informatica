import os
os.system('cls')

print("Dado un vector de dimensión N, formado por caracteres, indicar si el mismo es una palabra de tipo palíndromo.")
print()

vector= ['n','e','u','q','u','e','n']   # <------- parametro
N=len(vector)

print("Palabra elegida: "+str(vector))

def esPalindromoAux(vector,N,M):
    if M>=N:
        return True
    if vector[M]==vector[N]:
        return esPalindromoAux(vector,N-1,M+1)
    else:
        return False


def esPalindromoRecursivo(vector,N):
    return esPalindromoAux(vector,N-1,0)


def esPalindromoIterativo(V,N):
    J=N-1
    for i in range (N//2):
        if V[i]!=V[J]:
            return False
        J=J-1
        
    return True
            

resultado = esPalindromoIterativo(vector,N)
print("Verificar de forma iterativa: "+str(resultado))

resultado=esPalindromoRecursivo(vector,N)
print("Verificar de forma recursiva: "+str(resultado))