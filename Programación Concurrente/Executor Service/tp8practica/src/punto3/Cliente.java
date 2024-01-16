package punto3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cliente implements Runnable{

	private int id;
	private Random ran;
	public Cliente(int id,Random random) {
		this.id=id;
		this.ran=random;
	}
	@Override
	public void run() {
		try {
			int tiempo=ran.nextInt(2)+1;
			System.out.println("El cliente "+id+" esta siendo antendido.");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("El cliente "+id+" se retira.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
