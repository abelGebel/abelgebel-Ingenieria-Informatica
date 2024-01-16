package ejemplo1;

import java.util.concurrent.Semaphore;

public class Atencion {

	static private Semaphore semaforo=new Semaphore(4);
	
	public Atencion() {}

	public Semaphore getSemaforo() {
		return semaforo;
	}	
}
