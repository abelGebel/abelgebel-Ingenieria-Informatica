package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class TrabajandoColores {

	public static void main(String[] args) {
		
		MarcoConColor miMarco  = new MarcoConColor();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);


	}

}

class MarcoConColor extends JFrame{
	
	public MarcoConColor() {
		setTitle("Prueba con colores");
		setSize(400,400);
		LaminaConColor miLamina = new LaminaConColor();
		add(miLamina);
		
		miLamina.setBackground(Color.PINK);
		

	}
}

class LaminaConColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);
		g2.setPaint(Color.YELLOW);
		g2.draw(rectangulo);

		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		//g2.setPaint(Color.BLUE);
		//g2.setPaint(new Color(12,180,30).brighter());
		g2.setPaint(new Color(12,180,30).darker());
		g2.fill(elipse);
	}

	
}