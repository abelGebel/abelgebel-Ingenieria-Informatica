import os
os.system('cls')

### Dictionaries ###

my_dict = dict()
my_other_dict = {}

print(type(my_dict))
print(type(my_other_dict))

my_other_dict = {"Name":"Abel", "Surname":"Gebel", "Age":35, 1:"Python"}

my_dict = {
    "Name":"Abel",
    "Surname":"Gebel",
    "Age":35,
    "Languajes": {"Java", "Postgress", "Python"},
    1:1.58
}

print(my_other_dict)
print(my_dict)

print(len(my_other_dict))
print(len(my_dict))

print(my_dict["Name"])

my_dict["Name"] = "Pedro"
print(my_dict["Name"])

print(my_dict[1])

my_dict["Calle"] = "Calle Abel" 
print(my_dict)

del my_dict["Calle"]
print(my_dict)

print("Abel" in my_dict) 
print("Surname" in my_dict) # search by key 
print(my_dict["Surname"])

print(my_dict.items())
print(my_dict.keys())
print(my_dict.values())

my_list = ["Name", 1, "Floor"]
my_new_dict = dict.fromkeys((my_list))
print(my_new_dict)
my_new_dict = dict.fromkeys(("Name",1,"Floor"))
print(my_new_dict)

my_new_dict = dict.fromkeys(my_dict)
print(my_new_dict)

my_new_dict = dict.fromkeys(my_dict, "Gebel")
print(my_new_dict)

my_values = my_new_dict.values()
print(my_values)
print(list(my_values))

print(list(my_new_dict))
print(tuple(my_new_dict))
print(set(my_new_dict))