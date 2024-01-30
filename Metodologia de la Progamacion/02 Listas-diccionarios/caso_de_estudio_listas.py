'''
CE: Mediante un menú de opciones realizar el siguiente programa modular para gestionar el listado de notas de
un examen para los alumnos de una institución educativa:

a. Registrar alumnos: para cada uno se debe solicitar DNI, nombre y nota. Validar que la nota se
encuentre entre 0 y 10. El proceso finaliza cuando el dni es igual a cero.
b. Mostrar el listado de alumnos con sus respectivas notas.
c. Buscar un alumno por su DNI y mostrar su nombre y nota.
d. Modificar los datos de un alumno buscando por DNI (el DNI no se puede modificar).
e. Eliminar un alumno buscando por su DNI. Emitir un mensaje de confirmación.
f. Mostrar el promedio de las notas ingresadas
g. Salir
'''

import os

def verificarOpcion():
    while(True):
        try:
            op=int(input("Ingrese una opcion: "))
            if 1<=op<=7:
                break
            else:
                print("INGRESO NO VALIDO...")
        except:
            print("INGRESO NO VALIDO...")
    return op

def menu():
    print("1) Regristrar alumnos")
    print("2) Mostrar listado")
    print("3) Buscar alumno por DNI")
    print("4) Modificar datos de alumno por DNI")
    print("5) Elininar datos de alumno por DNI")
    print("6) Mostrar promedio de las notas ingresadas")
    print("7) Salir")
    print("")
    opcion=verificarOpcion()
    os.system('cls')
    return opcion

def verificarDni():
    while (True):
        try:
            dni=int(input("DNI: "))
            if (len(str(dni)) < 7 or len(str(dni)) > 8) and dni != 0:
                print("INGRESO NO VALIDO...")
            else:
                break
        except:
            print("INGRESO NO VALIDO...")       
    return dni

def verificarNombre():
    while True:
        nombre=input('Nombre: ')
        if len(nombre) < 6 or ' ' not in nombre or nombre.replace(' ','').isalpha()==False:
            print('NOMBRE NO VALIDO')
        else:
            break
    return nombre          

def verificarNota():

    while(True):
        try:
            num = int(input("Nota: "))
            if num<0 or num>10:
                print("ERROR. Nota no valida...")
            else:
                break
        except:
            print("INGRESO NO VALIDO...")
    return num

def registrarAlumnos():

    while(True):
        print('')
        print('(Ingrese un DNI igual a 0 para finalizar)')
        print('')
        dni=verificarDni()
        if dni==0:
            break
        else:
            nombre=verificarNombre()
            nota = verificarNota()
            listado.append([dni,nombre,nota])
            print("Alumno agregado correctamente")
            print("")
            continuar=input("(Presione ENTER para continuar)")
            os.system('cls')
    os.system('cls')
    return listado

def mostrarListado(listado):
    print("----------LISTADO DE ALUMNOS----------")
    print("")
    for i in enumerate(listado):
        print(i)
    print("")
    continuar=input("(precione una tecla para continuar)")
    os.system('cls')

def buscarAlumno(listado):
    dni = verificarDni()
    band = False
    for i in range(len(listado)):
        if dni == listado[i][0]:
            print (listado[i])
            band = True
            break
    if band == False:
        print('Alumno no registrado')
    print("")
    continuar=input("(Precione ENTEER para continuar)")
    os.system('cls')

def modificarAlumno():
    dni = verificarDni()
    band = False

    for i in range(len(listado)):
        if dni == listado[i][0]:
            nombre = verificarNombre()
            nota=verificarNota()
            listado[i][1]=nombre
            listado[i][2]=nota
            band=True
            break
    print("")
    if band == False:
        print('Alumno no registrado')
    else:
        print("Alumno modificado correctamente")
    print("")
    continuar=input("(Precione ENTER para continuar)")
    os.system('cls')
    return listado

def eliminarAlumno():
    for i in range(len(listado)):
        print(listado[i])
    print("")

    dni=verificarDni()
    band = False
    os.system('cls')

    for i in range(len(listado)):
        if listado[i][0]==dni:
            del listado[i]
            band = True
            break

    print("")
    if band == True:
        print("Alumno borrado correctamente")
    else:
        print('Alumno no registrado')
    print("")
    continuar = input("(Presione ENTER para continuar)")
    os.system('cls')
    return listado

def promedio(alumnos):
    suma=0
    for i in range(len(alumnos)):
        suma+=alumnos[i][2]
    promedio = float(suma/len(alumnos))
    print("")
    print(f'El promedio de las notas ingresadas es: {round(promedio,2)}')   
    print("")
    continuar = input("(Presione ENTER para continuar)")
    os.system('cls')

#Principal
os.system('cls')
opcion = 0
listado=[[455298029,"Garcia",6],
        [41936168,"Lopez",1],
        [43817333,"Diaz",7],
        [3333333,"lol",5]]

while (True):
    opcion=menu()
    if opcion == 1:
        listado =registrarAlumnos()
    elif opcion ==2:
        mostrarListado(listado)
    elif opcion == 3:
        buscarAlumno(listado)
    elif opcion==4:
        listado = modificarAlumno()
    elif opcion == 5:
        listado = eliminarAlumno()
    elif opcion ==6:
        promedio(listado)
    elif opcion == 7:
        print("Registro finalizado")
        break