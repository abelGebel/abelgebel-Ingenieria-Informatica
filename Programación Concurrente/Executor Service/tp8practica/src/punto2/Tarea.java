package punto2;

public class Tarea implements Runnable{

	static int contador=0;
	@Override
	public void run() {
		try {
			contador+=1;
			System.out.println("Nueva ejecucion "+(contador));
			Thread.sleep(3000);
			System.out.println("Fin ejecucion "+(contador));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
