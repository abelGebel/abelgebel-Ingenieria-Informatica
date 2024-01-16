package ejemplo3mercadoSecuencial;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1=new Cliente("Cliente 1",new int[]{2,2,1,5,2,3});
        Cliente cliente2=new Cliente("Cliente 2",new int[]{1,3,5,1,1});

        Cajera cajera1=new Cajera("Cajera 1");
        Cajera cajera2=new Cajera("Cajera 2");

        long initialTime=System.currentTimeMillis();//Tiempo inicial de referncia

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);

        /*
            Si se ejecuta se observa como se procesa primero la compra del cliente 1 y despues la 
            compra del cliente 2 tardando en procesar ambas compras un tiempo de 26 seg
        */
    }
}