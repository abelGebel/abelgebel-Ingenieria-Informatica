package ejemplo4;

import java.util.Random;

public class Hilo extends Thread{
	
	
	private int posicion;
	private long[] array;
	private Random r;

	public Hilo(int posicion,long[] array,Random r) {
		this.posicion=posicion;
		this.array=array;
		this.r=r;
	}

	public void run() {
		System.out.println("Run del hilo "+posicion);
		array[posicion]=compute(r);
		System.out.println("Termino hilo "+posicion);
	}
	
	
	public static long compute(Random r) {
		Long aux=r.nextLong();
		for(long i=1;i<=50000000;i++) {
			aux=aux -r.nextInt(100000);
		}
		return aux;
	}
}
