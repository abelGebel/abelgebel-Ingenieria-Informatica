package ejercicio2;
import a.Helper;

import java.util.Random;
import java.util.Scanner;

/*
 Ingresar una cantidad de N ángulos (en grados) e indicar, por cada uno, si se trata de un ángulo agudo,
recto, obtuso, llano u otro. Determinar la cantidad de ángulos obtusos y la cantidad de ángulos mayores a
180° ingresados. Además, para cada ángulo obtuso determinar su suplemento y para cada ángulo agudo
determinar su complemento. A los fines de simplificar la complejidad del problema, considere que los
ángulos ingresados corresponden a valores enteros.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
También necesita del objeto random para generar valores de manera aleatoria.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente
*/
public class Principal {

	static int cantAngObtusos;
	static int cantAngMayores180;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int ingreso=menu(input);
		if(ingreso==1) {
			ingresoManual(input);
		}else if(ingreso==2) {
			ingresoAleatorio();
		}
		System.out.println("Cantidad de angulos obtusos ingresados: "+cantAngObtusos);
		System.out.println("Cantidad de angulos mayores a 180 ingresados: "+cantAngMayores180);
		System.out.println();
		System.out.println("----------Fin programa----------");
	}

	private static void ingresoManual(Scanner input) {
		int angulo;
		int N = Helper.getIntegerPositivo(input, "Ingrese la cantidad de angulos: ","INGRESE UNA CANTIDAD VALIDA...");
		for(int i = 0; i < N;i++) {
			angulo = Helper.getIntegerPositivo(input, "Ingrese el "+(i+1)+"° angulo", "INGRESE UN ANGULO VALIDO POSITIVO...");
			clasificarAngulo(angulo);
		}
	}


	private static void ingresoAleatorio() {
		Random ran = new Random();
		int angulo;
		int N = ran.nextInt(10)+1;
		System.out.println("Cantidad de angulos: "+N);
		for(int i = 0; i < N;i++) {
			angulo=ran.nextInt(360);
			System.out.println();
			System.out.println("Angulo ingresado: "+angulo);
			clasificarAngulo(angulo);
		}
		System.out.println();
		
	}
	
	private static void clasificarAngulo(int angulo) {
		if(angulo<90) {
			System.out.println("Es un angulo agudo");
			System.out.println("Su complemento es: "+(90-angulo));
		}else if(angulo==90) {
			System.out.println("Es un angulo recto");
		}else if(angulo>90 && angulo<180) {
			System.out.println("Es un angulo obtuso");
			System.out.println("Su suplemento es: "+(180-angulo));
			cantAngObtusos+=1;
		}else if(angulo==180) {
			System.out.println("Es un angulo lllano");
		}else {
			cantAngMayores180+=1;
			System.out.println("El angulo entra en otra clasificacion");
		}
		
	}

	private static int menu(Scanner input) {
		int opcion;
		System.out.println("----------Inicio programa----------");
		System.out.println();
		System.out.println("Como quiere que se ingresen los datos?");
		System.out.println("1) De forma manual");
		System.out.println("2) De forma aleatoria");
		System.out.println("3) Salir");
		System.out.println();
		while(true) {
			opcion = Helper.getInteger(input,"Ingrese una opcion: ","OPCION NO VALIDA...");
			if(opcion>0 && opcion<4) {
				return opcion;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		
	}
	
	

}
