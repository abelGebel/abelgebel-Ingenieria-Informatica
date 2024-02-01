package punto1;

import java.util.concurrent.Semaphore;


public class Principal {

	public static void main(String[] args) {
		Semaphore A = new Semaphore(1);
		Semaphore B = new Semaphore(0);
		Semaphore C = new Semaphore(0);
		
		ProcesoA a = new ProcesoA(A,B,C);
		ProcesoB b = new ProcesoB(A,B,C);
		ProcesoC c = new ProcesoC(A,B,C);
		a.start();
		b.start();
		c.start();
	}
	
	static class ProcesoA extends Thread{
		Semaphore a;
		Semaphore b;
		Semaphore c;
		public ProcesoA(Semaphore a, Semaphore b, Semaphore c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
		
		public void run() {
			while(true) {
				try {
					a.acquire();
					System.out.print("A");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					b.release();
				}
			}

		}
		
	}
	
	static class ProcesoB extends Thread{

		Semaphore a;
		Semaphore b;
		Semaphore c;
		public ProcesoB(Semaphore a, Semaphore b, Semaphore c) {
			this.a=a;
			this.b=b;
			this.c=c;		
		}
		
		public void run() {
			while(true) {
				try {
					b.acquire();
					System.out.print("B");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					c.release();
				}
			}

		}
	}
	
	static class ProcesoC extends Thread{
		Semaphore a;
		Semaphore b;
		Semaphore c;
		public ProcesoC(Semaphore a, Semaphore b, Semaphore c) {
			this.a=a;
			this.b=b;
			this.c=c;			
		}
		
		public void run() {
			while(true) {
				try {
					c.acquire();
					System.out.print("C");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					a.release();
				}
			}

		}
		
	}

}