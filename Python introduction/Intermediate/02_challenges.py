import os
os.system('cls')

### Callenges ###

"""
EL FAMOSO "FIZZ BUZZ":
Escribe un programa que muestre por consola (con un print) los
números del 1 al 100 (ambos incluidos y con un salto de línea entre
cada impresión), sustituyendo los siguientes:
- Múltiplos de 3 por la palabra "fizz".
- Múltiplos de 5 por la palabra "buzz".
- Múltiplos de 3 y de 5 por la palabra "fizzbuzz".
"""


def fizzbuzz():
    for i in range(1,101):
    
        if i % 3 == 0 and i % 5 == 0:
            print("fizzbuzz")
        elif i % 3 == 0:
            print("fizz")
        elif i % 5 == 0:
            print("buzz")
        else:
            print(i)


"""
ES UN ANAGRAMA? 
Escribe una función que reciba dos palabras (String) y retorne
verdadero o falso (Bool) según sean o no anagramas.
- Un Anagrama consiste en formar una palabra reordenando TODAS
  las letras de otra palabra inicial.
- NO hace falta comprobar que ambas palabras existan.
- Dos palabras exactamente iguales no son anagrama.
"""

def is_anagram(string_one, string_two):
    
    if string_one.lower() == string_two.lower() :
        return False

    if sorted(string_one.lower()) == sorted(string_two.lower()) :
        return False
    
    return True

#print(is_anagram("Amor", "Roma"))


"""
Escribe un programa que imprima los 50 primeros números de la sucesión
de Fibonacci empezando en 0.
- La serie Fibonacci se compone por una sucesión de números en
  la que el siguiente siempre es la suma de los dos anteriores.
  0, 1, 1, 2, 3, 5, 8, 13...
"""

def fibonacci():

    prev = 0
    next = 1
    fibonacci = 0

    for i in range(1, 51):
        print(fibonacci) 
        prev = next 
        next = fibonacci
        fibonacci = prev + next 
     
# fibonacci()  
        

"""
ES UN NÚMERO PRIMO? 
Escribe un programa que se encargue de comprobar si un número es o no primo.
Hecho esto, imprime los números primos entre 1 y 100.
"""

def is_prime ():

    for number in range(1,101):

        is_prime = True
    
        for i in range (2, (number // 2) + 1):
                
            if number % i == 0:
                is_prime = False
                break
            
        if is_prime:
            print(number)

# is_prime()
            

"""
Crea un programa que invierta el orden de una cadena de texto
sin usar funciones propias del lenguaje que lo hagan de forma automática.
- Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
"""

"""
def invertir (stringValue):
    stringValue = stringValue[::-1]
    
    return stringValue
"""

def reverse (text):
    
    text_len = len(text)
    reversed_text = ""
    for i in range (0, text_len):
        reversed_text += text[text_len - i -1]
    return reversed_text

print(reverse("Hola mundo"))
