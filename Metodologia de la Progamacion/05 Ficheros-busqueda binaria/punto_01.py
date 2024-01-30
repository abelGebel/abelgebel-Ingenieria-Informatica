'''
Utilizando listas diseñar un programa modular que permita gestionar los vehículos de un concesionario
que se dedica a la venta de automóviles usados, las funcionalidades solicitadas son:
a. Leer la lista de vehículos desde el fichero vehiculos.txt y guardarlos en un diccionario.
b. Buscar un automóvil por su dominio utilizando la búsqueda binaria.
c. Buscar un automóvil por su marca. La misma debe soportar búsquedas por ocurrencias, es decir
que si por ejemplo se ingresa “citr” debe devolver todos los vehículos de la marca Citroen (sin
considerar mayúsculas ni minúsculas).
d. Crear un segundo fichero que guarde solamente los vehículos de una sola marca a pedido del
usuario. El nombre del fichero deberá ser igual a la marca solicitada (por ejemplo fiat.txt)
'''


import os
from typing import TextIO

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


def menu():
    print("1) Leer lista de vehiculos")
    print("2) Buscar automovil por dominio")
    print("3) Buscar automovil por marca")
    print("4) Crear fichero de una marca")
    print("5) Salir")
    print("6) Mostrar listado")
    print("")
    opcion= verificarOpcion()
    os.system('cls')
    return opcion



def leerLista():
    listado=[]
    fichero=open('vehiculos.txt','r')

    texto=fichero.readlines()
    fichero.close()


    for linea in texto:
        print(linea.split(";"))
        listado.append(linea.split(";"))

    print("")
    continuar = input("(ENTER para continuar)")
    print("")

    return listado


def busquedaBinaria(listado,busqueda):
    izq = 0 
    der = len(listado) -1

    while izq <= der:
        medio = (izq+der)//2
        if listado[medio][0] == busqueda:
            return medio
        elif listado[medio][0] > busqueda:
            der = medio-1
        else:
            izq = medio+1


def buscarDominio(listado):
    for i in range(len(listado)-1):

        for j in range(len(listado)-1):
            if listado[j][0] > listado[j+1][0]:
                aux = listado[j]
                listado[j] = listado[j+1]
                listado[j+1] = aux

    busqueda=input("Ingrese el dominio del vehiculo que desea bucar: ")
    resultado = busquedaBinaria(listado, busqueda)
    print (listado[resultado])
    
    print("")
    continuar = input("(ENTER para continuar)")
    print("")


def  buscarMarca(listado):
   
    marca=input("Que marca desea buscar?: ")
    marca=marca.lower()
    for i in range(len(listado)):
        elementoLista=str(listado[i][1])
        elementoLista=elementoLista.lower()
        busqueda = elementoLista.find(marca)
        if busqueda!=-1:
            print(listado[i])
    print("")
    continuar = input("(ENTER para continuar)")
    print("")


def ficheroMarcas(listado):


    print("De que marca quiere hacer un nuevo fichero?")
    print("1: Renault")
    print("2: Ford")
    print("3: Citroen")
    marca=input()

    if marca=="1":
        marca="Renault"
    elif marca=="2":
        marca="Ford"
    elif marca=="3":
        marca="Citroen"
    else:
        print("VALOR INCORRECTO")
        return

    x=[]
    try:
        fichero = open(f'{marca}.txt', 'x')
        fichero.close()
    except FileExistsError:
        print()


    for i in range(len(listado)):
        if listado[i][1]==marca:
            x.append(listado[i])

    texto=""
    for i in range(len(x)):
        texto=texto+str(x[i])+";"+'\n'
    
    fichero = open(f'{marca}.txt', 'w')
    fichero.writelines(texto)
    fichero.close       
  
#principal

os.system('cls')
listado = []
opcion = 0

while opcion != 5:
    os.system('cls')
    opcion = menu()
    if opcion == 1:
        listado = leerLista()
    elif opcion==2:
        buscarDominio(listado)
    elif opcion==3:
        buscarMarca(listado)
    elif opcion==4:
        ficheroMarcas(listado)
    elif opcion==6:
        for linea in listado:
            print(linea)
        continuar = input("(ENTER para continuar)")

            
            