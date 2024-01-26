/* Incorporar un método a la implementación de clase Stack (versiones básica o genérica propuestas en
teoría) que reciba como parámetros dos valores (actual y nuevo) y realice la operación de reemplazo del
valor actual por el nuevo sobre el objeto Stack que está ejecutando el mensaje o método. El método
deberá tener un valor de retorno que indicará la cantidad de reemplazos realizados, cuando no los haya se
debe retornar cero. Comprobar la funcionalidad incorporada creando una pila de caracteres y
reemplazando diferentes caracteres a pedido del operador. Para cada caso indicar cuantos reemplazos se
realizaron. */
package ejercicio01;
import a.Helper;
import java.util.Random;
import java.util.Scanner;

public class Punto1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int opcion;
		Random random=new Random();
		
		while(true) {
			menu();
			opcion=Helper.getInteger(input,"Ingrese una opcion: ");

			if(opcion==1) {
				ingreso1(input);
			}else if (opcion==2) {
				ingreso2(random);
			}else if (opcion==3)
				break;
			else {
				System.out.println("Ingreso no valido.");
			}
			System.out.println();

		}
		System.out.println("FIN PROGRAMA...");
	}

	public static void ingreso1(Scanner input) {
		char arreglo[]= {'a','a','b','a','c','a','x','z','p','p'};
		char actual;
		char nuevo;
		Pila pila=new Pila();
		
		
		for (int i=0;i<arreglo.length;i++) {
			pila.push(arreglo[i]);
			System.out.print((char)pila.peek()+" ");
		}

		System.out.println();
		
		
		actual=Helper.getAllCharacter(input, "Que caracter desea remplazar?");
		nuevo=Helper.getAllCharacter(input, "Que valor deseas colocar en su lugar?");
		
		System.out.println("La cantidad de remplazos realizados es: "+pila.remplazarElemento(actual,nuevo));
		
		while(!pila.estaVacia()) {
			System.out.print((char)pila.pop()+" ");
		}
		System.out.println();

	}
	
	public static void ingreso2(Random random) {
		char arreglo[]= {'a','a','b','a','c','a','x','z','p','p'};
		char actual;
		char nuevo;
		Pila pila=new Pila();
		
		for (int i=0;i<arreglo.length;i++) {
			pila.push(arreglo[i]);
			System.out.print((char)pila.peek()+" ");
		}
		
		System.out.println();
		
		char arregloAleatorio[]= {'a','b','c','d','e','f','g','h','i','j','k','n','m','o'};
		actual=arregloAleatorio[random.nextInt(14)];
		System.out.println("Caracter a remplazar: "+actual);
		nuevo=arregloAleatorio[random.nextInt(14)];
		System.out.println("Caracter a colocar en su lugar: "+nuevo);		
		
		System.out.println("La cantidad de remplazos realizados es: "+pila.remplazarElemento(actual,nuevo));
		
		while(!pila.estaVacia()) {
			System.out.print((char)pila.pop()+" ");
		}
		System.out.println();
	}
	
	public static void menu() {
		System.out.println("Como quieres ingresar los datos? ");
		System.out.println("1) Por teclado.");
		System.out.println("2) De forma aleatoria");
		System.out.println("3) Salir");
	}
}