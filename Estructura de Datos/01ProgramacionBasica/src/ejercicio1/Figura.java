package ejercicio1;

public class Figura {
	
	private double seg1,seg2,seg3,seg4;
	private double ladoA, ladoB;
	public static int contPoligonos;
	
	public Figura(double seg1,double seg2,double seg3,double seg4) {
		this.seg1=seg1;
		this.seg2=seg2;
		this.seg3=seg3;
		this.seg4=seg4;
	}
	
	public boolean esCuadrado() {
		if(seg1==seg2 && seg3==seg4 && seg1==seg3) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esRectangulo() {
		if(seg1==seg2 && seg3==seg4){
			ladoA=seg1;
			ladoB=seg3;
			return true;
		}else if(seg1==seg4 && seg2==seg3) {
			ladoA=seg1;
			ladoB=seg2;
			return true;
		}else if(seg1==seg3 && seg2==seg4) {
			ladoA=seg1;
			ladoB=seg2;
			return true;
		}else {
			return false;
		}
	}
	
	public double ladoA() {
		return ladoA;
	}
	
	public double ladoB() {
		return ladoB;
	}
	
	public void esPoligono() {
		System.out.println();
		System.out.println("La figura ingresada es un poligono");
		System.out.println();
		contPoligonos+=1;
		}
	
	
}
