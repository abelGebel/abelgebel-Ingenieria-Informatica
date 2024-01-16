package ejemplo5Contador;

/*
La clase HiloContador es el hilo que ejecuta la región crítica. Tiene un bucle en 10 iteraciones en el 
que se incrementa en 1 el valor de la variable contador. Finalmente, cada hilo habrá aumentado
en 10 unidades el valor inicial que tenía el contador.
*/

import java.util.Random;

public class HiloContador extends Thread{
private Contador contador;
Random random=new Random();
public HiloContador(String nNombre,Contador nContador){
    super(nNombre);
    contador=nContador;
}

/*
    Se inttrodujo un tiempo de espera con sleep() entre la recogida del valor de contador (getContador()) y
    su asignación con su incremento en 1 (setContador()) para que la CPU no realice de una sola vez todo
    un hilo y despues el otro. 
*/
/*
public void run(){
    try {
        for (int j = 0; j <10; j++) {
            int i =contador.getContador();
            sleep(random.nextInt(1));
            contador.setContador(i+1);
            System.out.println(getName()+" pone el contador a "+(i+1));
        }
    } catch (Exception e) {}
}
*/
/* 
public void run(){
    try {
        synchronized(contador){
            for (int j = 0; j <10; j++) {
                int i =contador.getContador();
                sleep(random.nextInt(1));
                contador.setContador(i+1);
                System.out.println(getName()+" pone el contador a "+(i+1));
            }
        } 
    } catch (Exception e) {}
}
*/

public void run(){
    try {
            for (int j = 0; j <10; j++) {
                synchronized(contador){
                int i =contador.getContador();
                sleep(random.nextInt(1));
                contador.setContador(i+1);
                System.out.println(getName()+" pone el contador a "+(i+1));
            }}
        
    } catch (Exception e) {}
}


}