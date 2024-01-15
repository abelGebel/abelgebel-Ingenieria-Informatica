import os
os.system('cls')

print("Determinar si un numero n es primo o no.")
n=19
print("Numero elegido: "+str(n))

def esPrimoIterativo(n):

    for i in range(2,n//2+1):
        if n%i==0:
            return False
    return True


def primoRecursivoAux(n,m):
    if m<=1:
        return True
    else:
        if n%m==0:
            return False
        else:
            return primoRecursivoAux(n,m-1)


def esPrimoRecursivo(n):
    return primoRecursivoAux(n,n//2+1)


resultado=esPrimoIterativo(n)
print("De forma iterativa: "+str(resultado))

resultado=esPrimoRecursivo(n)
print("De forma recursiva: "+str(resultado))

