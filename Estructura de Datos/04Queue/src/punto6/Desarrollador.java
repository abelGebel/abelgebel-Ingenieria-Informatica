package punto6;
public class Desarrollador {
	
	private String apellido;
	private String nombre;
	private Long cuit;
	private String especialidad;
	private Integer rango;
	
	public Desarrollador(){
	}
	
	public Desarrollador(String apellido, String nombre, Long cuit, String especialidad, Integer especailidad, Integer rango) {
		this.apellido=apellido;
		this.nombre=nombre;
		this.cuit=cuit;
		this.especialidad=especialidad;
		this.rango=rango;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Integer getRango() {
		return rango;
	}

	public void setRango(Integer rango) {
		this.rango = rango;
	}

	@Override
	public String toString() {
		return "Desarrollador [apellido=" + apellido + ", nombre=" + nombre + ", cuit=" + cuit + ", especialidad="
				+ especialidad + ", rango=" + rango + "]";
	}	
}