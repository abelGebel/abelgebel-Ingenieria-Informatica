package defaultPackage;

public class CalculosConMath {

	public static void main(String[] args) {


		//double raiz=Math.sqrt(9);
		
		double num1 = 5.85;
		
		int resultado = (int)Math.round(num1);
		
		System.out.println(resultado);

		resultado = (int) Math.pow(4, 2);
		System.out.println(resultado);
		
		int a = -3;
		
		resultado = Math.abs(a);
		System.out.println(resultado);
		
		String miNombre = "nombre"; // miNombre es un objeto (instancia) de la clase String.
		
		System.out.println(miNombre.charAt(0));
		System.out.println(miNombre.length());
		System.out.println(miNombre.charAt(miNombre.length()-1));

		
	}

}
