package punto6;

import java.util.Scanner;

public class Helper {

 static Scanner scanner = new Scanner(System.in);

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

 
 public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
     Integer integerValue = 0;
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
     return getInteger(scanner, inputMessage, "Ingrese un numero valido");
 }
 public static Integer getInteger(String inputMessage, String errorMessage) {
     return getInteger(Helper.scanner, inputMessage, errorMessage);
 }
 public static Integer getInteger(String inputMessage) {
     return getInteger(Helper.scanner, inputMessage, "Ingrese un numero valido");
 }
 
 
 public static Integer getRango(Scanner scanner, String inputMessage, String errorMessage) {
     Integer integerValue;
     while (true) {
         try {
             System.out.print(inputMessage);
             integerValue = Integer.parseInt(scanner.nextLine());
             if (integerValue>=1 && integerValue<=5) {
                 return integerValue;
             }else {
            	 System.out.println("Ingrese un rango valido (entre 1 y 5)");
             }
         }
         catch (Exception exception) {
             System.out.println(errorMessage);
         }
     }
 }
 
 public static Integer getRango(Scanner scanner, String inputMessage) {
     return getRango(scanner, inputMessage, "Ingrese un rango valido (entre 1 y 5)");
 }
 public static Integer getRango(String inputMessage, String errorMessage) {
     return getRango(Helper.scanner, inputMessage, errorMessage);
 }
 public static Integer getRango(String inputMessage) {
     return getRango(Helper.scanner, inputMessage, "Ingrese un rango valido (entre 1 y 5)"); 	 
 }
 
 
 
 public static Long getCuit(Scanner scanner, String inputMessage, String errorMessage) {
     Long value;
     while (true) {
         try {
             System.out.print(inputMessage);
             value = scanner.nextLong();
             if  (value>= (long)10000000000L && value<=99999999999L) {
                 return value;
             }else {
            	 System.out.println("El cuit debe ser un numero de 11 cifras...");
             }
         }
         catch (Exception exception) {
             System.out.println(errorMessage);
         }
     }
 }
 
 public static Long getCuit(Scanner scanner, String inputMessage) {
     return getCuit(scanner, inputMessage, "El cuit debe ser un numero de 11 cifras valido...");
 }
 public static Long getCuit(String inputMessage, String errorMessage) {
     return getCuit(Helper.scanner, inputMessage, errorMessage);
 }
 public static Long getCuit(String inputMessage) {
     return getCuit(Helper.scanner, inputMessage, "El cuit debe ser un numero de 11 cifras valido..."); 	 
 }
 
}