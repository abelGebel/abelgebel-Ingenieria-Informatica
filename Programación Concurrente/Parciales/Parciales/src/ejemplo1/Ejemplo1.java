package ejemplo1;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*
Una sala de hemoterapia puede atender como máximo 4 extracciones de sangre al mismo
tiempo. A medida que las personas van llegando a la sala esperan a ser atendidas puesto
que solo pueden donar 4 personas (suponga que la sala de espera es lo suficientemente
grande para que cualquier cantidad de personas espere). Cada donación demora un
tiempo aleatorio entre 4” y 8”. Las personas llegan a la sala en un tiempo aleatorio entre
200ms y 300ms. Simule la atención para 100 personas. Cada persona se debe identificar
por un número y debe mostrar por pantalla todos los sucesos para poder hacer el
seguimiento de la ejecución (persona X llega, persona X espera, persona X está donando,
persona X se retira).
*/

public class Ejemplo1 {
	
	static Semaphore sem=new Semaphore(4,true);
	
	public static void main(String[] args) {
		
		Random ran=new Random();
		
		for(int i=1;i<=20;i++) {
			try {
				Thread.sleep(ran.nextInt(100)+200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Thread donante = new Donante(i,ran);
			donante.start();
		}
	}
	
	static class Donante extends Thread {
		private int id;
		private Random ran;
		
		public Donante(int id,Random ran) {
			this.id=id;
			this.ran=ran;
		}
		
		public void run() {
			try {
				
			System.out.println("Persona "+id+" llego.");
			if(sem.availablePermits()==0) {
				System.out.println("Persona "+id+" espera.");
			}
			sem.acquire();
			System.out.println("Persona "+id+" esta donando.");
			Thread.sleep(4000+ran.nextInt(4000));
			
			System.out.println("Persona "+id+" se retira.");
			
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				sem.release();
			}
		}
	}
}
