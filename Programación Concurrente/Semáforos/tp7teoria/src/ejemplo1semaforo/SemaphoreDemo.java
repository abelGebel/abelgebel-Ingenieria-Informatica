package ejemplo1semaforo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	Semaphore semaphore = new Semaphore(10);
	
	public void printLock() {

		try {
			semaphore.acquire();
			System.out.println("Locks acquired");
			System.out.println("Locks remainig >>"+semaphore.availablePermits());
		} catch (InterruptedException e) {e.printStackTrace();
		}finally {
			semaphore.release();
			System.out.println("Locks Released");
			System.out.println("Locks remaining>>" + semaphore.availablePermits());
		}
		
		
		
	}

	public static void main(String[] args) {
		final SemaphoreDemo sem = new SemaphoreDemo();
		
		Thread thread = new Thread() {
			public void run() {
				sem.printLock(); }};
				
		thread.start();
	}

}
