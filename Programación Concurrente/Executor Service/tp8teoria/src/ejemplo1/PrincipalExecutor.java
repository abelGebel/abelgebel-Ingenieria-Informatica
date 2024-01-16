package ejemplo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class PrincipalExecutor {

	public static void main(String[] args) {
		Stream<String> flujo = Stream.of("tarea1,tarea2,tarea3");
		ExecutorService servicio = Executors.newCachedThreadPool();
		flujo.map(t->new Tarea(t)).forEach(servicio::execute);
	}

}
