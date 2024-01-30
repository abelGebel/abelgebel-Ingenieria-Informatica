'''
Implemente los métodos merge sort, quicksort y shell. Valide su funcionamiento utilizando un una lista
que contenga N números enteros generados al azar.
'''
import random

def inicializar():
    lista=[]
    N = random.randint(5,20)
    for i in range(N):
        numero=random.randint(0,99)
        lista.append(numero)
    return lista

def mergeSort(lista):

    if len(lista) < 2:
        return lista
    
    else:
        mitad=len(lista)//2
        derecha=mergeSort(lista[:mitad])
        izquierda=mergeSort(lista[mitad:])
        return merge(derecha,izquierda)

def merge(lista1,lista2):
    i,j=0,0
    resultado=[]

    while(i<len(lista1) and j<len(lista2)):
        if (lista1[i] <lista2[j]):
            resultado.append(lista1[i])
            i+=1
        else:
            resultado.append(lista2[j])
            j+=1

    resultado += lista1[i:]
    resultado += lista2[j:]
    return resultado

def particionado(lista):
    pivote = lista[0]
    menores = []
    mayores = []

    for i in range(1,len(lista)):
        if lista[i]<pivote:
            menores.append(lista[i])
        else:
            mayores.append(lista[i])
    return menores,pivote,mayores

def quicksort(lista):
    if len(lista)<2:
        return lista
    menores,pivote,mayores=particionado(lista)
    return quicksort(menores) + [pivote] + quicksort(mayores)

def shellSort(lista):
    n = len(lista)
    gap = n//2
    while gap > 0:
        for i in range(gap,n):
            tmp = lista[i]
            j=i
            while j>=gap and lista[j-gap] > tmp:
                lista[j] = lista[j-gap]
                j-=gap
            lista[j]=tmp
        gap=gap//2
    return lista




#principal
lista=inicializar()
print(lista)

lista1 = mergeSort(lista)
print(lista1)

lista2 = quicksort(lista)
print(lista2)

lista3 = shellSort(lista)
print(lista3)
