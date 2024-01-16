package ejemplo5Contador;

/*
Contiene el metodo main() que crea un objeto Contador y dos hilos HiloContador, que permite
ver el funcionamiento del programa con dos hilos ejecutándose simultáneamente.
*/
public class TestHiloContador {
public static void main(String[] args) {
    Contador cont = new Contador();
    HiloContador hc1=new HiloContador("hilo 1", cont);
    HiloContador hc2=new HiloContador("hilo 2", cont);
    hc1.start();
    hc2.start();


    try {
        hc1.join();
        hc2.join();

    } catch (InterruptedException e) {e.printStackTrace();}

    System.out.println("El ultimo valor debe ser 10*2=20");
}

/*
    Al ejecutar se parecia que el resultado noes el esperado y que varía cada vez que se ejecuta el programa.
    Esto se debe a que existe una región crítica (la variable contador) que no se controla. Una solución 
    a este problema es utilizar synchronized (nombreDeVariableSeccionCritica) y recoger todo el código
    de la región crítica, en este caso, el método run() del hilo. 

    El programador solo debe preocuparse porque:
        _El programa se ejecuto por "bloques".
        _Pones cada tarea en un hilo de ejcución.
*/
}