#ordenamiento por insercion
lista = [8,4,1,4,8,9,6,3,2,11]

for i  in range(1, len(lista)):
    actual = lista[i]
    indice = i

    while indice > 0 and lista[indice - 1] > actual:

        lista[indice]  = lista[indice - 1]
        indice = indice- 1

    lista[indice] = actual

print(lista)

#ordenamiento por seleccion

lista = [8,4,1,4,8,9,6,3,2,11]
longitud = len(lista)

for i in range(longitud-1):
    menor = i

    for j in range (i+1, longitud):
        if lista[j] < lista[menor]:
            menor = j

    temporal = lista[menor]
    lista[menor] = lista[i]
    lista[i] = temporal

print (lista)