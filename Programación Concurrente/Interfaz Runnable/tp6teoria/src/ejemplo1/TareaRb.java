package ejemplo1;

public class TareaRb implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Nombre "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
    
}
