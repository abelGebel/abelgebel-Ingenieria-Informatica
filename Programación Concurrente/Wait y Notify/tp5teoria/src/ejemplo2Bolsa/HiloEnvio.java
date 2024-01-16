package ejemplo2Bolsa;

/*
Construimos un Thread que cuando la bolsa este llena la envía. Este Hilo se encarga de sacar por
pantalla el mensaje de "Enviando la bolsa con X elementos". Para ello recibe la Bolsa como parámetro y
chequea que esta llena. Usa un bloque de código sincronizado (syncronized). Este bloque de código
coordina el trabajo entre nuestros dos Thread y permite que un Thread llene la Bolsa y cuando este llena
elotro Thread la envíe.
*/

public class HiloEnvio extends Thread{
private Bolsa bolsa;

public HiloEnvio (Bolsa bolsa){
    super();
    this.bolsa=bolsa;
}

public void run(){
    if(bolsa.estaLlena()!=true){
        try {
            synchronized(bolsa){
                bolsa.wait();
            }
        } catch (Exception e) {}
        
        System.out.println("Enviando la bolsa con " + bolsa.getSize()+" elementos");
    }

}

public Bolsa getBolsa(){
    return bolsa;
}

//public void setBolsa(){this.bolsa=bolsa;}


}
