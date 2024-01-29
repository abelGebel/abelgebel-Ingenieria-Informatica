package punto3;
import java.util.Random;
import java.util.Scanner;

public class Punto3 {

	public static void main(String[] args) {
		System.out.println("------------------------------------------------");
		System.out.println("CREAR TRES LISTAS A PARTIR DE UNA LISTA PRICIPAL");
		System.out.println("------------------------------------------------");
	
		//creacion de objetos
		Helper helper=new Helper();
		Random random =new Random();		
		SimpleLinkedList list=new SimpleLinkedList();
		Scanner input=new Scanner(System.in);
		
		Integer opcion=0;
		
		//region menu
		opcion=menu(input,opcion,helper);
		if (opcion==1) {
			list=ingresoManual(input,list);
		}else {
			list=ingresoRandom(list,random);
		}
		crearListas(list);
	}
	
	
	//region de ingreso de datos
	public static SimpleLinkedList ingresoManual(Scanner input, SimpleLinkedList list) {
	
		char car;
		int N=Helper.getInteger(input,"Cuantos caracteres desea ingresar?: ","Ingrese una cantidad valida");
		
		while(N>0) {
			car=Helper.getCharacter(input,"Ingrese un caracter: ");
			list.addLast(car);
			N-=1;
		}
		System.out.println("Caracteres ingresados: ");
		System.out.println(list.toString());
		return list;
	}

	public static SimpleLinkedList ingresoRandom(SimpleLinkedList list, Random random) {
		
		Integer N=random.nextInt(10,20);
		System.out.println("Cantidad de caracteres generados: " + N);
		for(int i=0; i<N;i++) {
			list.addLast(Helper.caracterRandom(random));
		}
		System.out.println(list.toString());
		return list;
	}

	
	
	public static void crearListas(SimpleLinkedList list) {
		char car;
		SimpleLinkedList vocales=new SimpleLinkedList();
		SimpleLinkedList consonantes=new SimpleLinkedList();
		SimpleLinkedList simbolos=new SimpleLinkedList();
		
		while(list.count!=0) {
			car=(char) list.removeFirst();
			car=Character.toLowerCase(car);
			if (!Character.isLetter(car)) {
				simbolos.addLast(car);
			}else if (car=='a'||car=='e'||car=='i'||car=='o'||car=='u') {
				vocales.addLast(car);
			}else {
				consonantes.addLast(car);
			}
		}
		System.out.println("vocales:");
		System.out.println(vocales.toString());
		
		System.out.println("consonantes:");
		System.out.println(consonantes.toString());
		
		System.out.println("simbolos:");
		System.out.println(simbolos.toString());	
	}

	
	public static Integer menu(Scanner input, Integer opcion, Helper helper) {
		System.out.println();
		System.out.println("1) Ingresar datos por teclado");
		System.out.println("2) Generar datos de forma aleatoria");
		
		while(true) {
			opcion=helper.getInteger(input,"Ingrese una opcion: ");
			if (opcion==1 || opcion==2) {
				break;
			}else {
				System.out.println("Ingrese una opcion valida... ");
			}
		}
		return opcion;
	}
}