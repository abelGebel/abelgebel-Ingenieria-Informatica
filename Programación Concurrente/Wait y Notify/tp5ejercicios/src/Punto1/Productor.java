package Punto1;

import java.util.ArrayList;
import java.util.Random;

public class Productor extends Thread{
    
    private ArrayList<Integer> lista;
    private int num;

    public Productor(ArrayList<Integer>lista,int num){//construcator q recibe la lista
        this.num=num;
        this.lista=lista;//Atributode la clase,hago usodde la listaque pase por el programa prinipal
    }

    public void run(){
        
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(500)+1000);
            synchronized(lista){
            	while(lista.size()>=5) {
            		System.out.println("Prod("+num+") Lista llena: me duermo");
            		lista.wait();
            	}
                int numero = random.nextInt(99);
                lista.add(numero);//Se geneera un numero y se gagrega a la lista
                lista.notify();
                System.out.println("Prod("+num+") agrego el numero: "+numero);
                System.out.println("Prod("+num+"): Notificando...");
                
            }   
        }catch (InterruptedException e) {
                e.printStackTrace();}
        

        /* 

        int numero = random.nextInt((fin-inicio)+1)+inicio;
        
        try {
            Thread.sleep(random.nextInt((S-I)+1)+I);
            synchronized(Lista){
                Lista.add(numero);//Se geneera un numero y se gagrega a la lista
                Lista.notifyAll();
                System.out.println("Prod("+Num+") Numero agregado: "+numero);

            }
            System.out.println("Prod("+Num+"): Notificando...");

                //Thread.sleep(4000);
           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}