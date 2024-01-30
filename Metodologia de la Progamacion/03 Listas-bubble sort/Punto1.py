'''
Utilizando listas diseñar un programa modular que permita gestionar los vehículos de un concesionario
que se dedica a la venta de automóviles usados, las funcionalidades solicitadas son:

a. Agregar vehículos, los atributos del mismo son:
■ Dominio: String entre 6 y 9 caracteres sin espacios
■ Marca: (R=Renault, F=Ford, C=Citroen)
■ Tipo: U=Utilitario, A=Automóvil
■ Modelo: en el rango [2005, 2020]
■ Kilometraje
■ Precio valuado: representa el precio de valuación del vehículo según su año de fabricación
y estado.
■ Precio de venta: Es de solo lectura y representa el precio de venta del vehículo y su valor
es un 10% más que el precio valuado.
■ Estado: (V=Vendido, D=Disponible, R=Reservado). Este valor no se debe ingresar, por
defecto es disponible (D).
b. Reservar un automóvil: implica cambiar el estado del vehículo a Reservado (R)
c. Buscar un automóvil por su dominio
d. Ordenar la lista de automóviles en forma ascendente o descendente por Marca
e. Ordenar la lista de automóviles en forma ascendente o descendente por Precio de venta
mostrando solamente los que se encuentren disponibles.
Consideraciones
- El programa debe cargar la lista en con al menos 10 automóviles en el momento en que se inicia.
- Realice todas las validaciones necesarias para el punto 2) a)
'''
import os

def inicializar():
    listado=[["NE193PO","R","A",2006,40000,2000000,round(2000000*1.1),"D"],
             ["OL902IU","F","A",2011,60000,1500000,round(1500000*1.1),"D"],
             ["QR440LO","C","U",2014,30000,1250000,round(1250000*1.1),"D"],
             ["KE901BV","F","A",2009,10000,4500000,round(4500000*1.1),"D"],
             ["MQ552JI","R","U",2019,50000,3000000,round(3000000*1.1),"D"],
             ["MN123OK","C","A",2010,65000,2100000,round(2100000*1.1),"D"],
             ["JK982CF","R","U",2008,20000,1500000,round(1500000*1.1),"D"],
             ["PO002QW","F","U",2009,80000,2100000,round(2100000*1.1),"D"],
             ["MN948EF","F","A",2009,65000,3050000,round(3050000*1.1),"D"],
             ["111111","R","A",2008,45000,1100000,round(1100000*1.1),"D"]]
    return listado


def verificarOpcion():
    while True:
        try:
            op = int(input("Ingrese una opcion: "))
            if op < 1 or op >8:
                print ("ERROR. Intentelo nuevamente...")
            else:
                break    
        except:
            print("ERROR. Intentelo nuevamente...")
    return op


def menu():
    print("1) Agregar vehiculo")
    print("2) Reservar automovil")
    print("3) Buscar automovil por dominio")
    print("4) Ordenar la lista de automóviles en forma ascendente o descendente por Marca")
    print("5) Ordenar en forma ascendente o descendente por Precio de venta (solo disponibles)")
    print("6) Salir")
    print("")
    opcion= verificarOpcion()
    os.system('cls')

    return opcion


def verificarDominio():
    while True:
        dom=input("Dominio: ")
        if len(dom)>5 and len(dom)<10 and dom.find(" ")==-1:
            break
        else:
            print("DOMINIO INCORRECTO...")
            print("")
    return dom


def verificarMarca():
    while True:
        print("")
        print("R) Renault")
        print("F) Ford")
        print("C) Citroen")
        print("")
        marca = input("Ingrese marca: ")
        if marca.upper()!="R" and marca.upper()!="F" and marca.upper()!="C":
            print("ERROR. Intentelo nuevamente")
        else:
            marca=marca.upper()
            break
    return marca
    

def verificarTipo():
    while True:
        print("A) para automovil")
        print("U) para utilitario")
        tipo = input()
        if tipo.upper()!="U" and tipo.upper()!="A":
            print("ERROR. Intente nuevamente")
        else:
            tipo=tipo.upper()
            break
    print("")
    return tipo


def verificarModelo():
    while True:
        try:
            mod = int(input("Modelo: "))
            if mod > 2004 and mod < 2021:
                break
            else:
                print("EL MODELO TIENE QUE ESTAR EN UN RANGO DE 2005 Y 2020")
        except:
            print("ERROR. Intente nuevamente")
    print("")
    return mod
     

def verificarKilometraje():
    while True:
        try:
            kil = int(input("Kilometraje: "))
            if kil < 0:
                print("ERROR. Intente nuevamente")
            else:
                break
        except:
                print("ERROR. Intente nuevamente")
    print("")
    return kil


def verificarPrecio():
    while True:
        try:
            precio = float(input("Precio: "))
            if precio< 0:
                print("ERROR. Intente nuevamente")
            else:
                break
        except:
                print("ERROR. Intente nuevamente")
    print("")
    return precio


def agregarVehiculos():
    continuar = "s"
    while continuar=="s" or continuar=="S":
        dominio= verificarDominio()
        marca = verificarMarca()
        tipo = verificarTipo()
        modelo = verificarModelo()
        kilometraje = verificarKilometraje()
        precio = verificarPrecio()
        precioVenta = round(precio*1.1) 
        estado = "D"
        listado.append([dominio,marca,tipo,modelo,kilometraje,precio,precioVenta,estado])
        print("Agregado correctamente")
        print("")
        continuar=input("Desea continuar? (s/n)")
    return listado


def mostrar(listado):
    os.system('cls')

    for elem in enumerate(listado):
        print(elem)
    print("")
    continuar = input("(ENTER para continuar)")
    print("")


def reservar(lisado):
    band = False
    for elem in enumerate(listado):
        print(elem)
    print("")
    busqueda = input("Ingrese el dominio del automovil que marcar como reservado: ")
    for pos,elem in enumerate(listado):
        if busqueda == listado[pos][0]:
            listado[pos][7] = "R"
            band=True
    
    print("")
    if band == True:
        print("Automovil reservado correctamente")
    else:
        print("DOMINIO DE AUTOMOVIL NO REGISTRADO")
    print("")
    continuar = input("(ENTER para continuar)")
    return listado


def buscar(listado):
    band = False
    busqueda = input("Ingrese el dominio: ")
    for pos,elem in enumerate(listado):
        if busqueda == listado[pos][0]:
            print (elem)
            band = True
    
    if band == False:
        print("EL DOMINIO INGRESADO NO ESTA REGISTRADO")
    print("")
    continuar = input("(ENTER para continuar)")


def verificarOpcionOrden():
    print("1) De forma ascendente")
    print("2) De forma descendente")
    while True:
        try:
            eleccion = int(input(""))
            if eleccion == 1 or eleccion == 2:
                break
            else:
                print("ERROR. Intentelo nuevamente")
        except:
            print("ERROR. Intentelo nuevamente")
    return eleccion


def ordenarMarca(listado):
    n = len(listado)
    print("Ordenar por marca: ")
    eleccion = verificarOpcionOrden()
    if eleccion == 1:
        for i in range(n):
            for j in range(0, n-1):
                if listado[j][1] > listado[j+1][1]:
                    listado[j], listado[j+1] = listado[j+1], listado[j]
        mostrar(listado)

    if eleccion == 2:
        for i in range(n):
            for j in range(0, n-1):
                if listado[j][1] < listado[j+1][1]:
                    listado[j], listado[j+1] = listado[j+1], listado[j]
        mostrar(listado)
    return

        
def ordenarPrecio(listado):
    n = len(listado)
    print("Orden por precio: ")
    eleccion = verificarOpcionOrden()
    if eleccion == 1:
        for i in range(n):
            for j in range(0, n-1):
                if listado[j][6] > listado[j+1][6]:
                    listado[j], listado[j+1] = listado[j+1], listado[j]
        
    if eleccion == 2:
        for i in range(n):
            for j in range(0, n-1):
                if listado[j][6] < listado[j+1][6]:
                    listado[j], listado[j+1] = listado[j+1], listado[j]

    for pos,elem in enumerate(listado):
        if listado[pos][7]=="D":
            print(elem)

    print("")
    continuar = input("(ENTER para continuar)")
        
    return



#Principal--------------------------------------------------------------------------------------------------------
os.system('cls')
listado = inicializar()
opcion = 0

while opcion != 6:
    os.system('cls')
    opcion = menu()
    if opcion == 1:
        listado = agregarVehiculos()
    elif opcion == 2:
        listado = reservar(listado)
    elif opcion == 3:
        buscar(listado)
    elif opcion == 4:
        ordenarMarca(listado)
    elif opcion ==5:
        ordenarPrecio(listado)
    elif opcion == 7:
        mostrar(listado)


print("")
print("Fin programa")


