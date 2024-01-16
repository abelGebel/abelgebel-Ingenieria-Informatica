package Punto2;

import java.util.List;
import java.util.Random;

public class Cliente extends Thread {

	private List<Integer> bizcocho;
	private List<Integer> factura;
	private Integer posicion;
	
	public Cliente(List<Integer> bizcocho, List<Integer> factura, int numero) {
		this.bizcocho = bizcocho;
		this.factura = factura;
		posicion = numero; //posicion señala el numero de cliente
	}
	
	@Override
	public void run() {
		try {
			
			synchronized (bizcocho) {
				while(bizcocho.isEmpty()) {
					System.out.println("Cliente "+ posicion + " esperando, mostrador de bizcochos vacio");
					bizcocho.wait();
				}
				int producto = bizcocho.remove(0);
				System.out.println("El cliente " + posicion + " compro el bizcocho " + producto);
			}
			
			synchronized (factura) {
				while(factura.isEmpty()) {
					System.out.println("Cliente "+ posicion + " esperando, mostrador de facturas vacio");
					factura.wait();
				}
				int producto = factura.remove(0);
				System.out.println("El cliente " + posicion + " compro la factura " + producto);
			}
			
			Random rdm = new Random();
			Thread.sleep(rdm.nextInt((400 - 200)+1)+200);
			System.out.println("El cliente "+ posicion + " se ha retirado.");
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}