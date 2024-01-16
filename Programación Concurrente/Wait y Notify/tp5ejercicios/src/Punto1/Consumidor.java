package Punto1;

import java.util.ArrayList;
import java.util.Random;

public class Consumidor extends Thread{

    private ArrayList<Integer>lista;
    private int num;
    public Consumidor(ArrayList<Integer>lista,int num){
        this.num=num;
        this.lista=lista;
    }
    
    public void run(){
        try {

        Random random = new Random();
        Thread.sleep(random.nextInt(4000)+400);
        synchronized(lista){
            while(lista.size()==0){
                System.out.println("Consu ("+num+"): No hay elementos para consumir, me duermo");
                lista.wait();
                System.out.println("Consu ("+num+") Me despertaron");
            }
            int consumido=lista.remove(0);//Elprimere elementos producido tinene qe se el primero en se savado            
            lista.notify();
            System.out.println("Consu ("+num+") Consumido: "+consumido);
            System.out.println("Consu("+num+"): Notificando...");

        }
        } catch (InterruptedException e) {e.printStackTrace();}
    }
}