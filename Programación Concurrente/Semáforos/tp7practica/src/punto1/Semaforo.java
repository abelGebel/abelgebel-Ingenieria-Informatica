package punto1;

import java.util.concurrent.Semaphore;

public class Semaforo extends Thread {
    static Semaphore sem = new Semaphore(3);

    public void run(){
        try {
            //sem.tryAcquire();
            //System.out.println("Antes de dormir: "+Thread.currentThread().getName());
            sem.acquire();
            System.out.println("Me duermo ");
            Thread.sleep(500);
            System.out.println("Me despierto ");
        } catch (Exception e) {
        }

        sem.release();
    }
    
}