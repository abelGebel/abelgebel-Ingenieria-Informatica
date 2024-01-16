package punto1tp4;

public class PrintX{
	private int id;
	public PrintX(int id) {
		this.id=id;
	}
	
	public void imprimirX() {
		for(int i = 0;i<100;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("."+i+"X("+this.id+").");
		}
	}
}
