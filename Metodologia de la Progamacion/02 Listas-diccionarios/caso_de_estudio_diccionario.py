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
        print('(Ingrese un DNI igual a 0 para finalizar)')
        print('')
        dni = verificarDni()
        if dni == 0:
            break
        else:
            nombre=verificarNombre()
            nota = verificarNota()
            listado[dni] = [nombre,nota]
            print("Alumno agregado correctamente")
            print("")
            continuar=input("(Presione ENTER para continuar)")
            os.system('cls')
    os.system('cls')
    return listado

def mostrarListado(listado):
    print("----------LISTADO DE ALUMNOS----------")
    print("")
    for clave,valor in listado.items():
        print(clave,valor)
    print("")
    continuar=input("(precione una tecla para continuar)")
    os.system('cls')

def buscarAlumno(listado):
    dni = verificarDni()
    band = False

    for clave,valor in listado.items():
        if dni == clave:
            print (clave,valor)
            band = True
            break
    if band == False:
        print('Alumno no registrado')
    print("")
    continuar=input("(Precione ENTER para continuar)")
    os.system('cls')

def modificarAlumno():
    buscar = verificarDni()
    band=False

    for clave,valor in listado.items():
        if buscar == clave:
            band=True
            valor[0] = verificarNombre()
            valor[1] = verificarNota()
            print("")
            print("Alumno modificado correctamente")
            print("")
            break
    
    if band==False:
        print('')
        print('Dni no registrado')
        print('')
    
    continuar=input("(Precione ENTER para continuar)")
    os.system('cls')
    return listado
        
def eliminarAlumno():
    for clave,valor in listado.items():
        print(clave,valor)
    print("")

    dic1 = listado
    dic2 = {}
    band = False
    dni = verificarDni()
    os.system('cls')

    for clave,valor in dic1.items():
        if clave != dni:
            dic2[clave] = valor
        else:
            band = True
    
    print("")
    if band == True:
    
        for clave,valor in dic2.items():
            print(clave,valor)
        print("")
        print("Alumno borrado correctamente")
    else:
        print("Alumno no registrado")

    print("")
    continuar = input("(presione una tecla para continuar)")
    os.system('cls')
    return dic2

def promedio(listado):
    suma=0
    for clave,valor in listado.items():
        suma+=valor[1]
    promedio = float(suma/len(listado))
    print("")
    print(f"El promedio de las notas ingresadas es: {round(promedio,2)}")   
    print("")
    continuar = input("(presione una tecla para continuar)")
    os.system('cls')
        
        
#Principal----------------------------------------------------------------------------------------------
os.system('cls')
opcion = 0
listado={41098760:["Rogerio Garcia", 9],
        38095109: ["Eric Lopez",6],
        44009129: ["Javier Carbona",1],
        40989222: ["Alejandro Ayala",8],
        1111111: ["Ruan Martins",10]}

while (True):
    opcion=menu()
    if opcion == 1:
        listado =registrarAlumnos()
    elif opcion ==2:
        mostrarListado(listado)
    elif opcion == 3:
        buscarAlumno(listado)
    elif opcion == 4:
        listado = modificarAlumno()
    elif opcion == 5:
        listado = eliminarAlumno()
    elif opcion ==6:
        promedio(listado)
    elif opcion == 7:
        print("Registro finalizado")
        break