'''
Diseñar un programa que dados los números A y B permita realizar las siguientes operaciones a elección
del operador
a. Calcular la raíz cuadrada de A.
b. Calcular el cociente entre A y B.
c. Calcular el valor de R = (A! - B!) / A^5.
d. Fin del programa.
'''
from math import factorial
import os

#Menu.
def menu(opcion):
    while (True):
        print('')
        print("a. Calcular la raíz cuadrada de A.")
        print("b. Calcular el cociente entre A y B.")
        print("c. Calcular el valor de R = (A! - B!) / A^5.")
        print("d. Fin del programa.")
        print('e. Ingresar otros valores.')
        print('')
        opcion = input('Ingrese una opcion: ')
        print('')
        if opcion.isalpha():
            opcion=opcion.lower()
            if opcion=='a' or opcion=='b' or opcion=='c' or opcion== 'd' or opcion=='e':
                return opcion
            else:
                print('OPCION INCORRECTA...')
        else:
            print('OPCION INCORRECTA...')
        

def raizCuadrada(A= 0):
    if A >= 0:
        print("La raiz cuadrada de A es:", (A**(1/2)))
    else:
        print ("Error, A es un numero negativo.")


def cociente(A = 0, B = 0):
    if B != 0:
        print ("El cociente entre A Y B es:", (A/B))
    else:
        print("Error, división no definida...")


def operacion(A, B):
    resultado = ( (factorial(A) - factorial(B)) / A**5 )
    print (f"El resultado de ( (factorial({A}) - factorial({B})) / A**5 ) es:", resultado)


def verificarNumero():
    while True:
        try:
            num = int(input())
            return num 
        except:
            print('VALOR INCORRECTO, DEBE INGRESAR UN ENTERO...')


def ingresarValores():
    print("Ingrese el valor entero A:")
    A = verificarNumero()
    print('Ingrese el valor entero B:')
    B = verificarNumero() 
    return A,B

    
#Programa principal-----------------------------------------------------------------------------------------

os.system('cls')
A,B= ingresarValores()
opcion = " "

while opcion != "d":
    print('')
    print(f'Valor A = {A}, valor B = {B}')
    opcion = menu (opcion)
    os.system('cls')

    if opcion == "a":
        raizCuadrada(A)

    elif opcion == "b":
        cociente(A,B)

    elif opcion == "c":
        operacion(A,B)   

    elif opcion == "d":
        print("FIN PROGRAMA..")

    elif opcion == 'e':
        A,B = ingresarValores()


