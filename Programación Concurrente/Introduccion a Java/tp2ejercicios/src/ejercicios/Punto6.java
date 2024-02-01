package ejercicios;
import java.util.Scanner;
//Imprima por pantalla el siguiente patrón empleando bucles for, asteriscos y matrices, y
//según un número entero “n” ingresado por el usuario. Por ejemplo, el siguiente patrón es
//para n=3. Usted debe dejar abierta la cantidad a ingresar para que la impresión sea dinámica.
//* * *	 para n=4 * * * *
// * *			   * * *	
//  *			    * *
// * *			     *
//* * *			    * *
//				   * * *
//				  * * * *

public class Punto6 {

	public static void main(String[] args) {
		int n,limiteInf,limiteSup;
		
		Scanner input = new Scanner(System.in); 
		System.out.print("Ingrese el valor de n: ");
		n=input.nextInt();
		n=n*2-1;
		char matriz[][] = new char[n][n];
		
		//Crear una cruz de * en la matriz
		int aux=0;
		for(int j=0;j<n;j++) {
			matriz[aux][j]='*';
			matriz[(n-1)-aux][j]='*';
			aux+=1;
		}
		
		//Rellenar la parte superior
		limiteInf=0;
		limiteSup=n;	//Estas variables controlan que no se agregen astericos en los costados de la figura
			
		for(int i=0;i<n/2;i++) {
				
			for(int j=limiteInf;j<limiteSup;j++) {
				
				if(matriz[i][j]!='*') {
					if(matriz[i][j-1]==' ' && matriz[i][j+1]==0) {
							matriz[i][j]='*';
					}else {
						matriz[i][j]=' ';
					}
				}
			}
			limiteInf+=1;
			limiteSup-=1;
		}
			
		//Rellenar la parte inferior
		limiteInf=0;
		limiteSup=n;
		
		for(int i=n-1;i>n/2;i--) {
				
			for(int j=limiteInf;j<limiteSup;j++) {
				if(matriz[i][j]!='*') {
					if(matriz[i][j-1]==' ' && matriz[i][j+1]==0) {
							matriz[i][j]='*';
					}else {
						matriz[i][j]=' ';
					}		
				}
			}
			
			limiteInf+=1;
			limiteSup-=1;
		}
		
		//Rellenar los espacios vacios y mostrar la matriz 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matriz[i][j]==0) {
					matriz[i][j]=' ';
				}
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
