import os
os.system('cls')

### Lists ###

my_list = list()
my_other_list = []

print(len(my_list))

my_list = [35, 24, 62, 52, 30, 30, 17]
print(my_list)
print(len(my_list))

my_other_list = [23, 1.58, "Abel", "Gebel"] 

print(type(my_list))
print(type(my_other_list))

print(my_other_list[0])
print(my_other_list[-1])
print(my_other_list[-3])

print(my_list.count(30))

age, height, name, surname = my_other_list
print(name)

print(my_list + my_other_list)



my_other_list.append("Factory")
print(my_other_list)

my_other_list.insert(1,"Blue")
print(my_other_list)

my_other_list.remove("Blue")
print(my_other_list)

my_list.remove(30)
print(my_list)

print(my_list.pop())
print(my_list)

print(my_list.pop(2))
print(my_list)


del my_list[2]
print(my_list)

my_new_list = my_list.copy()

my_list.clear()
print(my_list)
print(my_new_list)

my_new_list.reverse()
print(my_new_list)


my_new_list.sort()
print(my_new_list)

print(my_new_list[1:2])


my_list = list("Hello Python")
print(my_list)
print(type(my_list))