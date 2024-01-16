package punto2;

/*Implemente una clase que muestre la fecha y hora actual del sistema. Desde el main()
lance la ejecución de dicha tarea cada 2 segundos de forma ininterrumpida, para ello
deberá programar la ejecución del ExecutorService:
ScheduledExecutorService scheduledExecutorService =
Executors.newScheduledThreadPool(1);
scheduledExecutorService.scheduleAtFixedRate(tarea a ejecutar, espera inicial,
espera, unidad de tiempo utilizada);*/


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService =Executors.newScheduledThreadPool(1);
		//scheduledExecutorService.scheduleWithFixedDelay(new Tarea2(), 0, 2, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(new Tarea2(), 0, 2, TimeUnit.SECONDS);
	}
}
