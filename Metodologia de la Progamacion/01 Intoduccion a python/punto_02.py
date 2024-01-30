'''
Diseñe un programa que muestre todos los números primos que se encuentran en el intervalo [A, B]. El
algoritmo debe finalizar cuando A o B sean iguales a cero. También debe validar que ambos números
sean positivos y que A sea menor que B.
'''

import os
os.system('cls')

def verificarValor():
    while True:
        try:
            valor=int(input("Ingrese un numero entero: "))
            if valor>=0:
                break
            else:
                print("ERROR. Numero negativo...")
        except:
            print("INGRESE UN VALOR VALIDO...")
    return valor

def calculoNumeroPrimo(A,B):

    listaPrimos=[]
    for a in range (A,B+1):
            cont = 0
            i = 2
            while i < a and cont == 0:
                resto = a%i
                if resto == 0:
                    cont += 1
                i += 1
    
            if cont == 0:
                listaPrimos.append(a)
    print()
    print(f'Numeros primos entre {A} y {B}: {listaPrimos}')
    continuar=input("(ENTER para continuar)")
    os.system("cls")

def numeroPrimo():
    print("PROGRAMA PARA ENCONTRAR NUMEROS PRIMOS ENTRE DOS VALORES A Y B")
    while True:
        print()
        print ("(Para finalizar ingrese un valor 0)")
        print()

        A = verificarValor()   
        if A == 0:
            break
        
        B = verificarValor()
        if B==0:
            break
        if A>B:
            C=B
            B=A
            A=C
        calculoNumeroPrimo(A,B)

    print()
    

     
#Principal---------------------------------------------------------------
numeroPrimo()
os.system('cls')
print ("FIN PROGRAMA...")