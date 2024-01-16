package ejemplo4;

public class Tarea1 implements Runnable{

	@Override
	public void run() {
		int total=0;
		for(int i=0;i<5;i++) {
			total+=i;
			System.out.println("i: "+i+" total: "+total);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Nombre del Thread: "+Thread.currentThread().getName());
		System.out.println("Resultado devuelto: "+total);
		//Runnable no devuelve nada
	}

}
