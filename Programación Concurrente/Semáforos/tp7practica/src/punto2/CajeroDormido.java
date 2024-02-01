package punto2;


public class CajeroDormido extends Thread{

	static Cajero cajero;
	public CajeroDormido(Cajero cajero){
		CajeroDormido.cajero=cajero;
	}
	
	public void run() {
		try {
			Thread.sleep(5000);
			cajero.agregarCajero();
		} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("SE AGREGA UN CAJERO");
		

	}
}

