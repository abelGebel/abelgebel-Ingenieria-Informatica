package punto1tp5;

import java.util.ArrayList;
import java.util.Random;

/*
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

public class Principal implements Runnable{
	
	private Consumidor consumidor;
	private Productor productor;
	boolean esProductor;

	public Principal(Consumidor consumidor,boolean esProductor) {
		this.consumidor=consumidor;
		this.esProductor=esProductor;
	}
	public Principal(Productor productor,boolean esProductor) {
		this.productor=productor;
		this.esProductor=esProductor;
	}

	public static void main(String[] args) {
	    Random random = new Random();
        ArrayList<Integer> miLista = new ArrayList<>();
        int i=1;
		
		try {
			while (true) {
				
				Productor prod = new Productor(miLista,i);
                Consumidor cons = new Consumidor(miLista,i);
                Runnable proceso1 = new Principal(prod, true);
                Runnable proceso2 = new Principal(cons, false);

    			new Thread(proceso1).start();
    			new Thread(proceso2).start();
                i++;
				Thread.sleep(random.nextInt(1000)+100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if(esProductor) {
			this.productor.producir();
		}else {
			this.consumidor.consumir();
		}
	}
}
