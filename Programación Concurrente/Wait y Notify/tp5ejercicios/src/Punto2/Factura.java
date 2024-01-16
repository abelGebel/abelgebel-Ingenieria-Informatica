package Punto2;

import java.util.List;
import java.util.Random;

public class Factura extends Thread {
	
	private List<Integer> factura;
	Random rdm = new Random();

	public Factura(List<Integer> factura) {
		this.factura = factura;
	}
	
	@Override
	public void run() {
		
		while (true) {
			int producto=0;
			
			try {
				sleep(rdm.nextInt(300)+1000);
				
				synchronized(factura) {
					rdm= new Random();
					producto=rdm.nextInt(40);
					factura.add(producto);
					System.out.println("Se ha producido una factura: " + producto);
					factura.notify();
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
