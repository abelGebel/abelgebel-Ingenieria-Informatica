import os
os.system('cls')

### Functions ###

def my_function ():
    print("This is a function")

my_function ()

def sum_two_values (first_number, second_number):
    print(first_number + second_number)

sum_two_values (3, 5)
sum_two_values ("3","5")
sum_two_values (3.6, 5)


def sum_two_values_with_return (first_number, second_number):
    return first_number + second_number

my_result = sum_two_values_with_return (10,5)
print(my_result)

def print_name (name, surname):
    print(f"{name} {surname}")

print_name ("Abel", "Gebel")
print_name (surname = "Gebel", name = "Abel")


def print_name_with_default (name, surname, alias = "no alias"):
    print(f"{name} {surname} {alias}")

print_name_with_default ("Abel", "Gebel")


def print_upper_texts (*texts):
    for text in texts:
        print(text.upper())

print_upper_texts ("Hi", "Python", "Abel")
