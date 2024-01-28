package a;

import java.util.Scanner;

/*
Encolar números en una cola hasta que se ingrese el número 99; luego desencolarlos y hacer lo
siguiente: calcular el factorial de los números positivos, sumar los negativos y contar los ceros.
*/
public class Principal {
	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		ColaCircular cola = new ColaCircular(5);
		
		Integer numero;
		
		while(true) {
			
			numero= Helper.getInteger(input,"Ingrese un numero para encolar ( 99 para finalizar): ");
			
			if(numero==99) {
				break;
			}else {
				cola.encolar(numero);
			}
		}
		Integer contCeros=0;
		Integer sumaNeg=0;
		while(!cola.vacia()) {
			
			numero=(Integer) cola.quitar();
			if(numero>0) {
				System.out.println("Factorial de "+numero+": "+calcularFactorial(numero));
				calcularFactorial(numero);
			}else if (numero<0) {
				sumaNeg=sumaNeg+numero;
			}else {
				contCeros++;
			}
		}
		
		System.out.println("Suma de los numeros negativos:" + sumaNeg);
		System.out.println("Cantidad de ceros: "+contCeros);
	}

	public static int calcularFactorial(Integer numero) {
		
		if(numero==0||numero==1) {
			return 1;
		}else {
			return numero*calcularFactorial(numero-1);
		}
	}
}
