package punto2;

import java.util.Random;

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
public class Principal {

	public static void main(String[] args) {
		Cajero cajero=new Cajero(3,false);
		int idCliente=1;
		Random random= new Random();
		//CajeroDormido cajeroDormido=new CajeroDormido(cajero);
		//cajeroDormido.start();

		while(idCliente<=10) {
            try {
            	Cliente cliente=new Cliente(idCliente,cajero);
            	cliente.start();
				Thread.sleep(1000);
			} catch (InterruptedException e) {e.printStackTrace();}
            idCliente++;
		}
	}
	


}
