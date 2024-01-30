''' Escribir un programa que implemente una agenda. En la agenda se podrán guardar nombres y números de
teléfono. El programa debe mostrar el siguiente menú:

● Añadir/modificar: solicita un nombre, si el nombre se encuentra en la agenda, debe mostrar el teléfono
y, opcionalmente, permitir modificarlo si no es correcto. Si el nombre no se encuentra, debe permitir
ingresar el teléfono correspondiente.

● Buscar: solicitando una cadena de caracteres, y muestra todos los contactos cuyos nombres empiezen 
por dicha cadena.

● Borrar: solicita un nombre y si existe nos preguntará si queremos borrarlo de la agenda. 

● Listar: muestra todos los contactos de la agenda.
Implementar el programa con un diccionario.'''

import os

def verificarOpcion():
    while(True):
        try:
            op=int(input("Ingrese una opcion: "))
            if 1<=op<=5:
                break
            else:
                print("INGRESO NO VALIDO...")
        except:
            print("INGRESO NO VALIDO...")
    return op

def menu():
    print('--------AGENDA--------')
    print ("1) Añadir/modificar. ")
    print ("2) Buscar.")
    print ("3) Borrar.")
    print ("4) Listar.")
    print ('5) Salir.')
    opcion = verificarOpcion()
    os.system('cls')
    return opcion

def verificarNombre():
    while True:
        nombre=input('Nombre: ')
        if nombre=='' or nombre.replace(' ','').isalpha()==False:
            print('INGRESO NO VALIDO...')
        else:
            return nombre

def verificarNumero():
    while True:
        numero=input('Numero: ')
        if numero.isnumeric()==False:
            print('INGRESO NO VALIDO...')
        else:
            return numero

def anadirModificar():

    while True:

        nombre = verificarNombre()
        if nombre in agenda:
            print('El nombre ya se encuentra registrado con el numero:')
            print(agenda[nombre])
            cambio=input('Desea cambiarlo?(s/n)')
            if cambio == 's' or cambio == 'S':
                numero = verificarNumero()
                agenda[nombre] = numero
        else:
            numero = verificarNumero()
            agenda[nombre] = numero
            print('Contacto agregado correctamente.')
        print('')
        continuar=input('Desea continuar?(s/n)')
        os.system('cls')
        if continuar == 'n' or continuar== 'N':
            break

    return agenda

def buscar(agenda):
    cadena=input('Ingrese una busqueda: ')
    for clave,valor in agenda.items():
        if clave.lower().startswith(cadena.lower()):
            print(clave,valor)
    print('')
    continuar=input('(Presione ENTER para continuar)')
    os.system('cls')

def borrar(agenda):
    nombre = verificarNombre()
    if nombre in agenda:
        cambio=input(f'Desea borrar el contacto con el nombre {nombre} y el numero {agenda[nombre]}?(s/n) ')
        if cambio=='s' or cambio == 'S':
            del agenda[nombre]
            print('Nombre borrado correctamente')

    else:
        print('Nombre no registrado.')

    print('')
    continuar=input('(Presione ENTER para continuar)')
    os.system('cls')
    return agenda

def listar(agenda):
    print('---CONTACTOS---')
    print('')
    for clave,valor in agenda.items():
        print(clave,valor)
    print('')
    continuar=input('(Presione ENTER para continuar)')
    os.system('cls')



#Principal----------------------------------------------------------------------------------------
os.system('cls')
opcion=0
agenda={"Maxi Lopez": 11,
        "Perez":45,
        "Walker":10,
        "Dazz":39,
        "Maxi Diaz":38}

while (True):
    opcion = menu()
    if opcion == 1:
        agenda = anadirModificar()
    elif opcion ==2:
        buscar(agenda)

    elif opcion == 3:
        agenda = borrar(agenda)

    elif opcion == 4:
        listar(agenda)    
    elif opcion ==5:
        print('Fin registro')
        break
