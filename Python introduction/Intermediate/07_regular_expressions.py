import os
os.system('cls')

### Regular Expressions ###

import re

# match

my_string = "Esta es la lección numero 7: Expresiones Regulares lección"
my_other_string = "Esta no es la lección numero 7: Manejo de Ficheros"

match = re.match("Esta es la lección", my_string, re.I)

match = re.match("Esta no es la lección", my_other_string)

if not(match == None):
    print(match)
    start, end = match.span()
    print(my_other_string[start:end])


print(re.match("Expresiones Regulares", my_string))

# search
search = re.search("lección", my_string, re.I)
print(search)
start, end = search.span()
print(my_string[start:end])

# findall
findall  = re.findall("lección", my_string, re.I)
print(findall)


# split
print(re.split(":", my_string))

# sub
print(re.sub("Expresiones", "Expresionessssss", my_string))



# Patterns

pattern = r"[lL]ección"
print(re.findall(pattern, my_string))

pattern = r"[lL]ección|Expresiones"
print(re.findall(pattern, my_string))

pattern = r"[a-z]"
print(re.findall(pattern, my_string))

pattern = r"[0-9]"
print(re.findall(pattern, my_string))
print(re.search(pattern, my_string))


pattern = r"\d"
print(re.findall(pattern, my_string))

pattern = r"\D"
print(re.findall(pattern, my_string))

pattern = r"[l].*"
print(re.findall(pattern, my_string))

email = "mouredev@mouredev.com"
pattern = r"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z-.]+$"
print(re.match(pattern, email))
print(re.search(pattern, email))
print(re.findall(pattern, email))

email = "mouredev@mouredev.com.mx"
print(re.findall(pattern, email))

# Para aprender y validar expresiones regulares: https://regex101.com