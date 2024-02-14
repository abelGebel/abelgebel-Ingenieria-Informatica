package defaultPackage;
import javax.swing.*;

public class PesoIdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String genero = "";
		
		do {
			
			genero = JOptionPane.showInputDialog("Introduce tu genero (H/M)");
			
		}while(genero.equalsIgnoreCase("H")==false&& genero.equalsIgnoreCase("M")==false);
		
		int pesoIdeal = 0;
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura"));
		
		if(genero.equalsIgnoreCase("H")) {
			pesoIdeal = altura-110;
		}else {
			pesoIdeal = altura-120;
		}
		System.out.println("Tu peso ideal es: "+pesoIdeal);
	}

}
