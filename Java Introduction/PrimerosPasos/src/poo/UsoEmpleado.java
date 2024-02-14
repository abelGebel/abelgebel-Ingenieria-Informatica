package poo;

import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado("paco",85000,1990,12,17);
		Empleado empleado2 = new Empleado("ana",95000,1995,1,4);
		Empleado empleado3 = new Empleado("rosa",105000,2002,5,9);
		Empleado empleado4 = new Empleado("lucas");
		Jefatura jefe = new Jefatura("daniel",55000,2006,9,25);
		jefe.setIncentivo(2570);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		Empleado[] empleados = new Empleado[6];
		
		empleados[0] = empleado1;
		empleados[1] = empleado2;
		empleados[2] = empleado3;
		empleados[3] = empleado4;
		empleados[4] = jefe; // <------- Polimorfismo (principio de sustitucion)
		empleados[5] = new Jefatura("maria",95000,1999,5,26);
		Jefatura jefaFinanzas = (Jefatura)empleados[5] ; // <--- CASTING (sino no se puede aplicar el metodo incentivo)
		jefaFinanzas.setIncentivo(55000); 

		Arrays.sort(empleados);
		
		Empleado directorCommercial = new Jefatura("Sandra",85000,2012,05,05);
		
		Comparable ejemplo = new Empleado("Eli",95000,2011,06,07);
		
		
		if(directorCommercial instanceof Empleado) {
			System.out.println("Es de tipo jefatura");
		}
		
		if(ejemplo instanceof Comparable) {
			System.out.println("Implementa interface comparable");
		}
		
		System.out.println(jefaFinanzas.tomarDecisiones("Dar vacaciones"));
		
		
		for(Empleado e: empleados) {
			System.out.println("id: "+e.getId()+" Nombre: "+e.getNombre() + " Sueldo: "+e.getSueldo()+
					" Fecha de alta: "+e.getAltaContrato() );
		}
		
		System.out.println(Empleado.idSiguiente());
		
		
		System.out.println("El jefe " + jefaFinanzas.getNombre()+" tiene un bonus de "
		+ jefaFinanzas.estableceBonus(500));
		
		System.out.println("El empleado " + empleados[3].getNombre()+" tiene un bonus de "
		+ empleados[3].estableceBonus(200));
	}
}

class Empleado implements Comparable, Trabajadores{
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		altaContrato = calendario.getTime();
		id=idSiguiente;
		idSiguiente++;
	}
	
	//public Empleado() {}  // <---- si hay un atributo final debe inicializarse en el const por defecto

	
	public Empleado(String nom) {
		
		this(nom,30000,2000,01,01);
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {// final public double getSueldo() <--- si se declara como FINAL no puede haber otro metodo que herede de la clase con el mismo nobre y diferentes acciones
		return sueldo;
	}
	
	public void setSueldo(double sue) {// final public double getSueldo() <--- si se declara como FINAL no puede haber otro metodo que herede de la clase con el mismo nobre y diferentes acciones
		sueldo=sue;
	}
	

	public Date getAltaContrato() {
		return altaContrato;
	}
	
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	public static String idSiguiente() { // <-- no acutua sobre objetos y no accede a variables o constantes declaradas en la clase salvo que sean estaticas
		return "El id siguiente es: " + idSiguiente;
	}
	
	@Override
	public int compareTo(Object o) {
		Empleado otroEmpleado=(Empleado) o;
		
		if(this.id < otroEmpleado.id) {
			return -1;
		}
		if(this.id > otroEmpleado.id) {
			return 1;
		}
		return 0;
	}
	
	public double estableceBonus(double gratificacion) {
		return Trabajadores.bonusBase+gratificacion;
	}
	
	
	//final private String nombre; // <--- no se deberia poder cambiar
	private String nombre;
	private double sueldo;
	private Date altaContrato;	
	private int id;
	private static int idSiguiente=1; // <---- permite ir modificando el id automaticamente. variable que pertenece a la clase


	
}

final class Jefatura extends Empleado implements Jefes{ //<---- con el FINAL nadie puede heredar de jefatura
	
	public Jefatura(String nom, double sue,int anio, int mes, int dia) {
		super(nom, sue, anio, mes, dia);
	}
	
	public void setIncentivo(double b) {
		incentivo = b;
		double sueldoJefe = super.getSueldo()+incentivo;
		super.setSueldo(sueldoJefe);
		
	}
	
	public double getSueldo() { 
		double sueldoJefe = super.getSueldo(); // <---- CON SUPER SE LLAMA AL METODO PADRE (EMPLEADO)
		return sueldoJefe;
	}
	
	@Override
	public String tomarDecisiones(String decision) {
		return "Un miembro de la direccion ha tomado la decision de: "+decision;
	}
	
	@Override
	public double estableceBonus(double gratificacion) {
		double prima = 2000;
		return Trabajadores.bonusBase+gratificacion+prima;
	}
	
	private double incentivo;




}
