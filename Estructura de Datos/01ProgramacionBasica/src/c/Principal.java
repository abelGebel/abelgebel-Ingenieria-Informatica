package c;

import java.util.Scanner;
import a.Helper;

/*
Dado un número, indicar si el mismo pertenece al intervalo de valores [30, 255]. Si el número
pertenece al intervalo, solicitar otro número al usuario y calcular la suma de ambos valores. Si el
número no pertenece al intervalo pero es positivo, determinar la mitad del mismo. El ingreso de
números debe continuar hasta que se ingrese un cero.
*/
public class Principal {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Helper helper = new Helper();
		Scanner input = new Scanner(System.in);
		int num1;
		int num2;
		
		
		System.out.println();
		System.out.println("-----------Inicio del programa-----------");
		System.out.println("numero<0 --> no hacer nada");
		System.out.println("numero [30,255] --> solicitar otro número y calcular la suma");
		System.out.println("numero = 0 --> salir");
		System.out.println("otro --> determinar la mitad del numero");

		while (true) {
			System.out.println();

			num1 = helper.getInteger(input, "Ingrese un entero: ", "ERROR, DEBE INGRESAR UN ENTERO");
			
			if(num1>=30 && num1<=255) {
				num2 = helper.getInteger(input, "Ingrese otro entero: ", "ERROR, DEBE INGRESAR UN ENTERO");
				System.out.println("Suma de los numeros ingresados = "+(num1+num2));
				System.out.println();
				
			}else if(num1 >0 && (num1<30 || num1>255 )){
				System.out.println("Mitad del numero ingresado: " + (float)num1/2);
			
			}else if(num1==0) {
				break;
			}
		}
		

	}

}
