package defaultPackage;

import java.util.Scanner;
import javax.swing.JOptionPane;
@SuppressWarnings("unused")

public class EntradaEjemplo {

	public static void main(String[] args) {
		/*
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce tu nombre");
		String nombre = entrada.nextLine();
		System.out.println("Introduce edad");
		int edad = entrada.nextInt();
		System.out.println(nombre+" "+edad);
		
		nombre = JOptionPane.showInputDialog("Introduce nombre");
		String edad2 = JOptionPane.showInputDialog("Edad");
		
		System.out.println(nombre+" "+(Integer.parseInt(edad2)+1));
		
		*/
		//Clase numberFormat
		double x=100;
		System.out.println(x);
		System.out.printf("%1.2f",x/3 + 1);
		System.out.println();
		String num1 = JOptionPane.showInputDialog("introduce un numero");
		double num2 = Double.parseDouble(num1);
		
		System.out.print("La raiz de "+num2+" es ");
		System.out.printf("%1.2f",Math.sqrt(num2));

	}

}
