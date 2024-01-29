package punto4;
import java.util.Random;
import java.util.Scanner;
import a.ColaCircular;
import a.Helper;

public class Punto4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int opcion=0;
		String cadena;
		System.out.println("------------INICIO PROGRAMA------------");
		ColaCircular cola = new ColaCircular(4);
		cola.encolar(5);
		cola.encolar(2);
		cola.encolar(8);
		cola.encolar(1);

		while(true) {
			System.out.println("Ingreso de datos");
			opcion=menu(input,opcion,"De forma manual","De forma aleatoria");
			if(opcion==1) {
				System.out.println("Ingrese una cadena de caracteres: ");
				cadena=input.nextLine();
				cifrado(cadena,opcion,input);
			}else if(opcion==2) {
				cadena=generarCadena(ran);
				cifrado(cadena,opcion,input);
			}else {
				break;
			}
		}
		System.out.println("------------FIN PROGRAMA------------");
	}
	
	public static void cifrado(String cadena, int opcion, Scanner input) {
		ColaCircular cola = new ColaCircular(4);
		cola.encolar(5);
		cola.encolar(2);
		cola.encolar(8);
		cola.encolar(1);
		String codificado = "";
		int head;
			opcion = menu(input, opcion, "Codificar", "Decodificar");
			
			if(opcion==1) {
				for (char c: cadena.toCharArray()){	
					head=(int) cola.quitar();
					codificado += (char)((int)c + head);
					cola.encolar(head);
				}
			}else {
				for (char c: cadena.toCharArray()){	
					head=(int) cola.quitar();
					codificado += (char)((int)c - head);
					cola.encolar(head);
				}
			}
			
			System.out.println(codificado);			
	}
	
	public static String generarCadena(Random random) {
        String caracteresPosibles = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int longitud = 12;

        StringBuilder stringBuilder = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = random.nextInt(caracteresPosibles.length());
            char caracterAleatorio = caracteresPosibles.charAt(indiceAleatorio);
            stringBuilder.append(caracterAleatorio);
        }
        
        String stringAleatorio = stringBuilder.toString();        
        System.out.println("String aleatorio: " + stringAleatorio);
		return stringAleatorio;
    
	}

	private static int menu(Scanner input, int opcion,String mensaje1,String mensaje2) {
		System.out.println();
		System.out.println("1) "+mensaje1);
		System.out.println("2) "+mensaje2);
		System.out.println("3) Salir");
		System.out.println();
		while(true) {
			opcion=Helper.getIntegerPositivo(input,"Elija una opcion: ", "OPCION NO VALIDA...");
			if(opcion>0 && opcion<4) {
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		System.out.println();
		return opcion;
	}

}
