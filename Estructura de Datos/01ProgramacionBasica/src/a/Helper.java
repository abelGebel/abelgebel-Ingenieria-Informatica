package a;
import java.util.Scanner;

public class Helper {
	
	static Scanner scanner = new Scanner(System.in);
	 
	 
    //region Character Helpers
    public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage,char[] charValues ) {
        String string;
        char characterValue;
        while (true) {
            System.out.print(inputMessage);
            try {
                
            	string = scanner.nextLine();
            	
            	if(string.length() == 1) {
            		characterValue = string.charAt(0);
            		for(int i=0;i<charValues.length;i++) {
                        if(Character.toLowerCase(characterValue)==charValues[i]) {
                            return characterValue;
                        }
                	}
                    System.out.println(errorMessage);
            		
            	}else {
                    System.out.println(errorMessage);
            	}
            	
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Character getCharacter(Scanner scanner, String inputMessage) {
    	char[] charValues = {'s','n'};
        return getCharacter(scanner, inputMessage, "Ingrese un caracter valido",charValues);
    }
    public static Character getCharacter(String inputMessage, String errorMessage) {
    	char[] charValues = {'s','n'};
        return getCharacter(Helper.scanner, inputMessage, errorMessage,charValues);
    }
    public static Character getCharacter(String inputMessage) {
    	char[] charValues = {'s','n'};
        return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter valido",charValues);
    }
 
 
    //region Integer Helpers
    public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Integer getInteger(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un valor valido");
    }
    public static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }
    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un valor valido");
    }


    public static Integer getIntegerPositivo(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                if (integerValue>=0) {
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
    public static Integer getIntegerPositivo(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un valor valido");
    }
    public static Integer getIntegerPositivo(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }
    public static Integer getIntegerPositivo(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un valor valido");
    }
    
    
    public static double getFloat(Scanner scanner, String inputMessage, String errorMessage) {
        double floatValue;
        while (true) {
            try {
                System.out.print(inputMessage);
                floatValue = scanner.nextDouble();
                return floatValue;                          
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    public static double getFloat(Scanner scanner, String inputMessage) {
        return getFloat(scanner, inputMessage, "Ingrese un valor valido");
    }
    public static double getFloat(String inputMessage, String errorMessage) {
        return getFloat(Helper.scanner, inputMessage, errorMessage);
    }
    public static double getFloat(String inputMessage) {
        return getFloat(Helper.scanner, inputMessage, "Ingrese un valor valido");
    }
}