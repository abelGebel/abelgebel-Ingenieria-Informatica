package ejemplo3mercadoThread;
/*
Se puede procesar dos clientes a la vez si hubiese dos cajeras y seasigna una a cada cliente.
Para ello se modifica la clase "Cajera.java" haciendo que herede de Thread.
*/


public class Cajera extends Thread{
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Cajera (String nombre,Cliente cliente,long initialTime){
        super();
        this.nombre=nombre;
        this.cliente=cliente;
        this.initialTime=initialTime;
    }

    public void run() {
    	System.out.println("La cajera "+ this.nombre + "COMIENZA A PROCESAR LA COMPRA DEL CLIENTE" 
    	+ cliente.getNombre()+" EN EL TIEMPO: "+ (System.currentTimeMillis()-this.initialTime)/1000+"seg");
    	    
    	        for (int i=0;i<cliente.getCarroCompra().length; i++){
    	            this.esperarXsegundos(cliente.getCarroCompra()[i]);
    	            System.out.println("Procesado el producto "+(i+1)+" del cliente " +this.cliente.getNombre()
    	            +" -> Tiempo: "+ (System.currentTimeMillis()-this.initialTime)/1000+"seg");
    	        }

    	        System.out.println("La cajera "+this.nombre + " HA TERMINADO DE PROCESAR "+cliente.getNombre()
    	        +" EN EL TIEMPO: "+ (System.currentTimeMillis()-this.initialTime)/1000+"seg");
    }
    

    private void esperarXsegundos(int segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (Exception e) {}
    }

}