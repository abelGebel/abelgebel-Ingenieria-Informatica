package ejemplo4Join;

public class UnHilo extends Thread{
    public UnHilo(String nombreHilo){
        super(nombreHilo);
    }
    public void run(){
        System.out.println(getName());
    }
}

