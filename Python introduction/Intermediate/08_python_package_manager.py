import os
os.system('cls')

### Python Package Manager ###

# PIP https://pypi.org

# pip install pip
# pip --version

import numpy # pip install numpy

print(numpy.version.version)
numpy_array = numpy.array([3, 4, 7, 9])
print(type(numpy_array))
print(numpy_array * 2)


# import pandas # pip install pandas

# pip list
# pip uninstall pandas
# pip show numpy

# pip install requests

import requests

response = requests.get("https://pokeapi.co/api/v2/pokemon?limit=151")
print(response)
print(response.status_code)
print(response.json())


# Arithmetics Package

from mypackage import arithmetics


print(arithmetics.sum_two_values(1, 4))