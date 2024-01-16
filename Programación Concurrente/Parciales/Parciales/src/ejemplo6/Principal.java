package ejemplo6;
/*
 Cada 4” se agrega un elemento nuevo a una lista de números enteros que inicia vacía. Cada
número agregado es un número aleatorio entre [30-80]. Una vez que se agrega el nuevo elemento
a la lista, se deben mostrar todos los elementos, mostrar la suma actual, el promedio actual y se
debe indicar si el resultado de la suma es un divisible por 6 o no. Repetir dicha tarea cada 4”.  
*/
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService =Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleWithFixedDelay(new Tarea(), 1, 3, TimeUnit.SECONDS);

	}
}
