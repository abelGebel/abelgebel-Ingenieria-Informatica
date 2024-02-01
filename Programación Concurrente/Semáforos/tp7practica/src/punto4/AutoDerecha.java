package punto4;

import java.util.Random;

public class AutoDerecha extends Thread{
	private int id;
	private Semaforo semaforo;

	
	public AutoDerecha(int id,Semaforo semaforo) {
		this.id=id;
		this.semaforo=semaforo;
	}
	
	public void run() {
		Random random = new Random();
        System.out.println("Auto " + id + " llego a la derecha del puente");
        if(semaforo.getSemaforoAutosDerecha().availablePermits()==0) {
        	System.out.println("CANTIDAD DE AUTOS EN EL LADO DERECHO SUPERIOR AL LIMITE");
        }
        try {
			semaforo.getSemaforoAutosDerecha().acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (semaforo.getSemaforoPuente().availablePermits() == 0) {
            System.out.println("Auto " + id + " esta esperando poder cruzar en el lado derecho.");
        }
		try {
			semaforo.getSemaforoPuente().acquire();
			System.out.println("Auto "+id+" esta a la derecha del puente empezando a cruzar");
            Thread.sleep(random.nextInt(2000)+3000);
            System.out.println("Auto "+id+" salio del puente por el lado izquierdo.");
			semaforo.getSemaforoPuente().release();
			semaforo.getSemaforoAutosDerecha().release();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
