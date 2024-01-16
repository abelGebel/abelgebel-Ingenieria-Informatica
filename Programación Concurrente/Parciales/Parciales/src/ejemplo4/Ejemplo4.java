package ejemplo4;

/*
Genere un array de tipo Long de 30 posiciones. Debe lanzar tandas de 5 hilos concurrentes
para que vayan llenando dichas posiciones (desde la posición 0 a la 29), es decir, cuando los
primeros 5 hilos hayan finalizado, debe lanzar otros 5 hilos nuevos y así hasta completar las 30
posiciones. Cada posición del array es el resultado de una función llamada compute(Random r).
Importante: Inicialice una única semilla Random para todo el procedimiento.
Al finalizar el llenado muestre el array completo y el tiempo de ejecución total.
*/

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ejemplo4 {

    public static void main(String[] args) {
        Random random = new Random(); // inicializa una única semilla Random

        Long[] array = new Long[30];
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int posicionActual = 0;
        
        while (posicionActual < 30) {
            for (int i = 0; i < 5; i++) {
                    int posicion = posicionActual++;
                    Runnable tarea = new Tarea(posicion, array, random);
                    executorService.submit(tarea);          
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Array completo:");
        for (Long valor : array) {
            System.out.println(valor);
        }    
    }
    
    
    static class Tarea implements Runnable {
        private int posicion;
        private Long[] array;
        private Random ran;

        public Tarea(int posicion, Long[] array, Random ran) {
            this.posicion = posicion;
            this.array = array;
            this.ran = ran;
        }

        @Override
        public void run() {
            Long valor = compute(ran);
            array[posicion] = valor;
            System.out.println("Posicion " + posicion + " calculada por hilo " + Thread.currentThread().getName());
        }

        private Long compute(Random ran) {
            // función para calcular el valor de cada posición del array
    		Long aux=ran.nextLong();
    		for(long i=1;i<=50000000;i++) {
    			aux=aux -ran.nextInt(100000);
    		}
    		return aux;
        }
    }

}
