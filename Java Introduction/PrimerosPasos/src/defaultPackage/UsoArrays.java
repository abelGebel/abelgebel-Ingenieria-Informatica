package defaultPackage;

public class UsoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] matriz = new int[5];
		//int[] matriz = {5,23,33,11,0};
		matriz[0]=5;
		matriz[1]=23;
		matriz[2]=33;
		matriz[3]=11;
		matriz[4]=0;
		
		for(int i=0;i<matriz.length;i++) {
			System.out.println(i+": "+matriz[i]);
		}
	}

}
