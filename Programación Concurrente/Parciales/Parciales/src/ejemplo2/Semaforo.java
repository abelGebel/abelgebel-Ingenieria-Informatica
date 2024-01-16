package ejemplo2;

import java.util.concurrent.Semaphore;

public class Semaforo {

	static private Semaphore mesa=new Semaphore(3);
	static private Semaphore pinza=new Semaphore(4);
	static private Semaphore destornillador=new Semaphore(2);
	static private Semaphore sargento=new Semaphore(4);
	
	public Semaphore getMesa() {
		return mesa;
	}

	public Semaphore getPinza() {
		return pinza;
	}

	public Semaphore getDestornillador() {
		return destornillador;
	}

	public Semaphore getSargento() {
		return sargento;
	}

	
}
