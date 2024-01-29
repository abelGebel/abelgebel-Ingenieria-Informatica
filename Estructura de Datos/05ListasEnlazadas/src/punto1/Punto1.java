package punto1;

import java.util.Random;
import java.util.Scanner;

public class Punto1 {

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------");
		System.out.println("IMPLEMENTACION DE LA CLASE QUEUE UTILIZANDO LISTAS");
		System.out.println("--------------------------------------------------");
		
		//creacion de objetos
		Scanner input=new Scanner(System.in);
		Random random=new Random();
		Helper helper=new Helper();

		Integer opcion=0;
		Integer num=0;

		//region menu
		while(true) {
			Queue<Integer> cola=new Queue();
			
			opcion=menu(input,opcion,helper);
			if (opcion==1) {
				ingresoManual(input,helper,cola,num);
			}else if (opcion==2) {
				ingresoRandom(cola,random,num);
			}else  if (opcion==3) {
				break;
			}else {
				System.out.println("Ingrese una opcion valida...");
			}
		}
		System.out.println("FIN PROGRAMA...");
	}
	
	
	public static Integer menu(Scanner input, Integer opcion, Helper helper) {
		System.out.println();
		System.out.println("1) Ingresa datos manualmente");
		System.out.println("2) Ingresa datos generados aleatoriamente");
		System.out.println("3) Salir");
		opcion=helper.getInteger(input,"Ingrese una opcion: ");
		System.out.println();
		return opcion;
	}
	
	//region de ingreso de datos
	public static void ingresoManual(Scanner input, Helper helper, Queue<Integer> cola, Integer num) {
		
		while(true) {
			num=helper.getInteger(input,"Ingrese un numero (99 para finalizar): ");
			if(num==99) {
				break;
			}
			cola.add(num);		
		}
		System.out.println();
		desencolar(cola);
	}
	

	public static void ingresoRandom(Queue<Integer> cola, Random random, Integer num) {
		
		Integer cantidad=random.nextInt(4,11);
		System.out.println("Cantidad de numeros generados: " + cantidad);
		
		for (int i=0;i<cantidad;i++) {
			num=random.nextInt(-10,10);
			cola.add(num);
		}
		System.out.println(cola.toString());
		System.out.println();
		desencolar(cola);
		
	}
	
	public static void desencolar(Queue<Integer> cola) {
		int num;
		int cont=0;
		int suma=0;
		
		while(!cola.isEmpty()) {
			
			num=cola.remove();
			if (num>0) {
				System.out.println("El factorial del numero " + num + " es: " + factorial(num));
			}else if(num<0) {
				suma+=num;
			}else {
				cont+=1;
			}
		}
		System.out.println("Suma de los numeros negativos: " + suma);
		System.out.println("Cantidad de ceros: " + cont);
	}
	
	public static double factorial(Integer numero) {
	      double fact =  1;
	      for( int i = 1; i <= numero; i++ ) {
	         fact *= i;
	      }
	      return fact;
	}
}