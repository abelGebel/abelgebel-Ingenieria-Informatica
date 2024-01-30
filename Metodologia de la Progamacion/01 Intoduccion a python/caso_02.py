'''
Diseñar el siguiente programa:
a. Cargar una lista con N números generados en forma aleatoria.
b. Mostrar los elementos cargados en la lista
c. Solicitar un número y contar cuántas veces se repite en la lista.
d. Mostrar todos los números de la lista que se encuentren en el intervalo [a, b].
e. Calcular la suma de los números que superan el promedio.
'''

import random
import os

def verificarOpcion():
    while True:
        try:
            op = int(input("Ingrese una opcion: "))
            if op < 1 or op >6:
                print ("ERROR. Intentelo nuevamente...")
            else:
                break    
        except:
            print("ERROR. Intentelo nuevamente...")
    return op

def verificarNumero():
    while True:
        try:
            num = int(input())
            return num 
        except:
            print('VALOR INCORRECTO, DEBE INGRESAR UN NUMERO ENTERO...')
            

def menu():
    print("")
    print("1) Cargar una lista con N números generados en forma aleatoria.")
    print("2) Mostrar los elementos cargados en la lista.")
    print("3) Solicitar un número y contar cuántas veces se repite en la lista.")
    print("4) Mostrar todos los números de la lista que se encuentren en el intervalo [a, b].")
    print("5) Calcular la suma de los números que superan el promedio.")
    print("6) Salir")
    print("")
    opcion=verificarOpcion()
    os.system('cls')
    return opcion



def generarLista():
    
    N = random.randint(10,30)
    for i in range(N):
        numero=random.randint(-10,10)
        lista.append(numero)
    print(f'Lista generada: {lista}')
    return lista

def contar(lista):
    print('Ingrese un valor')
    valor = verificarNumero()

    print("El valor ingresado se encuentra",lista.count(valor),"vez/veces en la lista")


def mostrarIntervalor(lista):
    listaAux=[]
    print("Ingrese un valor a:")
    a = verificarNumero()
    print("Ingrese un valor b:")
    b = verificarNumero()

    if a>b:
        c=a
        a=b
        b=c
        
    print(f"Valores que se encuentran entre {a} y {b}:")
    for i in range(len(lista)):
        if lista[i]>=a and lista[i]<=b:
            listaAux.append(lista[i])
    print(listaAux)

    
def promedio(lista):
    suma=0
    listaAux=[]
    for i in range(len(lista)):
        suma+=lista[i]
    
    media=suma/len(lista)
    print(f'media: {media}')
    print("Valores de la lista que superan la media:")

    for i in range(len(lista)):
        if lista[i]>media:
            listaAux.append(lista[i])
    print(listaAux)


#principal--------------------------------------------------------------------------------------------------
os.system('cls')
opcion = 0
lista=[]

while opcion!=6:
    opcion=menu()

    if opcion==1:
        lista = generarLista()

    elif opcion==2:
        print(lista)

    elif opcion==3:
        contar(lista)
    
    elif opcion==4:
        mostrarIntervalor(lista)

    elif opcion==5:
        promedio(lista)

print('FIN PROGRAMA...')