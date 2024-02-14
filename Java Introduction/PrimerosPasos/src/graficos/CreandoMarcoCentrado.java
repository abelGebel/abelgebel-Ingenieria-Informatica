package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		MarcoCentrado miMarco = new MarcoCentrado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);

	}

}


@SuppressWarnings("serial")
class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamano = miPantalla.getScreenSize();
		
		int altura = tamano.height;
		int ancho = tamano.width;
		setSize(ancho/2,altura/2);
		setLocation(ancho/4,altura/4);
		setTitle("Marco Centrado");
		Image miIcono = miPantalla.getImage("src/graficos/Leader.jpg");
		setIconImage(miIcono);
	}
	
}