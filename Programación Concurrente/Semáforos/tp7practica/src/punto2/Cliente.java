package punto2;

import java.util.Random;


public class Cliente extends Thread{
	
	Random random= new Random();
	private int id;
	private Cajero cajero;
	
	public Cliente(int id, Cajero cajero) {
		this.id=id;
		this.cajero=cajero;
	}
	
	@Override
	public void run() {

		if (cajero.getCajero().availablePermits() == 0) {
            System.out.println("Cliente " + id + " esta esperando poder ser atendido.");
        }
		try {
			cajero.getCajero().acquire();
            System.out.println("Cliente " + id + " esta siendo atendido por el cajero ");
            
            Thread.sleep(5000);
            System.out.println("Cliente "+id+" se retira.");
            cajero.getCajero().release();
		} catch (InterruptedException e) {e.printStackTrace();}
		
		
	}

}
