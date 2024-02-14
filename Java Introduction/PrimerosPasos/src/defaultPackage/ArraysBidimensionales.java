package defaultPackage;

import java.util.*;

public class ArraysBidimensionales {

	public static void main(String[] args) {
		Random random= new Random();
		int[][] matriz = new int[3][2];
		
		matriz[0][0]=88;
		matriz[0][1]=55;
		matriz[1][0]=23;
		matriz[1][1]=13;
		matriz[2][0]=98;
		matriz[2][1]=53;
		
		int filas = matriz.length;
		int columnas = matriz[0].length; // Suponemos que todas las filas tienen la misma longitud
		
	    try {
			for(int i=0; i<filas; i++) {
				for(int j=0; j<columnas; j++) {
					System.out.print(matriz[i][j]+" ");
				}
				System.out.println();
			}
	    } catch (ArrayIndexOutOfBoundsException e) {
	        // Captura la excepción y muestra un mensaje de error
	        System.err.println("Error: Se ha producido una excepción ArrayIndexOutOfBoundsException. " +
	                           "Asegúrate de que los índices de la matriz estén dentro de los límites.");
	    }
		

		System.out.println();
		
		int[][] enteros = new int[3][4];
		
		filas = enteros.length;
		columnas = enteros[0].length;
		
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				enteros[i][j]=random.nextInt(90)+10;
				System.out.print(enteros[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int[]fila:enteros) {
			for(int z: fila) {
				System.out.print(z+" ");
			}
			System.out.println();			
		}
		
	}

}
