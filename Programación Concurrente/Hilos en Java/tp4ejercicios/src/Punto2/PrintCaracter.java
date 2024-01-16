package Punto2;

public class PrintCaracter extends Thread{
	
	private char[] caracteres;
	private int posicion; 
	
	public PrintCaracter(char[] caracteres,int posicion) {
		this.posicion=posicion;
		this.caracteres=caracteres;
	}
	


	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(caracteres[posicion]);
	}

}
