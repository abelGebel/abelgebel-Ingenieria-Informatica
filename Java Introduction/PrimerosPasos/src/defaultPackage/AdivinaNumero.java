package defaultPackage;
import java.util.*;

public class AdivinaNumero {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		int aleatorio = (int) (Math.random()*100);
		
		
		int numero = 100;
		
		int intentos = 0;
		
		do{
			intentos++;
			System.out.println("Introduce un numero: ");
			numero = entrada.nextInt();
			
			if(aleatorio < numero) {
				System.out.println("Mas bajo");
			}
			else if(aleatorio > numero) {
				System.out.println("Mas alto");
			}
			else if (aleatorio == numero){
				System.out.println("CORRECTO");
			}
			
		}while(numero!=aleatorio);
		
		System.out.println(intentos + " intentos");

	}

}
