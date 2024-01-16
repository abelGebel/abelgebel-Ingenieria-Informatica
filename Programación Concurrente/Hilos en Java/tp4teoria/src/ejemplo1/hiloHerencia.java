package ejemplo1;

public class hiloHerencia extends Thread {
    public static void main(String[] args) {
        hiloHerencia hilo1 = new hiloHerencia();
        hilo1.setName("Un hilo que hereda de thread");
        hilo1.start();

    }
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Soy " + getName());
    }
}