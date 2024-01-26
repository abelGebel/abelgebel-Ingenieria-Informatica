/* Para convertir un número dado en base decimal a una base destino se debe dividir dicho número entre la
base destino, dejando el residuo y dividiendo el cociente sucesivamente entre la base destino hasta
obtener cociente 0, luego los restos de las divisiones leídos en orden inverso indican el número en la base
destino. Alternativamente, se puede dividir sucesivamente como en el caso anterior hasta que el dividendo
sea menor que el divisor, en cuyo caso el número en la base destino se obtendrá tomando el último
cociente calculado y luego los restos en orden inverso (ver figuras). Elaborar un programa que permita
convertir un número dado en base decimal a las bases binario u octal, a petición del usuario. Para ello, haga
uso de Stack. */

package ejercicio04;
import a.Helper;
import java.util.Random;
import java.util.Scanner;

public class Punto4 {

	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		Random random = new Random();
		int opcion;
		while (true) {
			opcion=menu(input);
			
			if (opcion==1) {
				ingresoManual(input);
			}else if(opcion==2) {
				ingresoAleatorio(random);
			}else {
				break;
			}
		}
		System.out.println("FIN PROGRAMA");
	}

	private static void ingresoManual(Scanner input) {
		int opcion,numero;
		numero=Helper.getIntegerPositivo(input,"Ingrese un numero en base decimal: ");
		while(true) {
			System.out.println("1) base octal");
			System.out.println("2) base binaria");
			System.out.println("3) salir");
			System.out.println();
			opcion=Helper.getInteger(input, "A que base destino quieres convertir el numero?: ");
			if (opcion==1) {
				System.out.println("Notacion octal: "+octal(numero));
			}else if (opcion==2){
				System.out.println("Notacion binario: "+binario(numero));
			}else if(opcion==3){
				break;
			}else {
				System.out.println("Ingrese una opcion valida...");
			}
		}
		
	}

	private static void ingresoAleatorio(Random random) {
		int numero = random.nextInt(99)+1;
		System.out.println("Numero generado en notacion decimal: "+numero);
		System.out.println("Notacion octal: "+octal(numero));
		System.out.println("Notacion binario: "+binario(numero));
	}



	public static int menu(Scanner input) {
		int opcion;
		System.out.println();
		System.out.println("1) De forma manual");
		System.out.println("2) De forma aleatoria");
		System.out.println("3) Salir");
		System.out.println();
		while(true) {
			opcion=Helper.getIntegerPositivo(input,"Como quiere ingresar el numero?: ", "OPCION NO VALIDA...");
			if(opcion>0 && opcion<4) {
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		System.out.println();
		return opcion;

	}





	public static String octal(int numero) {
		Pila pila=new Pila();
		String salida="";
		int resto;
		do {
			resto=numero%8;
			pila.push(resto);
			numero=numero/8;
			
			
		}while(numero>=8);
		
		pila.push(numero);

		
		while(!pila.estaVacia()) {
			salida+=pila.pop();		
		}
		
		return salida;
	}	
	
	public static String binario(int numero) {
		Pila pila=new Pila();
		String salida="";
		int resto;
		do {
			resto=numero%2;
			pila.push(resto);
			numero=numero/2;
			
				
		}while(numero>=2);
		pila.push(numero);
		while(!pila.estaVacia()) {
			salida+=pila.pop();		
		}
		
		return salida;
	}

}
