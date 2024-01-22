package d;

public class Paciente {
	
	private int id;
	private double altura;
	private double peso;
	
	public Paciente(){}
	
	public Paciente(int id,double altura, double peso) {
		this.id=id;
		this.altura=altura;
		this.peso=peso;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
}
