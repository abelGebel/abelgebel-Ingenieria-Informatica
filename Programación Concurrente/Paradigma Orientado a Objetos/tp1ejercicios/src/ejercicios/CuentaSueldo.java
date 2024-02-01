package ejercicios;

public class CuentaSueldo extends Cuenta {
	
	//Atributos
	
	private int legajo;
	private String institucion,beneficios;
	private long cbu;
	private final double tope = 15000;
	
	//Constructores
	
	public CuentaSueldo(){}
	
	public CuentaSueldo(long dni, double saldoActual, double interesAnual, long cbu) {
		super(dni,saldoActual,interesAnual);
		this.cbu=cbu;
	}
	
	//Metodos
	
	public void retirar(double monto){
		
		if (monto>tope) {
			System.out.println("Cantidad superio al tope de $"+tope);
		}else if(monto>saldoActual) {
			System.out.println("Cantidad ingresada superior a saldo actual");
		}else {
			this.saldoActual-=monto;
			System.out.println("Monto a retirar: $"+monto+" Total: $"+saldoActual);
		}
	}
	
	public void transferir(double monto, long cbu) {
		if(monto>saldoActual) {
			System.out.println("Saldo insuficiente");
		}
		else {
			this.saldoActual-=monto;
			System.out.println("Transferencia realizada con éxito al cbu: "+cbu+", monto: "+monto);
		}
		
	}
	
	public void transferir(double monto, String alias) {
		if(monto>saldoActual) {
			System.out.println("Saldo insuficiente");
		}
		else {
			saldoActual-=monto;
			System.out.println("Transferencia realizada con éxito a "+alias+", monto: "+monto);
		}
	}

	@Override
	public String toString() {
		return "CuentaSueldo [cbu=" + cbu + ", numeroCuenta=" + numeroCuenta + ", dni=" + dni + ", saldoActual="
				+ saldoActual + ", interesAnual=" + interesAnual + "]";
	}
}
