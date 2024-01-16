package ejemplo3Thread;

public class TestUnHilo {
    public static void main(String[] args) {
        UnHilo hilo1 = new UnHilo("Hilo1");
        hilo1.start();
    }
}