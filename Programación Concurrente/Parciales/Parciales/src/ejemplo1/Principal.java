package ejemplo1;

import java.util.Random;

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
public class Principal {

	public static void main(String[] args) {
		Atencion atencion=new Atencion();
		Random random= new Random();

		for(int i = 1; i<=100;i++) {
			Donante donante = new Donante(i,atencion,random);
			donante.start();
			try {
				Thread.sleep(random.nextInt(100)+200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
