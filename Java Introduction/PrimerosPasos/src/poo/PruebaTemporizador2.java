package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		
		Reloj miReloj = new Reloj();
		miReloj.enMarcha(2000,true);
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		System.exit(0);
	}

}

class Reloj{
	
	public void enMarcha(int intervalo, final boolean sonido){
		//como en la clase interna no accedemos a la variable intervalo, no hace falta que sea final.
		
		class DameLaHora2 implements ActionListener { //Clase interna local dentro de un metodo// solo se debe usar una vez en el codigo
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date ahora= new Date();
				System.out.println("La hora es " + ahora);
				
				if(sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
				
				
			}
		}
	
		ActionListener oyente = new DameLaHora2();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
}
