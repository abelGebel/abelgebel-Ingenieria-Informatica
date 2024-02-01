package punto4;

import java.util.Random;

public class AutoIzquierda extends Thread{
	
	private int id;
	private Semaforo semaforo;
	
	
	public AutoIzquierda(int id,Semaforo semaforo) {
		this.id=id;
		this.semaforo=semaforo;
	}
	
	public void run() {
		Random random = new Random();
        System.out.println("Auto " + id + " llego a la izquierda del puente");
        if(semaforo.getSemaforoAutosIzquierda().availablePermits()==0) {
        	System.out.println("CANTIDAD DE AUTOS EN EL LADO IZQUIERDO SUPERIOR AL LIMITE");
        }
        try {
			semaforo.getSemaforoAutosIzquierda().acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (semaforo.getSemaforoPuente().availablePermits() == 0) {
            System.out.println("Auto " + id + " esta esperando poder cruzar en el lado izquierdo.");
        }
		try {
			semaforo.getSemaforoPuente().acquire();
			System.out.println("Auto "+id+" esta a la izquierda del puente empezando a cruzar");
            Thread.sleep(random.nextInt(2000)+3000);
            System.out.println("Auto "+id+" salio del puente por el lado derecho.");
			semaforo.getSemaforoPuente().release();
			semaforo.getSemaforoAutosIzquierda().release();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
}
