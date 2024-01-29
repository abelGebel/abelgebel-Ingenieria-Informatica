package cruce;

import java.util.concurrent.Semaphore;

/*
) En la siguiente imagen, extraída de un cruce de calles, cada auto desea seguir su ruta (a), y de
no tener algún mecanismo de orden o control se producirá un choque, traducido a palabras
informáticas, un interbloqueo (b).
Los cuatro cuadrantes de la intersección son los recursos compartidos sobre los que se
demanda control, si los cuatro coches desean atravesar el cruce, las necesidades de recursos
son las siguientes:
 El coche que va hacia el norte necesita los cuadrantes 1 y 2
 El coche que va hacia el oeste necesita los cuadrantes 2 y 3
 El coche que va hacia el sur necesita los cuadrantes 3 y 4
 El coche que va hacia el este necesita los cuadrantes 4 y 1
Implemente mediante pseudocódigo, usando cualquier mecanismo de sincronización e
identificando cada auto por el sentido hacia donde desea ir (N, S, E y O), una rutina que
permita la circulación de los autos y evite el interbloqueo.
*/
public class Principal {

	static Semaphore sem1=new Semaphore(1,true);
	static Semaphore sem2=new Semaphore(1,true);
	static Semaphore sem3=new Semaphore(1,true);
	static Semaphore sem4=new Semaphore(1,true);
	
	
	public static void main(String[] args) {
		Auto autoO = new Auto("O");

		Auto autoN = new Auto("N");
		Auto autoS = new Auto("S");
		Auto autoE = new Auto("E");
		autoN.start();
		autoS.start();
		autoE.start();
		autoO.start();
	}

	static class Auto extends Thread{
		String id;
		public Auto(String id) {
			this.id=id;
		}
		
		public void run(){
			if(id.equals("N")) {
				
				try {
					sem1.acquire();
					sem2.acquire();
					System.out.println("auto N esta cruzando");
					Thread.sleep(6000);
					System.out.println("auto N cruzo");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					sem1.release();
					sem2.release();
				}
			}
			
			if(id.equals("S")) {
				try {
					sem3.acquire();
					sem4.acquire();
					System.out.println("auto S esta cruzando");
					Thread.sleep(4000);
					System.out.println("auto S cruzo");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					sem3.release();
					sem4.release();
				}
			}
			
			if(id.equals("E")) {
				try {
					sem1.acquire();
					sem4.acquire();
					System.out.println("auto E esta cruzando");
					Thread.sleep(4000);
					System.out.println("auto E cruzo");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					sem1.release();
					sem4.release();
				}
			}
			
			if(id.equals("O")) {
				try {
					sem2.acquire();
					sem3.acquire();
					System.out.println("auto O esta cruzando");
					Thread.sleep(4000);
					System.out.println("auto O cruzo");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					sem2.release();
					sem3.release();
				}
			}
			
			
		}
		
	}
}
