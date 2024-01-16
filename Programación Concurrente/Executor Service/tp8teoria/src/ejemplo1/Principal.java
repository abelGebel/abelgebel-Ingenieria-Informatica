package ejemplo1;

public class Principal {

	public static void main(String[] args) {
		Thread t1=new Thread(new Tarea("tarea 1"));
		t1.start();
		Thread t2=new Thread(new Tarea("tarea 2"));
		t2.start();
		Thread t3=new Thread(new Tarea("tarea 3"));
		t3.start();

	}

}
