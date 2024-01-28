package a;

public class ColaCircular {
	
	private Object []contenedor;
	private int head;
	private int tail;
	private int contador;
	private int capacidad=10;
	
	public ColaCircular() {
		this.contenedor=new Object[capacidad];
		this.head=0;
		this.tail=0;
		this.contador=0;
	}
	
	public ColaCircular(int capacidad) {
		this.capacidad=capacidad;
		this.contenedor=new Object[capacidad];
		this.head=0;
		this.tail=0;
		this.contador=0;
	}
	
	public boolean llena() {
		return(contador>=capacidad);
	}
	
	public boolean vacia() {
		return(contador<=0);
	}
	
	public int siguiente(int posicion) {
		++posicion;
		if(posicion==capacidad) {
			posicion=0;
		}
		return posicion;
	}
	
	public void encolar(Object elemento) {
		if(llena()) {
			System.out.println("La cola esta llena...");
		}else {
			contenedor[tail]=elemento;
			tail=siguiente(tail);
			++contador;
		}
	}
	
	public Object quitar() {
		if(vacia()) {
			System.out.println("La cola esta vacia...");
			throw new RuntimeException("La cola esta vacia...");
		}else {
			Object numero=contenedor[head];
			head=siguiente(head);
			--contador;
			return numero;
		}
	}
	
	public Object peek(){
		return contenedor[head];
	}
	
	public int capacidad() {
		return capacidad;
	}
	
	public int cantidadElmentos() {
		return contador;
	}
}
