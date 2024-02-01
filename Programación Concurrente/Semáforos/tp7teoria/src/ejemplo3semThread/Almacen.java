package ejemplo3semThread;

import java.util.concurrent.Semaphore;

public class Almacen{
	private final int MAX_LIMITE=20;
	private int producto=0;
	private Semaphore productor = new Semaphore(MAX_LIMITE);
	private Semaphore consumidor = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);
	
	public void producir(String nombreProductor) {
		System.out.println(nombreProductor+" intentando almacenar un producto");
		try {
			productor.acquire();
			mutex.acquire();
			producto++;
			System.out.println(nombreProductor+" almacena un producto"
			+" Almacen con " + producto + " productos");
			mutex.release();
			Thread.sleep(500);
		} catch (InterruptedException e) {e.printStackTrace();
		}finally {
			consumidor.release();
		}
	}
	
	public void consumir(String nombreConsumidor) {
		System.out.println(nombreConsumidor+" intentando retirar un producto");
		try {
			consumidor.acquire();
			mutex.acquire();
			producto--;
			System.out.println(nombreConsumidor+" retira un producto"+" Almacen con "+producto+ " productos");
			mutex.release();
			Thread.sleep(100);
			
		} catch (InterruptedException e) {e.printStackTrace();
		}finally {
			productor.release();
		}
	}

}
