import os
os.system('cls')


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

lista=[7,8,10,9,2,3,4,1,5,6]
print(quicksort(lista))


"""



def quickSort(lista, start, stop):   #lista , 0, 1
    if stop - start > 0:   # 1-0 > 0  
        pivot, left, right = lista[start], start, stop    # lista[0]=9 , 0 , 5
        while left <= right:      #   1 <= 2

            while lista[left] < pivot:  # lista[1]=10 < 9
                left += 1 # 
            while lista[right] > pivot: # lista[2]=7 > 9
                right -= 1  # 
            if left <= right:    # 1 <= 2
                lista[left], lista[right] = lista[right], lista[left]    #  10=7 , 7=10
                left += 1  #  2
                right -= 1   # 1 
                                                        #[8,7,10,9,12,15]
        quickSort(lista, start, right)
        quickSort(lista, left, stop)
    return lista


lista=[9,10,7,8,12,15]
lista=quickSort(lista,0,len(lista)-1)
print(lista)


"""