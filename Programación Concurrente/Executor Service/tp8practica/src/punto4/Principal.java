package punto4;
/*
Programe la ejecución de una tarea repetitiva, que cada 5 segundos chequee si en un
directorio (carpeta/folder) a elección se ha creado un nuevo archivo. Para ello deberá
iniciar la lectura y carga de los nombres de archivos para luego verificar si ha agregado
uno nuevo, en caso de que un nuevo archivo sea creado se deberá mostrar por pantalla
“Nuevo archivo [nombre_archivo], con tamaño [tamaño_archivo]”. Deberá copiar un
nuevo archivo a dicha carpeta para comprobar el proceso
*/
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService =Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleWithFixedDelay(new Tarea(), 0, 5, TimeUnit.SECONDS);
	}

}