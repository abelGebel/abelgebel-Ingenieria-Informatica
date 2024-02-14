package poo;

public class Coche {
	
	private int ruedas; // --> DATOS ENCAPSULADOS (private)
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	
	private String color;
	private int pesoTotal;
	private boolean asientosCuero, climatizador;
	
	public Coche(){
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		pesoPlataforma=500;
	}

	public String getColor() {
		return "El color del coche es " + color;
	}
	
	public void setColor(String colorCoche) {
		color = colorCoche;
	}
	
	
	public String getLargo() {
		return "El largo del coche es "+largo;
	}
	
	
	public String getAsientosCuero() {
		if(asientosCuero==true) {
			return "El coche tiene asientos de cuero";
		}
		return "El coche tiene asientos de serie";
	}
	
	
	public void setAsientosCuero(String asientosCuero) {
		if(asientosCuero.equalsIgnoreCase("si")) {
			this.asientosCuero = true; 

		}else {
			this.asientosCuero = false; 
		}
	}
	
	public String getClimatizador() {
		if(climatizador==true) {
			return "El coche lleva climatizador";
		}
		return "El coche lleva aire acondicionado";
	}
	
	
	public void setClimatizador(String climatizador) {
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String pesoCoche() { //SETTER+GETTER
		
		int peso_carroceria=500;
		pesoTotal = pesoPlataforma+peso_carroceria;
		
		if(asientosCuero) {
			pesoTotal = pesoTotal + 50;
		}
		if(climatizador) {
			pesoTotal = pesoTotal + 20;
		}
		return "El peso del coche es " + pesoTotal;
	}
	
	
	public int precioCoche() {
		int precioFinal = 10000;
		
		if(asientosCuero) {
			precioFinal += 2000;
		}
		
		if(climatizador) {
			precioFinal +=1500;
		}
		
		return precioFinal;
	}
	
	
	public String datosGenerales() {
		return "La plataforma del vehículo tiene "+ ruedas + "ruedas"
				+". Mide " + largo/1000 + " metros con un ancho de " + ancho + " cm y un peso de plataforma"
				+" de " + pesoPlataforma + " kg";
	}

}
