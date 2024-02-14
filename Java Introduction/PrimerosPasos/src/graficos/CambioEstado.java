package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MarcoEstado miMarco  = new MarcoEstado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setTitle("Ventana 1");
	}
}

class MarcoEstado extends JFrame{
	
	public MarcoEstado() {
		setBounds(100,300,400,300);
		setVisible(true);
		
		CambiaEstado nuevo_estado = new CambiaEstado();
		
		addWindowStateListener(nuevo_estado);
		
	}
}

class CambiaEstado implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		System.out.println("La ventana ha cambiado de estado");
		
	}
	
}
