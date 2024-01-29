package punto4;
import java.util.Iterator;
import java.util.Scanner;

public class Punto4 {

	public static void main(String[] args) {
		SimpleLinkedList list=new SimpleLinkedList();
		Scanner input=new Scanner(System.in);
		
		
		System.out.print("Ingrese un numero: ");
		int num=input.nextInt();
		
		int primo=2;
		int cont;
		
		
		while(num>=primo) {

			Factor factor=new Factor();

			if(num%primo==0) {
				factor.setNumero(primo);
				cont=0;
				while(num%primo==0) {
					num/=primo;
					cont+=1;
				}
				factor.setExponente(cont);
				
			}
			list.addLast(factor);
			
			primo+=1;

			while(true) {
				boolean esPrimo=true;


				for (int i = 2; i <= primo / 2; i++) {
					if (primo % i == 0) {
						esPrimo=false;
						break;
				    }
				}
				if(esPrimo==true) {
					break;
				}else {
					primo+=1;
				}			
			}		
		}
		

		
		int max=0;
		int exponente;
		Iterator<Factor> iter=list.iterator();
		while(iter.hasNext()) {
				exponente=iter.next().getExponente();
				if (exponente>max) {
					max=exponente;
				}
		}
		
		System.out.println("El mayor exponente es: "+max );
		

	}

}
