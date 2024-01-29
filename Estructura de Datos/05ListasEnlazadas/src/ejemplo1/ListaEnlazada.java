package ejemplo1;

public class ListaEnlazada {
	Nodo cabeza;
	int size;
	
	public ListaEnlazada() {
		cabeza=null;
		size=0;
	}
	
	public Object obtener(int index) {
		int contador=0;
		Nodo temporal=cabeza;
		while(contador<index) {
			temporal=temporal.obtenerSiguiente();
			contador++;
		}
		return temporal.obtenerValor();
	}
	
	public void addPrimero(Object obj) {
		if(cabeza==null) {
			cabeza=new Nodo(obj);
		}
		else {
			Nodo temp = cabeza;
			Nodo nuevo =new Nodo(obj);
			nuevo.enlazarSiguiente(temp);
			cabeza=nuevo;
		}
		size++;
	}
	
	public void cortar(int index) {
		int contador=0;
		Nodo temporal=cabeza;
		while(contador<index-1) {
			temporal=temporal.obtenerSiguiente();
			contador++;
		}
		temporal.enlazarSiguiente(null);
		size=index;
	}
	
	public void eliminar(int index) {
		int contador=0;
		if(index==0) {
			cabeza=cabeza.obtenerSiguiente();
		}else {
			Nodo temporal=cabeza;
			while(contador<index-1) {
				temporal=temporal.obtenerSiguiente();
				contador++;
			}
			temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
		}
		size--;
		
	}
	
	public void eliminarPrimero() {
		cabeza = cabeza.obtenerSiguiente();
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public boolean estaVacia() {
		return (cabeza==null);
	}
}
