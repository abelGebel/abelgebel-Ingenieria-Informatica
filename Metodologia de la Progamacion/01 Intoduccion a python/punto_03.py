'''
Realizar un programa que genere aleatoriamente N números enteros y los guarde en una lista, luego
realizar lo siguiente:
a. Mostrar los valores generados
b. Mostrar los primeros M valores de la lista. Validar que M sea menor que el tamaño de la lista.
c. Mostrar los valores pares y la suma de estos.
d. Verificar si la lista se encuentra ordenado en forma descendente.
'''

import os
import random
os.system('cls')

def verificarOpcion():
    while (True):
        op = input('Ingrese una opcion: ')
        print('')
        if op.isalpha():
            op=op.lower()
            if op=='a' or op=='b' or op=='c' or op== 'd' or op=='e' or op=='f':
                return op
            else:
                print('OPCION INCORRECTA...')
        else:
            print('OPCION INCORRECTA...')

def menu():
    print('a. Mostrar los valores generados')
    print('b. Mostrar los primeros M valores de la lista.')
    print('c. Mostrar los valores pares y la suma de estos.')
    print('d. Verificar si la lista se encuentra ordenado en forma descendente.')
    print('e. Salir')
    print('f. Ingresar otros valores')



def validarN():
    while True:
        try:
            valor=int(input("Ingrese la cantidad de elementos de la lista aleatoria: "))
            return valor
        except:
            print()
            print("INGRESE UN VALOR VALIDO")
            print()

def inicializarLista():
    lista=[]
    N = validarN()
    for i in range(N):
        lista.append(random.randint(0,100))
    print (lista)
    print()
    return lista

def validarM():
    while True:
        try:
            valor=int(input("Ingrese hasta que valor de la lista desea imprimir en pantalla."))
            if valor<=len(lista):
                return valor
            else:
                print("Valor fuera de rango, intente nuevamente...")
        except:
            print("INGRESE UN VALOR VALIDO")


def mostrarValores(lista):
    listaM=[]
    M = validarM()
    for i in range(M):
        listaM.append(lista[i])
    print(listaM)

def sumaDePares(lista):
    print()
    print("Lista de numeros pares:")
    listaPares=[]
    suma=0
    for i in range(len(lista)):
        if lista[i]%2==0:
            listaPares.append(lista[i])
            suma+=lista[i]

    print(listaPares)
    print("La suma de los numeros pares es:",suma)
    print()
    
def verificarOrdenacion(lista):
    band=True
    for i in range(len(lista)-1):
        for j in range(1,len(lista)):
            if lista[i]<lista[j]:
                band=False
                break

    if band==False:
        print("La lista no esta ordenada de forma descendente.")
    else:
        print("La lista esta ordenada de forma descendente.")
    print()
    

#principal---------------------------------------------------------------------------------------
opcion=''
lista=inicializarLista()

while True:
    menu()
    opcion=verificarOpcion()
    os.system('cls')
    match opcion:
        case 'a':
            print(lista)
        case 'b':
            mostrarValores(lista)
        case 'c':
            sumaDePares(lista)
        case 'd':
            verificarOrdenacion(lista)
        case 'e':
            break
        case 'f':
            lista=inicializarLista()

os.system('cls')
print("FIN PROGRAMA...")