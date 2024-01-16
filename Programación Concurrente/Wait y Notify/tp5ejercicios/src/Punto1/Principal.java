package Punto1;

/*
Cuando se trata del profblema productor consumidor, es mejor usar un monitor

No todos los problemas se resuelven de la misma forma
per puede haber problemas que se puedan resover de mas
de una forma

Una cosa es la velocidad de creacion de los objetos consumidores, productores
y otra cosa es la velocidad conla qe se produce y se consume.

Puede que se muestre el mensaje consumido antes de que se agregee
Depende como se sede el control, en este caso al consumidor que se
quedo esperando en el while. Primero se imprime el mensaje en el while, seagregua el elemento
se consume,se muestra el mensaje conusmido y despues se muestra el mensaje
agregado del productor

Agregar y  consumir un elemento deverian estar dentro de una
region critica (puede ser una sola instruccion)
Sincronizar la operaccioncriticca con el elemtne oque se tiene en comun
(lista)

Se puede sincroniza el productor con cualqieroro objeto y no 
va a dar error el programa, pero no tiene sentido


Implemente, mediante Hilos heredando de Thread, el problema del Productor y
Consumidor empleando una lista de elementos (para 10 procesos productores y 10
procesos consumidores). La lista tendrá el comportamiento de una cola, es decir, se
manejará mediante el esquema FIFO. Los productores y consumidores serán lanzados de
manera aleatoria, es esperable que ambos procesos posean velocidades distintas, para el
caso de que los productores sean más lentos que los consumidores, provocará que los
consumidores se encolen a la espera de elementos a consumir. En el caso contrario podría
provocar que el contenedor de productos se llene. Los productores y consumidores serán
lanzados a intervalos entre 100ms – 200ms.

a. Realice la implementación para una cola infinita. Teniendo en cuenta que un
productor es más lento que un consumidor y demora en producir un nuevo
elemento entre 1000ms y 1500ms, en cambio un consumidor demora en consumir
un elemento entre 400ms y 800ms.

b. Realice la implementación para una cola de tamaño 5 que debe definir antes de
correr el programa. Si en un momento dado, la cantidad de elementos a producir
va a ser mayor a 5, el productor deberá esperar hasta que exista espacio, es decir,
hasta que algún elemento sea consumido. Para este caso los productores son más
rápidos que los consumidores. Un productor demora entre 400ms y 800ms para
producir un nuevo elemento, mientras que un consumidor demora entre 1000ms y
1500ms para consumir un elemento. Impleméntelo para un número infinito de
productores y consumidores.

c. Para ambos casos intercambie las velocidades de ambos procesos y comente los
resultados obtenidos.



*/

import java.util.ArrayList;
import java.util.Random;

public class Principal {
    
    public static void main(String[] args) {
        ArrayList<Integer> miLista = new ArrayList<>();
    	//int miLista[]=new int[5];
        Random random = new Random();
        int i=1;
        while(true){
            try {
                Productor prod = new Productor(miLista,i);
                prod.start();
                Consumidor cons = new Consumidor(miLista,i);
                cons.start();   
                i++;
                Thread.sleep(random.nextInt(100)+100);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
       
    }
   
}