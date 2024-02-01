package punto2;

import java.util.concurrent.Semaphore;

public class Supermercado {

    private static final int NUM_CAJAS = 3;
    private static final int NUM_CLIENTES = 50;

    private Semaphore[] cajas;
    private Semaphore colaEspera;
    private int clienteActual;

    public Supermercado() {
        cajas = new Semaphore[NUM_CAJAS];
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new Semaphore(1);
        }
        colaEspera = new Semaphore(1);
        clienteActual = 1;
    }

    public void atenderCliente() throws InterruptedException {
        // El cliente toma un lugar en la cola de espera
        colaEspera.acquire();
        int numCliente = clienteActual++;
        System.out.println("Cliente " + numCliente + " llega al supermercado");

        // El cliente espera a que haya una caja disponible
        for (int i = 0; i < NUM_CAJAS; i++) {
            if (cajas[i].tryAcquire()) {
                System.out.println("Cliente " + numCliente + " es atendido en la caja " + (i+1));
                Thread.sleep((long) (Math.random() * 2000) + 1000); // tiempo variable entre 1" y 3"
                System.out.println("Cliente " + numCliente + " termina de ser atendido en la caja " + (i+1));
                cajas[i].release();
                break;
            }
        }

        // El cliente sale de la cola de espera
        colaEspera.release();
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Thread[] clientes = new Thread[NUM_CLIENTES];
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes[i] = new Thread(() -> {
                try {
                    supermercado.atenderCliente();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            clientes[i].start();
        }

        // Uno de los cajeros se va al baño y vuelve después de 15 segundos
        try {
            supermercado.cajas[0].acquire();
            System.out.println("Cajero 1 se va al baño");
            Thread.sleep(15000);
            supermercado.cajas[0].release();
            System.out.println("Cajero 1 vuelve del baño");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperamos a que todos los clientes hayan sido atendidos
        for (int i = 0; i < NUM_CLIENTES; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}