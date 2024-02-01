package punto4;

import java.util.Random;


/*
En una ciudad existe un puente muy angosto en el que sólo pueden circular autos en un
único sentido, de izquierda a derecha o de derecha a izquierda. Cada auto demora en
cruzar el puente un tiempo aleatorio entre 3” y 5”. En cualquier momento pueden llegar
autos a cruzar en un sentido u otro. Debe implementar dicha simulación mostrando por
pantalla cuando un auto (con un número) llega a uno de los extremos (IZQ o DER),
cuando inicia el cruzado del puente (desde un sentido al otro) y cuando finaliza el
cruzado del puente. Los autos son indefinidos y pueden llegar a cualquiera de los 
extremos en un tiempo aleatorio entre 2” y 4”. Para que el cruzado de los autos sea
equitativo, implemente algún control para que como máximo pasen 15 autos en un
sentido y luego en el otro.
a) Simule la situación para que el puente solo permita cruzar a un (1) solo auto al
mismo tiempo en un mismo sentido.
b) Simule la situación para que el puente permita cruzar hasta 5 (cinco) autos al
mismo tiempo en un mismo sentido.
*/
public class Principal {

	public static void main(String[] args) {
		Semaforo semaforo=new Semaforo(1);
		int idAuto=1;
		Random random = new Random();
		int direccion;
		
		while(true) {
			
			try {
				direccion=random.nextInt(2);
				if(direccion==0) {
					AutoIzquierda autoIzquierda=new AutoIzquierda(idAuto,semaforo);
					autoIzquierda.start();
				}else {
					AutoDerecha autoDerecha=new AutoDerecha(idAuto,semaforo);
					autoDerecha.start();
				}
				Thread.sleep(random.nextInt(200)+200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			idAuto++;

		}


	}

}
