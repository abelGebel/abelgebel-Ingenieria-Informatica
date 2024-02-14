package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		
		Persona[] personas = new Persona[2];
		personas[0] = new Empleado2("Luis",50000,2009,02,25);
		personas[1] = new Alumno("ana","biologicas");
		
		for(Persona p:personas) {
			System.out.println(p.getNombre()+" "+p.dameDescripcion());
		}

	}

}

abstract class Persona{
	
	public Persona(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract String dameDescripcion();

	private String nombre;	
}

class Empleado2 extends Persona{
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia) {
		super(nom);
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		altaContrato = calendario.getTime();
		id=idSiguiente;
		idSiguiente++;
	}
	
	public String dameDescripcion() {
		return "Este empleado tiene un id= "+id+" con un sueldo= "+sueldo;
	}
	
	//public Empleado() {}  // <---- si hay un atributo final debe inicializarse en el const por defecto

	
	public Empleado2(String nom) {
		
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
	
	
	//final private String nombre; // <--- no se deberia poder cambiar
	private String nombre;
	private double sueldo;
	private Date altaContrato;	
	private int id;
	private static int idSiguiente=1; // <---- permite ir modificando el id automaticamente. variable que pertenece a la clase
	
}

class Alumno extends Persona{
	
	public Alumno(String nom, String car) {
		super(nom);
		carrera=car;
	}
	
	private String carrera;

	@Override
	public String dameDescripcion() {
		// TODO Auto-generated method stub
		return "Este alumno esta estudiando la carrera de "+carrera;
	}
	
}
