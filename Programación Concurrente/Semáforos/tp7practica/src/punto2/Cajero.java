package punto2;

import java.util.concurrent.Semaphore;

public class Cajero {

	static Semaphore cajero;
	static int numCajas;
	private boolean cajeroExtra;
	
	public Cajero(int numCajas,boolean cajeroExtra) {
		this.cajeroExtra=cajeroExtra;
		this.cajero=new Semaphore(numCajas);
	}

	public static void setCajero(Semaphore cajero) {
		Cajero.cajero = cajero;
	}

	public Semaphore getCajero() {
        return cajero;
    }

	
	public boolean hayCajeroEXTRA(){
		return cajeroExtra;
	}
	public void agregarCajero() {
		cajeroExtra=true;
	}

    


}
