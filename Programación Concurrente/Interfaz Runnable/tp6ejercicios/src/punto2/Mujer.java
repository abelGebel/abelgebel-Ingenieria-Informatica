package punto2;

import java.util.ArrayList;

public class Mujer {
	
    private ArrayList<Integer> baño;
    private ArrayList<Integer> cantidadMujeres;
    private Baño bañoControl;
    private int id;
    static int filaEspera=0;
    static int filaSalida=7;
    
    public Mujer(ArrayList baño,ArrayList cantidadMujeres,int id, Baño bañoControl) {
    	this.baño=baño;
    	this.cantidadMujeres=cantidadMujeres;
    	this.id=id;
    	this.bañoControl=bañoControl;
    }
    
    public synchronized void usoBañoMujer() {
    	
    	try {
			//System.out.println("Empleada mujer "+id+" llego al bano");

			synchronized(cantidadMujeres) {
				while(filaEspera>=7 || Baño.verificarGenero()==false ) {
					//System.out.println("Empleada mujer "+id+" esta haciendo fila fuera del bano");
					cantidadMujeres.wait();	
				}
			}
			filaEspera+=1;
			
    		synchronized(baño) {	
    			while(baño.size()>=3) {
    				System.out.println("Empleada mujer "+id+" espera a que se desocupe un hinodoro");
    				baño.wait();

    			}
    		}
    			baño.add(id);

    			System.out.println("Empleada mujer "+id+" esta usando un hinodoro");
    			Thread.sleep(2000);
    			baño.remove(0);
    			System.out.println("Empleada mujer "+id+" sale del bano");
    			Baño.notificar();
    			filaSalida-=1;
    			if(filaSalida==0) {
    				if(baño.size()>0) {
        				baño.remove(0);
    				}
    				System.out.println("SALE ULTIMA MUJER");
    				bañoControl.insertarGenero(false);
    				filaEspera=0;
    				filaSalida=7;
    				bañoControl.notificarHombres();
    				
    			}
    		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
