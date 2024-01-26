package ejercicio06;

public class PuntoEntrega {
	
	
	private String pueblo;
	private String negocio;
	private int cantFardos;
	private float montoDeuda;
	private String estadoDeuda;

	public PuntoEntrega(){}
	
	public PuntoEntrega(String pueblo, String negocio, int cantFardos, float montoDeuda, String estadoDeuda) {
		super();
		this.pueblo=pueblo;
		this.negocio=negocio;
		this.cantFardos=cantFardos;
		this.montoDeuda=montoDeuda;
		this.estadoDeuda=estadoDeuda;
	}

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}

	public int getCantFardos() {
		return cantFardos;
	}

	public void setCantFardos(int cantFardos) {
		this.cantFardos = cantFardos;
	}

	public float getMontoDeuda() {
		return montoDeuda;
	}

	public void setMontoDeuda(float montoDeuda) {
		this.montoDeuda = montoDeuda;
	}

	public String getEstadoDeuda() {
		return estadoDeuda;
	}

	public void setEstadoDeuda(String estadoDeuda) {
		this.estadoDeuda = estadoDeuda;
	}
	
	@Override
	public String toString() {
		return "PuntoEntrega [pueblo=" + pueblo + ", negocio=" + negocio + ", cantFardos=" + cantFardos
				+ ", montoDeuda=" + montoDeuda + ", estadoDeuda=" + estadoDeuda + "]";
	}
}