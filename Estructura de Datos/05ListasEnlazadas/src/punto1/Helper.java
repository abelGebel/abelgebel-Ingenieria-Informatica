package punto1;
import java.util.Scanner;
 
public class Helper {
 
    static Scanner scanner = new Scanner(System.in);
 
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
        return getInteger(scanner, inputMessage, "Ingrese un numero valido");
    }
    public static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }
    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un numero valido");
    }
}