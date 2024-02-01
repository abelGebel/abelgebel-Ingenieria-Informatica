package ejercicios;

import java.util.Random;

//Crear una tabla de tamaño 7x7 y rellenarla de forma que los elementos de la diagonal
//principal sean 1 y el resto números aleatorios impares.

public class Punto1 {

	public static void main(String[] args) {
		Random random = new Random();
		int numeroRandom = 0;
		
		for (int i=0; i<7; i++) {
			
			for(int j=0; j <7; j++) {
				
				if (i==j) {
					System.out.print(1+"  ");
		
				}else {
					
					do {
						numeroRandom=random.nextInt(1,100);
					}while(numeroRandom%2==0);
					if(numeroRandom<10) {
						System.out.print(numeroRandom+"  ");
					}else {
						System.out.print(numeroRandom+" ");
					}
				}
			}
			System.out.println();
		}

	}

}
