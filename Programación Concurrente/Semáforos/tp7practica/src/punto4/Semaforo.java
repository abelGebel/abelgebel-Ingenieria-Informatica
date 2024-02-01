package punto4;

import java.util.concurrent.Semaphore;

public class Semaforo {
	static Semaphore semaforoPuente;
	static Semaphore autosIzquierda=new Semaphore(3);
	static Semaphore autosDerecha=new Semaphore(3);
	static int permisos;
	
	public Semaforo(int permisos) {
		this.semaforoPuente=new Semaphore(permisos);
	}

	public Semaphore getSemaforoPuente() {
		return semaforoPuente;
	}
	public Semaphore getSemaforoAutosIzquierda() {
		return autosIzquierda;
	}
	public Semaphore getSemaforoAutosDerecha() {
		return autosDerecha;
	}


	
	
	
	
}
