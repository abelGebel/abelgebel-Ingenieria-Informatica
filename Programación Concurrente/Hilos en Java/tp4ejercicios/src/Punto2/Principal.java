package Punto2;

/*
Debe solicitar el ingreso de una frase por la entrada de teclado, a continuación (una vez
apretado Enter) deberá imprimir 10 veces dicha frase pero carácter por carácter
empleando hilos.

*/


public class Principal {

	public static void main(String[] args) {
		
		String frase="HOLAMUNDO";

		char[] caracteres = new char[frase.length()];
	    for (int i = 0; i < frase.length(); i++) {
	        caracteres[i] = frase.charAt(i);
	    }
	    
	    Thread misHilos[]=new Thread[caracteres.length];
	    for (int i=0;i<caracteres.length;i++) {
			System.out.print(caracteres[i]);
	    }
	    System.out.println();
	    for (int i=0;i<caracteres.length;i++) {
			misHilos[i] = new PrintCaracter(caracteres, i);
			misHilos[i].start();
	    }
	}

}
