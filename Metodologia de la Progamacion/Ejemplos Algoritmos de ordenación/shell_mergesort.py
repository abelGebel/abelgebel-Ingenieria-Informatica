# Función merge_sort
def merge_sort(lista):
 
   """
   Lo primero que se ve en el psudocódigo es un if que
   comprueba la longitud de la lista. Si es menor que 2, 1 o 0, se devuelve la lista.
   ¿Por que? Ya esta ordenada. 
   """
   if len(lista) < 2:
      return lista
    
    # De lo contrario, se divide en 2
   else:
        middle = len(lista) // 2
        right = merge_sort(lista[:middle])
        left = merge_sort(lista[middle:])
        return merge(right, left)
    
# Función merge
def merge(lista1, lista2):
    """
    merge se encargara de intercalar los elementos de las dos
    divisiones.
    """
    i, j = 0, 0 # Variables de incremento
    result = [] # Lista de resultado
 
   # Intercalar ordenadamente
    while(i < len(lista1) and j < len(lista2)):
        if (lista1[i] < lista2[j]):
            result.append(lista1[i])
            i += 1
        else:
            result.append(lista2[j])
            j += 1
 
   # Agregamos los resultados a la lista
    result += lista1[i:]
    result += lista2[j:]
 
    # Retornamos el resultados
    return result



# Prueba del algoritmo

lista = [31,3,88,1,4,2,42]

merge_sort_result = merge_sort(lista)  
print(merge_sort_result)


def shellSort(lista):
    n = len(lista) #8
    gap = n // 2   #4
    while gap > 0:   #2<0
        for i in range(gap, n):   #(2,8)
            tmp = lista[i]    #tmp =  lista[2] -> 1
            j = i              #j=2
            while j >= gap and lista[j - gap] > tmp:  #j>=2   lista[0] > lista[2] 
                lista[j] = lista[j - gap]
                j -= gap  #j=0
            lista[j] = tmp  #lista[0]=lista[2] -> 2

        gap = gap // 2   # 2
    return lista
    
lista=[3,5,1,5,7,8,9,2]
lista=shellSort(lista)
print(lista)