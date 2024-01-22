package ejercicio4;
import java.util.Scanner;
import a.Helper;
/*
Implementar una función, módulo o subprograma que determine si un número entero positivo (validado)
es un número compuesto.
Definición: Número compuesto es todo número natural mayor que 1 que no es primo. Por ejemplo: 4, 6, 10.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
*/
public class Principal {

	public static void main(String[] args) {
		System.out.println("----------INICIO PROGRAMA----------");
		System.out.println();

		Scanner input = new Scanner(System.in);
		int numero;
		char opcion;
		while(true) {
			numero=Helper.getIntegerPositivo(input,"Ingrese un entero positivo: ","ENTRADA NO VALIDA...");
			System.out.println();
			if(numero==0) {
				System.out.println("EL 0 NO PUEDE SER CLASIFICADO...");
			}else {
				verificarCompuesto(numero);
			}
			char[] charValues = {'s','n'};
			opcion=Helper.getCharacter(input, "Desea continuar? (s/n)","INGRESO NO VALIDO...", charValues);
			System.out.println();
			if(opcion=='n'||opcion=='N') {
				break;
				
			}
		}
		System.out.println("----------FIN PROGRAMA----------");

	}

	private static void verificarCompuesto(int n) {
		int contador=0;
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				contador+=1;
			}
		}
		if(contador==0) {
			System.out.println("El numero ingresado NO es compuesto");
		}else {
			System.out.println("El numero ingresado ES compuesto");

		}
		System.out.println();
		
		
	}

}
