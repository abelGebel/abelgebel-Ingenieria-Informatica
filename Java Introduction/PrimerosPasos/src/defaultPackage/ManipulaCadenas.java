package defaultPackage;
import java.util.Locale;
import java.util.Scanner;
public class ManipulaCadenas {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String frase = "Hoy es un estuoendo dia para aprender java";
		
		String fraseResumen = frase.substring(0, 12)+" irnos a la playa";
		
		System.out.println(fraseResumen);
		
		String alumno1, alumno2;
		
		alumno1 = "david";
		alumno2 = "David";

		System.out.println(alumno1.equals(alumno2));
		System.out.println(alumno1.equalsIgnoreCase(alumno2)); // se ignoran las mayúsculas de los dos string.

		Scanner input;
		Locale miObjeto;
		
		//Si un metodo es estatico se debe poner el nombre de la clase delante del metodo, ej Math.round.
		
	}

}
