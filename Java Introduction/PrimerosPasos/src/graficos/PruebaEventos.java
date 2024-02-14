package graficos;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class PruebaEventos {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MarcoBotones miMarco  = new MarcoBotones();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
		setBounds(300,300,500,300);
		setTitle("Botones y eventos");
		LaminaBotones miLamina = new LaminaBotones();
		add(miLamina);
	}
}

class LaminaBotones extends JPanel implements ActionListener{
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");

	public LaminaBotones() {
		add(botonAzul); 
		add(botonAmarillo);
		add(botonRojo);

		botonAzul.addActionListener(this); 
		botonAmarillo.addActionListener(this);
		botonRojo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if(botonPulsado==botonAzul) {
			setBackground(Color.BLUE);
		}
		if(botonPulsado==botonAmarillo) {
			setBackground(Color.YELLOW);
		}
		if(botonPulsado==botonRojo) {
			setBackground(Color.RED);
		}	
	}
	
}


