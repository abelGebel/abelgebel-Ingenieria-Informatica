package punto1;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class Principal {
	
	static Semaphore tubo1=new Semaphore(20,true);
	static Semaphore tubo2=new Semaphore(30,true);
	static Semaphore tubo3=new Semaphore(30,true);


	public static void main(String[] args) {
        Random ran= new Random();   
        String categoria="";
        int edad;
        for(int i = 1; i<=50;i++) {
        	try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	edad=ran.nextInt(71)+10;
        	
			if(edad>=10 && edad<=20) {
				categoria="Joven";
			}
			if(edad>=21 && edad<=45) {
				categoria="Adulto";
			}
			if(edad>=46 && edad<=70) {
				categoria="Adulto Mayor";
			}
			if(edad>=71 && edad<=80) {
				categoria="Anciano";
			}
        	
            Humano humano = new Humano(i,edad,ran,categoria);
            humano.start();
            System.out.println("Se lanzo el humano "+i +", "+categoria+", edad: "+edad);
        }

	}
	
	
	static class Humano extends Thread{
		
		int id,edad;
		String categoria;
		Random ran;
		public Humano(int id, int edad, Random ran,String categoria) {
			this.id=id;
			this.edad=edad;
			this.ran=ran;
			this.categoria=categoria;
		}
		
		
		public void run() {
			if(categoria.equals("Joven")) {
				try {		
					tubo1.acquire(1);
					Thread.sleep(100+ran.nextInt(500));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 1");
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}finally {
					tubo1.release(1);
				}
				
				try {
					tubo2.acquire(2);
					Thread.sleep(150+ran.nextInt(100));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 2");
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}finally {
					tubo2.release(2);
				}
				
				try {
					tubo3.acquire(3);
					Thread.sleep(250+ran.nextInt(10000));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 3");
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}finally {
					tubo3.release(3);
				}
			}
			
			
			if(categoria.equals("Adulto")) {
				
				try {
					tubo1.acquire(2);
					Thread.sleep(50+ran.nextInt(500));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo1.release(2);
				}
				
				try {
					tubo2.acquire(2);
					Thread.sleep(100+ran.nextInt(100));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo2.release(2);
				}
				
				try {
					tubo3.acquire(3);
					Thread.sleep(200+ran.nextInt(10000));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 3");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo3.release(3);
				}	
			}
			
			
			if(categoria.equals("Adulto Mayor")) {

				try {
					tubo1.acquire(3);
					Thread.sleep(200+ran.nextInt(1000));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo1.release(3);
				}
				
				try {
					tubo2.acquire(2);
					Thread.sleep(300+ran.nextInt(450));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo2.release(2);
				}
				
				try {
					tubo3.acquire(3);
					Thread.sleep(450+ran.nextInt(15000));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 3");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo3.release(3);
				}
			}
			
			
			if(categoria.equals("Anciano")) {

				try {
					tubo1.acquire(4);
					Thread.sleep(300+ran.nextInt(100));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo1.release(4);
				}
				
				try {
					tubo2.acquire(3);
					Thread.sleep(450+ran.nextInt(150));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo2.release(3);
				}
				
				try {
					tubo3.acquire(2);
					Thread.sleep(600+ran.nextInt(20000));
					System.out.println("Humano" +id+", "+categoria+", edad: "+edad+" termino el uso del tubo 3");					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					tubo3.release(2);
				}
			}
		}
	
		
	}

}
