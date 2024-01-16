package ejemplo4;

import java.util.Random;
/*
Genere un array de tipo Long de 30 posiciones. Debe lanzar tandas de 5 hilos concurrentes
para que vayan llenando dichas posiciones (desde la posición 0 a la 29), es decir, cuando los
primeros 5 hilos hayan finalizado, debe lanzar otros 5 hilos nuevos y así hasta completar las 30
posiciones. Cada posición del array es el resultado de una función llamada compute(Random r).
Importante: Inicialice una única semilla Random para todo el procedimiento.
Al finalizar el llenado muestre el array completo y el tiempo de ejecución total.
*/


public class Principal {

	public static void main(String[] args) {
		
		long inicio,fin;

		Random random = new Random();
		long[] array = new long[15];
		Thread misHilos[]=new Thread[15];
		int posicionActual=0;
		
		inicio = System.currentTimeMillis();

		while(posicionActual < 15) {
			
            for (int i = 0; i < 5; i++) {
    			misHilos[posicionActual] = new Hilo(posicionActual,array,random);
    			misHilos[posicionActual].start();
                posicionActual++;
			}
            
            for (int i = (posicionActual-5); i <posicionActual; i++) {
				try {
	                System.out.println("join de posicionActual: "+ i );
					misHilos[i].join();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}

		
		for(int i =0;i<15;i++) {
			System.out.println(array[i]);
		}
		
		fin = System.currentTimeMillis();
		System.out.println(fin);
		System.out.println("Duracion: "+(fin-inicio));
	}
}
