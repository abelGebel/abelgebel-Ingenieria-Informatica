package ejemplo2;


public class Dispositivo extends Thread{

	private Semaforo semaforo;
	private int id;
	
	public Dispositivo(Semaforo semaforo,int id){
		this.semaforo=semaforo;
		this.id=id;
	}
	
	public void run() {
		
		try {


		semaforo.getMesa().acquire(1);
		
		semaforo.getDestornillador().acquire(1);
		semaforo.getPinza().acquire(1);
		System.out.println("Dispositivo "+id+" pasa por la fase (1).");
		Thread.sleep(4000);
		semaforo.getDestornillador().release();
		semaforo.getPinza().release();
		
		semaforo.getSargento().acquire(2);
		System.out.println("Dispositivo "+id+" pasa por la fase (2).");
		Thread.sleep(2000);
		semaforo.getSargento().release(2);
		
		semaforo.getPinza().acquire(2);
		System.out.println("Dispositivo "+id+" pasa por la fase (3).");
		Thread.sleep(4000);
		semaforo.getPinza().release(2);
		
		System.out.println("DISPOSITIVO ("+id+") FUE ENSAMBLADO");

		semaforo.getMesa().release();
		
		
		} catch (InterruptedException e) {e.printStackTrace();}
		
	}
}
