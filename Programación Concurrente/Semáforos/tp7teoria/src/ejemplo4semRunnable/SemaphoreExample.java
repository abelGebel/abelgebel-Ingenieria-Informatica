package ejemplo4semRunnable;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	
	private int i=0;

	public static void main(String[] args) {
		final SemaphoreExample example=new SemaphoreExample();
		final Semaphore semaphore = new Semaphore(1);
		final Runnable r = new Runnable() {
			
			public void run() {
				while (true) {
					try {
						semaphore.acquire();
						//seccion critica a proteger
						example.printSomething();
						Thread.sleep(1000);
						semaphore.release();
					}catch(Exception ex) { }}}
		};
		new Thread(r,"a").start();
		new Thread(r,"b").start();
		new Thread(r,"c").start();
	}

	public void printSomething() {
		i++;
		System.out.println("- current value of the i: "+i+" hilo "+Thread.currentThread().getName());
		
	}
}
