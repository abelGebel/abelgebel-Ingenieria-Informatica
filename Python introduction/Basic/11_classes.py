import os
os.system('cls')

### Classes ###

class MyEmptyPerson:
    pass

print(MyEmptyPerson)
print(MyEmptyPerson())


class Person:
    def __init__(self, name,surname, alias = "no alias"): # class constructor
        self.name = name
        self.surname = surname
        self.alias = alias

    def walk (self):
        print(f"{self.name} {self.surname} {self.alias} is walking")



my_person = Person("Abel", "Gebel")
print(my_person.name)

print(f"{my_person.name} {my_person.surname}")
my_person.walk()