package ejemplo1WaitNotify;

public class Saludo {



    public Saludo(){}
    boolean llegoJefe=false;

    public synchronized void saludoEmpleado(String nombre){
        try {
            
            if(llegoJefe==false){
                wait();
                System.out.println(nombre+" buenos dias jefe");
            }else{
                System.out.println(nombre+" perdon por el retraso");
            }
            
            
        } catch (Exception e) {}
    }

    public synchronized void saludoJefe(String nombre){
        System.out.println(nombre+" buenos dias empleados");
        notifyAll();
        llegoJefe=true;
    }
}