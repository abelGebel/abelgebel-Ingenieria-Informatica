package Punto2;
import java.util.List;
import java.util.Random;


public class Bizcocho extends Thread{

	private List<Integer> bizcocho;
	Random rdm = new Random();
	public Bizcocho(List<Integer> bizcocho) {
		this.bizcocho = bizcocho;
	}
	
	@Override
	public void run() {
		
		while(true) {
			int producto=0;
			try {
				sleep(rdm.nextInt(200)+400);
				
				synchronized(bizcocho) {
					producto=rdm.nextInt(40);
					bizcocho.add(producto);
					System.out.println("Se ha producido un bizcocho: " + producto);
					bizcocho.notify();
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			  }
		}	
	}
}