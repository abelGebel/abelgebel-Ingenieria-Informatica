import os
os.system('cls')

### Loops ###

# While

my_condition = 0

while my_condition < 10:
    print(my_condition)
    my_condition += 2
else: # opcional
    print("My condition is greater or equals to 10")




while my_condition < 20:
    my_condition += 1
    if my_condition == 15:
        print("My condition is 15")
        break

    print(my_condition)




# For

my_list = [35, 24, 62, 52, 30, 30, 17]
for element in my_list:
    print(element)


my_tuple = (23, 1.58, "Abel", "Gebel", "Abel")
for element in my_tuple:
    print(element)

my_set = {"Abel", "Gebel", 35}
for element in my_set:
    print(element)


my_dict = {"Name":"Abel", "Surname":"Gebel", "Age":35, 1:"Python"}
for element in my_dict:
    print(element)
    if(element == "Age"):
        break

for element in my_dict.values():
    print(element)


for element in my_dict:
    if(element == "Age"):
        continue
    print(element,"executed")


print("The execution continues")