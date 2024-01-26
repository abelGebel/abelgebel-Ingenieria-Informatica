/*  Un preventista de gaseosas debe recorrer una cantidad de N pueblos con el objetivo de concretar pedidos
de su producto. El producto se vende por fardos de 6 unidades y el precio del fardo es “p”. Cada vez que
llega a un pueblo, el preventista toma el pedido de una cantidad de fardos para un solo negocio por pueblo
y registra el importe de la deuda. Tras visitar el último pueblo en el cual se encuentra una de las
distribuidoras de la empresa de gaseosas, el preventista confirma la información de las ventas realizadas y
en función de ello, se prepara el camión de reparto. El repartidor deberá regresar por el mismo camino que
hizo el preventista haciendo las entregas y realizando las cobranzas en base a lo registrado por su
compañero. Realice un programa que permita registrar la información de los pedidos realizados, es decir,
los pueblos visitados por el preventista, el nombre de los negocios cliente, la cantidad de fardos de
gaseosas vendidos en cada pueblo y la deuda a cobrar. Por otra parte, el programa deberá mostrar los
pueblos visitados por el preventista (en el orden en que los visita), los nombres de los negocios cliente, la
cantidad de fardos vendidos y el total de fardos a entregar. Asimismo, se deben presentar los pueblos que
recorre el repartidor (en el orden en que los visita), el monto cobrado en cada pueblo y el total recaudado
en concepto de las deudas cobradas. Para almacenar la información se puede usar objetos de la clase
PuntoDeEntrega, la cual tendrá los atributos: nombre del pueblo, nombre del negocio cliente, cantidad de
fardos de gaseosas, monto de la deuda y estado de la deuda (pendiente o pagado según corresponda). */


package ejercicio06;

import java.util.Random;
import java.util.Scanner;
import a.Helper;

public class Punto6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int opcion=0;
		System.out.println("------------INICIO PROGRAMA------------");
		while(true) {
			opcion=menu(input,opcion);
			if(opcion==1) {
				ingresoManual(input);
			}else if(opcion==2) {
				ingresoAleatorio(ran);
			}else {
				break;
			}	
		}
		System.out.println("FIN PROGRAMA");
	}
	
	private static void ingresoManual(Scanner input) {
		int N=Helper.getIntegerPositivo(input, "Igrese la cantidad de ciudades: ");
		Pila pila=new Pila(N);
		float p = (float) Helper.getFloat(input,"Precio por fardo:");
		
		System.out.println();
		System.out.println("REGISTRO DE PREVENTAS");
		System.out.println("-----------------------------------------------");
		input.nextLine();
		for (int i=0; i<N;i++) {
			
			PuntoEntrega puntoEntrega=new PuntoEntrega();
			System.out.print("Nombre del pueblo: ");
			puntoEntrega.setPueblo(input.nextLine());
			System.out.print("Nombre del negocio: ");
			puntoEntrega.setNegocio(input.nextLine());
			puntoEntrega.setCantFardos(Helper.getInteger(input, "Cantidad de fardos:"));
			puntoEntrega.setMontoDeuda(p*puntoEntrega.getCantFardos());
			puntoEntrega.setEstadoDeuda("Pendiente");
			
			pila.push(puntoEntrega);
			System.out.println(pila.peek().toString());
			System.out.println();

		}
		recorridoRepartidor(pila,p,N);
	}
	
	private static void ingresoAleatorio(Random ran) {
		int N=ran.nextInt(9)+5;
		System.out.println("Cantidad de ciudades: "+ N);
		Pila pila=new Pila(N);
		float p=ran.nextFloat(20)+1;
		int cantFardos;
		System.out.println("Precio por fardo: "+p);
		System.out.println();
		System.out.println("REGISTRO DE PREVENTAS");
		System.out.println("-----------------------------------------------");
		
		for (int i=1; i<=N;i++) {
			cantFardos=ran.nextInt(20)+1;
			PuntoEntrega puntoEntrega=new PuntoEntrega("Pueblo "+i,"Negocio "+i,cantFardos,cantFardos*p,"Pendiente");
			pila.push(puntoEntrega);
			System.out.println(pila.peek().toString());
			System.out.println();
		}
		recorridoRepartidor(pila,p,N);

		
	}

	public static void recorridoRepartidor(Pila pila, float p, int N) {
		float totalRecaudado=0;
		System.out.println("RECORRIDO DEL REPARTIDOR");
		System.out.println("-------------------------------------");
		for (int i=0; i<N;i++) {
			pila.peek().setEstadoDeuda("pagado");
			totalRecaudado+=pila.peek().getMontoDeuda();
			System.out.println(pila.pop());	
		}
		System.out.println("Total recaudado: " + totalRecaudado);
		
	}



	private static int menu(Scanner input, int opcion) {
		System.out.println();
		System.out.println("1) De forma manual");
		System.out.println("2) De forma aleatoria");
		System.out.println("3) Salir");
		System.out.println();
		while(true) {
			opcion=Helper.getIntegerPositivo(input,"Como quiere cargar los datos?: ", "OPCION NO VALIDA...");
			if(opcion>0 && opcion<4) {
				break;
			}else {
				System.out.println("OPCION NO VALIDA...");
			}
		}
		System.out.println();
		return opcion;
	}

}