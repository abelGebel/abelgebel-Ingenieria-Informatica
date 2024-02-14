package defaultPackage;
import javax.swing.*;

public class AccesoAplicacion {

	public static void main(String[] args) {

		String clave = "contra";
		
		String pass = "";
		
		while(clave.equals(pass)==false) {
			
			pass = JOptionPane.showInputDialog("Introduce la contraseña");
			
			if(clave.equals(pass)==false) {
				System.out.println("CONTRASEÑA INCORRECTA");
			}
			
		}
		System.out.println("Contraseña correcta");
		
	}

}
