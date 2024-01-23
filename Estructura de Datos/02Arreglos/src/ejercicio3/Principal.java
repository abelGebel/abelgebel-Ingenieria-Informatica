package ejercicio3;

import java.util.Random;
import java.util.Scanner;

import a.Helper;

/*
Escribir un programa que permita ingresar números a una matriz M x N, mostrar la matriz en la consola y
obtener su matriz transpuesta. Además, calcular el producto de los elementos de una fila o la suma de una
columna, efectuando los cálculos sobre la matriz o su transpuesta, todo a petición del usuario. Los valores
M y N son indicados por el usuario. Agregar los controles necesarios.
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
				//ingresoManual(input);
			}else if(opcion==2) {
				ingresoAleatorio(ran, input);
			}else {
				break;
			}
			
		}
		System.out.println("------------FIN PROGRAMA------------");

	}

	private static void ingresoAleatorio(Random ran,Scanner input) {
		int N = ran.nextInt(3)+2;
		int M = ran.nextInt(3)+2;
		System.out.println("Cantidad de filas: "+M);
		System.out.println("Cantidad de columnas: "+N);
		int matriz[][]=new int[M][N];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				matriz[i][j]=ran.nextInt(10);
			}
		}
		System.out.println("Matriz generada:");
		mostrarMatriz(matriz,M,N);
		System.out.println();
		int matrizTranspuesta[][]=generarTranspuesta(matriz,M,N,ran);
		System.out.println("Matriz transpuesta:");
		mostrarMatriz(matrizTranspuesta,N,M);
		realizarCalculos(input,matriz,matrizTranspuesta,M,N);

	}

	private static void realizarCalculos(Scanner input, int[][] matriz, int[][] matrizTranspuesta, int m, int n) {
		int opcion;
		while(true) {
			System.out.println("Que desea hacer?");
			System.out.println("1) Mostrar matriz");
			System.out.println("2) Mostrar transpuesta");
			System.out.println("3) Calcular el producto de una fila");
			System.out.println("4) Calcular la suma de una columna");
			System.out.println("5) Salir");
			opcion=Helper.getIntegerPositivo(input,"Ingrese una opcion: ","ERROR...");
			System.out.println();
			
			if(opcion==1) {
				mostrarMatriz(matriz,m,n);
			}else if(opcion==2) {
				mostrarMatriz(matrizTranspuesta,n,m);
			}else if(opcion==3) {
				System.out.println("Sobre que matriz desea realizar los calculos?");
				System.out.println("1) Matriz ");
				System.out.println("2) Transpuesta");
				opcion=Helper.getIntegerPositivo(input,"Ingrese una opcion: ","ERROR...");
				
				if(opcion==1) {
					multiplicarElementos(matriz,m,n,input);
				}else if(opcion==2) {
					multiplicarElementos(matrizTranspuesta,n,m,input);
				}else {
					System.out.println("ERROR...");
				}
				
			}else if(opcion==4) {
				System.out.println("Sobre que matriz desea realizar los calculos?");
				System.out.println("1) Matriz ");
				System.out.println("2) Transpuesta");
				opcion=Helper.getIntegerPositivo(input,"Ingrese una opcion: ","ERROR...");
				if(opcion==1) {
					sumarElementos(matriz,m,n, input);
				}else if(opcion==2) {
					sumarElementos(matrizTranspuesta,n,m,input);
				}else {
					System.out.println("ERROR...");
				}
				
			}else if(opcion==5){
				break;
			}else {
				System.out.println("ERROR...");
			}
			
			
		}
		
	}

	private static void sumarElementos(int[][] matriz, int m, int n, Scanner input) {
		char continuar='s';
		
		while(continuar=='s' || continuar=='S') {
			int columna=Helper.getIntegerPositivo(input,"Que columna desea sumar?: ","ERROR...");
			int suma=1;
			if(columna<=n && columna>0) {
				
				for(int i=0;i<m;i++) {
					suma+=matriz[i][columna-1];
				}
				System.out.println("La suma de la columna "+columna+" es: "+suma);
			}else {
				System.out.println("NUMERO FUERA DE RANGO (cantidad de columnas: "+n+")");
			}
			
			System.out.println("");
			continuar=Helper.getCharacter(input,"Desea continuar?(s/n): ");
		}
		
	}

	private static void multiplicarElementos(int[][] matriz, int m, int n, Scanner input) {

		char continuar='s';
		while(continuar=='s' || continuar=='S') {
			int fila=Helper.getIntegerPositivo(input,"Que fila desea multiplicar?: ","ERROR...");
			int producto=1;
			if(fila<=m && fila>0) {
				
				for(int i=0;i<n;i++) {
					producto*=matriz[fila-1][i];
				}
				System.out.println("El producto de la fila "+fila+" es: "+producto);
			}else {
				System.out.println("NUMERO FUERA DE RANGO (cantidad de filas: "+m+")");
			}
			
			System.out.println("");
			continuar=Helper.getCharacter(input,"Desea continuar?(s/n): ");
		}

	}

	private static int[][] generarTranspuesta(int[][] matriz, int m, int n, Random ran) {
		
		int transpuesta[][]=new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				transpuesta[i][j]=matriz[j][i];
			}
		}
		return transpuesta;
	}
	
	private static void mostrarMatriz(int[][] matriz, int m, int n ) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
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
