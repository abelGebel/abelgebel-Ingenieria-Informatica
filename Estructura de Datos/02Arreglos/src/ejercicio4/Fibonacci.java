package ejercicio4;
import a.Helper;

import java.util.Arrays;
import java.util.Scanner;
/*
Escribir un programa que permita generar los términos de la serie Fibonacci y guardarlos, hasta que el
usuario decida no continuar. El programa debe calcular y mostrar la suma de los números pares, la cantidad
de los impares, el promedio de los términos generados y la cantidad de términos mayores a dicho
promedio.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio. 
*/
public class Fibonacci {

	public static void main(String[] args) {
		
		char continuar;
		while(true) {

		Scanner input = new Scanner(System.in);
		int n=2;

        System.out.println("Generados los dos primeros terminos de la serie Fibonacci");
        char opcion = Helper.getCharacter(input,"Desea generar el siguiente termino? (s/n): ");
        
        while (opcion=='S' || opcion=='s') {
        	n++;
        	System.out.println("Generado (total: "+n+" terminos)");
            opcion = Helper.getCharacter(input,"Desea generar el siguiente trmino? (s/n): ");
        }

        int arregloFibonacci[]= new int[n];
        arregloFibonacci[0]=0;
        arregloFibonacci[1]=1;
        
		int numeroAnterior = 0;
        int numeroActual = 1;
        int siguienteNumero;
        
        
        for(int i=2;i<n;i++) {
        	siguienteNumero = numeroAnterior + numeroActual;
            numeroAnterior = numeroActual;
            numeroActual = siguienteNumero;
            
            arregloFibonacci[i]=numeroActual;
        }

		realizarCalulos(arregloFibonacci);
		System.out.println();
		continuar=Helper.getCharacter(input,"Desea continuar?(s/n): ");
		if(continuar=='n') {
			break;
		}
		
		}
	}

	private static void realizarCalulos(int[] arregloFibonacci) {
		System.out.println();
        System.out.println("Arreglo generado:");
		System.out.println(Arrays.toString(arregloFibonacci));
		
		int sumaPares=0;
		int cantImpares=0;
		float total=0;
		float promedio;
		
		for(int i=0;i<arregloFibonacci.length;i++) {
			if (arregloFibonacci[i]%2==0) {
				sumaPares=sumaPares+arregloFibonacci[i];
			}else {
				cantImpares=+1;
			}
			total=total+arregloFibonacci[i];
		}
		promedio=total/arregloFibonacci.length;
		
		System.out.println("Suma de los numeros pares: "+sumaPares);
		System.out.println("Cantidad de numeros impares: "+cantImpares);
		System.out.println("Promedio de los terminos generados: "+promedio);
		System.out.print("Terminos mayores al promedio: ");
		for(int i=0;i<arregloFibonacci.length;i++) {
			if(arregloFibonacci[i]>promedio) {
				System.out.print(arregloFibonacci[i]+" ");
			}
		}

	}

}
