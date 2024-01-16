package ejemplo1WaitNotify;

/*
A veces conviene que un hilo se boquee a la espera de que ocurra algun evento, como la llegada de un dato.
Todos los objetos java tienen el metodo wait() que deja bloqueado al hilo que lo llama y el metodo notify(), que
que desbloquea a los hilos bloqueados por wait() (modelo productor consumidor)

BLOQUEAR UN HILO 
Las llamadas a wait() lanzan excempciones que hay que capturar, por lo que todas las llamadas
deben estar en un bloque try-cath.
Para que un hilo se bloquee basta con que llame al metodo wait() de cualquier objeto. Es necesario que dicho
hilo haya marcado ese objeto como ocpado con synchronized. Si no, salta una excempcion de que el hilo no 
es propietario del monitor o alg asi.

Si el hilo quiere retirar datos de una lista y nohay datos, puede esperar a que los haya:

synchronized(lista){
    if (lista.size()==0){
        lista.wait();
        dato=lista.get(0);
        lista.remove(0);
    }
}

Se usa synchronized(lista) para "apropiarse" del objeto lista. Si no hay datos se ejecuta lista.wait().
Una vez que realizael el wait(), el objeto lista  se mararca como "desocupado", de forma que otros hilos lo
usen. Cuando se despierta y sale del wait() se marca como "ocupado". 

El hilo  se desbloquea y sale del wait() cuando alguien  llame a lista.notify(). Si el hilo que mete datos
en la lista llama luego a lista.notify(), cuando sale del wait() se tienen datos disponibles en la lista, asi 
que unicamente hay que leerlos (y borrarlos para no volve a tratarlos la sigiente vez).

synchronized(lista){
    lista.add(dato);
    lista.notify();
}


Si varios hilos llaman a wait() se bloquena en una lista de espera (el primero que llamo a wait() es el primero
de la lista y el ultimo que llamo el ultimo).

Cada llamada a notify() despierta al primer hilo de la lista de espera, pero no al resto que siguen dormidos. 
Se nesecita hacer tantos notify() como hilos hayan hecho wait() para ir despertandolos de 1 en 1.

Si se hacen vairos notify() antes de que haya hilos en espera, quedan marcados todos esos notify, de forma que
los sigientes hilos que hagan wait() no quedan bloqueados.

Funcionan como contador. Cada wait() mira elcontador y si  es cero o menos se bloquea. Cuando se desbloquea
decrementa el contaodor. Cada notify() incremetna el contador y si se hace 0 o positivo, despierta al 
primer hilo de la cola.

Es buena costumbre "ocultar" la sincronizacion a los hilos de forma que no se depende de que el programador
se acuerde de implementar su hilo correctamente (llamada a synchronized y llamada a wait y notify)

Es conveniente poner la lista de datos dentro de una clase y poner dos metodos synchronized para 
añadir y recoger datos, con el wait y el notify dentro.

public class MiListSincronizada{
    private LinkedList lista = new LinkedList();
    

    public synchronized void addDato(Object dato){
        lista.add(dato);
        lista.notify();
    }
}

public synchronized Object getDato(){
    if (lista.size()==0){
        wait();
        Object dato=lista.get;
        lista.remove();
        return dato;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        Saludo s = new Saludo();//Objeto en común, se encarga del wait y notify.

        Personal Empleado1 = new Personal("Pepe",s,false);
        Personal Empleado2 = new Personal("José",s,false);
        Personal Empleado3 = new Personal("Pedro",s,false);
        Personal Jefe1= new Personal("JEFE",s,true);
        /*
            Instancio los hilos paso como parámetro:
            *Nombre del Hilo
            *Objeto en común (Saludo)
            *Booleano para verificar si es jefe o empleado
            Y luego lanzo los hilos.
        */
        
        Empleado1.start();
        Empleado2.start();
        Empleado3.start();
        Jefe1.start();
    }
}