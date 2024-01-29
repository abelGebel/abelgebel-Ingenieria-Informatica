package punto6;
import java.util.Scanner;

public class Punto6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);		
		SimpleLinkedList lista=new SimpleLinkedList();
		

		int opcion=0;
		while(true) {
			opcion=menu(input, opcion);
			
			if(opcion==1) {
				lista=agregarVideo(input,lista);
			}else if (opcion==2) {
				
				opcion=menu2(input,opcion);
				if(opcion==1) {
					listaDetema(input,lista);
				}
				
			}else if(opcion==3) {
				
			}else {
				break;
			}
		}

	}

	public static void listaDetema(Scanner input, SimpleLinkedList lista) {
		SimpleLinkedList listaTema=new SimpleLinkedList();
	}

	public static int menu2(Scanner input, int opcion) {
		System.out.println("1) Videos de un tema a eleccion");
		System.out.println("2) Videos que no superen una duración dada.");
		System.out.println("3) Videos seleccionados aleatoriamente");
		System.out.println("4) Videos de un determinado creador de contenido");
		opcion=input.nextInt();
		return 0;
	}

	public static SimpleLinkedList agregarVideo(Scanner input, SimpleLinkedList lista) {
		
		char respuesta;
		do {
			Video video=new Video();
			
			System.out.print("Identificador: ");
			video.setIdentificador(input.nextLine());
			System.out.print("Titulo: ");
			video.setTitulo(input.nextLine());
			System.out.print("Creador de contenido: ");
			video.setCreador(input.nextLine());
			System.out.println("Duracion: ");
			video.setDuracion(input.nextInt());
			respuesta=input.next().charAt(0);
			lista.addLast(video);
			
		}while(respuesta=='s');
		
		
		
		return lista;
	}

	public static int menu(Scanner input, int opcion) {
		System.out.println("1) Agregar video");
		System.out.println("2) Crear lista de reproduccion");
		System.out.println("3) Duracion total de los videos de un tema");
		System.out.println("4) Salir");
		opcion=input.nextInt();
		return opcion;
	}


}
