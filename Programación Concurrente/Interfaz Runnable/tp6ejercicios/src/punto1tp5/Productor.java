package punto1tp5;

import java.util.ArrayList;
import java.util.Random;

public class Productor {
    
    private ArrayList<Integer> lista;
    private int num;

    public Productor(ArrayList<Integer>lista,int num){//construcator q recibe la lista
        this.num=num;
        this.lista=lista;//Atributode la clase,hago usodde la listaque pase por el programa prinipal
    }

    public void producir(){
        
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000)+1000);
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
    
    }
}