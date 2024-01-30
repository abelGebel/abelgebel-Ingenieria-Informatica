import os
os.system('cls')

def busquedaBinaria(lista, x):
    izq = 0 
    der = len(lista) -1 

    while izq <= der:
        medio = (izq+der)//2
        print ("izq:", izq, "der:", der, "medio:", medio)

        if lista[medio] == x:
            return medio
        elif lista[medio] > x:
            der = medio-1
        else:
            izq = medio+1
    return -1

lista = [1, 3, 5, 10, 12, 15, 17,30, 31, 35, 60]
x = int(input("¿Valor buscado?: "))
resultado = busquedaBinaria(lista, x)
print ('El elemento se encuentra en la posicion', resultado)

