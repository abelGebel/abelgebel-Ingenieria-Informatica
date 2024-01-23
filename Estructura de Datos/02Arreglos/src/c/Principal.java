package c;


/*
Escribir el código necesario para crear y mostrar objetos del tipo Libro. En general, 
un libro cuenta con los siguientes atributos: Titulo, Autor, Editorial, Año de Publicación, Precio.
*/
public class Principal {

	public static void main(String[] args) {
		Libro libros[]=new Libro[3];
		
		libros[0]=new Libro("1984","George Orwell","Secker & Warburg",1949,29.99);
		libros[1]=new Libro("El Gran Gatsby","F. Scott Fitzgerald","Charles Scribner's Sons",1925,24.99);
		libros[2]=new Libro("Cien años de soledad","Gabriel García Márquez","Editorial Sudamericana",1967,19.99);
		
		for(int i=0;i<3;i++) {
            System.out.println(libros[i].getTitulo() + " - " + libros[i].getAutor() + " - " + libros[i].getEditorial() + " - " + libros[i].getAnioDePublicacion() + " - " + libros[i].getPrecio());
		}
	}

}
