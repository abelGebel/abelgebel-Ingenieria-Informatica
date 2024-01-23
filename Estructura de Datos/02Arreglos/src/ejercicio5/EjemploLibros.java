package ejercicio5;
import java.util.Random;
public class EjemploLibros {
	
	public EjemploLibros() {}
	
	public  String cargarTitulos(Random random) {
		String nombresAleatorios[]= {"Reino de papel","Still with me","Violeta","La espia",
				"Caraval","Legendary","No-cosas","El italiano","Caos","El Renegado"};
		String valor=nombresAleatorios[random.nextInt(9)];
		return valor;	
	}
	
	public String cargarAutores(Random random) {
		String nombresAleatorios[]= {"Victoria Resco","Lily Del Pilar","Isabel Allende",
				"Danielle Steel","Stephanie Garber","Byung-Chul Han","Arturo Perez-Reverte",
				"Magali Tajes","Marissa Meyer"};
		String valor=nombresAleatorios[random.nextInt(8)];
		return valor;
	}

	public String cargarEditoriales(Random random) {		
		String nombresAleatorios[]= {"V&R S.A.","Grupo Planeta S.A.I.","House Grupo",
				"URANO S.A."};
		String valor=nombresAleatorios[random.nextInt(3)];
		return valor;
	}
	
	public int cargarAnio(Random random) {		
		return random.nextInt(30)+1990;
	}
}