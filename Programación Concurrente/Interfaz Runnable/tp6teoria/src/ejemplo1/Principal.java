package ejemplo1;

public class Principal {
    public static void main(String[] args) {
        //Se crea un objeto tarearbqe se comparte en cada Thread.
        TareaRb t=new TareaRb();
        //Las tareas son instancias de la clase Thread
        Thread t1 = new Thread(t,"pepe");
        Thread t2 = new Thread(t,"ana");
        Thread t3 = new Thread(t,"juan");
        //Los threads se ponen en ejecucion y compiten entre si
        t1.start();
        t2.start();
        t3.start();
    }
}