package ejemplo3semThread;

public class Consumidor extends Thread{
	private Almacen almacen;
	
	public Consumidor(String name,Almacen almacen) {
		super(name);
		this.almacen=almacen;
	}
	
	public void run() {
		while(true) {
			almacen.consumir(this.getName());
		}
	}
}
