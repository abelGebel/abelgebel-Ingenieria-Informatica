package defaultPackage;

public class Variables {

	public static void main(String[] args) {
		
		byte edad = 35; //Declaración e iniciación de variable en una unica linea.
		System.out.println(edad);
		edad = 75;
		edad+=3;
		System.out.println(edad);

		final double constante;
		
		constante =3;
		System.out.println("constante: " + constante);
		// constante = 2.2; no se puede modificar una vez asignado el valor.
	}

}
