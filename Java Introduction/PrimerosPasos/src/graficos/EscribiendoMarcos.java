package graficos;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscribiendoMarcos {

	public static void main(String[] args) {

		MarcoTexto miMarco = new MarcoTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoTexto extends JFrame{
	
	public MarcoTexto() {
		setVisible(true);
		setSize(600,450);
		setLocation(400,200);
		setTitle("primer texto");
		Lamina miLamina = new Lamina();
		add(miLamina);
	}
}

class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawString("Texto en el marco", 100, 100);
		
	}
}