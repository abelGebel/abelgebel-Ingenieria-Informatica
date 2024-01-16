package punto1;

import java.util.concurrent.TimeUnit;

public class TareaRunnable implements Runnable {
	
	private String numero;
	public TareaRunnable(String numero) {
		this.numero=numero;
	}
	
	public void run()
	{
		System.out.println("Ejecutando Tarea "+numero+" dentro de: " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
	}

}