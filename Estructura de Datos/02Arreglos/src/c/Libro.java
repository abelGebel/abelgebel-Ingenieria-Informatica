package c;

public class Libro {
	private String titulo;
	private String autor;
	private String editorial;
	private int anioDePublicacion;
	private double precio;
	
	public Libro() {
		
	}
	
	public Libro(String titulo, String autor, String editorial, int anioDePublicacion, double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anioDePublicacion = anioDePublicacion;
		this.precio = precio;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public int getAnioDePublicacion() {
		return anioDePublicacion;
	}


	public void setAnioDePublicacion(int anioDePublicacion) {
		this.anioDePublicacion = anioDePublicacion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		System.out.println();
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", anioDePublicacion="
				+ anioDePublicacion + ", precio=" + precio + "]";
	}
	
}
