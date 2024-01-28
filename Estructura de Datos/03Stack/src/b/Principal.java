package b;

import java.util.Scanner;
import ejercicio01.Pila;
/*
Escribir un programa que permita verificar la parentización simple de una expresión matemática; es
sabido que los paréntesis “(” y “)” se utilizan para fijar la prioridad de las operaciones matemáticas, de
ese modo una expresión como ser: 4 * (5 – 2) se dice que está correctamente parentizada porque se
encuentra un paréntesis de apertura y uno de cierre.
El programa que se solicita debe permitir ingresar una cadena de texto que supuestamente contiene
una expresión matemática con paréntesis, la cual deberá verificarse.
Una forma de resolver el ejercicio es utilizar un contador que se incrementa cuando se encuentra la
apertura de un paréntesis y se decrementa cuando se encuentra el cierre de un paréntesis; otra forma
de resolver el mismo ejercicio es utilizar un objeto del tipo Stack, obviamente esta es la forma
solicitada.

*/
public class Principal {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("Ingrese una expresion matematica: ");
		String expresion=input.nextLine();
		
		Pila pila=new Pila(expresion.length());
		
		for(int i=0;i<expresion.length();i++) {
			
			
			
			
		}
		

	}

}
