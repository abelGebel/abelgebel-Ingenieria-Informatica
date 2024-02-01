package punto1;
/*
Implemente, mediante Hilos heredando de Thread, un programa que emplee un semáforo
general inicializado en 3 y simplemente cada hilo duerma por 5”. Debe indicar el
momento antes de empezar a dormir y cuando deja de dormir. Observar el orden de
ejecución de los hilos pasando por parámetro el nombre del mismo. Debe lanzar 10 hilos.
*/

public class Principal {
    public static void main(String[] args) {
        
        for(int i=0;i<10;i++){
            Semaforo sem=new Semaforo();
            sem.start();
        }
    }
}
