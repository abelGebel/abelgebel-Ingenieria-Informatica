import os
os.system('cls')

# variables

my_string_variable = "My String variable" # The convention for variables in Python is to use snake case
print(my_string_variable)

my_int_variable = 5 
print(my_int_variable)

my_bool_variable = False
print(my_bool_variable)

# Concatenation of variables in a print

print(my_string_variable, my_int_variable, my_bool_variable)

print(type(print(my_string_variable, my_int_variable, my_bool_variable))) # print es una funcion de python, no tiene tipo

print("This is the value of:",my_bool_variable)

# some python functions
print(len(my_string_variable))

# variables on a single line
name, surname, age = "Abel", "Gebel", 23

print("My name is", name, surname, "and i am", age, "years old.") #this is error prone and is not recommended

# Inputs
# name =input("What's your name?")
# age = input("How old are you?")
# print(name)
# print(age)

# we change its type, python does not have strong typing
name = 23
age = "abel"
print(name)
print(age)

# Do we force the type?
addres: str = "My direccion"
addres = True
print(type(addres))