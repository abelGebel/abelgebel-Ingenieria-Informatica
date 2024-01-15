import os
os.system('cls')

print("Calcular la suma de todos los divisores de un número.")
n=12
print("Numero elegido: "+str(n))

def SumaDivisoresIterativo(n):
    acum=0
    
    for i in range(1,n//2+1):
        if n % i ==0:
            acum=acum+i
    return acum



def SumaDivisoresAux(n,m):
    if m==0:
        return 0
    else:
        if n%m==0:
            return m + SumaDivisoresAux(n,m-1)
        else:
            return SumaDivisoresAux(n,m-1)
        

def SumaDivisoresRecursivo(n):
    return SumaDivisoresAux(n,n//2)


resultado=SumaDivisoresIterativo(n)
print("De forma iterativa: "+str(resultado))

resultado=SumaDivisoresRecursivo(n)
print("De forma recursiva: "+str(resultado))

