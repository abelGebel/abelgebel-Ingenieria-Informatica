package ejemplo9;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/*
El Aeropuerto Internacional de Londres posee 3 terminales (T1, T2 y T3) para la distribución
de los vuelos diarios de las aerolíneas que operan en dicho aeropuerto, por restricciones, cada
terminal solo posee una aerolínea específica. Los taxis llegan a dichas terminales transportando
los pasajeros que luego embarcarán los aviones. Cada taxi se dirige a la terminal que le
corresponde según el destino de los pasajeros (esta elección se debe realizar de forma aleatoria).
Un taxi puede transportar entre uno y cuatro pasajeros. Una vez que los pasajeros descienden del
taxi se dirigen a cualquier boletería para hacer el check-in. Debe simular para una cantidad
indefinida de taxis y pasajeros. Debe controlar en todo momento la cantidad de pasajeros que
recibe cada terminal (informando esto por pantalla), debe mostrar por pantalla cuando un
pasajero llega a la terminal, cuando se dirige a realizar el check-in y cuando finaliza el check-in,
informando para ello el número de pasajero.
La terminal T1 posee 5 boleterías para hacer el check-in.
La terminal T2 posee 6 boleterías para hacer el check-in.
La terminal T3 posee 5 boleterías para hacer el check-in.
Los taxis llegan constantemente a cada terminal entre 80-150ms.
El tiempo de demora en el check-in para cada pasajero es entre 150-250ms. Cada boletería
atiende un pasajero a la vez.
Se puede resolver mediante ExecutorService o Semáforos o combinaciones de ambos esquemas.

*/
public class Principal {

	static Semaphore T1 = new Semaphore(5,true);
	static Semaphore T2 = new Semaphore(6,true);
	static Semaphore T3 = new Semaphore(5,true);
	
	static Semaphore taxi1 = new Semaphore(4,true);
	static Semaphore ocupado1 = new Semaphore(1,true);
	static Semaphore salida1 = new Semaphore(0,true);

	static Semaphore salioTaxi1 = new Semaphore(1,true);


	public static void main(String[] args) {
		Random ran= new Random();
		int i=1;
		
		ScheduledExecutorService scheduledExecutorService =Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleWithFixedDelay(new Taxi(), 5, 5, TimeUnit.SECONDS);
		
		while(true) {
			Thread pasajero=new Pasajero(i,ran);
			pasajero.start();
			i++;
		}
	}
	
	
	static class Pasajero extends Thread{

		private int id;
		
		public Pasajero(int id, Random ran) {
			this.id=id;
		}
		
		public void run() {
			try {		
				tomaTaxi();
				checkIn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		private void tomaTaxi() throws InterruptedException{
			
			if(salioTaxi1.availablePermits()==0) {
				salioTaxi1.acquire();
			}
			
			if(taxi1.availablePermits()==0) {
				System.out.println("Pasajero "+id+" espera");
			}
			
			taxi1.acquire();
			System.out.println("Pasajero "+id+" se subio al taxi");
		}
		
			
		private void checkIn() throws InterruptedException{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	static class Taxi implements Runnable{

		@Override
		public void run() {
			
			try {
				salioTaxi1.acquire();
				System.out.println("Taxi salio");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Taxi llego a terminal");
			
			for(int i = 0; i<taxi1.availablePermits();i++) {
				salioTaxi1.release();
			}
			
			for(int i=0; i<4;i++) {
				taxi1.release();
			}
			
			ocupado1.release();
			
		}
		
	}

}
