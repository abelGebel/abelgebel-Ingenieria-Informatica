package punto1;
/*
Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo de caracteres
como contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de
una cola que prioriza velocidad. Comprobar la implementación propuesta creando una instancia de la cola y
utilizando las operaciones de la misma a pedido del operador. Para ello, puede usar un menú de opciones. 
*/
import java.util.Random;
import java.util.Scanner;
import a.ColaCircular;
import a.Helper;
public class Punto1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ColaCircular cola = new ColaCircular(20);
		Random random = new Random();
		int opcion;

		
		while (true) {
			opcion=menu(input);
			if (opcion==5) {
				break;
			}else if(opcion==1) {
				encolar(random,input,cola);
			}else if(opcion==2) {
				desencolar(cola);
			}else if (opcion==3) {
				System.out.println("Proximo a salir: " + cola.peek());
			}else {
				System.out.println("Cantidad de elementos: "+cola.cantidadElmentos());
			}
		}
		System.out.println("Fin programa...");
	}

	public static void desencolar(ColaCircular cola) {
		System.out.println("------Desencolando------");
		while(!cola.vacia()) {
			System.out.print(cola.quitar()+" ");
		}
		System.out.println();
	}

	public static void encolar(Random random,Scanner input, ColaCircular cola) {
		char respuesta;
		char caracter;
		
		System.out.println();
		respuesta=Helper.getCharacter(input, "Quiere ingresar los caracteres manualmente?(s/n): ");
		if(respuesta=='s') {
			
			while(!cola.llena() && respuesta=='s') {
				caracter=Helper.getAllCharacter(input, "Ingrese caracter: ");
				cola.encolar(caracter);
				respuesta=Helper.getCharacter(input, "Desea continuar?(s/n): ");
			}
		}else {
			char arreglo[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};
			while(!cola.llena()) {
				cola.encolar(arreglo[random.nextInt(14)]);
			}		
		}		
	}
	
	 public static Integer menu(Scanner input) {
	     Integer integerValue = 0;
	     while (true) {
	    	System.out.println();
	        System.out.println("----------MENU----------");
	        System.out.println("1) Encolar");
	        System.out.println("2) Desencolar");
	        System.out.println("3) Proximo a salir");
	        System.out.println("4) Ver Cantidad de elementos");
	        System.out.println("5) Salir");
	        System.out.println();
	        integerValue = Helper.getInteger(input,"Ingrese una opcion: ","OPCION NO VALIDA...");
	        if (integerValue>=1 && integerValue<=5) {
	            return integerValue;
	        }else {
	        	System.out.println("OPCION NO VALIDA...");
	        }   
	     }
	 }
}
