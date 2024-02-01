package punto3;

/*Un supermercado posee 3 cajas de atención y 15 carritos para que los clientes realicen las
compras. Cuando los 15 carritos están ocupados, los clientes esperan afuera del
supermercado a que se desocupe uno de estos carritos y así poder entrar al supermercado
a comprar. Cada cliente demora en realizar sus compras un tiempo aleatorio entre 4”-7” y
cada cajero demora en atender a cada cliente un tiempo aleatorio entre 2”- 4”. Debe
mostrar un mensaje indicando que el “Cliente X entró al Súper y tomó el carrito Y”, otro
mensaje cuando el “Cliente X está comprando”, otro mensaje cuando “Cliente X está
pagando en la caja” y un último mensaje cuando “Cliente X abandona el Súper”. Los
clientes llegan de forma indefinida al supermercado en un tiempo aleatorio entre 300ms y
500ms.
*/

public class Main {

    public static void main(String[] args) {
        int clientId = 1;
        Supermarket supermarket = new Supermarket(3, 15);

        while (true) {
            try {
                Client client = new Client(clientId,supermarket);
                client.start();
                Thread.sleep(Helper.randomIntNumber(300,500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clientId++;
        }
    }

}
