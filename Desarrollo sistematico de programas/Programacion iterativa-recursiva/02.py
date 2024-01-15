import os
os.system('cls')
print("Calcular la potencia n de un número x.")
print()

def potenciaIterativo(n,x):

    resultado=1

    for i in range(n):
        resultado=resultado*x
    return resultado


def potenciaRecursivo(n,x):

    if n==0:
        return 1
    else:
        if n==1:
            return x
        else:
            return x*potenciaRecursivo(n-1,x)


n=3
x=5
resultado=potenciaIterativo(n,x)
print("De forma iterativa: " + str(resultado))

n=2
x=8
resultado=potenciaRecursivo(n,x)
print("De forma recursiva: " + str(resultado))