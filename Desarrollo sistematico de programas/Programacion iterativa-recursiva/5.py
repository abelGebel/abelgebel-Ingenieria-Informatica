import os
os.system('cls')

print("Dado un Número entero Positivo, determinar la cantidad de Divisores del mismo.")

n=8
print("Numero entero elegido: "+str(n))


def calcularDivisoresIterativo(n):
    i=2
    cantidadDivisores=1

    while (i<=n//2):
        if n%i==0:
            cantidadDivisores=cantidadDivisores+1
        i=i+1
    return cantidadDivisores


def divisoresAux(n,m):
    if m==1:
        return 1
    else:
        if n%m==0:
            return 1+divisoresAux(n,m-1)
        else:
            return divisoresAux(n,m-1)
        
def calcularDivisoresRecursivo(n):
    return divisoresAux(n,n//2)


resultado=calcularDivisoresIterativo(n)
print("De forma recursiva: "+str(resultado))    

resultado=calcularDivisoresRecursivo(n)
print("De forma recursiva: "+str(resultado))    


