package b;
import java.util.Scanner;

import a.ColaCircular;
import a.Helper;
/*
Escribir una función, método o subprograma que reciba como parámetros dos colas y devuelva una cola
que resulte ser la unión de las otras dos. Se debe definir el mecanismo de “unión entre colas”, puede
ser que la primera cola se encole detrás de la segunda, o que la segunda cola se encole después de la
primera.

*/
public class Principal {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);

		ColaCircular cola1 = new ColaCircular(30);
		ColaCircular cola2 = new ColaCircular(30);
		Integer numero;
		
		System.out.println("Ingrese valores enteros para la primera cola (99 para finalizar)");
		while(true) {
			numero=Helper.getInteger(input, "");
			if(numero==99) {
				break;
			}
			cola1.encolar(numero);
		}
		
		System.out.println("Ingrese valores enteros para la segunda cola (99 para finalizar)");
		while(true) {
			numero=Helper.getInteger(input, "");
			if(numero==99) {
				break;
			}
			cola2.encolar(numero);
		}
		ColaCircular union = new ColaCircular(30);
		ColaCircular aux = new ColaCircular(30);

		union=unirColas(cola1,cola2, aux);
		
		System.out.println("Union de las colas: ");
		
		while(!union.vacia()) {
			System.out.print(union.quitar()+" ");
		}
		
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

}
