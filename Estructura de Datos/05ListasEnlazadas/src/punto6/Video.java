package punto6;
public class Video {
	
	private String identificador;
	private String titulo;
	private String creador;
	private int duracion;
	
	public Video() {}
	
	public Video(String identificador, String titulo,String creador,int duracion) {
		this.identificador=identificador;
		this.titulo=titulo;
		this.creador=creador;
		this.duracion=duracion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Video [identificador=" + identificador + ", titulo=" + titulo + ", creador=" + creador + ", duracion="
				+ duracion + "]";
	}
	
	

}
