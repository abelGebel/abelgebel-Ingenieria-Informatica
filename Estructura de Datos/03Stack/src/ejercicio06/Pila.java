package ejercicio06;

public class Pila {
	private PuntoEntrega[] contenedor;
	private int cuenta;
	private int capacidad;

	
	public Pila() {
		this.cuenta=0;
		this.capacidad=20;
		this.contenedor= new PuntoEntrega[20];
	}
	
	public Pila(int capacidad) {
		this.cuenta=0;
		this.capacidad=capacidad;
		this.contenedor= new PuntoEntrega[capacidad];
	}
	
	public boolean estaLlena() {
		return this.cuenta>capacidad;
	}
	
	public boolean estaVacia() {
		return this.cuenta<=0;
	}
		
	
	public void push(PuntoEntrega valor) {
		if (this.estaLlena()) {
			throw new RuntimeException("Error, la pila esta llena");
		}
		this.contenedor[cuenta]=valor;
		++this.cuenta;
	}
		
	public PuntoEntrega pop() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error, la pila esta vacia");
		}
		--cuenta;
		return this.contenedor[cuenta];
	}
	
	
	
	public PuntoEntrega peek() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error, la pila esta vacia");
		}
		
		return this.contenedor[cuenta-1];
	}
}