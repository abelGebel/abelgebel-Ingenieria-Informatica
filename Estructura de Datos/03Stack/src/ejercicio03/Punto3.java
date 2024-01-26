package ejercicio03;
/*
Escribir un programa que permita transformar una expresión matemática escrita en notación interfija a
notación posfija. Normalmente las expresiones matemáticas se escriben de la forma “4+5”, que es conocida
como notación interfija dado que el operador “+” está en el medio (eso significa inter) de los dos operandos
“4” y “5”; la misma expresión se puede escribir como “45+” y en este caso se dice que está en notación
posfija porque el operador “+” está después (eso significa pos) de los dos operandos “4” y “5”. Para
simplificar el ejercicio se considera que los operandos son los dígitos 1 al 9 (un solo dígito por operando) y
los operadores corresponden a las cuatro operaciones básicas “+”, “-”, “*” y “/”.

El algoritmo de transformación utiliza una pila donde se almacenan los operadores y una cadena de texto
donde se va formando (concatenando) la expresión en notación posfija. En la página 288, capítulo 9 del libro
de Joyanes Aguilar “Estructuras de datos en Java”, se presenta un algoritmo de transformación que se puede
tomar como referencia para la resolución de este ejercicio.
*/
import java.util.Scanner;
import a.Helper;
import ejercicio01.Pila;

public class Punto3 {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		
		Character respuesta;
		do {
			
			
			System.out.println("Ingrese una operacion en notacion interfija:");
			String inFija=input.nextLine();
			posFija(inFija);
			System.out.println();
			respuesta=Helper.getCharacter(input, "Desea continuar? (s/n)");
			System.out.println();
		}while(respuesta=='s');
		System.out.println("FIN PROGRAMA...");
	}
	

	public static void posFija(String inFija) {
		System.out.println("Notacion postfija: ");
		Pila pila = new Pila(inFija.length());
		char caracter;
		char[] resultado=new char[inFija.length()];
		int cont=0;
		
		for (int i=0; i<inFija.length();i++) {
			caracter=(char)inFija.charAt(i);
			
			if (esOperando(caracter)) {
				resultado[cont]=caracter;
				cont++;
				
			}else if(caracter=='(') {
				pila.push(caracter);
				
			}else if(caracter==')') {
				while(pila.peek()!='(') {
					resultado[cont]=pila.pop();
					cont++;
				}
				pila.pop();		
				
			}else {
				
				if(pila.estaVacia()) {
					pila.push(caracter);
				}else if((caracter=='+'||caracter=='-')&&(pila.peek()=='*'||pila.peek()=='/'||pila.peek()=='^'||pila.peek()=='+'||pila.peek()=='-')) {
					resultado[cont]=pila.pop();
					pila.push(caracter);
					cont++;

				}else if((caracter=='*'||caracter=='/')&&(pila.peek()=='*'||pila.peek()=='/'||pila.peek()=='^')) {
					resultado[cont]=pila.pop();
					pila.push(caracter);
					cont++;
				}else {
					pila.push(caracter);
				}
				
			}

		}
		
		
		while(!pila.estaVacia()) {
			resultado[cont]=pila.pop();
			cont++;
		}
		
		for(int i=0;i<cont;i++) {
			System.out.print(resultado[i]);
		}
	}

	
	public static boolean esOperando(char caracter) {
		if((char)caracter!='+'&&(char)caracter!='-'&&(char)caracter!='*'&&(char)caracter!='/'&&(char)caracter!='^'&&(char)caracter!='('&&(char)caracter!=')'){
			return true;
		}else {
			return false;
		}
	}
}
