package ejemplo6;

public class unaTareaEnUnHilo extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.print(i+",");
        }
    }
}

