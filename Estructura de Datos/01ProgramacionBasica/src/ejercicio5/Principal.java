package ejercicio5;
import a.Helper;
import java.util.Random;
import java.util.Scanner;
/*
 Encontrar el máximo común divisor de dos números enteros positivos (validados).
Definición: El máximo común divisor de dos o más números enteros es el mayor número entero que los
divide exactamente a todos, esto es sin dejar resto en cada división.
Solución: El algoritmo de Euclides transforma un par de enteros positivos en otro par, dividiendo
repetidamente el entero mayor por el menor y reemplazando el mayor por el menor y el menor por el
resto. Cuando el resto es 0, el número más pequeño distinto de cero de la pareja resultante será el máximo
común divisor de la pareja original.
*/
public class Principal {

	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		menu(input,ran);
	}

	private static void menu(Scanner input, Random ran) {
		
		System.out.println("----------INICIO PROGRAMA----------");
		int opcion;
		int a,b;
		while(true) {
			System.out.println();
			System.out.println("Como quiere que se ingresen los datos?");
			System.out.println("1) De forma manual");
			System.out.println("2) De forma aleatoria");
			System.out.println("3) Salir");
			opcion=Helper.getInteger(input, "Ingrese una opcion: ","OPCION NO VALIDA...");
			System.out.println();
			
			if(opcion==1) {
				a=Helper.getIntegerPositivo(input, "Ingrese un entero positivo a: ","INGRESO NO VALIDO...");
				b=Helper.getIntegerPositivo(input, "Ingrese otro entero positivo b: ","INGRESO NO VALIDO...");
				System.out.println("El mcd entre "+a+" y "+b+" es: "+euclides(a,b));
				
			}else if(opcion==2) {
				a=ran.nextInt(100);
				b=ran.nextInt(100);
				System.out.println("El mcd entre "+a+" y "+b+" es: "+euclides(a,b));
			}else if(opcion==3) {
				System.out.println("----------Fin programa----------");
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		
	}

	private static int euclides(int a, int b) {	
		if(b==0) {
			return a;
		}else {
			int r=a%b;
			return euclides(b,r);
		}
	}
	
	

}
