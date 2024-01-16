package ejemplo2;

import java.util.concurrent.Semaphore;

/*
Una planta de ensamblado de dispositivos posee 3 mesas donde cada una permite el
ensamblado de un único dispositivo al mismo tiempo pero simultáneamente. El armado de un
dispositivo transita por 3 fases, la Fase 1 requiere el empleo de un destornillador y una pinza,
la Fase 2 requiere el empleo de dos sargentos y la Fase 3 requiere el empleo de dos pinzas.
Cada Fase si bien independientes, se realizan en la misma mesa y en el orden mencionado
(Fase 1, 2 y 3), y como habrá observado, con herramientas distintas. Se desea armar un lote de
100 componentes y la empresa solo cuenta con 4 pinzas, 2 destornilladores y 4 sargentos. El
tiempo que insume cada fase está dado por: Fase 1 es T, el de la Fase 2 es ½ de T y el de la
Fase 3 es 2T. Simula la situación empleando semáforos y muestre por pantalla cada etapa del
proceso indicando el estado de avance de cada componente a medida que transita por las
distintas etapas. Tome T = 400ms.
*/
public class Ejemplo2 {
	
	static Semaphore mesas=new Semaphore(3);
	static Semaphore pinzas=new Semaphore(4);
	static Semaphore destornilladores=new Semaphore(2);
	static Semaphore sargentos=new Semaphore(4);


	public static void main(String[] args) {
		
		for(int i=1;i<=20;i++) {
			Thread dispositivo=new Dispositivo(i);
			dispositivo.start();
		}

	}
	
	static class Dispositivo extends Thread{
		
		private int id;
		public Dispositivo(int id) {
			this.id=id;
		}
		
		public void run() {
			
			try {
				destornilladores.acquire();
				pinzas.acquire();
				System.out.println("Dispositivo "+id+" esta en la FASE 1");
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				destornilladores.release();
				pinzas.release();
			}
			
			
			try {
				sargentos.acquire(2);
				System.out.println("Dispositivo "+id+" esta en la FASE 2");
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				sargentos.release(2);
			}

			try {
				pinzas.acquire(2);
				System.out.println("Dispositivo "+id+" esta en la FASE 3");
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pinzas.release(2);
			}
		}
		
	}

}
