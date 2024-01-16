package ejemplo3mercadoRunnable;

public class Main implements Runnable{
	
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;
	
	public Main(Cliente cliente, Cajera cajera, long initialTime) {
		this.cajera=cajera;
		this.cliente=cliente;
		this.initialTime=initialTime;
	}
	
	
    public static void main(String[] args) {
        Cliente cliente1=new Cliente("Cliente 1",new int[]{2,2,1,5,2,3});
        Cliente cliente2=new Cliente("Cliente 2",new int[]{1,3,5,1,1});

        Cajera cajera1=new Cajera("Cajera 1");
        Cajera cajera2=new Cajera("Cajera 2");

        long initialTime=System.currentTimeMillis();//Tiempo inicial de referncia

        Runnable proceso1 = new Main(cliente1,cajera1, initialTime);
        Runnable proceso2 = new Main(cliente2,cajera2, initialTime);
        
        new Thread(proceso1).start();
        new Thread(proceso2).start();
    }

	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
		
	}
	
    /*
    En este caso no se dispone ni se podra sobreescribir los metodos de la clase Thread ya que no 
    se van a usar y solo se va a tener que sobreescribir el metodo run(). Solo es necesario
    implementar el metodo run() para que los procesos implementados en ese metodo se ejecueten
    en un hilo diferente. Se utiliza objetso de la clases cliente y cajera para implementar la 
    multitarea.
    
    Cajera seria el consumidor y cliente el productor. Clietne es algo estatico en este caso. Cajero
    es el que compite entre si.
    */
}