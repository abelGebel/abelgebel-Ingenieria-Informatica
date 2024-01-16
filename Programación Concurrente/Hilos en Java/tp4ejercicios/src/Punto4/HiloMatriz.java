package Punto4;

public class HiloMatriz extends Thread{//Heredamos de la clase Thread
	//Creamos los atributos que vamos a utilizar para el intercambio de filas.
	   private int[][] matrizA;
	   private int[][] matrizB;
	   private int fila;	//Fila acutal que se va a estar intercambiando
	   
	   //creamos el consructor que recibe como parametros las matrices y la fila actual que se este intercambiando
	   public HiloMatriz(int[][] matrizA, int[][] matrizB, int fila) {
	       this.matrizA = matrizA;
	       this.matrizB = matrizB;
	       this.fila = fila;
	   }
			   
	   public void run() {
	   	//Realizamos el intercambio de la fila i-esima de la matriz A con la columna i-esima de la matriz B sirviendonos de una variable temporal que sirva como recipiente
	       for (int i = 0; i < matrizB.length; i++) {	// matrizB.length=cantidad de filas de la matriz B(200)
	           int temp = matrizA[fila][i];
	           matrizA[fila][i] = matrizB[i][fila];
	           matrizB[i][fila] = temp;
	       }
	   } 
}