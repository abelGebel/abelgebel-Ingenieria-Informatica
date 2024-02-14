package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import graficos.LaminaBotonesII.ColorFondo;

public class EventosVentana {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MarcoVentana miMarco  = new MarcoVentana();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoVentana miMarco2  = new MarcoVentana();
		miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		miMarco.setTitle("Ventana 1");
		miMarco2.setTitle("Ventana 2");
		miMarco2.setBounds(600,300,400,300);


	}
}

class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
		setBounds(100,300,400,300);
		setTitle("Respondiendo");
		setVisible(true);

		//MVentana oyente_ventana = new MVentana();
		//addWindowListener(oyente_ventana);
		addWindowListener(new MVentana());
	}
}

class MVentana extends WindowAdapter{
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada");
	}
}




/* 
class MVentana implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana abierta");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando ventana");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("LA VENTANA HA SIDO CERRADA");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana restaurada");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana activada");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana desactivada");	
	}
}
*/