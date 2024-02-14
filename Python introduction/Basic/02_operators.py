import os
os.system('cls')

### Operators ###

print(3 + 4)
print(3 - 4)
print(3 * 4)
print(3 / 4)
print(10 % 3)
print(10 // 3)
print(10 ** 3) # exponent
print(2 ** 3 + 3 - 7 / 1 // 4)

print("Hola" + "Python")

# print("Hola" + 5) error
print("Hola" + str(5))
print("Hola " * 5)
# print("Hola " * (2.5+2.5)) error
print("Hola " * int((2.5+2.5)))

### Comparative operators ###

print(3 > 4)
print(3 < 4)
print(3 >= 4)
print(3 <= 4)
print(3 == 4)
print(3 != 4)

print(3 > 4 == 2) 
print(3 > 2 > 1) 

print("Hola" < "Python") # alphabetical order (ASCII) 
print("Hola" > "Zola")

# boolean logic
print(3 > 4 and "Hola" > "Python")
print(3 < 4 and "Hola" > "Python")

print(3 > 4 or "Hola" > "Python")
print(3 < 4 or "Hola" > "Python")

print(not(3 > 4))
