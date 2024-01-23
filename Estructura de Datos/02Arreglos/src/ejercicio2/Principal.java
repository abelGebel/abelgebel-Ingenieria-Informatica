package ejercicio2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import a.Helper;

/*
Escribir un programa que permita ingresar el tamaño de un arreglo de números enteros y luego ingresar los
elementos del mismo, los cuales deben ser números primos. El programa debe mostrar el arreglo original y
a partir de él generar dos arreglos más: uno que contendrá los valores mayores a X (dado por el usuario) y
el otro que guardará los menores a Y (también dado por el usuario). Luego debe mostrar los arreglos
generados y revertir (dar vuelta) los valores de los mismos para mostrarlos nuevamente.
El ejercicio debe realizarse mediante la codificación de un método, función o subprograma que permita
mostrar cualquier tipo de arreglo.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
*/
public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int opcion=0;
		System.out.println("------------INICIO PROGRAMA------------");
		
		while(true) {
			opcion=menu(input,opcion);
			if(opcion==1) {
				ingresoManual(input);
			}else if(opcion==2) {
				ingresoAleatorio(ran);
			}else {
				break;
			}
			
		}
		
		System.out.println("------------FIN PROGRAMA------------");

	}
	
	private static void ingresoAleatorio(Random ran) {
		int n=ran.nextInt(10)+5;
		System.out.println("Longitud del arreglo: "+n);
		int primos[]=new int[n];
		int aux,contPrimos=0;
		while(contPrimos<n) {
			aux=ran.nextInt(99)+1;
			if(verificarPrimo(aux)) {
				 primos[contPrimos]=aux;
				 contPrimos++;
			}
		}
		
		System.out.println("Arreglo generado: ");
		System.out.println(Arrays.toString(primos));
		generarArreglos(primos,n);
	}
	
	private static void ingresoManual(Scanner input) {
		int n = Helper.getIntegerPositivo(input, "Ingrese la longitud del arreglo", "ERROR...");
		int primos[]=new int[n];
		int aux;
		for(int i=0;i<n;i++) {
			while(true) {
				aux=Helper.getIntegerPositivo(input, "Ingrese un numero primo positivo: ","ERROR...");
				if(verificarPrimo(aux)) {
					primos[i]=aux;
					break;
				}else {
					System.out.println("Debe ingresar un numero PRIMO positivo");
				}
			}
		}
		System.out.println("Arreglo ingresado: ");
		System.out.println(Arrays.toString(primos));
		generarArreglos(primos,n);
		
	}

	private static void generarArreglos(int[] primos, int n) {
		Scanner input = new Scanner(System.in);
		char opcion;
		int arregloMayores[]=new int[n];
		int arregloMenores[]=new int[n];
		System.out.println();
		System.out.println("El programa generara dos vectores del arreglo de numeoros primos");
		System.out.println("con valores mayores que un valor <x> y menores que un valor <y> respectivamente");
		System.out.println();
		
		
		while(true) {
			int x,y,contMayores=0,contMenores=0;
			x=Helper.getIntegerPositivo(input,"Ingrese un valor positivo x : ","ERROR...");
			y=Helper.getIntegerPositivo(input,"Ingrese un valor positivo y : ","ERROR...");
			System.out.println();
			for(int i=0;i<n;i++) {
				
				if(primos[i]>x) {
					arregloMayores[contMayores]=primos[i];
					contMayores++;
				}
				if(primos[i]<y) {
					arregloMenores[contMenores]=primos[i];
					contMenores++;
				}
			}
			
			visualizarArreglos(primos,arregloMayores,arregloMenores,input,contMayores,contMenores,x,y);
			
			opcion=Helper.getCharacter(input,"Desea continuar con los mismos vectores?(s/n)");
			if(opcion=='n') {
				break;
			}
			
		}
		
		
	}

	private static void visualizarArreglos(int[] primos, int[] arregloMayores, int[] arregloMenores, Scanner input, int contMayores, int contMenores, int x, int y) {
		int opcion;
		while(true) {
			System.out.println();
			System.out.println("Que vector desea visualizar?");
			System.out.println("1) Vector de primos");
			System.out.println("2) Vector de numeros mayores que el valor x ("+x+")");
			System.out.println("3) Vector de numeros menores que el valor y ("+y+")");
			System.out.println("4) Vector de numeros mayores que el valor x (invertido)");
			System.out.println("5) Vector de numeros menores que el valor y (invertido)");
			System.out.println("6) Salir de este menu");
			opcion=Helper.getIntegerPositivo(input, "Ingrese una opcion: ","ERROR...");
			System.out.println();
			if(opcion==6) {
				break;
			}
			switch (opcion) {
		    case 1:
				System.out.println(Arrays.toString(primos));
		        break;
		        
		    case 2:
	        	System.out.print("[ ");
		        for (int i=0;i<contMayores;i++) {
		            System.out.print(arregloMayores[i] + " ");
		        }
	        	System.out.print(" ]");
		        System.out.println();
		        break;
		        
		    case 3:
	        	System.out.print("[ ");
		        for (int i=0;i<contMenores;i++) {
		            System.out.print(arregloMenores[i] + " ");
		        }
	        	System.out.print(" ]");
		        System.out.println();
		        break;
		        
		    case 4:
	        	System.out.print("[");
		        for (int i = contMayores - 1; i >= 0; i--) {
		            System.out.print(arregloMayores[i] + " ");
		        }
	        	System.out.print("]");
		        System.out.println();
		        break;
		        
		    case 5:
	        	System.out.print("[ ");
		        for (int i = contMenores - 1; i >= 0; i--) {
		            System.out.print(arregloMenores[i] + " ");
		        }
	        	System.out.print(" ]");
		        System.out.println();
		        break;
		        
		    default:
		        System.out.println("ERROR...");
			}
		}
		
	}

	private static boolean verificarPrimo(int n) {
		int contador=0;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				contador+=1;
			}
		}
		if(contador==0) {
			return true;
		}else {
			return false;
		}
	}

	
	private static int menu(Scanner input, int opcion) {
		System.out.println();
		System.out.println("1) De forma manual");
		System.out.println("2) De forma aleatoria");
		System.out.println("3) Salir");
		System.out.println();
		while(true) {
			opcion=Helper.getIntegerPositivo(input,"Como quiere cargar los datos?: ", "OPCION NO VALIDA...");
			if(opcion>0 && opcion<4) {
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		System.out.println();
		return opcion;
	}

}
