package defaultPackage;

import java.util.Scanner;

public class EvaluaEdad {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		System.out.println("Edad: ");
		int edad = entrada.nextInt();
		
		if(edad<18) {
			System.out.println("Eres adolescente");
		}else if (edad<40){
			System.out.println("Eres joven");
		}else {
			System.out.println("Eres maduro");
		}
	}

}
