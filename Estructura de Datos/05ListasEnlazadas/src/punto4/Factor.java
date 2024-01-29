package punto4;
public class Factor {
	
	private int primo;
	private int exponente;
	
	public Factor() {
	}
	
	public Factor(int primo,int exponente) {
		this.exponente=exponente;
		this.primo=primo;
	}

	public int getNumero() {
		return primo;
	}

	public void setNumero(int numero) {
		this.primo = numero;
	}

	public int getExponente() {
		return exponente;
	}

	public void setExponente(int exponente) {
		this.exponente = exponente;
	}

	@Override
	public String toString() {
		return "Factor [primo=" + primo + ", exponente=" + exponente + "]";
	}
}
