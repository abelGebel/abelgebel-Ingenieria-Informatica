package ejercicio04;

public class Pila {
	private int[] contenedor;
	private int cuenta;
	private int capacidad=30;
	
	public Pila() {
		this.cuenta=0;
		this.capacidad=20;
		this.contenedor= new int[capacidad];
	}
	
	public Pila(int capacidad) {
		this.cuenta=0;
		this.capacidad=capacidad;
		this.contenedor=new int[this.capacidad];
	}
	
	public boolean estaLlena() {
		return this.cuenta>capacidad;
	}
	
	public boolean estaVacia() {
		return this.cuenta<=0;
	}
	
	
	
	public void push(int numero) {
		if (this.estaLlena()) {
			throw new RuntimeException("Error, la pila esta llena");
		}
		this.contenedor[cuenta]=numero;
		++this.cuenta;
	}
	
	
	
	public int pop() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error, la pila esta vacia");
		}
		--cuenta;
		return this.contenedor[cuenta];
	}
	
	public int peek() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error, la pila esta vacia");
		}
		return this.contenedor[cuenta-1];
	}
}

