package ejemplo1;

import java.util.Random;

public class Donante extends Thread{
	private int id;
	private Atencion atencion;
	private Random random;
	
	
	public Donante(int id,Atencion atencion,Random random) {
		this.id=id;
		this.atencion=atencion;
		this.random=random;
	}
	
	public void run() {
		try {
			
		System.out.println("Persona "+id+" llega.");
		if (atencion.getSemaforo().availablePermits() == 0) {
            System.out.println("Persona " + id + " esta esperando.");
        }
			
			atencion.getSemaforo().acquire();
			System.out.println("Persona "+id+" esta donando.");
			Thread.sleep(random.nextInt(4000)+4000);
			System.out.println("Persona"+id+" se retira.");
			atencion.getSemaforo().release();
			
			
			
		} catch (InterruptedException e) {e.printStackTrace();
		}
		
	}

}
