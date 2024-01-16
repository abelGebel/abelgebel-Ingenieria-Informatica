package punto2;

import java.util.ArrayList;

public class Persona implements Runnable{

	private ArrayList<Integer> baño;
    private int id;
    private Control control;
    private String genero;
    
    public Persona(ArrayList<Integer> baño,int id,Control control,String genero) {
    	this.baño=baño;
    	this.id=id;
    	this.control=control;
    	this.genero=genero;
    }
    
	public void run() {
		
		try {
			
				
				synchronized(control) {
					System.out.println("Empleado "+id+" llego al baño");
					baño.add(id);
					while(baño.size()>=4) {
						System.out.println("Emplead "+id+" espera a que se desocupe un hinodoro");
						control.wait();
					}
					System.out.println("Emplead "+id+" esta usando un hinodoro");
					Thread.sleep(2000);
					baño.remove(0);
					System.out.println("Emplead"+id+" sale del baño");
					control.notify();
				}

				
			
			
		} catch (InterruptedException e) {e.printStackTrace();}
		
	}

}
