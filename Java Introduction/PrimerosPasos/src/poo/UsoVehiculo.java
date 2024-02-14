package poo;


//Modularización: dividir un programa en trozos (modulos, formado por varias clases).
//Encapsulamiento: las propiedades de los objetos no deben ser publicos, no deben cambiarse desde otra clase.
public class UsoVehiculo {

	public static void main(String[] args) {
		
		Coche coche1 = new Coche();
		
		coche1.setColor("rojo");
		
		Furgoneta furgoneta1 = new Furgoneta(7,580);
		
		furgoneta1.setColor("azul");
		furgoneta1.setAsientosCuero("si");
		furgoneta1.setClimatizador("si");
		
		System.out.println(coche1.datosGenerales()+" " +coche1.getColor());
		System.out.println(furgoneta1.datosGenerales()+" " +furgoneta1.getColor()+" "+furgoneta1.getDatosFurgoneta());

	}

}
