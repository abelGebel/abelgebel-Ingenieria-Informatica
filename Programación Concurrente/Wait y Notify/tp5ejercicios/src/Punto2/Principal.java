package Punto2;

/*
Imagine el escenario de una panadería que produce Bizcochos y Facturas que son
colocados en un mostrador, cada cliente se lleva un Bizcocho y una Factura, si los
productos aún no están producidos, los clientes esperan. La producción de elementos y la
compra son indefinidas (una panadería que trabaja las 24hs sin descansar recibiendo en
todo momento clientes compradores). Además hay que destacar que los Bizcochos y
Facturas se producen de a uno por vez, puesto que existen dos hornos muy pequeños y
solo permiten la producción de un elemento de cada tipo en cualquier momento pero
simultáneamente. Simule la situación indicando en cada momento todo lo que sucede en
la Panadería: producción de un Bizcocho, producción de una Factura, cliente comprando,
cliente esperando, cliente retirándose del local y mostrador vacío. Tenga en cuenta que el
tiempo de producción de un Bizcocho es entre 400ms y 600ms, el de una Factura es entre
1000ms y 1300ms, y la llegada de los clientes se produce entre 800ms y 1500ms, la
compra y la retirada de los clientes del local demanda un tiempo entre 200ms y 400ms.
Debe identificar a cada cliente.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		
		List<Integer> bizcocho = new ArrayList<Integer>();
		List<Integer> factura = new ArrayList<Integer>();
		int numero=0; 
		
		Bizcocho Bizcocho = new Bizcocho(bizcocho);
		Bizcocho.start();
		Factura Factura = new Factura(factura);
		Factura.start();
		
		while(true) {
			
			numero+=1;
			Cliente Cliente = new Cliente(bizcocho,factura,numero);
			Cliente.start();
			Random random = new Random();
			 
			try {
				Thread.sleep(random.nextInt((1500 - 800)+1)+800);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
}