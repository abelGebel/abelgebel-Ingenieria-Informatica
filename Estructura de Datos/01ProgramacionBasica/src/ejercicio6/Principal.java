package ejercicio6;
import java.util.Random;
import java.util.Scanner;

import a.Helper;
/*
Dadas las longitudes de los tres lados de un triángulo, determinar qué clasificación le corresponde
(Equilátero, Isósceles o Escaleno). Para ello, en primer lugar, se debe determinar si las medidas de los tres
lados forman un triángulo usando el teorema de la desigualdad del triángulo.
Teorema de la desigualdad del triángulo: La suma de las longitudes de cualquiera de los dos lados de un
triángulo es mayor que la longitud del tercer lado. 
*/
public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	
	private static void menu() {
		Scanner input = new Scanner(System.in);
		Random ran = new Random();

		System.out.println("----------INICIO PROGRAMA----------");
		int opcion;
		while(true) {
			System.out.println();
			System.out.println("Como quiere que se ingresen los datos?");
			System.out.println("1) De forma manual");
			System.out.println("2) De forma aleatoria");
			System.out.println("3) Salir");
			opcion=Helper.getInteger(input, "Ingrese una opcion: ","OPCION NO VALIDA...");
			System.out.println();
			
			if(opcion==1) {
				ingresoManual(input);
			}else if(opcion==2) {
				ingresoAleatorio(ran);
			}else if(opcion==3) {
				System.out.println("----------Fin programa----------");
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		
	}


	private static void ingresoAleatorio(Random ran) {
		int lado1,lado2,lado3;
		lado1=ran.nextInt(30)+1;
		lado2=ran.nextInt(30)+1;
		lado3=ran.nextInt(30)+1;
		while(true) {
			if(!verificarTrianglo(lado1,lado2,lado3)) {
				lado1=ran.nextInt(30)+1;
				lado2=ran.nextInt(30)+1;
				lado3=ran.nextInt(30)+1;
			}else {
				break;
			}
		}
		System.out.println("Lado A: "+lado1);
		System.out.println("Lado B: "+lado2);
		System.out.println("Lado C: "+lado3);

		clasificarTriangulos(lado1,lado2,lado3);
	}


	private static void ingresoManual(Scanner input) {
		int lado1,lado2,lado3;
		lado1=Helper.getInteger(input, "Ingrese la longitud del primer lado: ", "INGRESO NO VALIDO...");
		lado2=Helper.getInteger(input, "Ingrese la longitud del segundo lado: ", "INGRESO NO VALIDO...");
		lado3=Helper.getInteger(input, "Ingrese la longitud del tercer lado: ", "INGRESO NO VALIDO...");
		
		if(verificarTrianglo(lado1,lado2,lado3)) {
			clasificarTriangulos(lado1,lado2,lado3);
		}else {
			System.out.println("NO CUMPLE CON EL TEOREMA DE LA DESIGUALDAD DEL TRIANGULO...");
		}
		
	}


	private static void clasificarTriangulos(int lado1, int lado2, int lado3) {
		if((lado1==lado2) && (lado1==lado3)) {
			System.out.println("El triangulo es EQILATERO");
		}else if((lado1==lado2)|| (lado1==lado3) ||(lado2==lado3) ) {
			System.out.println("El triangulo es ISOSCELES");
		}else {
			System.out.println("El triangulo es ESCALENO");
		}
		
	}


	private static boolean verificarTrianglo(int lado1, int lado2, int lado3) {
		if((lado1+lado2>lado3)&&(lado1+lado3>lado2)&&(lado2+lado3>lado1)) {
			return true;
		}else {
			return false;
		}
			
	}

}
