### File Handling ###
import os
os.system('cls')

# .txt file

txt_file = open("Intermediate/my_file.txt", "w+") # Leer y escribir

txt_file.write("Mi nombre es Abel\nMi apellido es Gebel\nAunque tambien me gusta Java\nTengo 23 años\nMi lenguage favorito es Python")

txt_file.close()

txt_file = open("Intermediate/my_file.txt", "r+") 

print(txt_file.read())
#print(txt_file.read(10))
#print(txt_file.readline())
#print(txt_file.readline())
#print(txt_file.readlines())

for line in txt_file.readlines():
    print(line)


txt_file.close()

#os.remove("Intermediate/my_file.txt")


# .json file

import json

json_file = open("Intermediate/my_file.json", "w+")

json_test = {
    "Name":"Abel", 
    "Surname":"Gebel", 
    "Age":35, 
    "lenguage":["python", "java", "lisp"]
} 

json.dump(json_test, json_file, indent = 2)

json_file.close()

with open("Intermediate/my_file.json") as my_other_file:
    for line in my_other_file.readlines():
        print(line)


json_dict = json.load(open("Intermediate/my_file.json"))
print(json_dict)
print(type(json_dict))
print(json_dict["Name"])

# .csv file
import csv

csv_file = open("Intermediate/my_file.csv", "w+")

# .xlsx file

# .xml file
import xml