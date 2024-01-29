package punto2;

import java.util.Scanner;

public class Punto2 {

	public static void main(String[] args) {
		Stack pila=new Stack();
		Stack  pilaAux=new Stack();
		Scanner input=new Scanner(System.in);
		
		System.out.println("Ingrese una expresion matematica");
		char car;
		char carAux;
		String expresion=input.nextLine();
		
		for(int i=0; i<expresion.length();i++) {
			car=expresion.charAt(i);
			if (car=='(' || car==')' || car=='[' || car==']' || car=='{' || car=='}') {
				pila.push(car);
			}
		}
		
		while(pila.empty()) {
			
			
			
	
		}
		
		
		
		
		

			
		


	}

}
