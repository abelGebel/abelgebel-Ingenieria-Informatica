package punto3;

import java.util.concurrent.Semaphore;

public class Supermarket {
    private final Semaphore box;
    private final Semaphore shoppingCart;

    public Supermarket(int numBox, int numShoppingCart) {
        this.box = new Semaphore(numBox);
        this.shoppingCart = new Semaphore(numShoppingCart);
    }

    public Semaphore getBox() {
        return box;
    }

    public Semaphore getShoppingCart() {
        return shoppingCart;
    }

}
