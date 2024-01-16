package ejemplo4Join;

/*
Metodo join(): permite a un hilo quedar a la espera que termine un segundo hilo.
Suele utilizarse para matener un orden en la secuencia de los hilos. Así, se puede arancar
una secuencia de hilos llamando a join() para que cada uno finalice en el orden que se ha
marcado según la llamada a join(). Es obligatorio controlar los métodos join() y sleep() 
mediante exepcion.
*/

public class TestDosHilos {
public static void main(String[] args) {
    UnHilo h1 = new UnHilo("hilo1");
    UnHilo h2 = new UnHilo("hilo2");

    h1.start();
    h2.start();

    try {
        h1.join();
        h2.join();

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Fin del programa");

}
}

