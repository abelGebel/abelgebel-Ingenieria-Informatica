package ejemplo2mostrarCerosUnos;

public class MostrarCeroUnoHiloThread {
    public static void main(String[] args) {
        HiloMostrarCero h1 =new HiloMostrarCero();
        h1.start();
        HiloMostrarUno h2 =new HiloMostrarUno();
        h2.start();
    }
}

    class HiloMostrarCero extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 1000; i++) {
                System.out.print("0-");
            }
        }
    }

    class HiloMostrarUno extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 1000; i++) {
                System.out.print("1-");
            }
        }
    }
