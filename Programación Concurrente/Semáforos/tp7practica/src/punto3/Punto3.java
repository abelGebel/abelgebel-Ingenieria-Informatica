package punto3;
import java.util.Random;
import java.util.concurrent.Semaphore;
/*
Un supermercado posee 3 cajas de atención y 15 carritos para que los clientes realicen las
compras. Cuando los 15 carritos están ocupados, los clientes esperan afuera del
supermercado a que se desocupe uno de estos carritos y así poder entrar al supermercado
a comprar. Cada cliente demora en realizar sus compras un tiempo aleatorio entre 4”-7” y
cada cajero demora en atender a cada cliente un tiempo aleatorio entre 2”- 4”. Debe
mostrar un mensaje indicando que el “Cliente X entró al Súper y tomó el carrito Y”, otro
mensaje cuando el “Cliente X está comprando”, otro mensaje cuando “Cliente X está
pagando en la caja” y un último mensaje cuando “Cliente X abandona el Súper”. Los
clientes llegan de forma indefinida al supermercado en un tiempo aleatorio entre 300ms y
500ms.
*/
public class Punto3 {

	public static void main(String[] args) {

		final int numCarritos=20;
		
		Semaphore cajas = new Semaphore(3);
		Semaphore []carrito = new Semaphore[numCarritos];
		Random rand = new Random();
		
		for (int i = 0; i < numCarritos; i++) {
        	carrito[i] = new Semaphore(1);
		}
		
		
		int i=1;
		while(true) {
			new Cliente(i, cajas,carrito,rand).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
		
	}
	
	
	
	

	
	
	
	static class Carrito extends Thread{
		private final int id;
        private final Semaphore carrito;
		
		public Carrito(int id, Semaphore carrito, Random rand) {
            this.id = id;
            this.carrito = carrito;
		}
		
        public void run() {
        	while(true) {
        		try {
        			carrito.acquire();
        			carrito.release();
        		}catch (InterruptedException e) {}
        	}	
        }     
	}
	
	
	
    static class Cliente extends Thread {
        private final int id;
        private final Semaphore cajas;
        private final Random rand;
        private final Semaphore[] carrito;

        public Cliente(int id, Semaphore cajas, Semaphore[] carrito,  Random rand) {
            this.id = id;
            this.cajas = cajas;
            this.carrito=carrito;
            this.rand = rand;
        }

        public void run() {
        	
        	int numCarrito=0;
            boolean tieneCarrito=false;
			while (!tieneCarrito) {
			    for (int i = 0; i < carrito.length; i++) {
			        if (carrito[i].tryAcquire()) { // Intenta adquirir una caja disponible
			            System.out.println("Cliente "+id+" entró al Súper y tomó el carrito "+(i+1));
			            tieneCarrito=true;
			            numCarrito=i;
			            break;
			        }		        
			    } 
			}
			
			System.out.println("Cliente " + id + " esta comprando.");
            try {
				Thread.sleep(8000);
				cajas.acquire();
	            System.out.println("Cliente "+id+" esta pagando en la caja");
	            Thread.sleep(2000);

				
				
			} catch (InterruptedException e1) {e1.printStackTrace();
			}finally {
	            cajas.release();
	            carrito[numCarrito].release(); 
	            System.out.println("Cliente " + id + " abandona el Súper.");
			}
            
            
            
            

           
            
            
            
        }
    }
	
	
}




/*



public class Punto3 {
    public static void main(String[] args) {
        final int NUM_CAJAS = 3;
        final int NUM_CARRITOS = 15;

        Semaphore carritos = new Semaphore(NUM_CARRITOS);
        Semaphore[] cajas = new Semaphore[NUM_CAJAS];
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new Semaphore(1);
        }

        Random rand = new Random();

        // Generamos los clientes
        for (int i = 1; ; i++) {
            new Cliente(i, carritos, cajas, rand).start();
            try {
                Thread.sleep(rand.nextInt(201) + 300); // Entre 300ms y 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Cliente extends Thread {
        private final int id;
        private final Semaphore carritos;
        private final Semaphore[] cajas;
        private final Random rand;

        public Cliente(int id, Semaphore carritos, Semaphore[] cajas, Random rand) {
            this.id = id;
            this.carritos = carritos;
            this.cajas = cajas;
            this.rand = rand;
        }

        public void run() {
            try {
                // Esperar a que haya un carrito disponible
                carritos.acquire();
                System.out.println("Cliente " + id + " entró al Súper y tomó el carrito");

                // Realizar compras
                Thread.sleep(rand.nextInt(4) + 4); // Entre 4" y 7"
                System.out.println("Cliente " + id + " está comprando");

                // Esperar a que una caja esté disponible
                int cajaIndex = -1;
                while (cajaIndex == -1) {
                    for (int i = 0; i < cajas.length; i++) {
                        if (cajas[i].tryAcquire()) {
                            cajaIndex = i;
                            break;
                        }
                    }
                    if (cajaIndex == -1) {
                        Thread.sleep(100); // Esperar y volver a intentar
                    }
                }

                // Pagar en la caja
                System.out.println("Cliente " + id + " está pagando en la caja " + (cajaIndex + 1));
                Thread.sleep(rand.nextInt(3) + 2); // Entre 2" y 4"

                // Liberar el carrito y la caja
                carritos.release();
                cajas[cajaIndex].release();

                System.out.println("Cliente " + id + " abandonó el Súper");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
*/