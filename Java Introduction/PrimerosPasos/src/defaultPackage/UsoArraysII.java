package defaultPackage;

import javax.swing.JOptionPane;

public class UsoArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] paises = new String[4];

		for(int i=0; i<4; i++) {
			paises[i] = JOptionPane.showInputDialog("Introduce país "+(i+1));
		}
		
		for(String elemento:paises) { //bucle for each
			System.out.println(elemento);
		}
		
		
	}

}
