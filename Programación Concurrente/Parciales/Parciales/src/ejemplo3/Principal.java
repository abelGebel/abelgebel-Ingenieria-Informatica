package ejemplo3;

import java.util.Random;


/*
Genere un array de tipo string de 30 posiciones. Debe lanzar tandas de 5 hilos concurrentes
para que vayan llenando dichas posiciones (desde la posición 0 a la 29), es decir, cuando los
primeros 5 hilos hayan finalizado, debe lanzar otros 5 hilos nuevos y así hasta completar las 30
posiciones. Cada posición del array es el resultado de una función llamada compute(Random r).
Importante: Inicialice una única semilla Random para todo el procedimiento.
*/
public class Principal {

	public static void main(String[] args) {
		Random random = new Random();
		String[] array = new String[30];
		Thread misHilos[]=new Thread[30];
		int cantidad=0;

		long inicio,fin;
		inicio = System.currentTimeMillis();
		for (int i = 0; i<=29;i++) {
			
			misHilos[i] = new Hilo(i,array,random);
			misHilos[i].start();
			cantidad+=1;
			if (cantidad==5) {
				System.out.println("5 hilos lanzaods");
				for(int j=(i-4);j<=i;j++) {
					try {
						misHilos[i].join();
					} catch (InterruptedException e) {e.printStackTrace();}
				}
				cantidad=0;

			}
		}
		for(int i =0;i<=29;i++) {
			System.out.println(array[i]);
		}

		fin = System.currentTimeMillis();
		System.out.println("Duracion: "+(fin-inicio));

	}

}
