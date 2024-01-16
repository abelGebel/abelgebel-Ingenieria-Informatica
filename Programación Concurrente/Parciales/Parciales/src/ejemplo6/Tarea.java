package ejemplo6;

import java.util.ArrayList;
import java.util.Random;

public class Tarea implements Runnable{

    private  ArrayList<Integer> lista = new ArrayList<>();
    private static Random ran= new Random();
	public void run() {
		
		int numero=ran.nextInt(51)+30;
		int suma=0;
		int promedio=0;
		lista.add(numero);		

		for(int i=0;i<lista.size();i++) {
			suma=suma+lista.get(i);
		}
		promedio=suma/lista.size();

		System.out.println(lista);
		System.out.println("suma actual = "+suma);
		System.out.println("promedio actual: "+promedio);
		if(suma%6==0) {
			System.out.println("ES divisible por 6");
		}else {
			System.out.println("NO es divisible por 6");
		}
		System.out.println();
	}

}
