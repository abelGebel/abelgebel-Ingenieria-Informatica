package ejemplo1;

public class Main {

	public static void main(String[] args) {
		/*
		Nodo primer = new Nodo("EJEMEPLO");
		Nodo segunto = new Nodo(3);
		Nodo tercero = new Nodo("Hola");

		primer.enlazarSiguiente(segunto);
		primer.obtenerSiguiente().enlazarSiguiente(tercero);
		
		System.out.println(primer.obtenerSiguiente().obtenerSiguiente().obtenerValor());
		*/
		
		ListaEnlazada lista = new ListaEnlazada();
		System.out.println("Esta vacia: "+lista.estaVacia());
		
		lista.addPrimero("Jorge");
		lista.addPrimero(20);
		lista.addPrimero("Hola");
		lista.addPrimero(2);
		
		System.out.println("Primer elemento: "+lista.obtener(0));
		System.out.println("Ultimo: "+lista.obtener(lista.size()-1));
		System.out.println("Index 2: "+lista.obtener(2));
		System.out.println("Esta vacia: "+lista.estaVacia());
		System.out.println("Tamanio: "+lista.size());
		
		
	}

}
