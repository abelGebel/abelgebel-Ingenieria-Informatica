package punto2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Principal {
	
	static Semaphore pista1=new Semaphore(20);
	static Semaphore pista2=new Semaphore(10);

	public static void main(String[] args) {
		Random ran=new Random();

		for(int i= 0; i<200;i++) {
			Recluta r=new Recluta(i+1,ran);
			r.start();
		}
	}
	
	static class Recluta extends Thread{
		int id;
		Random ran;
		public Recluta(int id,Random ran) {
			this.id=id;
			this.ran=ran;
		}
		
		public void run() {
			
			try {
				pista1.acquire();
				System.out.println("Recluta "+id+" ingreso a la pista 1.");
				Thread.sleep(1100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pista1.release();
				System.out.println("Rcluta "+id+" salio de la pista 1.");
				System.out.println("Rcluta "+id+" ingreso al pasillo.");
			}
			
			try {
				pista2.acquire();
				System.out.println("Recluta "+id+" ingreso a la pista 2.");
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pista2.release();
				System.out.println("Rcluta "+id+" salio de la pista 2.");
			}
			
		}
		
	}
	
	
}
