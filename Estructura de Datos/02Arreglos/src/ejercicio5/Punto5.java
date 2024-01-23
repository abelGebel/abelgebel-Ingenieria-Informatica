package ejercicio5;

/*Escribir un programa que permita ingresar y almacenar la información de muchos libros de acuerdo a la
implementación del caso ejemplo c); luego el usuario podrá indicar un autor o una editorial y el programa
deberá mostrar los libros cuyo autor o editorial correspondan a los indicados. Además, se deberá informar 
la cantidad de libros guardados que tienen un precio menor a un valor X dado. */

import a.Helper;
import c.Libro;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Punto5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Random random = new Random();
		int opcion=0;
		ArrayList<Libro> registroLibros = new ArrayList<>();

		while (true) {
			menu();
			opcion = Helper.getInteger(input,"Ingrese una opcion: ");
			if (opcion==1) {
				registroLibros=ingreso1(registroLibros,input);
			}else if (opcion==2) {
				registroLibros=ingreso2(registroLibros,input,random);
			}else if(opcion==3) {
				buscarLibro(registroLibros,input);
			}else if (opcion==4) {
				precioMenor(registroLibros,input);
			}else if (opcion==5) {
				break;
			}else {
				System.out.println("Ingreso no valido");
			}
		}
		System.out.println();
		System.out.println("------------FIN PROGRAMA------------");
	}

	


	public static ArrayList<Libro> ingreso1(ArrayList<Libro> registroLibros, Scanner input) {
		char continuar;
		do {
			System.out.println();
			Libro libro=new Libro();
			
			System.out.print("Titulo:");
			libro.setTitulo(verificarEscapcioVacio(input));

			System.out.print("Autor:");
			libro.setAutor(verificarEscapcioVacio(input));
			
			System.out.print("Editorial:");
			libro.setEditorial(verificarEscapcioVacio(input));
			
			libro.setAnioDePublicacion(Helper.getIntegerPositivo(input,"Anio de publicacion: "));
			
			libro.setPrecio(Helper.getFloat(input,"Ingrese precio: "));
			input.nextLine(); // Consumir el carácter de nueva línea restante

			registroLibros.add(libro);
			System.out.println("'Libro agregado correctamente'");
			continuar=Helper.getCharacter(input,"Desea continuar?(s/n)");
			
			
		}while(continuar=='s');
		
		for (Libro i: registroLibros) {
			System.out.println(i);
		}	
		return registroLibros;
	}
    
	
	public static ArrayList<Libro> ingreso2(ArrayList<Libro> registroLibros, Scanner input, Random random) {
		EjemploLibros ejemploLibros = new EjemploLibros();
		char continuar;

		do {
			Libro libro=new Libro();
			
			libro.setTitulo(ejemploLibros.cargarTitulos(random));

			libro.setAutor(ejemploLibros.cargarAutores(random));
			
			libro.setEditorial(ejemploLibros.cargarEditoriales(random));
			
			libro.setAnioDePublicacion(ejemploLibros.cargarAnio(random));
			
			libro.setPrecio(random.nextFloat()*10000);
			
			registroLibros.add(libro);
			System.out.println("'Libro agregado correctamente'");
			continuar=Helper.getCharacter(input,"Desea continuar?(s/n)");
			System.out.println();
			
		}while(continuar=='s');
		
		for (Libro i: registroLibros) {
			System.out.println(i);
		}
		return registroLibros;
	}
	
	
	

	public static void buscarLibro(ArrayList<Libro> registroLibros, Scanner input) {

		String busqueda;
		System.out.println("Que autor/editorial desea buscar?");
		busqueda= input.nextLine();
		boolean band=false;
		for(int i=0; i<registroLibros.size(); i++){
			if (registroLibros.get(i).getAutor().equalsIgnoreCase(busqueda)) {
				System.out.println(registroLibros.get(i));
				band=true;
			}
			if (registroLibros.get(i).getEditorial().equalsIgnoreCase(busqueda)) {
				System.out.println(registroLibros.get(i));
				band=true;
			}
		}
		if (band==false) {
			System.out.println("AUTOR O EDITORIAL NO ENCONTRADOS...");
		}
	}
	
	
	public static void precioMenor(ArrayList<Libro> registroLibros, Scanner input) {

		int cont=0;
		double x = Helper.getFloat(input,"Ingrese un precio:");
		
		for(int i=0; i<registroLibros.size(); i++){
			if (registroLibros.get(i).getPrecio()<x) {
				cont+=1;
			}
		}
		System.out.println("Cantidad de libros con precio menor a "+x+": "+cont);
		input.nextLine(); // Consumir el carácter de nueva línea restante

	}


	public static String verificarEscapcioVacio(Scanner input) {
		String entrada;
		while(true) {
			entrada=input.nextLine();
			if (entrada.equals("")) {
				System.out.println("INGRESO NO VALIDO...");
			}else {
				break;
			}
		}
		return entrada;
	}
	
	
	
    public static void menu() {
		System.out.println();
		System.out.println("MENU");
		System.out.println("--------------------------------------");
		System.out.println("1) Registrar libro por teclado.");
		System.out.println("2) Registrar libro de forma aleatoria.");
		System.out.println("3) Buscar libro por autor o editorial.");
		System.out.println("4) Mostrar cantidad de libros con un precio menor a un valor x.");
		System.out.println("5) Salir.");
	}	
}
