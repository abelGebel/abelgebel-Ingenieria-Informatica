package punto5;

import java.math.BigInteger;

public class Tarea implements Runnable{
	
	private long elemento;

	public Tarea (long valor) {
		elemento=valor;
	}
	
	@Override
	public void run() {
		System.out.println("Hilo " + Thread.currentThread().getName().substring(14) + " ejecutandose...");
		System.out.println("Resultado del Hilo " + Thread.currentThread().getName().substring(14) + " : " + compute(elemento)+ ".");
	}
	
	static BigInteger M = new BigInteger("1999");
	
	private static BigInteger compute(long ind) {
		String s= "";
		for(long i=0; i<ind;i++) {
			s = s + ind;
		}
		return new BigInteger(s.toString()).mod(M);
	}

}