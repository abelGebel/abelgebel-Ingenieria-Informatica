package punto5;
public class Usuario {
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private String correo;
	private char cuenta;

	public Usuario(){}
	
	public Usuario(String nombre,String apellido,String usuario,String clave,String correo,char cuenta) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.usuario=usuario;
		this.clave=clave;
		this.correo=correo;
		this.cuenta=cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getCuenta() {
		return cuenta;
	}

	public void setCuenta(char cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", clave=" + clave
				+ ", correo=" + correo + ", cuenta=" + cuenta + "]";
	}
	
	
}
