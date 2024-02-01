package ejercicios;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Random random = new Random();		
		double monto,saldoActual,interesAnual;
		long dni,cbu;
		String aux;
		
		//Objeto cuenta
		
		dni = random.nextLong(3000000,60000000);	
		saldoActual = Math.round(random.nextDouble(0,30000));
		aux=String.format("%.2f", random.nextDouble());
		interesAnual=Double.parseDouble(aux.replace(",", "."));
		
		Cuenta cuenta1 = new Cuenta(dni,saldoActual,interesAnual);
		
		System.out.println(cuenta1.toString());
		
		monto= Math.round(random.nextDouble(10000,30000));
		cuenta1.ingresar(monto);
		monto=Math.round(random.nextDouble(10000,30000));
		cuenta1.ingresar(monto);
		monto=Math.round(random.nextDouble(15000,25000));
		cuenta1.retirar(monto);
		
		System.out.println();
		
		//objeto cuentaSueldo1
		
		dni = random.nextLong(1000000,60000000);
		saldoActual = Math.round(random.nextDouble(15000,25000));
		aux=String.format("%.2f", random.nextDouble());
		interesAnual=Double.parseDouble(aux.replace(",", "."));
		cbu = random.nextLong(000000000000000000L,999999999999999999L);
		
		CuentaSueldo cuentaSueldo1 = new CuentaSueldo(dni,saldoActual,interesAnual,cbu);
		
		System.out.println(cuentaSueldo1.toString());
		
		monto=Math.round(random.nextDouble(10000,15000));
		cuentaSueldo1.retirar(monto);
		
		System.out.println();
		
		//objeto cuenta sueldo2
		
		dni = random.nextLong(1000000,60000000);
		saldoActual = Math.round(random.nextDouble(15000,25000));
		aux=String.format("%.2f", random.nextDouble());
		interesAnual=Double.parseDouble(aux.replace(",", "."));
		cbu = random.nextLong(000000000000000000L,999999999999999999L);
		
		CuentaSueldo cuentaSueldo2 = new CuentaSueldo(dni,saldoActual,interesAnual,cbu);
		
		//System.out.println(cuentaSueldo2.toString());
		//monto=random.nextDouble(10000,15000);
		//cuentaSueldo2.retirar(monto);
	}
}
