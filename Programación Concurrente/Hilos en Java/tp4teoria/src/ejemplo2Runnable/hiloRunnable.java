package ejemplo2Runnable;

public class hiloRunnable implements Runnable{
    public static void main(String[] args) {
        hiloRunnable run = new hiloRunnable();
        Thread hilo1 = new Thread(run);
        hilo1.start();
    }

    @Override
    public void run() {
        System.out.println("Soy "+this.toString()+" Hola");
    }
}
