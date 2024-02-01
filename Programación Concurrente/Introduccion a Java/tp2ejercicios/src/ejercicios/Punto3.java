package ejercicios;
import java.util.Random;
import java.util.Scanner;

//Dado un tablero de ajedrez de 10x10, y pidiendo al usuario que ingrese una posición
//cualquiera. Simular desde dicha posición 5 movimientos del "caballo" de forma aleatoria.
//Mostrar en cada movimiento, las posibles posiciones a las cuales puede saltar el caballo, es
//decir, el conjunto de movimientos posibles. Se debe mostrar en todo momento la posición
//actual y la posición siguiente. Las posiciones no deben ser “hardcodeadas”, sino calculadas
//de forma aleatoria y verificadas.

public class Punto3 {

	public static void main(String[] args) {
		
		int tablero[][]=new int[10][10];
		int x,y,direccion,movimiento,xInicial,yInicial;
		Scanner input = new Scanner(System.in); 
		Random random = new Random();
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				tablero[i][j]=0;
			}
		}
		
		System.out.println("Ingrese las cordenadas iniciales:");
		x=input.nextInt();
		y=input.nextInt();
		x--;y--;
		tablero[x][y]=1;
		movimiento=2;
		xInicial=x;
		yInicial=x;
		
		
		while(movimiento<7) {
			
			direccion=random.nextInt(1,9);
			try {
				switch(direccion) {
				case 1:
					x-=2;
					y+=1;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 2:
					x-=1;
					y+=2;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 3:
					x+=1;
					y+=2;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 4:
					x+=2;
					y+=1;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 5:
					x+=2;
					y-=1;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 6:
					x+=1;
					y-=2;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 7:
					x-=1;
					y-=2;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				case 8:
					x-=2;
					y-=1;
					tablero[x][y]=movimiento;
					mostrarTablero(tablero, movimiento,x ,y );
					movimiento+=1;
					xInicial=x;
					yInicial=y;
					break;
				}
			}catch (Exception e) {
				x=xInicial;
				y=yInicial;
			}			
		}
	}
		
	
	public static void mostrarTablero(int[][] tablero,int movimiento,int x, int y) {
		int aux=1;
		System.out.println((movimiento-1)+"° movimiento");
		System.out.println("Posicion inicial = "+(movimiento-1));
		System.out.println("Posibles movimientos = X");
		System.out.println("Posicion final = "+movimiento);
		/*
		while(aux<9){
			try {
				switch(aux) {
				case 1:
					tablero[x-2][y+1]='x';
					aux++;
					break;
				case 2:
					tablero[x-1][y+2]='x';
					aux++;
					break;
				case 3:
					tablero[x+1][y+2]='x';
					aux++;
					break;
				case 4:
					tablero[x+2][y+1]='X';
					aux++;
					break;
				case 5:
					tablero[x+2][y-1]='X';
					aux++;
					break;
				case 6:
					tablero[x+1][y-2]='X';
					aux++;
					break;
				case 7:
					tablero[x-1][y-2]='X';
					aux++;
					break;
				case 8:
					tablero[x-2][y-1]='X';
					aux++;
					break;
				
				}	
			}catch(Exception e) {
				aux++;
			}
			

		}
		*/
		
		
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(tablero[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(tablero[i][j]=='X') {
					tablero[i][j]='0';
				}
			}
		}
		*/
	}

}
