package punto1;
/*
Implemente, mediante Hilos heredando de Thread, un programa que emplee un semáforo
general inicializado en 3 y simplemente cada hilo duerma por 5”. Debe indicar el
momento antes de empezar a dormir y cuando deja de dormir. Observar el orden de
ejecución de los hilos pasando por parámetro el nombre del mismo. Debe lanzar 10 hilos.
*/

import java.util.concurrent.Semaphore;

public class Punto1 {
	
    static Semaphore semaforo = new Semaphore(3);

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0;i<10;i++) {
			Thread dormir = new dormir(i+1);
			dormir.start();
			Thread.sleep(50);
		}
	}
	
	static class dormir extends Thread {
		
		private int id;

		public dormir(int id) {
			this.id=id;
		}
		
		public void run(){
			try {
				semaforo.acquire();
				System.out.println("Hilo "+id+" duerme.");
				Thread.sleep(2000);
				System.out.println("Hilo "+id+" se despierta.");
				semaforo.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
