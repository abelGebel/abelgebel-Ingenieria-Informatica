package ejemplo8;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*
Un supermercado posee 1 caja de atención rápida (menos de 5 artículos) y 1 caja de
atención normal (más de 5 artículos). Los clientes llegan al supermercado en un tiempo
aleatorio entre 300ms y 500ms. Cada cliente demora en realizar sus compras un tiempo
aleatorio entre 3”-6”, cada cajero rápido (caja rápida) demora en atender a cada cliente un
tiempo aleatorio entre 2”- 4” y cada cajero normal (caja normal) demora en atender a cada
cliente un tiempo aleatorio entre 3”- 7”. La compra de cada cliente es un número aleatorio
entre [2, 8] para decidir si irá por la caja de atención rápida o normal. Debe simular las 2
colas, es decir, cada cliente realiza la compra y se dirige a una cola específica del
supermercado (dependiendo de la cantidad de productos a comprar). Debe mostrar un mensaje
indicando que el “Cliente X entró al Súper”, otro mensaje cuando el “Cliente X está
comprando”, otro mensaje cuando “Cliente X está pagando en la caja Y” y un último mensaje
cuando “Cliente X abandona el Súper”. Simule la atención del supermercado para 50 clientes
*/
public class Principal {
	
	static Semaphore cajaRapida =new Semaphore(1);
	static Semaphore cajaNormal =new Semaphore(1);

	public static void main(String[] args) {
		Random ran = new Random();
		
		for(int i=0;i<20;i++) {
			Thread cliente=new Cliente(i+1,cajaRapida,cajaNormal,ran);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cliente.start();
		}
	}

	
	static class Cliente extends Thread{

		private int id;
		private Semaphore cajaRapida;
		private Semaphore cajaNormal;
		private Random ran;
		
		public Cliente(int id, Semaphore cajaRapida, Semaphore cajaNormal, Random ran) {
			this.id=id;
			this.cajaRapida=cajaRapida;
			this.cajaNormal=cajaNormal;
			this.ran=ran;
		}
		
		public void run() {
			
			int productos;
			System.out.println("Cliente "+id+" entro al Super");
			System.out.println("Cliente "+id+" esta comprando");
			
			try {
				Thread.sleep(4000);
				productos=ran.nextInt(7)+2;
				if(productos>=2 && productos<=5) {
					try {
						cajaRapida.acquire();
						System.out.println("Cliente "+id+" está pagando "+productos+" productos en la caja rapida");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						cajaRapida.release();
					}

				}else {
					try {
						cajaNormal.acquire();
						System.out.println("Cliente "+id+" está pagando "+productos+" productos en la caja normal");
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						cajaNormal.release();
					}
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Cliente "+id+" abandona el super.");
		}
		
	}
	
}
