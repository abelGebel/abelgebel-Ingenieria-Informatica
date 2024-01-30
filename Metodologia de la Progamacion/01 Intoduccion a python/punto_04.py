'''
Escribir un programa que realice lo siguiente:
a. Cargar una lista con 30 números enteros aleatorios entre 1 y 1000 que no se repitan y que no
sean primos
b. Mostrar los números de la lista
c. Modificar todos los números que sean múltiplos de 3 elevándolos al cuadrado
d. Ingrese un número entero denominado objetivo y determine la cantidad de pares de elementos
del vector que tienen una diferencia igual al valor objetivo.
'''

import os
import random

def verificarOpcion():
    while (True):
        op = input('Ingrese una opcion: ')
        print('')
        if op.isalpha():
            op=op.lower()
            if op=='a' or op=='b' or op=='c' or op== 'd' or op=='e':
                return op
            else:
                print('OPCION INCORRECTA...')
        else:
            print('OPCION INCORRECTA...')

def menu():
    print('a. Cargar una lista con 30 números enteros aleatorios entre 1 y 1000 que no se repitan y que no sean primos')
    print('b. Mostrar los números de la lista')
    print('c. Modificar todos los números que sean múltiplos de 3 elevándolos al cuadrado')
    print('d. Ingrese un número entero denominado objetivo y determine la cantidad de pares de elementos del vector que tienen una diferencia igual al valor objetivo.')
    print('e. Salir')


def cargarLista():
    lista=[]
    for i in range(30):
        while True:
            numero = random.randint(1,100)
            if numero not in lista:

                if numero > 1:
                    cont = 0
                    i = 2
                
                    while i < numero and cont == 0:
                        resto = numero % i
                        if resto == 0:
                            cont += 1
                        i += 1

                    if cont !=0:
                        lista.append(numero)
                        break
            
    print (lista)
    return lista


def modificarNumeros(lista):
    for i in range(30):
        if (lista[i] % 3 ) == 0:
            lista [i] **= 2
    print (lista)
    return lista



def ingresarObjetivo(lista):
    objetivo = int(input("Ingrese el valor objetivo: "))

    cont = 0
    for i in range (29):
        for j in range (1,30):
            if lista[i] - lista[j] == objetivo:
                cont +=1

    for i in range (29):
        for j in range (1,30):
            if lista[j] - lista[i] == objetivo:
                cont +=1
    print (" la cantidad de pares de elementos del vector que tienen una diferencia igual al valor objetivo es: ",cont)



#principal----------------------------------------------------------------------------------------------
os.system('cls')
opcion=''
lista=[]
while True:
    menu()
    opcion=verificarOpcion()
    os.system('cls')
    match opcion:
        case 'a':
            lista = cargarLista()
        case 'b':
            print(lista)
        case 'c':
            if lista==[]:
                print("LISTA VACIA...")
            else:
                lista = modificarNumeros(lista)              
        case 'd':
            if lista==[]:
                print('LISTA VACIA...')
            else:
                ingresarObjetivo(lista)
        case 'e':
            break
        

os.system('cls')
print("FIN PROGRAMA...")