package ejemplo5;

import java.util.ArrayList;

public class Cajero {
	private int id;
	private ArrayList<Integer> miLista;
	private ArrayList<Integer> monitor;
	
	public Cajero(int id,ArrayList<Integer> miLista,ArrayList<Integer> monitor) {
		this.id=id;
		this.miLista=miLista;
		this.monitor=monitor;
	}

	
	
	public void iniciarAtencion() {
		int cliente;
		
		while(true) {
		synchronized(miLista) {
			
				while(miLista.size()==0) {
					try {
						System.out.println("Caejro"+id+"no tiene clientes");
						miLista.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		cliente = miLista.remove(0);
		
		System.out.println("Cajero "+id+" esta atendiendo a al cliente "+cliente );
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		synchronized(monitor) {
			monitor.notify();
		}

		}
		
	}
	
}
