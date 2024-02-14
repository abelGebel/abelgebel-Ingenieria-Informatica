package defaultPackage;

public class PrimeraClase {

	@SuppressWarnings("unused")
	public static void main(String agrs[]) {
		
		System.out.println("Hola mundo");
		
		//-------------------TIPOS DE DATOS-------------------
		//					  PRIMITIVOS				
		//Enteros:
		int numeroEntero = 7; //entre 2billones y -2billones --> 4 bytes de espacio de almacenamiento.
		short numeroCorto = 3; //enre 30mil y -30mil --> 2 bytes.
		long numeroLargo = 30L; // --> 8 bytes, sufijo l.
		byte numeroByte = 9; // entre 127 y -128 --> 1 byte.
		
		//Coma flotante (decimales):
		float numeroFlotante = 33.1F; // de 6 a 7 cifras decimales significativas --> 4 bytes, sufijo f.
		double numeroDouble = 20.2211; // 15 cifras significativas --> 8 bytes. 
		
		//Caracteres:
		char caracter = 'A'; // (Unicode)
		
		//Booleanos
		boolean booleano = true;
		
		/* Variable:
		 * Espacio en memoria del ordenador donde se almacenará un valor que podrá
		 * cambiar durante la ejecución del programa
		 * A la hora de crear un programa surge la necesidad de guardar datos temporalmente
		 * que se necesitará utilizar en el futuro.
		 * Iniciar una variable es darle un valor
		 * Las variables siempre se almacenan en la ram, no en el disco duro.
		 */
	}
}
