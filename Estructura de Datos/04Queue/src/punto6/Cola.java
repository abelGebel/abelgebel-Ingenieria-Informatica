package punto6;

public class Cola {
	
	Desarrollador desarrollador =new Desarrollador();
	
	private Desarrollador [] contenedor;
	private int head;
	private int tail;
	private static final char dimension=20;
	
    public Cola() {
        this(Cola.dimension);
    }
	
	public Cola(int dimension) {
        this.contenedor =  new Desarrollador[dimension];
        this.head = 0;
        this.tail = 0;
    }

	public boolean vacia() {
		return(head==tail);
	}
	public boolean llena() {
		return(head==siguiente(tail));
	}
	
	public int siguiente(int posicion) {
		++posicion;
		if(posicion==dimension) {
			posicion=0;
		}
		return posicion;
	}
	
	public void encolar(Desarrollador elemento) {
		if(llena()) {
			throw new RuntimeException("La cola esta llena");
		}
		contenedor[tail]=elemento;
		tail=siguiente(tail);
	}
	
	public Desarrollador quitar() {
		if(vacia()) {
			throw new RuntimeException("La cola esta llena");
			
		}
		Desarrollador valor=contenedor[head];
		head=siguiente(head);
		return valor;
	}
	
	public Desarrollador peek(){
		return contenedor[head];
	}
}