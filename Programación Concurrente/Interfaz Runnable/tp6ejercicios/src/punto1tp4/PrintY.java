package punto1tp4;

public class PrintY{
	private int id;
	public PrintY(int id) {
		this.id=id;
	}
	
	public void imprimirY() {
		for(int i = 0;i<100;i++) {
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
