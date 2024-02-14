import os
os.system('cls')

### Strings ###

my_string = "My String"
my_other_string = 'My another String'

print(len(my_string))
print(len(my_other_string))
print(my_string + " " + my_other_string)

my_new_line_string = "This is a String\nwhit a line break"
print(my_new_line_string)

my_tab_string = "\tThis is a String whit tab"
print(my_tab_string)

my_scape_string = "\\tThis is an \\n escaped String"
print(my_scape_string)

# Formatting
name, surname, age = "Abel", "Gebel", 23

print("My name is {} {} and i am {} years old.".format(name, surname, age))
print("My name is %s %s and i am %d years old." %(name, surname, age))
print(f"My name is {name} {surname} and i am {age} years old.")

# Character unpacking
language = "Python"
a,b,c,d,e,f = language
print(a)
print(b)

# Division
language_slice = language[1:3]
print(language_slice)
language_slice = language[1:]
print(language_slice)
language_slice = language[-2]
print(language_slice)

# Reverse
reverse_language = language[::-1]
print(reverse_language)

# Functions

print(language.capitalize()) # First letter capitalized
print(language.upper())
print(language.count("t"))
print(language.isnumeric())
print("1".isnumeric())
print(language.lower())
print(language.upper().isupper())
print(language.startswith("Py"))