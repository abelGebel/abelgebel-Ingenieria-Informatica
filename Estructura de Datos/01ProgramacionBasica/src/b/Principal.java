package b;

import java.util.Random;

/*
Dada una cantidad de monedas de 25 y 50 centavos y de 1, 2, 5 y 10 pesos, calcule la cantidad de
dinero que se tiene en total.
*/
public class Principal {

	public static void main(String[] args) {
		
		Random ran = new Random();		
		int cantidad=0;
		float total=0;
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 25 centavos: "+cantidad);
		total += 0.25*cantidad;
		System.out.println("Total: "+total);
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 50 centavos: "+cantidad);
		total += 0.50*cantidad;
		System.out.println("Total: "+total);
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 1 peso: "+cantidad);
		total += cantidad;
		System.out.println("Total: "+total);
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 2 pesos: "+cantidad);
		total += 2*cantidad;
		System.out.println("Total: "+total);
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 5 pesos: "+cantidad);
		total += 5*cantidad;
		System.out.println("Total: "+total);
		
		cantidad = ran.nextInt(10); 
		System.out.println("Cantidad de monedas de 10 pesos: "+cantidad);
		total += 10*cantidad;
		System.out.println("Total: "+total);
		
		System.out.println();
		System.out.println("Total de dinero: "+total);
	}

}
