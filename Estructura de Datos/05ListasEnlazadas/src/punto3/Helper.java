package punto3;
import java.util.Random;
import java.util.Scanner;

 
public class Helper {
 
 
    static Scanner scanner = new Scanner(System.in);
 
 
    //region Character Helpers
    public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage) {
        Character characterValue;
        while (true) {
            System.out.print(inputMessage);
            try {
                characterValue = scanner.nextLine().charAt(0);
                return characterValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Character getCharacter(Scanner scanner, String inputMessage) {
        return getCharacter(scanner, inputMessage, "Ingrese un caracter valido");
    }
    public static Character getCharacter(String inputMessage, String errorMessage) {
        return getCharacter(Helper.scanner, inputMessage, errorMessage);
    }
    public static Character getCharacter(String inputMessage) {
        return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter valido");
    }
 
 
    //region Integer Helpers
    public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                if(integerValue>0) {
                    return integerValue;

                }else {
                    System.out.println(errorMessage);
                }
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Integer getInteger(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un numero valido");
    }
    public static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }
    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un numero valido");
    }
    
    public static Character caracterRandom(Random random) {
		Character arregloCaracteres[]= {'a','b','c','d','e','g','h','i','k','l','m',
				'o','p','u','1','2','3','4','5','6','7','8','9','0','|','.',':','-',
				'+'};
		return arregloCaracteres[random.nextInt(0,29)];	
    }
}