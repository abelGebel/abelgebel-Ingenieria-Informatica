package Punto4;

/*
Defina 2 matrices. Matriz A de 100 x 200 y matriz B de 200 x 100. Inicialice ambas con
números aleatorios (1-100). Luego realice el intercambio de forma concurrente de cada
fila de A a su correspondiente columna en B y viceversa (cada columna de B a su
correspondiente fila en A) sin perder la información en el pasaje. Muestre las matrices
antes y después del intercambio.
*/

import java.util.Random;

public class Principal {	


	public static void main(String[] args) {
		Random random = new Random();
		
		//Inicializamos las matrices
		int n = 3;
	    int m = 6;
		int[][] matrizA = new int[n][m];
		int[][] matrizB = new int[m][n];
		
		for (int i=0;i<matrizA.length;i++) {
			for(int j=0;j<matrizA[i].length;j++) {
				matrizA[i][j]=random.nextInt(1,100);
			}
		}
		
		for (int i=0;i<matrizB.length;i++) {
			for(int j=0;j<matrizB[i].length;j++) {
				matrizB[i][j]=random.nextInt(1,100);
			}
		}
		//Mostramos las matrices
       System.out.println("Matriz A antes del intercambio:");
       mostrarMatriz(matrizA);
       System.out.println("Matriz B antes del intercambio:");
       mostrarMatriz(matrizB);
		
		
		
		//Creamos un vector de hilos con la cantidad de filas y columnas de las respectivas matrices
		Thread[] hilos = new Thread[matrizA.length];
		
		//Lanzamos los hilos mediante un for
       for (int i = 0; i < hilos.length; i++) {
           hilos[i] = new HiloMatriz(matrizA, matrizB, i);
           hilos[i].start();
       }
       
       //creamos un bloque try catch con el metodo join() para asegurarse de que los hiles terminen antes que el programa principal
       try {
           for (int i = 0; i < hilos.length; i++) {
               hilos[1].join();
           }
       } catch (InterruptedException e) {}

       // Mostramos las matrices después del intercambio
       System.out.println("Matriz A despues del intercambio:");
       mostrarMatriz(matrizA);
       System.out.println("Matriz B despues del intercambio:");
       mostrarMatriz(matrizB);
   

	}
	

	public static void mostrarMatriz(int[][] matriz) {
		for (int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
