package ejemplo4;

public class PrincipalHilo {

	public static void main(String[] args) {
		Tarea1 t= new Tarea1();
		Thread hilo=new Thread(t);
		hilo.start();
		

	}

}
