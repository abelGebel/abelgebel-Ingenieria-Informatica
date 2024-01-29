package punto5;
import java.util.Iterator;
import java.util.Scanner;

public class Punto5 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		SimpleLinkedList lista=new SimpleLinkedList();
		
		while(true) {
			
			int opcion=menu(input);
			if(opcion==1) {
				lista=agregar(input,lista);
			}else if(opcion==2) {
				buscar(lista,input);
			}else if(opcion==3) {
				mostrarTipo(lista,input);
			}else {
				break;
			}
		}
		
	

	}

	public static void mostrarTipo(SimpleLinkedList lista, Scanner input) {
		
		SimpleLinkedList listaAux=new SimpleLinkedList();
		
		System.out.println("Mostrar usuarios con cuenta: ");
		System.out.println("p: premium");
		System.out.println("g: gratuita");
		
		char opcion=input.next().charAt(0);
		Usuario usuario=new Usuario();

		Iterator<Usuario> iter=lista.iterator();
		while(iter.hasNext()) {
				usuario=iter.next();
				if (usuario.getCuenta()==opcion) {
					listaAux.addLast(usuario);
				}
		}
		Iterator<Usuario> iterAux=listaAux.iterator();
		while(iterAux.hasNext()) {
			usuario=iterAux.next();
			if (usuario.getCuenta()==opcion) {
				System.out.println(usuario);
			}
	}

		
		
		
	}

	public static void buscar(SimpleLinkedList lista, Scanner input) {
		
		input.nextLine();
		SimpleLinkedList listaAux=new SimpleLinkedList();

		System.out.println("ingrese nombre: ");
		String nom=input.nextLine();
		System.out.println("Ingrese apellido");
		String apell=input.nextLine();
		
		Usuario usuario=new Usuario();

		Iterator<Usuario> iter=lista.iterator();
		
		while(iter.hasNext()) {
			usuario=iter.next();
			if (usuario.getNombre().contains(nom) || usuario.getApellido().contains(apell)) {
				listaAux.addLast(usuario);
			}
	    }
		Iterator<Usuario> iterAux=listaAux.iterator();

		while(iterAux.hasNext()) {
				System.out.println(iterAux.next());
	    }
		
		
		
	}

	public static SimpleLinkedList agregar(Scanner input, SimpleLinkedList lista) {
		char respuesta;
		do {
			Usuario usuario=new Usuario();
			input.nextLine();
			System.out.print("nombre:");
			usuario.setNombre(input.nextLine());
			System.out.print("apellido:");
			usuario.setApellido(input.nextLine());
			System.out.print("usuario: ");
			usuario.setUsuario(input.nextLine());

			System.out.print("clave");
			usuario.setClave(input.nextLine());

			System.out.println("correo:");
			
			usuario.setCorreo(input.nextLine());

			System.out.println("cuenta:");
			usuario.setCuenta(input.next().charAt(0));
			
			lista.addLast(usuario);
			System.out.println("Desea continuar?(s/n)");
			respuesta=input.next().charAt(0);
			
			
		}while(respuesta=='s');
		
		return lista;
	}

	public static int menu(Scanner input) {
		
		System.out.println("1) Agregar usuarios");
		System.out.println("2) Buscar usuarios por nombre y/o apellido");
		System.out.println("3) Mostrar usuarios con un tipo de cuenta");
		System.out.println("4) Salir");
		int opcion=input.nextInt();
		return opcion;
	}

}
