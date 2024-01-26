/* Ingrese una frase e imprima un mensaje indicando si la misma es palíndromo o no. Para ello, debe hacer
uso de Stack. Una frase es palíndromo cuando se lee igual hacia adelante que hacia atrás (no se tienen en
cuenta los espacios en blanco). Ejemplo “oso”, “somos”, “reconocer”, “anita lava la tina”. */


package ejercicio02;
import a.Helper;
import ejercicio01.Pila;

import java.util.Random;
import java.util.Scanner;

public class Punto2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------");
		System.out.println("PROGRAMA PARA VERIFICAR SI UNA FRASE ES PALINDROMO");
		System.out.println("--------------------------------------------------");
		int opcion=0;

		while(true) {
			opcion=menu(input,opcion);
			if (opcion==1) {
				ingreso1(input);
			}else if (opcion==2) {
				ingreso2();
			}else if (opcion==3){
				break;
			}
		}
		System.out.println("FIN PROGRAMA...");
	}

	
	public static void ingreso1(Scanner input) {
		
		String fraseAux="";
		String frase="";
		String result;
		frase=verificarEntrada(input);
		result = frase.replaceAll("\\s+","").toLowerCase();
		fraseAux=cargarPila(result,fraseAux);
		esPalindromo(frase,result,fraseAux);
	}

	public static void ingreso2() {
		
		Random random=new Random();
		String fraseAux="";
		String frase="";
		
		String arregloFraces[]= {"oso","Ana lava lana","Luz azul","Ojo rojo",
				"Yo soy","ala","Neuquen","sos","alla","ojo","rayar","rapar",
				"celular","pais","puerta","luz roja","coma","auto","libro","lugar"};
		
		frase=arregloFraces[random.nextInt(19)];
		String result=frase.replaceAll("\\s+","").toLowerCase();
		
		fraseAux=cargarPila(result,fraseAux);
		esPalindromo(frase,result,fraseAux);
	}
	
	
	public static String cargarPila(String result, String fraseAux) {
		Pila pila=new Pila(result.length());
		int cont=0;
		while(!pila.estaLlena()) {
			pila.push(result.charAt(cont));
			cont++;
		}
		
		while (!pila.estaVacia()) {
			fraseAux+=pila.pop();
		}
		return fraseAux;
	}


	public static void esPalindromo(String frase,String result, String fraseAux) {
		if (result.equals(fraseAux)) {
			System.out.println("La palabra/frase ["+frase+"] ES palindromo.");
		}else {
			System.out.println("La palabra/frase ["+frase+"] NO es palindromo.");
		}
		System.out.println();
	}
	
	
	public static String verificarEntrada(Scanner input) {
		String valor;
		while(true) {
			boolean band=true;
			System.out.println("Ingrese una palabra/frase");
			valor=input.nextLine();

			for (int i=0; i<valor.length();i++) {
				
				if (Character.isDigit(valor.charAt(i))) {
	                System.out.println("LA ENTRADA NO PUEDE INCLUIR NUMEROS...");
	                System.out.println();
	                band=false;
	                break;
	            }
			}
			if (band==true) {
				break;
			}
		}
		return valor;
	}
	
	private static int menu(Scanner input, int opcion) {
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