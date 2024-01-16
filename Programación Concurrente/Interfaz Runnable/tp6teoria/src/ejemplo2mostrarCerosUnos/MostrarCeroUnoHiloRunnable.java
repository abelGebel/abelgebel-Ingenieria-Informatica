package ejemplo2mostrarCerosUnos;

public class MostrarCeroUnoHiloRunnable {

    public static void main(String[] args) {
        HiloMostrarCero h1=new HiloMostrarCero();
        HiloMostrarUno h2=new HiloMostrarUno();
    }
}

    class HiloMostrarCeros implements Runnable{

        private Thread t;

        public HiloMostrarCeros(){
            t=new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.print("0-");
            }
        }
    }

    class HiloMostrarUnos implements Runnable{

        private Thread t;

        public HiloMostrarUnos(){
            t=new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.print("1-");
            }
        }
    }
    