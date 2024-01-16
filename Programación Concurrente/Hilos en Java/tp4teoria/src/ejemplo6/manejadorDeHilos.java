package ejemplo6;

public class manejadorDeHilos {
    public static void main(String[] args) {
        unaTareaEnUnHilo a,b;
        a=new unaTareaEnUnHilo();
        b=new unaTareaEnUnHilo();
        a.start();
        b.start();
        //Compiten entre sí.
        
        /*
            Las dos tareas se han ejecutado a la vez y cuando han podido han ido escribiendo el numero por el 
            que iban contando. Si se ejecuta varias veces el programa se verá que da resultados disntintos. 
            Se podría crear un vector de hilos y que el hilo 1 haga dormir al 2 y cuando haya terminado 
            de ejecutar su tarea que corra el 2. Y de paso un tercer hilo que se ejecute continuamente.
        */
    }
}