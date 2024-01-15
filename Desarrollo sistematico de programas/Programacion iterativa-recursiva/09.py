import os
os.system('cls')

print("Calcular la suma de las diagonales de dos matrices cuadradas de dimension nxn.")
n=3
m1=[[1,2,3],
    [4,5,6],
    [7,8,9]]

m2=[[1,2,3],
    [4,2,6],
    [9,8,3]]


def mediaIterativa(m1,m2,n):
    suma=0
    for i in range(0,n):
        suma=suma + m1[i][i] + m2[i][i]
    return suma

def mediaRecursiva(m1,m2,n):

    if n<0:
        return 0
    else:
        return m1[n][n] + m2[n][n] + mediaRecursiva(m1,m2,n-1)


resultado = mediaIterativa(m1,m2,n)
print("De forma iterativa: "+str(resultado))
resultado =mediaRecursiva(m1,m2,n-1)
print("De forma recursiva: "+str(resultado))
