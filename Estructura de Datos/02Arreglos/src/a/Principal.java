package a;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Escribir un programa que permita ingresar números generados aleatoriamente (entre 1 y 100 inclusive)
en un arreglo de enteros de dimensión 10. El programa debe mostrar el resultado de la suma de los
números pares así como el producto de los impares.

*/
public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pares=0,impares=1;
		Random ran = new Random();
		int array[]= new int[10];
		int value;
		for(int i=0;i<10;i++) {
			System.out.print("Ingrese un valor: ");
			value=input.nextInt();
			array[i]=value;
		}
		
		System.out.println("Arreglo generado: ");
		System.out.println(Arrays.toString(array));
		
		
		for(int i=0;i<10;i++) {
			if(array[i]%2==0) {
				pares+=array[i];
			}else {
				impares*=array[i];
			}
		}
		System.out.println("Suma de los numeros pares: "+pares);
		System.out.println("Producto de los nuemros impares: "+impares);

	}

}
