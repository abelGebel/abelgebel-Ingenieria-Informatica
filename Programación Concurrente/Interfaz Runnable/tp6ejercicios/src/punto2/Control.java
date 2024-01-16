package punto2;

public class Control {
	private int contador;
	boolean hayHombres=false; 

	public void setContador(int contador){
		if(contador<=0) {
			this.contador=0;
		}else {
			this.contador=contador;
		}
	}

	public int getContador(){
		return contador;
	}
	
	public void setHayHombres(boolean hayHombres) {
		this.hayHombres=hayHombres;
	}

	public boolean getHayHombres() {
		return hayHombres;
		
	}
}