package punto2;

import java.util.ArrayList;
import java.util.Random;

public class Baño {

    private static  ArrayList<Integer> baño;
    private static  ArrayList<Integer> cantidadMujeres;
    private static  ArrayList<Integer> cantidadHombres;
    static Random random = new Random();
    private static boolean hayMujeres;

	
    public Baño(ArrayList baño,ArrayList cantidadMujeres,ArrayList cantidadHombres){
    	this.baño=baño;
    	this.cantidadMujeres=cantidadMujeres;
    	this.cantidadHombres=cantidadHombres;
    }
    
	public static void notificar() {
		try {
			synchronized(baño){
				baño.notify();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void notificarMujeres() {
		try {
			synchronized(cantidadMujeres){

				for(int i=1;i<=7;i++) {
					cantidadMujeres.notify();

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void notificarHombres() {
		try {
			synchronized(cantidadHombres){
				for(int i=1;i<=10;i++) {
					cantidadHombres.notify();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean verificarGenero() {
		return hayMujeres;
	}
	
	public void insertarGenero(boolean hayMujeres) {
		Baño.hayMujeres=hayMujeres;
	}
}