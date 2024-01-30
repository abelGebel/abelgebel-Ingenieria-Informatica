#buble sort
arr = [8,4,1,4,8,9,6,3,2,11]


for i in range(len(arr)-1):

    for j in range(len(arr)-1):
        if arr[j] > arr[j+1]:
            aux = arr[j]
            arr[j] = arr[j+1]
            arr[j+1] = aux 

print(arr)
        

