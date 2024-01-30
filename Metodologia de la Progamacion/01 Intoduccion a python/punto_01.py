'''
Diseñe un algoritmo que solicite un número entre 1 y 3. Luego si el número ingresado es: 1 que muestre
el mensaje Uno, si es 2 muestre el mensaje Dos, si es 3 muestre el mensaje Tres, si no es ninguno de los
anteriores mostrar un mensaje de error. El proceso finaliza a pedido del operador.
'''

import os 
os.system('cls')

def verificarValor():
    while True:
        try:
            valor=int(input("Ingrese un numero entero entre 1 y 3 inclusive: "))
            break
        except:
            print("INGRSE UN VALOR VALIDO...")
    
    return valor

continuar = "s"
while continuar.lower()!="n":
    num = verificarValor()
    if num == 1:
        print ("El numero es 'Uno'")
    elif num == 2:
        print ("El numero es 'Dos'")
    elif num == 3:
        print ("El numero es 'Tres'")
    else:
        print("ERROR, numero fuera de rango...")
    continuar = input("Desea continuar (s/n)? ")
    os.system('cls')
print ("FIN PROGRAMA...")

