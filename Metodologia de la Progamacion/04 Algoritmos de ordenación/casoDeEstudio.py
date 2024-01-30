'''
CE: Dada la siguiente lista de números, realice en forma manual la ordenación de los mismos utilizando
el método SHELL
5 2 9 10 1 11 19 25 50
'''
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

lista=[5,2,9,10,1,11,19,25,50]
lista = shellSort(lista)
print(lista)

