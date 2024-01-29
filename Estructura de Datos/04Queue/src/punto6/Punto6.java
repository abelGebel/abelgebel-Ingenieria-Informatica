package punto6;
import java.util.Random;
import java.util.Scanner;

public class Punto6 {

	public static void main(String[] args) {
		System.out.println("PROGRAMA PARA LA SELECCION DE DESARROLLADORES DE UNA NOMINA");
		System.out.println("-----------------------------------------------------------");
		System.out.println();
		Cola cola = new Cola();
		Scanner input =new Scanner(System.in);
		char respuesta;
		
		do {
			respuesta=Helper.getCharacter("Quiere ingregrsar los datos manualmente?(s/n): ");
			System.out.println();
			
			if (respuesta=='s'|| respuesta=='S') {
				ingresoManual(cola,input,respuesta);
			}else {
				ingresoRandom(cola,input);
			}
			respuesta=Helper.getCharacter(input,"Desea continuar? (s/n)");
			System.out.println();
			
		}while (respuesta=='s' || respuesta=='S');
		System.out.println("FIN PROGRAMA...");
	}

	

	public static void ingresoManual(Cola cola, Scanner input, char respuesta) {
		while((respuesta=='s' || respuesta=='S') && !cola.llena()) {
			Desarrollador desarrollador=new Desarrollador();
			
			System.out.println("Ingrese apellido:");
			desarrollador.setApellido(input.nextLine());
			System.out.println("Ingrese nombre:");
			desarrollador.setNombre(input.nextLine());
			
			desarrollador.setCuit(Helper.getCuit(input,"Ingrese cuit: "));
			
			desarrollador.setEspecialidad(especialidades(input));
			
			desarrollador.setRango(Helper.getRango(input,"Ingrese rango: "));
			
			cola.encolar(desarrollador);
			respuesta=Helper.getCharacter(input,"Desea continuar?(s/n): ");
			System.out.println();
		}
		seleccion(cola,input);
	}

	public static String especialidades(Scanner input) {
		
		input.nextLine();   //limpiar el Scanner
		String especialidad;
		System.out.println("1) administracion de sistemas");
		System.out.println("2) base de datos");
		System.out.println("3) infraestructura en la nube");
		System.out.println("4) ciencia de datos");
		System.out.println("5) back end");
		System.out.println("6) front end");
		System.out.println("7) interfaz de usuario");
		System.out.println("8) pruebas");
		System.out.println("9) otro");
		
		int opcion=Helper.getInteger(input,"Ingrese una opcion: ");
		switch(opcion) {
		  case 1:
		    return "administracion de sistemas";
		  case 2:
		    return "base de datos";
		  case 3:
		    return "infraestructura en la nube";
		  case 4:
		    return "ciencia de datos";
		  case 5:
			  return "back end";
		  case 6:
			  return "front end";
		  case 7:
			  return "interfaz de usuario";
		  case 8:
			  return "pruebas";
		  default:
			  System.out.println("Ingrese especialidad: ");
			  especialidad=input.nextLine();
			  return especialidad;
		}
	}

	
	
	public static void ingresoRandom(Cola cola, Scanner input) {
		Random random=new Random();
		
		while (!cola.llena()) {
			Desarrollador desarrollador=new Desarrollador();
			
			String arregloApellido[]= {"Perez","Lopez","Mamani","Flores","Diaz","Gomes","Sanchez",
					"Gonzalez","Martinez","Rodriguez"};
			desarrollador.setApellido(arregloApellido[random.nextInt(9)]);
			
			String arregloNombre[]= {"Manuel","Lucas","Pablo","Abel","Leonel","Pedro","Maria",
					"Gabriel","Laura","Norma","Valentina","Jeremias"};
			desarrollador.setNombre(arregloNombre[random.nextInt(11)]);
			
			desarrollador.setCuit(random.nextLong(10000000000L,99999999999L));
			
			String arregloEspecialidad []= {"administracion de sistemas","base de datos", 
					"infraestructura en la nube", "ciencia de datos", "back end", "front end"
					, "interfaz de usuario", "pruebas"};
			desarrollador.setEspecialidad(arregloEspecialidad[random.nextInt(7)]);
			desarrollador.setRango(random.nextInt(1,6));
			cola.encolar(desarrollador);
			
		}
		
		seleccion(cola,input);
	}


	public static void seleccion(Cola cola, Scanner input) {
		Cola colaAux= new Cola();
		Cola colaSeleccion=new Cola();
		
		System.out.println("Ingrese la especialidad deseada: ");
		String esp=input.nextLine();
		int ran=Helper.getRango(input,"Ingrese el rango: ");
		
		while(!cola.vacia()) {
			
			if(cola.peek().getEspecialidad().equalsIgnoreCase(esp) && cola.peek().getRango()==ran) {
				
				colaSeleccion.encolar(cola.quitar());
	
			}else {
				colaAux.encolar(cola.quitar());		
			}
		}
		
		while(!colaAux.vacia()) {
			cola.encolar(colaAux.quitar());
		}
		System.out.println("Desarrolladores que cumplen con el criterio:");
		System.out.println();
		desencolar(colaSeleccion);
		System.out.println("Desarrolladores disponibles:");
		System.out.println();
		desencolar(cola);
	}

	public static void desencolar(Cola a) {
		while(!a.vacia()) {
			System.out.println(a.quitar());
			System.out.println();
		}
	}
}