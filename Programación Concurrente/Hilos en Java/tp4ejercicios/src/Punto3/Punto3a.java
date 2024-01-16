package Punto3;

/*3.a. Se le solicita que lo ejecute 20 veces de forma secuencial (para root entre [1-20])
y calcule el tiempo de ejecución, y además revise el “Administrador de tareas” de 
Windows para comprobar la utilización de la/las CPU/s*/

public class Punto3a {
	
	public static double SumRootN(int root) {
		double result =0;
		for (int i = 0; i < 10000000; i++) {
			result += Math.exp(Math.log(i)/root);
		}
		return result;
	}
	
	public static void main(String[] args) {
		long tiempoInicial, tiempoFinal;
		tiempoInicial = System.currentTimeMillis();
		for (int i = 1; i <= 20; i++) {
			double suma = SumRootN(i);
			System.out.println("Resultado para root= "+i+": "+suma);
		}
		tiempoFinal= System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion "+(tiempoFinal-tiempoInicial)+" milisegundos");
	}
}