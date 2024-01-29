package barberia;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*
Mediante semáforos y pseudocódigo, resuelva el siguiente problema: Una barbería posee una
sala de espera con n sillas y una sala para el barbero. Si no hay clientes esperando, el barbero
duerme. Si un cliente entra a la barbería y todas las sillas están ocupadas, el cliente se retira.
Si el barbero está ocupado, pero hay sillas, el cliente se sienta en una de las sillas libres. Si el
barbero está dormido, el cliente lo despierta. Escriba un programa para coordinar al barbero y
los clientes.

*/
public class Principal {
	
	static Semaphore sillas = new Semaphore(10,true);
	static Semaphore barbero = new Semaphore(1,true);


	public static void main(String[] args) {
		Random  ran=new Random();
		int i=1;
		while(true) {
			
			Thread cliente = new Cliente(i,ran);
			cliente.start();
			i++;
			try {
				Thread.sleep(ran.nextInt(2000)+3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	static class Cliente extends Thread{
		private int id;
		private Random ran;
		
		public Cliente(int id, Random ran) {
			super();
			this.id=id;
			this.ran=ran;
		}
		
		public void run() {
			
			boolean corte=false;
			try {
				
			if(sillas.availablePermits()==0) {
				System.out.println("NO HAY SILLAS DISPONIBLES, CLIENTE "+id+" SE RETIRA");
			}else {
				sillas.acquire();
				if(barbero.availablePermits()==0) {
					System.out.println("Barbero ocupado,cliente "+id+" espera.");
				}
				try {
					barbero.acquire();
					System.out.println("Cliente "+id+" se esta cortando el pelo.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					sillas.release();
				}

				Thread.sleep(ran.nextInt(4000)+4000);
				corte=true;
				
			}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(corte) {
					System.out.println("Cliente "+id+" termino de cortarse el pelo y se retira.");
					barbero.release();
				}
			}
		}	
	}

}
