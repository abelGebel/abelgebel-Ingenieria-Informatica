package ejemplo4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrincipalCallable {

	public static void main(String[] args) {
		
		try {
			ExecutorService servicio= Executors.newFixedThreadPool(1);
			Future<Integer> resultado=servicio.submit(new MiCallable());
			servicio.shutdown();
			System.out.println("Resultado devuelto: "+resultado.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
