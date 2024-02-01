package ejercicios;
import java.util.Random;

//Sopa de Letras: defina una matriz de caracteres de 12 x 12. Programáticamente disponga las
//siguientes palabras en distintas posiciones (no está permitido que todas las palabras estén
//dispuestas de arriba a abajo y de izquierda a derecha) y asegúrese de que todas quepan. A
//continuación rellene los espacios en blanco con caracteres aleatorios. Muestre el resultado final.
//Palabras: CAMELLO, ELEFANTE, AGUILA, CAMALEON, AVESTRUZ, COCODRILO,ANTILOPE, SERPIENTE, BUFALO, COMADREJA.

public class Punto2 {

	public static void main(String[] args) {
		Random random=new Random();
		
		char[][] matriz= new char[12][12];
		char[] p1 = {'C','A','M','E','L','L','O'};
		char[] p2 = {'E','L','E','F','A','N','T','E'};
		char[] p3 = {'A','G','U','I','L','A'};
		char[] p4 = {'C','A','M','A','L','E','O','N'};
		char[] p5 = {'A','V','E','S','T','R','U','Z'};
		char[] p6 = {'C','O','C','O','D','R','I','L','O'};
		char[] p7 = {'A','N','T','I','L','O','P','E'};
		char[] p8 = {'S','E','R','P','I','E','N','T','E'};
		char[] p9 = {'B','U','F','A','L','O'};
		char[] p10 = {'C','O','M','A','D','R','E','J','A'};
		
		matriz=cargarPalabra(matriz,p1,random);
		matriz=cargarPalabra(matriz,p2,random);
		matriz=cargarPalabra(matriz,p3,random);
		matriz=cargarPalabra(matriz,p4,random);
		matriz=cargarPalabra(matriz,p5,random);
		matriz=cargarPalabra(matriz,p6,random);
		matriz=cargarPalabra(matriz,p7,random);
		matriz=cargarPalabra(matriz,p8,random);
		matriz=cargarPalabra(matriz,p9,random);
		matriz=cargarPalabra(matriz,p10,random);
		
		//Se rellena la matriz con caracteres aleatorios
		for (int i = 0; i < 12; i++) {
		    for (int j = 0; j < 12; j++) {
		    	if (matriz[i][j]==0){
		    		matriz[i][j] = (char)(Math.random() * 26 + 'A');    		
		    	}	
		    }
		}
		
		//Se muestra el resultado
		for(int i=0; i<12;i++) {
			for(int j=0; j<12; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	public static char[][] cargarPalabra(char[][] matriz, char[] palabra,Random random) {
		
		int direccion,fila,columna,n=palabra.length;
		boolean sePuedeCargar;
		
		while (true) {	//Hasta que la palabra no entre en alguna direccion no se sale del bucle
			
			direccion=random.nextInt(1,7);
			fila=random.nextInt(12);
			columna=random.nextInt(12);
			
			sePuedeCargar=verificarPalabra(matriz,palabra,n,direccion,fila,columna);
			
			if(sePuedeCargar==true) {
				
				if(direccion==1) {	//Horizontal
					for(int i=0; i<n;i++) {
						matriz[fila][columna]=palabra[i];
						columna+=1;
					}
					break;
					
				}else if (direccion==2) { //Vertical
					for(int i=0; i<n; i++) {
						matriz[fila][columna]=palabra[i];
						fila+=1;
					}
					break;
					
				}else if (direccion==3){ //Diagonal
					for(int i=0; i<n; i++) {
						matriz[fila][columna]=palabra[i];
						fila+=1;
						columna+=1;
					}
					break;
				}else if (direccion==4) { //Horizontal invertido
					for(int i=n-1; i>=0;i--) {
						matriz[fila][columna]=palabra[i];
						columna+=1;
					}
					break;
					
				}else if(direccion==5) { //Vertical invertido
					for(int i=n-1; i>=0; i--) {
						matriz[fila][columna]=palabra[i];
						fila+=1;
					}
					break;
					
				}else { //Diagonal invertido
					for(int i=n-1; i>=0; i--) {
						matriz[fila][columna]=palabra[i];
						fila+=1;
						columna+=1;
					}
					break;
				}
			}
		}
		return matriz;

	}

	public static boolean verificarPalabra(char[][] matriz, char[] palabra, int n, int direccion, int fila, int columna) {

		try {
			if(direccion==1) {
				for(int i=0; i<n;i++) {
					
					if(matriz[fila][columna]==0 || matriz[fila][columna]==palabra[i]) {
						columna+=1;
					}else {
						return false;
					}
				}
			}else if (direccion==2) {
				
				for(int i=0; i<n; i++) {
					if(matriz[fila][columna]==0 || matriz[fila][columna]==palabra[i]) {	
						fila+=1;
					}else {
						return false;
					}
				}
			}else {
				for(int i=0; i<n; i++) {
					if(matriz[fila][columna]==0 || matriz[fila][columna]==palabra[i]) {	
						fila+=1;
						columna+=1;
					}else {
						return false;
					}
				}
			}
			
		}catch (Exception e) {
			return false; //Si la longitod de la palabra no entra o choca con otra palabra se retorna false
		}
		return true;
	}
}
