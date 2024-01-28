package punto3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import a.ColaCircular;
import a.Helper;
/*
Escribir una función, método o subprograma que reciba como parámetros dos colas y devuelva una cola
que resulte ser la unión de las otras dos, sin elementos repetidos. Para este caso el mecanismo de “unión
entre colas” es en el que sucesiva y alternadamente se toma un elemento de cada cola y se encola en una
nueva. El mecanismo de unión debe incluir las consideraciones necesarias para incorporar solo una vez
cada valor a la cola resultante de manera que no haya elementos repetidos. Considere que las colas pueden
ser de longitudes diferentes.
*/
public class Punto3 {

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
	
	public static ColaCircular unirColas(ColaCircular cola1, ColaCircular cola2,ColaCircular aux) {
		while(!cola1.vacia()) {
			aux.encolar(cola1.quitar());
		}
		while(!cola2.vacia()) {
			aux.encolar(cola2.quitar());
		}
		return aux;
	}


	private static void ingresoManual(Scanner input) {
		int longitud;
		longitud = Helper.getInteger(input,"Ingrese la longitud de la primer cola: ");
		ColaCircular cola1 = new ColaCircular(longitud);
		longitud = Helper.getInteger(input,"Ingrese la longitud de la segunda cola: ");
		ColaCircular cola2 = new ColaCircular(longitud);
		char caracter;
		
		System.out.println("Ingrese los caracteres para la primera cola: ");
		while(!cola1.llena()) {
			caracter=Helper.getAllCharacter(input, "");
			cola1.encolar(caracter);
		}
		
		System.out.println("Ingrese los caracteres para la segunda cola: ");
		while(!cola2.llena()) {
			caracter=Helper.getAllCharacter(input, "");
			cola2.encolar(caracter);
		}
		
		ColaCircular resultado; 

		resultado=union(cola1,cola2);
		
		System.out.println("Desencolando la cola union: ");
		
		while(!resultado.vacia()) {
			System.out.println(resultado.quitar());
		}
		
	}

	public static void ingresoAleatorio(Random ran) {
		int longitud;
		longitud = ran.nextInt(10)+1;
		ColaCircular cola1 = new ColaCircular(longitud);
		System.out.println("Longitud de la primer cola: "+longitud);
		longitud = ran.nextInt(10)+1;
		System.out.println("Longitud de la segunda cola: "+longitud);
		ColaCircular cola2 = new ColaCircular(longitud);
		
		char caracter;
		
		System.out.println("Caracteres ingresados a la primera cola: ");

		while(!cola1.llena()) {
			caracter=caracterAleatorio(ran);
			System.out.print(caracter+" ");
			cola1.encolar(caracter);
		}
		System.out.println();
		System.out.println("Caracteres ingresados a la segunda cola: ");

		while(!cola2.llena()) {
			caracter=caracterAleatorio(ran);
			System.out.print(caracter+" ");
			cola2.encolar(caracter);
		}
		System.out.println();
		ColaCircular resultado; 

		resultado=union(cola1,cola2);
		
		System.out.println("Desencolando la cola union: ");
		
		while(!resultado.vacia()) {
			System.out.println(resultado.quitar());
		}
	}
	
	public static char caracterAleatorio(Random ran) {
        char[] arregloDeCaracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        							 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'};
		return arregloDeCaracteres[ran.nextInt(20)];
	}

	public static ColaCircular union(ColaCircular cola1, ColaCircular cola2) {

		ColaCircular aux = new ColaCircular(cola1.capacidad()+cola2.capacidad());
		ArrayList<Character> registro = new ArrayList<Character>();
		char elemento;
		
		while(!cola1.vacia()||!cola2.vacia()) {
			
			while(!cola1.vacia()) {
				elemento=(char)cola1.peek();
				System.out.println("elemento a agregar: "+elemento);
				if(!esRepetido(elemento,registro)) {
					registro.add(elemento);
					aux.encolar(cola1.quitar());
					break;
				}else {
					cola1.quitar();
				}
			}
			
			while(!cola2.vacia()) {
				elemento=(char)cola2.peek();
				System.out.println("elemento a agregar: "+elemento);
				if(!esRepetido(elemento,registro)) {
					registro.add(elemento);
					aux.encolar(cola2.quitar());
					break;
				}else {
					cola2.quitar();
				}	
			}
		}
		return aux;
	}

	
	public static boolean esRepetido(char elemento, ArrayList<Character> registro) {
		
		for(int i=0; i<registro.size();i++) {
			if(registro.get(i)==elemento) {
				return true;
			}
		}
		return false;
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
