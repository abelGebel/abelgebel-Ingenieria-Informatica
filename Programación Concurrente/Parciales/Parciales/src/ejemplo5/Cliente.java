package ejemplo5;

import java.util.ArrayList;

public class Cliente {
	
	private int id;
	private ArrayList<Integer> miLista;
	private ArrayList<Integer> monitor;

	
	public Cliente(int id, ArrayList<Integer> miLista,ArrayList<Integer> monitor) {
		this.id=id;
		this.miLista=miLista;
		this.monitor=monitor;
	}
	
	public void compraCliente() {
		synchronized(monitor) {
			
			while(miLista.size()>=3) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		miLista.add(id);
		synchronized(miLista) {
			miLista.notify();
		}
	}
}
