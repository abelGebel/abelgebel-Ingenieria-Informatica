package punto5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Se dispone del siguiente arreglo:
long[] vector = new long[] { 100477L, 105477L, 112986L,100078L,165987L, 142578L };
Se desea hacer el siguiente cálculo de cada número con la siguiente función que demora
varios segundos:
static BigInteger M = new BigInteger("1999");
private static BigInteger compute(long n) {
 String s = "";
 for (long i = 0; i < n; i++) {
 s = s + n;
 }
 return new BigInteger(s.toString()).mod(M);
Para ello deberá definir un Pool de ejecución de tamaño 2 para ejecutar dichos cálculos.
*/
public class Principal {

	public static void main(String[] args){
		long [] vector = new long[] {100477L, 105477L, 112986L, 100078L, 165987L, 142578L};
		ExecutorService executorService = Executors.newFixedThreadPool(2);// Creacion del pool con 2 hilos.
		
		for(int i=0;i<vector.length;i++) {
			Runnable task1 = new Tarea(vector[i]);
			executorService.submit(task1);
		}
		executorService.shutdown(); 
	}
}
