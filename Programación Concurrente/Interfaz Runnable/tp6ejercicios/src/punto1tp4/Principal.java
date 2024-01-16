package punto1tp4;


/*
Implemente lo siguiente:

a. Una clase que imprima el siguiente patrón de sucesión de X: “.0X.” (.iX. para
i=0……99), a continuación debe imprimir un patrón de sucesión de Y: “.0Y.”
(.iY. para i=0……99).

b. Mediante Hilos heredando de Thread, emplee dos clases para realizar dicha
impresión de forma concurrente. Repita el proceso 10 veces para observar cómo
se imprimen los distintos lanzamientos.

c. Obtenga la porción de la fila que posea la sucesión más larga de cualquier letra.
Imprima toda la sucesión.

d. Si en el inciso b) no se imprimen correctamente utilice una pausa o join.

e. Razone y comente los resultados obtenidos.
*/

public class Principal implements Runnable{
	private PrintX x;
	private PrintY y;

	public Principal(PrintX x,PrintY y) {
		this.x=x;
		this.y=y;
	}
	
	public static void main(String[] args) {

		long inicio,fin;
		inicio = System.currentTimeMillis();
		

		
		for(int i=0; i< 10;i++) {
			PrintX x=new PrintX(i);
			PrintY y=new PrintY(i);
			Runnable proceso1 = new Principal(x,y);
			new Thread(proceso1).start();
			System.out.println();
		}

		
		fin = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Duracion: "+(fin-inicio));

	}

	@Override
	public void run() {
		this.x.imprimirX();
		this.y.imprimirY();
	}

}
