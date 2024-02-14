package defaultPackage;

import javax.swing.JOptionPane;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long resultado = 1;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introdce un numero"));
		
		for(int i=numero;i>0;i--) {
			resultado = resultado*i;
		}
		System.out.println("El factorial de "+numero+" es "+resultado);
	}

}
