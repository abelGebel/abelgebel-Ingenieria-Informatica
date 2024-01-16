package punto2;

import java.util.ArrayList;

public class Hombre {
	
    private ArrayList<Integer> baño;
    private ArrayList<Integer> cantidadHombres;
    private Baño bañoControl;
    private int id;
    static int filaEsperaa=0;
    static int filaSalidaa=10;
    
    
    public Hombre(ArrayList baño,ArrayList cantidadHombres,int id,Baño bañoControl) {
    	this.baño=baño;
    	this.cantidadHombres=cantidadHombres;
    	this.id=id;
    	this.bañoControl=bañoControl;
    }
    
    public void usoBañoHombre() {
		//System.out.println("Empleado hombre "+id+" llego al bano");

    	try {
    		synchronized(cantidadHombres) {
				while(filaEsperaa>=10 || Baño.verificarGenero()==true ) {
					//System.out.println("hombre "+id+" esta haciendo fila fuera del bano");
					cantidadHombres.wait();	
				}
			}
    		filaEsperaa+=1;
    		synchronized(baño) {	
    			while(baño.size()>=3) {
    				System.out.println("Empleado hombre "+id+" espera a que se desocupe un hinodoro");
    				baño.wait();
    			}
    		}
    			baño.add(id);
    			System.out.println("Empleado hombre "+id+" esta usando un hinodoro");
    			Thread.sleep(2000);
    			baño.remove(0);
    			System.out.println("Empleado hombre "+id+" sale del bano");
    			Baño.notificar();
    			filaSalidaa-=1;
    			if(filaSalidaa==0) {
    				if(baño.size()>0) {
        				baño.remove(0);
    				}
    				System.out.println("SALE ULTIMO HOMBRE");
    				bañoControl.insertarGenero(true);
    				filaEsperaa=0;
    				filaSalidaa=10;
    				Baño.notificarMujeres();
    				
    			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
