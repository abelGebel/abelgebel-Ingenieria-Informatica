import os
os.system('cls')

### Lambdas ###

sum_two_values = lambda first_value, second_Value: first_value +second_Value
print(sum_two_values(2, 4))

def sum_three_values(value):
    return lambda first_value, second_Value: first_value +second_Value + value

print(sum_three_values(5)(3,6))

