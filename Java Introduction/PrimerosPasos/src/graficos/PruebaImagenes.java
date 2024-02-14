package graficos;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;
public class PruebaImagenes {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MarcoImagen miMarco  = new MarcoImagen();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
		setBounds(300,300,500,300);
		setTitle("Marco con imagen");
		LaminaConImagen miLamina = new LaminaConImagen();
		add(miLamina);
	}
}

class LaminaConImagen extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		/*File miImagen = new File("src/graficos/food.png");
		
		try {
			imagen = ImageIO.read(new File("src/graficos/food.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("La imagen no se encuentra");
		}
		
		//g.drawImage(imagen, 5, 5, null);
		*/
		
		try {
			imagen = ImageIO.read(new File("src/graficos/Earth.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("La imagen no se encuentra");
		}
		
		int anchura = imagen.getWidth(this);
		int altura = imagen.getHeight(this);

		
		
		g.drawImage(imagen, 0, 0, null);
		
		for(int i=0; i<200;i++) {
			for(int j=0; j<200; j++) {
				g.copyArea(0, 0, anchura, altura, anchura*i, altura*j);
			}

		}
	}
	private Image imagen;
}
