package punto2;
/*
Simule la atención en un supermercado donde existen 3 cajas. Cada cajero demora en
atender a un cliente un tiempo variable entre 1” y 3”. Suponga que la cola de espera es de
50 clientes. Deberá indicar el Número de cliente que es atendido, cuando comienza la
atención y cuando finaliza la misma. Y para complicarnos la vida, supongamos además
que uno de los 3 cajeros inicia NO Disponible, es decir, uno de los cajeros fue al baño y
vuelve 15” después de haber iniciado la atención sus dos compañeros cajeros.
a. En el primer intento la ejecución debería ser como la indicada arriba.
b. En el segundo intento se le pide que individualice a cada cajero, es decir,
necesitamos saber que cajero atiende a cada cliente, ¿será esto posible? ¿De qué
modo cree que podría resolverlo? Ahora una vez meditado el problema,
resuélvalo.
 */
import java.util.Random;
import java.util.concurrent.Semaphore;




public class Super {
    public static void main(String[] args) {
        final int NUM_CAJAS = 3;
        final int NUM_CLIENTES = 9;
        final int TIEMPO_BAÑO = 5;

        Semaphore[] cajas = new Semaphore[NUM_CAJAS];
        for (int i = 0; i < NUM_CAJAS; i++) {
        	if(i==0) {
        		cajas[i] = new Semaphore(0);
        	}else {
        		cajas[i] = new Semaphore(1);
        	}
            
        }

        Random rand = new Random();

        // Iniciamos los cajeros
        for (int i = 0; i < NUM_CAJAS; i++) {
            if (i == 0) { // El primer cajero inicia NO disponible
                System.out.println("Cajero " + (i+1) + " inicio NO disponible");
            } else {
                System.out.println("Cajero " + (i+1) + " inicio disponible");
            }
            new Cajero(i, cajas[i], rand, TIEMPO_BAÑO).start();
        }


        // Generamos los clientes
        for (int i = 0; i < NUM_CLIENTES; i++) {
            new Cliente(i+1, cajas, rand).start();
        }
    }
    
    
    
    

    static class Cajero extends Thread {
        private final int id;
        private final Semaphore caja;
        private final Random rand;
        private final int tiempoBaño;

        public Cajero(int id, Semaphore caja, Random rand, int tiempoBaño) {
            this.id = id;
            this.caja = caja;
            this.rand = rand;
            this.tiempoBaño = tiempoBaño;
        }

        public void run() {
        	boolean disponible=false;
            while (true) {
                try {
                    if (id == 0 && !disponible) { // El primer cajero inicia NO disponible
                        Thread.sleep(tiempoBaño * 1000);
                        System.out.println("CAJERO " + (id+1) + " VOLVIO");
                        disponible=true;
                        caja.release();
                    }
                    
                    caja.acquire(); // Espera a que un cliente llegue a la caja
                    //int tiempoAtencion = rand.nextInt(3) + 1; // Tiempo de atención aleatorio entre 1" y 3"
                    //System.out.println("Cajero " + (id+1) + " atendiendo al cliente en la caja (" + tiempoAtencion + " seg)");
                    //Thread.sleep(tiempoAtencion * 1000);
                    //System.out.println("Cajero " + (id+1) + " terminó de atender al cliente");
                    caja.release(); // Libera la caja para el siguiente cliente
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    
                }
            }
        }
    }

    static class Cliente extends Thread {
        private final int id;
        private final Semaphore[] cajas;
        private final Random rand;

        public Cliente(int id, Semaphore[] cajas, Random rand) {
            this.id = id;
            this.cajas = cajas;
            this.rand = rand;
        }

        public void run() {
            try {
            	boolean atendido=false;
                // Espera aleatoria antes de dirigirse a una caja
                //Thread.sleep(rand.nextInt(10) * 1000);
                while (!atendido) {
                    for (int i = 0; i < cajas.length; i++) {
                        if (cajas[i].tryAcquire()) { // Intenta adquirir una caja disponible
                            System.out.println("Cliente " + id + " en la caja " + (i+1) + " comenzo a ser atendido");
                            //int tiempoAtencion = rand.nextInt(3) + 1; // Tiempo de atención aleatorio entre 1" y 3"
                            Thread.sleep(3000);
                            System.out.println("Cliente " + id + " en la caja " + (i+1) + " se va.");
                            cajas[i].release(); // Libera la caja
                            atendido=true;
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
            	
            }
        }
    }
}
