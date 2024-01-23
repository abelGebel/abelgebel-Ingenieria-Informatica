package b;

import java.util.Random;

/*
 Escribir un programa que permita ingresar los valores de una matriz cuadrada (arreglo de dos
dimensiones), mostrar la matriz en la consola y calcular la suma de los elementos que no pertenezcan a
la diagonal principal. Además, informar la cantidad de números positivos, negativos y ceros que
contiene la matriz.
 
*/
public class Principal {

	public static void main(String[] args) {
		int sumaElementos=0,contPos=0,contNeg=0,contCeros=0;
		int n=3;
		Random ran = new Random();
		int matriz[][]=new int[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matriz[i][j]=ran.nextInt(50)-25;
				if(i!=j) {
					sumaElementos+=matriz[i][j];
				}
				if(matriz[i][j]>0) {
					contPos+=1;
				}else if(matriz[i][j]<0) {
					contNeg+=1;
				}else {
					contCeros+=1;
				}
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Suma de elementos no pertenecientes a la diagonal principal: "+sumaElementos);
		System.out.println("cantidad de números positivos: "+contPos);
		System.out.println("cantidad de números negativos: "+contNeg);
		System.out.println("cantidad de ceros: "+contCeros);


		
		
	}

}
