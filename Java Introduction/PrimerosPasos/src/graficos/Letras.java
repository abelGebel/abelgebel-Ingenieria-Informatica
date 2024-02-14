package graficos;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
public class Letras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuente = JOptionPane.showInputDialog("Introduce fuente");
		String [] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		boolean estaLaFuente = false;
		for(String nombre: fuentes) {
			
			if(fuente.equals(nombre)) {
				estaLaFuente = true;
				break;
			}
		}
		
		if(estaLaFuente) {
			System.out.println("Fuente instalada");
		}else {
			System.out.println("Fuente no instalada");
		}
	}
}
