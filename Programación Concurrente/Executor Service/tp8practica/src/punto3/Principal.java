package punto3;
/* Simule la atención en un supermercado donde existen 3 cajas. Cada cajero demora en
atender a un cliente un tiempo variable entre 1” y 3”. Suponga que la cola de espera es de
50 clientes. Deberá indicar por pantalla el Número de cliente que es atendido, cuando
comienza la atención y cuando finaliza la misma.*/

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Principal {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Random ran=new Random();
        for(int i=1;i<=20;i++) {
	        Runnable cliente = new Cliente(i,ran);
	        executorService.submit(cliente);
        }
        executorService.shutdown();
	}
}
