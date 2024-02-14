import os
os.system('cls')

### Sets ###

my_set = set()
print(type(my_set))

my_other_set = {}
print(type(my_other_set))

my_other_set = {"Abel", "Gebel", 35}
print(type(my_other_set))

print(len(my_other_set))

my_other_set.add("Hola")
print(my_other_set) # a Set is not an ordered structure

my_other_set.add("Gebel")
print(my_other_set) # a Set does not allow repeated elements

print("Gebel" in my_other_set)
print("Gebe" in my_other_set) # searches

my_other_set.remove("Abel")
print(my_other_set)

my_other_set.clear()
print(my_other_set)
print(len(my_other_set))

del my_other_set # remove variable

my_set = {"Abel", "Gebel", 35}
my_list = list(my_set)
print(my_list)
print(my_list[0])

my_other_set = {"Java", "Postgress", "Python"}

my_new_set = my_set.union(my_other_set)
print(my_new_set.union({"JavaScript", "C#"}))

print(my_new_set.difference(my_set))