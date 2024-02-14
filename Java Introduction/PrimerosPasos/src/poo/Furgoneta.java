package poo;

public class Furgoneta extends Coche{
	
	private int capacidadExtra;
	private int plazasExtra;
	
	public Furgoneta(int plazasExtra,int capacidadExtra) {
		super(); //<-- llama al constructor padre (en este caso el por defecto, podria ser otro)
		this.capacidadExtra = capacidadExtra;
		this.plazasExtra = plazasExtra;
	}
	
	public String getDatosFurgoneta() {
		return "La capacidad de carga es: " + capacidadExtra + " y las plazas son " + plazasExtra;
	}
}
