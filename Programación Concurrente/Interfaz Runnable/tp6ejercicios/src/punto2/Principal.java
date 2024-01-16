package punto2;
/*
En una oficina hay un baño unisex con 3 inodoros. El baño puede ser utilizado tanto por
hombres como por mujeres, pero no puede ser utilizado por hombres y mujeres al mismo
tiempo. Dar una solución libre de deadlocks implementando la interfaz Runnable
teniendo en cuenta que una mujer usa el baño entre 800ms y 1500ms, mientras que un
hombre lo utiliza entre 400ms y 900ms. Los empleados de ambos sexos pueden llegar en
cualquier momento a usar el baño (de forma aleatoria entre 600ms y 1200ms). Como
puede suceder que el baño solo sea usado por un único sexo, realizar un control que cada
7 mujeres pueden pasar 10 hombres y viceversa.
*/

import java.util.ArrayList;
import java.util.Random;

public class Principal implements Runnable{
	
	private Mujer mujer;
	private Hombre hombre;
	private boolean genero;

	public Principal(Mujer mujer,boolean genero) {
		this.genero=genero;
		this.mujer=mujer;
	}
	public Principal(Hombre hombre,boolean genero) {
		this.genero=genero;
		this.hombre=hombre;
	}


	public static void main(String[] args) {
	    Random random = new Random();
	    Control control= new Control();
        ArrayList<Integer> baño = new ArrayList<>();
        ArrayList<Integer> cantidadMujeres = new ArrayList<>();
        ArrayList<Integer> cantidadHombres = new ArrayList<>();

        control.setContador(7);
        int i=1;
        Baño bañoControl = new Baño(baño,cantidadMujeres,cantidadHombres);
        bañoControl.insertarGenero(true);
        
		try {
			while(true) {
				
				Mujer mujer = new Mujer(baño,cantidadMujeres,i,bañoControl);
				Hombre hombre = new Hombre(baño,cantidadHombres,i,bañoControl);
				Runnable proceso1 = new Principal(mujer,true);
    			new Thread(proceso1).start();
				Runnable proceso2 = new Principal(hombre,false);
    			new Thread(proceso2).start();
                i++;
				Thread.sleep(random.nextInt(1000));

			}
		} catch (InterruptedException e) {e.printStackTrace();} 
	}

	@Override
	public void run() {
		if(genero) {
			mujer.usoBañoMujer();

		}else {
			hombre.usoBañoHombre();
		}
	}
}