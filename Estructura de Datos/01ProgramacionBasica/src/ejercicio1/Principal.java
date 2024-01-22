package ejercicio1;
import a.Helper;
import java.util.Scanner;

/*
Dadas las longitudes de cuatro segmentos correspondientes a una figura geométrica, 
determinar si la misma se trata de un cuadrado, de un rectángulo o de otro polígono. 
Si la figura es un cuadrado, calcular su perímetro. Si es un rectángulo, calcular su 
superficie. La entrada de datos debe continuar en tanto los segmentos ingresados 
sean valores positivos. Determinar la mayor superficie y el menor perímetro calculados. 
Además, informar cuantas figuras de las dadas no corresponden ni a un cuadrado ni a un
rectángulo.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, 
se espera que el código controle los problemas que normalmente ocurren al operar con 
la consola o teclado. Se espera una correcta modularización entre el código que realiza 
el ingreso y validación de los datos respecto del código que hace lo que se solicita 
en el ejercicio.
*/

public class Principal {

	static double superficieMax;
	static boolean bandSuperficie =false;
	
	static double perimetroMin;
	static boolean bandPerimetro=false;
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("----------Inicio del programa----------");
		System.out.println();	
		ingresarSegmentos(input);
		System.out.println();
		System.out.println("----------Fin del programa-------------");
	}

	private static void ingresarSegmentos(Scanner input) {
		double seg1, seg2, seg3, seg4;
		
		while(true) {
			System.out.println("(Ingrese un valor menor o igual a cero para finalizar...)");
			System.out.println();
			seg1=Helper.getFloat(input, "Ingrese la longitud del primer segmento:","INGRESO NO VALIDO...");
			if(seg1<=0) {break;}
			seg2=Helper.getFloat(input, "Ingrese la longitud del segundo segmento:","INGRESO NO VALIDO...");
			if(seg2<=0) {break;}
			seg3=Helper.getFloat(input, "Ingrese la longitud del tercer segmento:","INGRESO NO VALIDO...");
			if(seg3<=0) {break;}
			seg4=Helper.getFloat(input, "Ingrese la longitud del cuarto segmento:","INGRESO NO VALIDO...");
			if(seg4<=0) {break;}
			
			Figura figura = new Figura(seg1,seg2,seg3,seg4);
			
			if(figura.esCuadrado()) {
				calcularPerimetro(seg1);
			}else if(figura.esRectangulo()){
				calcularSuperficie(figura.ladoA(),figura.ladoB());
			}else {
				figura.esPoligono();
			}
		}
		System.out.println();
		System.out.println("Mayor superficie ingresada: "+superficieMax);
		System.out.println("Menor perimetro ingresado: "+perimetroMin);
		System.out.println("Cantidad del resto de poligonos "+Figura.contPoligonos);
	}

	private static void calcularSuperficie(double ladoA, double ladoB) {
		double superficie=ladoA*ladoB;
		System.out.println("La figura es un regtangulo");
		System.out.println("Su superficie es "+superficie);
		System.out.println();
		if(!bandSuperficie) {
			bandSuperficie=true;
			superficieMax=superficie;
		}else {
			if(superficie>superficieMax) {
				superficieMax=superficie;
			}
		}
	}

	private static void calcularPerimetro(double seg) {
		double perimetro = seg*4;
		System.out.println("La figura es un cuadrado");
		System.out.println("Su perimetro es "+perimetro);
		System.out.println();
		if(!bandPerimetro) {
			bandPerimetro=true;
			perimetroMin=perimetro;
		}else {
			if(perimetro<perimetroMin) {
				perimetroMin=perimetro;
			}
		}
	}
	
}
