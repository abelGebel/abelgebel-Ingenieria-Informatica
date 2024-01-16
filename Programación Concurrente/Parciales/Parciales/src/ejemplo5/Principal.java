package ejemplo5;
import java.util.ArrayList;
import java.util.Random;
/*
Un supermercado posee 3 cajas de atención. Los clientes llegan al supermercado en un tiempo
aleatorio entre 300ms y 500ms. Cada cliente demora en realizar sus compras un tiempo aleatorio
entre 3”-5”, luego se dirige a la cola del supermercado y espera ser atendido, cada cajero demora
en atender a cada cliente un tiempo aleatorio entre 2”- 3”. Debe simular las 3 colas, es decir,
cada cliente realiza la compra y se dirige a una cola específica del supermercado (la elección de
la cola debe ser de forma aleatoria). Debe mostrar un mensaje indicando que el “Cliente X entró
al Súper”, otro mensaje cuando el “Cliente X está comprando”, otro mensaje cuando “Cliente X
está pagando en la caja Y” y un último mensaje cuando “Cliente X abandona el Súper”. Simule
la atención del supermercado para 50 clientes. 
*/
public class Principal implements Runnable{
	
	private Cajero cajero;
	private Cliente cliente;
	private boolean esCajero;
	
	public Principal(Cliente cliente, boolean esCajero ) {
		this.esCajero=esCajero;
		this.cliente=cliente;
	}
	
	public Principal(Cajero cajero, boolean esCajero ) {
		this.esCajero=esCajero;
		this.cajero=cajero;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
        ArrayList<Integer> miLista = new ArrayList<>();
        ArrayList<Integer> monitor = new ArrayList<>();

        
        for(int i=1;i<=3;i++) {
            Cajero cajero=new Cajero(i,miLista,monitor);
            Runnable proceso1 = new Principal(cajero,true);
			new Thread(proceso1).start();
        }

		for(int i=1;i<=5;i++) {
			try {
				Thread.sleep(300+random.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cliente cliente=new Cliente(i,miLista,monitor);
            Runnable proceso2 = new Principal(cliente,false);
			new Thread(proceso2).start();
		}
		
	}

	@Override
	public void run() {
		if(esCajero) {
			cajero.iniciarAtencion();
		}else {
			cliente.compraCliente();
		}
			
		
	}

}
