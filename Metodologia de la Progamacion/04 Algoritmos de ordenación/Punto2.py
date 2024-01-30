'''
Mostrar los pasos del ordenamiento de la lista: 6, 0, 3, 2, 5, 7, 4, 1 con los métodos de inserción y con
merge sort. 
'''
def insercion(lista):
    for i in range(1,len(lista)):
        actual = lista[i]
        indice = i

        while indice>0 and lista[indice-1]>actual:
            lista[indice]=lista[indice-1]
            indice-=1
        lista[indice]=actual
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



lista=[ 6, 0, 3, 2, 5, 7, 4, 1]
print (lista)
print()
print("Ordenamiento por insercion:")

lista=insercion(lista)
print(lista)

print("")
lista=[ 6, 0, 3, 2, 5, 7, 4, 1]
print (lista)
print("Ordenamiento por merge sort:")

lista=mergeSort(lista)
print(lista)




