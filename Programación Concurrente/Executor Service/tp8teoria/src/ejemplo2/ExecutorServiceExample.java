package ejemplo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(3);
		executor.execute(() -> doLongWork("hi 1"));
		executor.execute(() -> doLongWork("hi 2"));
		executor.execute(() -> doLongWork("hi 3"));
		executor.shutdown();

	}
	
	private static void doLongWork(String hola) {
		System.out.println("Running "+hola);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
