package Punto1;

/*
Implemente lo siguiente:

a. Una clase que imprima el siguiente patrón de sucesión de X: “.0X.” (.iX. para
i=0……99), a continuación debe imprimir un patrón de sucesión de Y: “.0Y.”
(.iY. para i=0……99).

b. Mediante Hilos heredando de Thread, emplee dos clases para realizar dicha
impresión de forma concurrente. Repita el proceso 10 veces para observar cómo
se imprimen los distintos lanzamientos.

c. Obtenga la porción de la fila que posea la sucesión más larga de cualquier letra.
Imprima toda la sucesión.

d. Si en el inciso b) no se imprimen correctamente utilice una pausa o join.

e. Razone y comente los resultados obtenidos.
*/

public class Principal {

	public static void main(String[] args) {

		long inicio,fin;
		inicio = System.currentTimeMillis();
		System.out.println(inicio);
		
		
		Thread misHilosX[]=new Thread[10];
		Thread misHilosY[]=new Thread[10];
		
		for(int i=0; i< 10;i++) {
			misHilosX[i] = new PrintX(i);
			misHilosX[i].start();
			misHilosY[i] = new PrintY(i);
			misHilosY[i].start();

		}
		for(int i=0; i < misHilosY.length; i++) {
			try {
				misHilosX[i].join();
				misHilosY[i].join();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("");

		fin = System.currentTimeMillis();
		System.out.println(fin);
		System.out.println("Duracion: "+(fin-inicio));

	}

}
