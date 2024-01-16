package Punto1;

public class PrintY extends Thread{
	private int id;
	public PrintY(int id) {
		this.id=id;
	}
	
	public void run() {
		for(int i = 0;i<10;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("."+i+"Y("+this.id+").");
		}
	}
}
