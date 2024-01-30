'''
Mediante un menú de opciones realizar el siguiente programa modular para gestionar el listado de
notas de un examen para los alumnos de una institución educativa:
a. Registrar alumnos: para cada uno se debe solicitar DNI, nombre y nota. Validar que la nota se
encuentre entre 0 y 10. El proceso finaliza cuando se ingresa un DNI igual a cero.
b. Mostrar el listado de alumnos con sus respectivas notas.
c. Buscar a un alumno por su DNI y mostrar su nombre y nota.
d. Ordenar la lista de alumnos en forma ascendente por nombre

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
    print("1) Registrar alumnos")
    print("2) Mostrar listado de alumnos")
    print("3) Buscar alumno por DNI")
    print("4) Ordenar alumnos de forma ascendente por nombre")
    print("5) Salir")
    print("")
    opcion= verificarOpcion()
    return opcion

def inicializar():
    alumnos = []
    alumnos = [[34,"Lopez",4],
              [27,"Ferrari",3],
              [72,"Martinez",9]]
    return alumnos

def verificarDNI():
    while True:
        try:
            dni = int(input("DNI: ")) 
            if dni >= 0:
                break  
            else:
                print("ERROR. Intente nuevamente...")  
        except:
            print("ERROR. Intente nuevamente...")    
    return dni

def verificarNombre():
    while True:
        nombre = input('Nombre: ')
        if nombre == '' or nombre.replace(' ','').isalpha()==False:
            print("ERROR. Intente nuevamente...")
        else:
            break      
    return nombre

def verificarNota():
    while True:
        try:
            nota = int(input("Nota: "))
            if nota<0 or nota>10:
                print("ERROR. Intentelo nuevamente...")
            else:
                break

        except:
            print("ERROR. Intentelo nuevamente...")

    return nota


def registrar():
    os.system('cls')
    while True:
        os.system('cls')
        print("")
        print("----------REGISTRO DE ALUMNOS----------")
        print("---(Ingrese un dni 0 para finalizar)---")
        print("")
        dni = verificarDNI()
        if dni == 0:
            break
        nombre = verificarNombre()
        nota= verificarNota()
        alumnos.append([dni,nombre,nota])

    return alumnos

    
def mostrar(alumnos):
    os.system('cls')

    print("")
    print("LISTADO DE ALUMNOS")
    print("")
    
    for elem in enumerate(alumnos):
        print(elem)
    print("")
    continuar = input("(ENTER para continuar)")
    print("")
    

def buscar(alumnos):
    print("")
    print("Busqueda por DNI")   
    busqueda = verificarDNI()
    print("")
    band=False
    for pos,elem in enumerate(alumnos):
        if alumnos[pos][0] == busqueda:
            print(elem)
            band=True
    if band == False:
        print("DNI no registrado")
    print("")
    continuar = input("(ENTER para continuar)")
    print("")


def ordenar(alumnos):
    n = len(alumnos)
    for i in range(n):
        for j in range(0, n-1):
            if alumnos[j][1] > alumnos[j+1][1]:
                alumnos[j], alumnos[j+1] = alumnos[j+1], alumnos[j]
    mostrar(alumnos)
    return

#Principal
os.system('cls')
alumnos = inicializar()
opcion = 0
while opcion != 5:
    os.system('cls')
    opcion  = menu()
    if opcion == 1:
        alumnos= registrar()
    elif opcion == 2:
        mostrar(alumnos)
    elif opcion == 3:
        buscar(alumnos)
    elif opcion == 4:
        ordenar(alumnos)
print("")
os.system('cls')
print("Fin programa")
