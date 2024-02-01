package punto3;

public class Client extends Thread {
    private final int clientId;
    private final Supermarket supermarket;

    public Client(int clientId, Supermarket supermarket) {
        this.clientId = clientId;
        this.supermarket = supermarket;
    }

    @Override
    public void run() {
        if (supermarket.getShoppingCart().availablePermits() == 0) {
            System.out.println("Cliente " + clientId + " esta esperando poder entrar al supermercado.");
        }
        try {
            supermarket.getShoppingCart().acquire();
            System.out.println("Cliente " + clientId + " entro al super y tomo un carrito.");
            Thread.sleep(Helper.randomIntNumber(4000,7000));

            if(supermarket.getBox().availablePermits()==0) {
            	System.out.println("Cliente "+clientId+" termino de comprar y esta haciendo fila para pagar");
            }
            supermarket.getBox().acquire();
            System.out.println("Cliente " + clientId + " esta pagando en la caja.");
            Thread.sleep(Helper.randomIntNumber(2000,4000));

            System.out.println("Cliente " + clientId + " abandona el super.");
            supermarket.getShoppingCart().release();
            supermarket.getBox().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
