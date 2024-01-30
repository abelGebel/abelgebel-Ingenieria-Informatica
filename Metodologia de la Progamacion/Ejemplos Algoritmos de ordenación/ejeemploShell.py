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
