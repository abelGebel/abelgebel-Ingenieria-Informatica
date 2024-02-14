package graficos;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class PruebaEventosII {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MarcoBotonesII miMarco  = new MarcoBotonesII();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoBotonesII extends JFrame{
	
	public MarcoBotonesII() {
		setBounds(300,300,500,300);
		setTitle("Botones y eventos");
		LaminaBotonesII miLamina = new LaminaBotonesII();
		add(miLamina);
	}
}

class LaminaBotonesII extends JPanel {
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");

	public LaminaBotonesII() {
		add(botonAzul); 
		add(botonAmarillo);
		add(botonRojo);
		
		ColorFondo Amarillo = new ColorFondo(Color.YELLOW);
		ColorFondo Azul = new ColorFondo(Color.BLUE);
		ColorFondo Rojo = new ColorFondo(Color.RED);

		

		botonAzul.addActionListener(Azul); 
		botonAmarillo.addActionListener(Amarillo);
		botonRojo.addActionListener(Rojo);
	}
	
	class ColorFondo implements ActionListener{

		private Color colorDeFondo;

		public ColorFondo(Color c) {
			colorDeFondo = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);	
		}	
	}
}

