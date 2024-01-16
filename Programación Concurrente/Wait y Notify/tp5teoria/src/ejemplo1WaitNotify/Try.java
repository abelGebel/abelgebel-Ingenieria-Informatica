package ejemplo1WaitNotify;

public class Try {
    public static void main(String[] args) {
        int [] array=new int[20];
        try{
            int b=0;
            int a=5/b;
            array[-3]=0;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error de indice en un array");
        }catch(ArithmeticException e){
            System.out.println("Error aritmetico");
        }finally{
            System.out.println("Error");
        }

    }
}   