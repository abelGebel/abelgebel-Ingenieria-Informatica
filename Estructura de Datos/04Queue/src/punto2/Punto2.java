package punto2;
/*
Escribir una función, método o subprograma que reciba como parámetros una cola y un número; debe
devolver una cola en la que se suprimen todas las apariciones del número, de sus múltiplos y de sus
divisores. Para la resolución del ejercicio debe utilizar colas circulares que prioricen la velocidad.
*/
import java.util.Random;
import java.util.Scanner;
import a.Helper;
import a.ColaCircular;
public class Punto2 {

	public static void main(String[] args) {
		System.out.println("METODO PARA QUITAR UN NUMERO, SUS MULTIPLOS Y DIVISORES DE UNA COLA");
		System.out.println("----------------------------------------------------------------------");
		Scanner input=new Scanner (System.in);
		ColaCircular cola = new ColaCircular();
		int numero = 1;
		char respuesta;
		
		do {
			respuesta=Helper.getCharacter(input,"Quiere ingresar los datos manualmente?(s/n): ");
			System.out.println();
			if (respuesta=='s') {
				ingresoManual(cola,numero,input);
			}
			else {
				ingresoRandom(cola,numero,input);
			}
			respuesta=Helper.getCharacter(input,"Desea continuar?(s/n): ");
			System.out.println();
		}while(respuesta=='s');
		System.out.println("FIN PROGRAMA...");
	}
	
	
	public static void ingresoManual(ColaCircular cola, int numero, Scanner input) {
		System.out.println("INGRESO DE NUMEROS A LA COLA");
		System.out.println("----------------------------");
		
		while(!cola.llena() && numero!=0) {
			numero=Helper.getInteger(input,"Ingrese un numero (ingrese un 0 para finalizar): ");
			cola.encolar(numero);
		}
		numero=Helper.getInteger(input,"Que numero desea quitar de la cola, sus multiplos y sus divisores?: ");
		ColaCircular colaResultado=new ColaCircular();
		colaResultado = suprimirNumero(numero,cola);
		System.out.println("Desencolando...");
		while(!colaResultado.vacia()) {
			System.out.println(colaResultado.quitar());
		}	
	}


	public static void ingresoRandom(ColaCircular cola, int numero, Scanner input) {
		
		Random random=new Random();
		
		while(!cola.llena()) {
			numero=random.nextInt(1,30);
			cola.encolar(numero);
			System.out.println(numero);
			
		}			
		numero=random.nextInt(1,30);
		System.out.println("Numero a suprimir: "+numero);
		
		ColaCircular colaResultado=new ColaCircular();
		colaResultado = suprimirNumero(numero,cola);		
		System.out.println("Desencolando...");
		while(!colaResultado.vacia()) {
			System.out.println(colaResultado.quitar());
		}	
	}

	public static ColaCircular suprimirNumero(int numero, ColaCircular cola) {
		
		ColaCircular colaAux =new ColaCircular();
		int variableAux;
		while(!cola.vacia()) {
			if ((int)cola.peek()%numero==0 || numero%(int)cola.peek()==0) {
				variableAux=(int) cola.quitar();
			}else {
				colaAux.encolar(cola.quitar());
			}
		}
		return colaAux;
	
	}

}