package defaultPackage;

public class UsoTallas {

	enum Tallas{MINI,MEDIANO,GRANDE,MUY_GRANDE }
	
	enum Talla{
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		private String abreviatura;
	}
	
	public static void main(String[] args) {
			
		Tallas s = Tallas.MINI;
		Tallas m = Tallas.MEDIANO;
		Tallas l = Tallas.MEDIANO;
		Tallas xl = Tallas.MUY_GRANDE;
		
		
		

	}

}
