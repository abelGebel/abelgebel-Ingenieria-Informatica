package ejemplo3;

import java.util.Random;

public class Hilo extends Thread{
	
	private int posicion;
	private String[] array;
	private Random r;
	

	public Hilo(int posicion,String[] array,Random r) {
		this.posicion=posicion;
		this.array=array;
		this.r=r;
	}
	
	public void run() {
		System.out.println("Run del hilo "+posicion);
		array[posicion]=compute(r);
	}
	
	public static String compute(Random r) {
		long aux = Math.abs(r.nextLong());
		return(aux+" "+esPrimo(aux));
	}
	
	public static boolean esPrimo(long numero) {
		int contador=2;
		boolean primo=true;
		while((primo)&&(contador!=numero)) {
			if(numero%contador==0) {
				primo=false;
			}
			contador ++;
		}
		return primo;
	}
	
}
