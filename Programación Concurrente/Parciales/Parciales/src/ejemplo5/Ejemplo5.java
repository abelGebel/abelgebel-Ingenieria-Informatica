package ejemplo5;

import java.util.Random;
import java.util.concurrent.Semaphore;

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
public class Ejemplo5 {

	public static void main(String[] args) {
        Semaphore[] cajas = new Semaphore[3];
        Semaphore filasOcupadas=new Semaphore(0);
        cajas[0]=new Semaphore(1);
        cajas[1]=new Semaphore(1);
        cajas[2]=new Semaphore(1);
        Random ran = new Random();
        
        for(int i=1; i<=20;i++) {
        	try {
				Thread.sleep(300+ran.nextInt(200));
	        	Thread cliente = new Cliente(i,ran,cajas,filasOcupadas);
	        	cliente.start();
	        	i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	static class Cliente extends Thread{
		private int id;
		private Random ran;
		private Semaphore[] cajas;
		private Semaphore filasOcupadas;

		public Cliente(int id, Random ran, Semaphore[] cajas, Semaphore filasOcupadas) {
			this.id=id;
			this.ran=ran;
			this.cajas=cajas;
			this.filasOcupadas=filasOcupadas;
		}
		
		public void run() {
			boolean pago=false;
			try {
				System.out.println("El cliente "+id+" entro al super.");
				System.out.println("Cliente "+id+" esta comprando.");
				Thread.sleep(3000+ran.nextInt(2000));
				
				while(true) {
					
					for(int i=0; i<cajas.length;i++) {
						
						if(cajas[i].tryAcquire()) {
							System.out.println("Cliente "+id+" esta pagando en la caja "+(i+1));
							Thread.sleep(6000+ran.nextInt(1000));
							pago=true;
							cajas[i].release();
							break;
						}
					}
					if(!pago) {
						filasOcupadas.acquire();
					}else {
						filasOcupadas.release();
						break;
					}					
				}			
				System.out.println("Cliente "+id+" se retira.");		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
