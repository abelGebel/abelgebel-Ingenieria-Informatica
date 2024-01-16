package ejemplo2Bolsa;

/*
Para rellenar la bolsa usamos el Tread del programa principal que cada segundo añadira un nuevo
elemento a la lista. 
Ambos Threads deben de estar sincronizados ya que hasta que la bolsa no este llena no la podemos
enviar. Para sincronizar el trabajo de los Threads usamos wait notify. HiloEnvio se pondrá a esperar
(wait) hasta que la bolsa este llena antes de enviarla.
*/

public class Principal {
public static void main(String[] args) {
    Bolsa bolsa = new Bolsa();
    HiloEnvio hilo = new HiloEnvio(bolsa);
    hilo.start();
    for (int i = 0; i <= 10; i++) {
        Producto p = new Producto();

        try {
            synchronized(bolsa){
                Thread.sleep(1000);
                if (bolsa.estaLlena()){
                    bolsa.notify();
                }
            }
        } catch (Exception e) {}
        bolsa.addProducto(p);
        System.out.println(bolsa.getSize());
    }
}

//Conviene usar wait notify cuando hay que sacar y agregar elementos.
}
