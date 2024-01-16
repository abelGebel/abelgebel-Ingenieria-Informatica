package ejemplo3Thread;


/*  La clase UnHilo contiene el codigo que ejecuta un hilo.
    La clase Thread tiene un conjunto de metodos que facilitan el trabajo con hilos. En ella se crea: 
    
    1) Un constructor con 1 parametro de entrada tipo String (contiene el nombre del hilo). El mismo 
    llama al constructor de la clase base, enviando el parámetro de entrada con el nombre.

    2) Un metodo run() que tiene el código con el trabajo que debe realizar el Thread (metodo mas importante).
    En este ejemplo solo imprime el nombre del hilo por pantalla.

    3) Para que el hilo se ejecute, se incluye una clase TestUnHilo que tiene el método main(). Se observa que 
    se creó una instancia del objeto UnHilo y se llama a su metodo start(). Este método no esta definido
    en esta clase, sino en la clase base Thread. Al utilizar este método, el objeto desde el qe se lo llama
    (en nuestro caso, unHilo) se pone en ejecución.

    4) El metodo start() hace una serie de procesos e invoca al método run() del hilo.

    5) Un hilo finaliza cuando culmina la escición de su método run() --> ESTADO MUERTO
*/


public class UnHilo extends Thread{
    public UnHilo(String nombreHilo){
        super(nombreHilo);
    }
    public void run(){
        System.out.println(getName());
    }
}
