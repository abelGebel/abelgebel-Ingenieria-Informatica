'''
Diseñar un programa modular que permita gestionar los productos de un comercio,
las funcionalidades solicitadas son:

a. Registrar productos: para cada uno se debe solicitar, código, descripción, precio y stock. Agregar las
siguientes validaciones:
i. El código no se puede repetir
ii. Todos los valores son obligatorios
iii. El precio y el stock no pueden ser negativos
b. Mostrar el listado de productos
c. Mostrar los productos cuyo stock se encuentre en el intervalo [desde, hasta]
d. Buscar el precio más alto de la lista de productos y a continuación listar los productos que lo poseen.
e. Diseñar un proceso que le sume X al stock de todos los productos cuyo valor actual de stock sea
menor al valor Y.
f. Eliminar todos los productos cuyo stock sea igual a cero.
g. Salir
'''

import os

def verificarOpcion():
    while True:
        try:
            op=int(input("Ingrese una opcion: "))
            if 1<= op <=7:
                break
            else:
                print("INGRESO NO VALIDO...")
        except:
            print("INGRESO NO VALIDO...")
    return op

def menu():
    print ("1) Registrar productos. ")
    print ("2) Mostrar el listado de productos.")
    print ("3) Mostrar valores de stock [desde, hasta]")
    print ("4) Buscar el precio más alto de la lista de productos y listar los productos que lo poseen.")
    print ('5) Sumar un valor "X" a los stocks que sean menor a un valor "Y" ')
    print ("6) Eliminar todos los productos cuyo stock sea igual a cero.")
    print ("7) Salir.")
    opcion = verificarOpcion()
    os.system('cls')
    return opcion

def verificarCodigo(productos):
    
    while True:
        try:
            band=False
            codigo=int(input("Codigo: "))
            for i in range(len(productos)):
                if codigo==productos[i][0]:
                    band=True
                    
            if band==True:
                print('CODIGO YA EXISTENTE...')
            else:
                break
        except:
            print('INGRESO NO VALIDO')

    return codigo

def verificarDescripcion():
    while True:
        descripcion=input('Descripcion: ')
        if descripcion == '':
            print('INGRESO NO VALIDO')
        else:
            return descripcion

def verificarPrecio():

    while (True):
        try:
            num=float(input("Precio "))
            if num<0:
                print("ERROR. Valor negativo...")
            else:
                break
        except:
            print("INGRESO NO VALIDO...")
    return num

def verificarStock():
    while (True):
        try:
            num=int(input("Stock: "))
            if num<0:
                print("ERROR. Valor negativo...")
            else:
                break
        except:
            print("INGRESO NO VALIDO...")
    return num

def registrarProductos():
    continuar=""
    while (True):
        codigo = verificarCodigo(productos)
        descripcion = verificarDescripcion()
        precio = verificarPrecio()
        stock = verificarStock()
        productos.append([codigo,descripcion,precio,stock])
        print('Agregado correctamente') 
        continuar=input("Desea continuar? (s/n)")
        os.system('cls')
        if continuar !="n" or continuar!='N':
            break
    return productos

def mostrarProductos(productos):
    print("----------LISTA DE PRODUCTOS----------")
    for i in range(len(productos)):
        print(productos[i])    
    print("--------------------------------------")
    continuar=input("(precione una tecla para continuar)")
    os.system('cls')

def mostrarDesde(productos):

    print("Ingrese el primer valor (desde):")
    desde=verificarStock()
    print("Ingrese el segundo valor (hasta):")
    hasta=verificarStock()
    if desde>hasta:
        aux=hasta
        hasta=desde
        desde=aux
    print("Productos que tienen stock entre",desde,"hasta",hasta)
    print("")

    for i in range(len(productos)):
        if desde <= productos[i][3] <= hasta:
            print(productos[i])
    print("")
    continuar=input("(Precione ENTER para continuar)")
    os.system('cls')

def buscarPrecioMasAlto(productos):
    mayor = 0

    for i in range(len(productos)):
        if productos[i][2]>mayor:
            mayor=productos[i][2]
    
    print("Productos con el precio mas alto:")
    for i in range(len(productos)):
            if productos[i][2] == mayor:
                print(productos[i])
    print("")
    continuar = input("(Presione ENTER para continuar)")
    os.system('cls')

def sumarStock(productos):
    Y = int(input("Ingrese el valor 'Y': "))
    X = int(input("Ingrese el valor a sumar X: "))
    print("Productos que cambiaron de stock:")
    print("")
    for i in range(len(productos)):
        if productos[i][3] < Y:
            productos[i][3] += X
            print(productos[i])
    print("")
    continuar = input("(Presione ENTER para continuar)")
    os.system('cls')
    return productos

def eliminarStock():
    for i in range(len(productos)):
        if productos[i][3]==0:
            del productos[i]
    print("Productos con stock 0 eliminados")
    print("")
    continuar = input("(Presione ENTER para continuar)")
    os.system('cls')
    return productos


#Principal----------------------------------------------------------------------------------
os.system('cls')
opcion=0
productos=[[34,"cama",float(90),3],
            [11,"lapicera",float(10),100],
            [98,"goma",float(90),300],
            [72,"remera,float",float(12),0]]

while(True):
    opcion = menu()
    if opcion == 1:
        productos = registrarProductos()
    elif opcion ==2:
        mostrarProductos(productos)
    elif opcion == 3:
        mostrarDesde(productos)
    elif opcion == 4:
        buscarPrecioMasAlto(productos)
    elif opcion ==5:
        sumarStock(productos)
    elif opcion == 6:
        productos= eliminarStock()
    elif opcion == 7:
        print("FIN DEL REGISTRO")
        break


