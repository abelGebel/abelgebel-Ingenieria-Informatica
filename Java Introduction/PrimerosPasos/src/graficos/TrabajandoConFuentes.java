package graficos;

import java.awt.*;
import javax.swing.*;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes miMarco  = new MarcoConFuentes();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoConFuentes extends JFrame{
	
	public MarcoConFuentes() {
		setSize(400,400);
		setTitle("prueba dibujo");
		LaminaConFuentes miLamina = new LaminaConFuentes();
		add(miLamina);
		miLamina.setForeground(Color.BLUE);
	}
}

class LaminaConFuentes extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Font miFuente = new Font("Courier", Font.BOLD, 26);
		g2.setFont(miFuente);
		g2.drawString("Abel", 100, 100);

		g2.setFont(new Font("Arial", Font.ITALIC, 26));
		g2.drawString("Java", 50, 50);


	}
}
