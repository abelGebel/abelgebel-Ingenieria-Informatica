package ejemplo1WaitNotify;

public class Personal extends Thread {
    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Personal(String nombre,Saludo saludo,boolean esJefe){
        this.nombre=nombre;
        this.saludo=saludo;
        this.esJefe=esJefe;
    }

    public void run(){
        System.out.println(nombre+" llegó.");
        try {
            Thread.sleep(1000);
            if(esJefe){
                saludo.saludoJefe(nombre);
            }else{
                saludo.saludoEmpleado(nombre);
            }
        } catch (Exception e) {}
    }

}
