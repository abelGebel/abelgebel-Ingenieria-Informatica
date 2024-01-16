package Punto3;

public class Punto3b {

    public static double SumRootN(int root) {
        double result = 0;
        for (int i = 1; i <= 10000000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        return result;
    }

    public static class SumRootNThread extends Thread {
        private int root;

        public SumRootNThread(int root) {
            this.root = root;
        }

        @Override
        public void run() {
            double suma = SumRootN(root);
            System.out.println("Resultado para root = " + root + ": " + suma);
        }
    }

    public static void main(String[] args) {
        int numHilos = 20;
        SumRootNThread[] hilos = new SumRootNThread[numHilos];

        long tiempoInicial = System.currentTimeMillis();

        for (int i = 0; i < numHilos; i++) {
            final int root = i + 1;
            hilos[i] = new SumRootNThread(root);
            hilos[i].start();
        }

        for (SumRootNThread hilo : hilos) {
            try {
                hilo.join(); // Esperar a que todos los hilos terminen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo total de ejecución del programa con hilos: " + (tiempoFinal-tiempoInicial) + " milisegundos");
    }
}
