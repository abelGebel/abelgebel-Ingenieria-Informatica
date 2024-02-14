import os
os.system('cls')

### Tuples ###

my_tuple = tuple()
my_other_tuple = ()

my_other_tuple = (35, 60, 30)

my_tuple = (23, 1.58, "Abel", "Gebel", "Abel")
print(my_tuple)
print(type(my_tuple))

print(my_tuple[0])
print(my_tuple[-1])
# print(my_tuple[-6]) index error
# print(my_tuple[4]) index error


print(my_tuple.count("Abel"))
print(my_tuple.index("Gebel"))
print(my_tuple.index("Abel"))


# my_tuple[1] = 1.80 IndentationError: unexpected indent
# my_tuple[5] = 1.80 

my_sum_tuple = my_tuple + my_other_tuple
print(my_sum_tuple)

print(my_sum_tuple[3:6])

my_tuple = list(my_tuple)
print(type(my_tuple))
my_tuple.insert(1, "Azul")
my_tuple = tuple(my_tuple)
print(tuple(my_tuple))
print(type(my_tuple))

# del my_tuple[2] TypeError: 'tuple' object doesn't support item deletion

del my_tuple
#print(my_tuple) NameError: name 'my_tuple' is not defined
