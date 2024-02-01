package ejercicios;

public class Cuenta {
	
	//Atributos
	
	protected long numeroCuenta,dni;
	protected double saldoActual;
	protected double interesAnual;
	protected static long ultimoNumeroCuenta=100000;
	
	//Constructores
	
	public Cuenta(){}
	
	public Cuenta(long dni, double saldoActual, double interesAnual) {
		this.dni=dni;
		this.saldoActual=saldoActual;
		this.interesAnual=interesAnual;
		this.numeroCuenta=++ultimoNumeroCuenta;
	}
	
	//Metodos
	
	public void actualizarSaldo() {
		saldoActual+= saldoActual*(interesAnual/365);
	}
	
	public void ingresar(double cantidad) {
		this.saldoActual+=cantidad;
		System.out.println("Se ingreso la cantidad de $"+cantidad+" Saldo total de $"+saldoActual);
	}
	
	public void retirar(double cantidad) {
		if(this.saldoActual>cantidad) {
			this.saldoActual-=cantidad;
			System.out.println("Monto a retirar: $"+cantidad+" Total: $"+saldoActual);
		}
		else {
			System.out.println("Cantidad ingresada superior a saldo actual");
		}
	}
	
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", dni=" + dni + ", saldoActual=" + saldoActual
				+ ", interesAnual=" + interesAnual + "]";
	}
}
