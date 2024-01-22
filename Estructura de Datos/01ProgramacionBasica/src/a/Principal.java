package a;
import java.util.Date;
import java.util.Scanner;

/*
Escribir un programa que solicite el nombre del usuario por la consola o teclado y muestre un saludo
donde aparezca la fecha y hora del sistema.
*/
public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String nombre;
		Date fechaHoraActual = new Date();
		
		System.out.println("Ingrese su nombre: ");
		nombre = input.next();
		System.out.println("Hola "+nombre+", la fecha y hora del sistema es: "+fechaHoraActual);
		input.close();
	}
}
