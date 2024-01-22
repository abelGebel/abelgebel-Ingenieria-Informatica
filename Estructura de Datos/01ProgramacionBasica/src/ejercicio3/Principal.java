package ejercicio3;
import a.Helper;
import java.util.Random;
import java.util.Scanner;

/*
Dado un número entero positivo, determinar si el mismo es perfecto, abundante o deficiente. Incluir la
validación pertinente para el ingreso del número.

Número perfecto: es todo número natural que es igual a la suma de sus divisores propios (es decir, todos
sus divisores excepto el propio número). Por ejemplo, 6 es un número perfecto ya que sus divisores
propios son 1, 2, y 3 y se cumple 1+2+3=6.
Número abundante: es todo número natural que cumple con que la suma de sus divisores propios es
mayor que el propio número. Por ejemplo, 12 es abundante ya que sus divisores son 1, 2, 3, 4 y 6 y la suma
de ellos (1+2+3+4+6=16) es mayor que 12.
Número deficiente: es todo número natural que cumple con que la suma de sus divisores propios es menor
que el propio número. Por ejemplo, 16 es un número deficiente ya que sus divisores propios son 1, 2, 4 y 8
y la suma de ellos (1+2+4+8=15) es menor que 16.

Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
También necesita del objeto random para generar valores de manera aleatoria.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
*/
public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("----------Inicio programa----------");
		menu(input);
		System.out.println("----------Fin programa----------");
	}

	private static void clasificarNumero(int n) {
		int acumulador=1;
		if(n==0 || n==1) {
			System.out.println("EL NUMERO 1 Y 0 NO ENTRAN EN NINGUNA CLASIFICACION...");
		}else{
			for(int i=2; i<=n/2;i++) {
				if(n%i==0) {
					acumulador+=i;
				}
			}
			
			if(acumulador<n) {
				System.out.println("El numero "+n+" es deficiente");
			}else if(acumulador==n){
				System.out.println("El numero "+n+" es perfecto");
			}else {
				System.out.println("El numero "+n+" es abundante");
			}
		}
		
	}
	
	private static void menu(Scanner input) {
		int opcion,numero;
		Random ran = new Random();
		while(true) {
			System.out.println();
			System.out.println("Como quiere que se ingresen los datos?");
			System.out.println("1) De forma manual");
			System.out.println("2) De forma aleatoria");
			System.out.println("3) Salir");
			System.out.println();
			opcion = Helper.getInteger(input, "Ingrese una opcion: ", "INGRESE UNA OPCION VALIDA");
			System.out.println();
			
			if(opcion==1) {
				numero = Helper.getIntegerPositivo(input,"Ingrese un entero positivo: ","INGRESE UN ENTERO POSITIVO VALIDO");
				clasificarNumero(numero);
			}else if(opcion==2) {
				numero=ran.nextInt(99)+1;
				clasificarNumero(numero);
			}else if(opcion==3) {
				break;
			}else {
				System.out.println("INGRESE UNA OPCION VALIDA");
			}
			
		}
		
	}


}
