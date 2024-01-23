package ejercicio1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import a.Helper;
/*
Escribir un programa que permita cargar, por la consola o teclado, dos arreglos de enteros con la misma
dimensión, la cual será indicada por el usuario. En uno de los arreglos se deben ingresar solamente
números deficientes y en el otro arreglo se deben ingresar solamente números compuestos. El programa
debe calcular, en un tercer arreglo, la diferencia de los mismos. Además, se debe obtener la media del
arreglo diferencia; mostrar los valores del primer vector que resultan mayores a la media y mostrar los
valores del segundo vector que resultan menores a la media.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
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
	}

	private static void ingresoManual(Scanner input) {
		int aux,contDeficientes=0,contCompuestos=0;
		int n =Helper.getIntegerPositivo(input,"Ingrese la longitud de los arrglos: ");
		int numDeficientes[]=new int[n];
		int numCompuestos[]=new int[n];
		while(contDeficientes<n) {
			aux=Helper.getIntegerPositivo(input,"Ingrese un numero deficiente","Numero no valido");
			if(verificarDeficiente(aux)) {
				numDeficientes[contDeficientes]=aux;
				contDeficientes++;
			}else {
				System.out.println("Numero no valido");
			}
		}
		
		while(contCompuestos<n) {
			aux=Helper.getIntegerPositivo(input,"Ingrese un numero compuesto","Numero no valido");
			if(verificarCompuesto(aux)) {
				numCompuestos[contCompuestos]=aux;
				contCompuestos++;
			}else {
				System.out.println("Numero no valido");
			}
		}
		mostrarVectores(numDeficientes,numCompuestos);
		calcularDiferencias(numDeficientes,numCompuestos,n);
	}

	private static void ingresoAleatorio(Random ran) {
		int n = ran.nextInt(10)+5;
		System.out.println("Longitud de los vectories generados: " +n);
		System.out.println();
		int numDeficientes[]=new int[n];
		int numCompuestos[]=new int[n];
		int aux,contDeficientes=0,contCompuestos=0;
		
		while(contDeficientes<n || contCompuestos<n) {
			aux=ran.nextInt(99)+1;

			if(contDeficientes<n && verificarDeficiente(aux)) {
				numDeficientes[contDeficientes]=aux;
				contDeficientes++;
			}
			aux=ran.nextInt(99)+1;

			if(contCompuestos<n && verificarCompuesto(aux)) {
				numCompuestos[contCompuestos]=aux;
				contCompuestos++;
			}
		}
		mostrarVectores(numDeficientes,numCompuestos);
		calcularDiferencias(numDeficientes,numCompuestos,n);
	}
	
	public static void mostrarVectores(int[] numDeficientes, int[] numCompuestos) {
		System.out.println("Arreglo de numeros deficientes:");
		System.out.println(Arrays.toString(numDeficientes));
		System.out.println();
		System.out.println("Arreglo de numeros compestos:");
		System.out.println(Arrays.toString(numCompuestos));
		System.out.println();
	}
	
	private static void calcularDiferencias(int[] numDeficientes, int[] numCompuestos,int n) {
		int arregloDiferencia[]=new int[n];
		int acumulador=0;
		double media;
		for(int i=0;i<n;i++) {
			arregloDiferencia[i]=numDeficientes[i]-numCompuestos[i];
			acumulador+=arregloDiferencia[i];
		}
		System.out.println("Arreglo diferencia:");
		System.out.println(Arrays.toString(arregloDiferencia));
		media=acumulador/n;
		System.out.println();
		System.out.println("Media aritmetica del arreglo diferencia: "+media);
		System.out.println();
		System.out.println("Valores del arreglo de num deficientes mayores a la media: ");
		for(int i=0;i<n;i++) {
			if(numDeficientes[i]>media) {
				System.out.print(numDeficientes[i]+" ");
			}
		}
		System.out.println();
		System.out.println("Valores del arreglo de num compuestos menores a la media:");
		for(int i=0;i<n;i++) {
			if(numCompuestos[i]<media) {
				System.out.print(numCompuestos[i]+" ");
			}
		}
	}

	private static boolean verificarDeficiente(int n) {
		int acumulador=1;

		for(int i=2; i<=n/2;i++) {
			if(n%i==0) {
				acumulador+=i;
			}
		}
	
		if(acumulador<n) {
			return true;
		}else {
			return false;
		}
	}	
		
	private static boolean verificarCompuesto(int n) {
		int contador=0;
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				contador+=1;
			}
		}
		if(contador==0) {
			return false;
		}else {
			return true;

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
