'''
Mediante un menú de opciones realizar el siguiente programa modular para gestionar el listado de notas
de un examen para los alumnos de una institución educativa:
a. Leer la lista de alumnos desde el fichero alumnos.txt y guardar su contenido en un diccionario. Cada
alumno cuenta con DNI, nombre y nota.
b. Mostrar el listado de alumnos con sus respectivas notas.
c. Modificar la nota de un alumno.
'''
import os

def verificarOpcion():
    while True:
        try:
            op = int(input("Ingrese una opcion: "))
            if op < 1 or op >5:
                print ("ERROR. Intentelo nuevamente...")
            else:
                break    
        except:
            print("ERROR. Intentelo nuevamente...")
    return op

def menu():
    print("1) Leer lista de alumnos")
    print("2) Mostrar lista de alumnos")
    print("3) Modificar nota de un alumno")
    print("4) Salir")
    opcion=verificarOpcion()
    print()
    return opcion

'''
def cargarLista(lista):
    fichero=open('./alumnos.txt','r')
    lista.append(fichero.readline())
    fichero.close()
    return lista
'''

def cargarLista():

    listado=[]
    fichero=open('alumnos.txt','r')

    texto=fichero.readlines()
    fichero.close()


    for linea in texto:
        print(linea.split(";"))
        listado.append(linea.split(";"))

    print("")
    continuar = input("(ENTER para continuar)")
    print("")

    return listado
    '''
    lista=[]
    with open('./alumnos.txt', 'r') as fichero:
        # Utiliza readlines() para obtener todas las líneas del archivo como una lista
        lineas = fichero.readlines()

        #Añade todas las líneas al final de la lista
        #lista.extend(lineas)
        lista.extend(linea.strip() for linea in lineas)

    # Devuelve la lista completa
    return lista
    '''


def mostrarLista(lista):
    for i in lista:
        print(i)
    

#Principal-------------------------------------------------------------------------------------------------------
os.system('cls')
lista =[]
opcion=0
    

while (True):
    opcion = menu()
    if opcion == 1:
        lista = cargarLista() 
    elif opcion ==2:
        mostrarLista(lista)
        print(lista)
    elif opcion == 4:
        break

        



    
   
        






            
        