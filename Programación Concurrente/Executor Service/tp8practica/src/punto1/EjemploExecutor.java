package punto1;
/*El Executor Framework permite crear un Pool de ejecución de hilos (ahora llamados
tareas/tasks). Revise el ejemplo “EjemploPool” subido al aula virtual. Implemente un
Pool de ejecución tamaño 3 para ejecutar 10 tareas, donde cada una de ellas realizará
el cálculo siguiente, recibiendo como parámetro (root) el entero correspondiente al
número de tarea:
public static SumRootN(int root)
 {
 double result = 0;
 for (int i = 0; i < 10000000; i++)
 {
 result += Math.exp(Math.log(i) / root);
 }
 System.out.println("Resultado” + result);
 }
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploExecutor {
	 public static void main(String[] args) {
	        System.out.println("Dentro de: " + Thread.currentThread().getName());

	        System.out.println("Creando el 'Executor Service' con un Pool de hilos de tamano 2");
	        ExecutorService executorService = Executors.newFixedThreadPool(2);

	        for(int i=1;i<=5;i++) {
		        Runnable task = new TareaRunnable("("+i+")");
		        executorService.submit(task);
	        }
	        executorService.shutdown();

	        /*
	        Runnable task1 = new TareaRunnable("1");
	        Runnable task2 = new TareaRunnable("2");
	        Runnable task3 = new TareaRunnable("3");
	        Runnable task4 = new TareaRunnable("4");
	        Runnable task5 = new TareaRunnable("5");
	        
	        System.out.println("Enviando las tareas a ejecución...");
	        executorService.submit(task1);
	        executorService.submit(task2);
	        executorService.submit(task3);
	        executorService.submit(task4);
	        executorService.submit(task5);
	        
	        executorService.shutdown();*/
	 }
}
