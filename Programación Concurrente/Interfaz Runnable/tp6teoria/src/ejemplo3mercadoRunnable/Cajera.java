package ejemplo3mercadoRunnable;
/*
Se simula el procesode cobro de un mercado, donde:
_Los clientes adquieren productos
_Una cajera cobra los productos, pasándo uno a un por el escaner de la caja. La cajera debe
procesar la compra cliente a cliente, primero le cobra al cliente 1, luego al 2,etc

Se define una clase "Cajera" y una clase "Cliente", la que tiene un "array de enteros" que 
representa los productos que se compraron y el timepo que la cajera tarda en pasar el
producto x el escaner.
*/


public class Cajera {
    private String nombre;

    public Cajera (String nombre){
        super();
        this.nombre=nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp){
        System.out.println("La cajera "+ this.nombre + "COMIENZA A PROCESAR LA COMPRA DEL CLIENTE" 
        + cliente.getNombre()+" EN EL TIEMPO: "+ (System.currentTimeMillis()-timeStamp)/1000+"seg");
    
        for (int i=0;i<cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("La cajera "+nombre+" ha procesado el producto "+(i+1)+" del cliente "+cliente.getNombre()
            +" -> Tiempo: "+ (System.currentTimeMillis()-timeStamp)/1000+"seg");
        }

        System.out.println("La cajera "+this.nombre + " HA TERMINADO DE PROCESAR "+cliente.getNombre()
        +" EN EL TIEMPO: "+ (System.currentTimeMillis()-timeStamp)/1000+"seg");
    }

    private void esperarXsegundos(int segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (Exception e) {}
    }

}