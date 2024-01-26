package ejercicio01;

public class Pila {
	private char[] contenedor;
	private int cuenta;
	private int capacidad;
	
	private char[]aux;
	private int cuentaAux;
	
	
	public Pila() {
		this.cuenta=0;
		this.cuentaAux=0;
		this.capacidad=10;
		this.aux=new char[this.capacidad];
		this.contenedor= new char[capacidad];
	}
	
	public Pila(int capacidad) {
		this.cuenta=0;
		this.capacidad=capacidad;
		this.contenedor=new char[this.capacidad];
		this.aux=new char[this.capacidad];
	}
	
	public boolean estaLlena() {
		return this.cuenta>capacidad-1;
	}
	
	public boolean estaVacia() {
		return this.cuenta<=0;
	}
	
	public void push(char numero) {
		if (this.estaLlena()) {
			throw new RuntimeException("Error, la pila esta llena");
		}
		this.contenedor[cuenta]=numero;
		++this.cuenta;
	}
	
	public char pop() {
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
	
	
	public void pushAux(char numero) {
		this.aux[cuentaAux]=numero;
		++this.cuentaAux;
	}
	
	public char popAux() {
		--cuentaAux;
		return this.aux[cuentaAux];
	}
	
	
	
	public int remplazarElemento(char actual,char nuevo) {
		
		int remplazos=0;
		
		while(!estaVacia()) {
			if (peek()==actual) {
				char varAux=pop();
				pushAux(nuevo);
				remplazos+=1;
			}else {
				pushAux(pop());
			}	
		}
		while(!estaLlena()) {
			push(popAux());
		}	
		return remplazos;
	}


}