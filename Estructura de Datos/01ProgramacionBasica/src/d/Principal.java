package d;
import java.util.Scanner;
import a.Helper;
/*
Ingresar la altura y el peso de un grupo de “P” de pacientes que realizan un control médico en 
un centro de salud. La cantidad “P” debe ser indicada por el usuario al inicio del programa. 
Determinar cuál es la altura máxima y el peso mínimo de los pacientes controlados.
*/

public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double altura;
		double peso;
		double alturaMax=0;
		double pesoMin=1000;
		int idPesoMin=0;
		int idAlturaMax=0;
	

		int p = Helper.getIntegerPositivo(input, "Ingrese la cantidad de pacientes: ", "INGRESO NO VALIDO");
		
		Paciente pacientes[]= new Paciente[p];
		
		for(int i =0; i<p; i++) {
			altura = Helper.getFloat(input, "Ingrese la altura del paciente "+ (i+1)+": ","INGRESO NO VALIDO...");
			peso = Helper.getFloat(input, "Ingrese el peso del paciente "+ (i+1)+": ");
			pacientes[i] = new Paciente(i+1,altura,peso);
		}
		
		for(int i =0; i<p; i++) {
			
			if(pacientes[i].getAltura()>alturaMax) {
				alturaMax=pacientes[i].getAltura();
				idAlturaMax=pacientes[i].getId();
			}
			if(pacientes[i].getPeso()<pesoMin) {
				pesoMin=pacientes[i].getPeso();
				idPesoMin=pacientes[i].getId();
			}
		}
		
		System.out.println();
		System.out.println("El paciente "+pacientes[idAlturaMax-1].getId()+" tiene la altura maxima de "+alturaMax);
		System.out.println();
		System.out.println("El paciente "+pacientes[idPesoMin-1].getId()+" tiene el peso minimo de "+pesoMin);
	}

}
