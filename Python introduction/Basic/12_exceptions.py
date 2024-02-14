import os
os.system('cls')

### Exceptions ###

numberOne, numberTwo = 5, 1

numberTwo = "1"

try:
    print(numberOne + numberTwo)
except:
    print("An error has occurred")

numberTwo = 1

try:
    print(numberOne + numberTwo)
except:
    print("An error has occurred")
else:
    print("the execution continues correctly")
finally:
    print("The execution continues")

numberTwo = "1"

try:
    print(numberOne + numberTwo)
except:
    print("An error has occurred")
else:
    print("the execution continues correctly")
finally:
    print("The execution continues")


try:
    print(numberOne + numberTwo)
except TypeError:
    print("A TypeError has occurred")
except ValueError:
    print("A ValueError has occurred")

try:
    print(numberOne + numberTwo)
except ValueError as error:
    print(error)
except Exception as exception:
    print(exception)



print("The execution continues")