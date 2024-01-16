package ejemplo4;

import java.util.concurrent.Callable;

public class MiCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
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
		return total;
	}
	
}
