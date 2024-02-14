import os
os.system('cls')

### Conditionals ###

my_condition = True

if my_condition:
    print("The 'if' condition is executed")


my_condition = 1

if my_condition:
    print("The second 'if' condition is executed")


if my_condition == 11:
    print("The second 'if' condition is executed")


if my_condition > 10 and my_condition < 20:
    print("is greater than 10 and less than 20")
elif my_condition ==1:
    print("is equal to 1")
else:
    print("is less than or equal to 10 or greater than or equal to 20")


print("The execution continues")

my_string = ""

if my_string:
    print("My text string is not empty")

if not my_string:
    print("My text string is empty")

my_string = "My text string"

if my_string:
    print("My text string is not empty")


