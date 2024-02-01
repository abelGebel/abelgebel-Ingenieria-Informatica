package punto3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static Scanner scanner = new Scanner(System.in);

    public static int readInt (String message) {
        String numberString;
        do {
            numberString = readStringLine(message);
            try {
                return Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: El valor que ingreso no corresponde a un número entero valido.");
            }
        } while (true);
    }

    public static float readFloat (String message) {
        String numberString;
        do {
            numberString = readStringLine(message);
            try {
                return Float.parseFloat(numberString);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: El valor que ingreso no corresponde a un número real valido.");
            }
        } while (true);
    }

    public static String readStringLine (String message) {
        String text;
        do {
            System.out.print(message);
            text = scanner.nextLine();
        } while (text.isBlank());
        return text;
    }

    public static char readCharLowerCase (String message) {
        return Character.toLowerCase(readChar(message));
    }

    public static char readCharUpperCase (String message) {
        return Character.toUpperCase(readChar(message));
    }

    public static char readChar (String message) {
        String text;
        do {
            text = readStringLine(message);
            if (text.length() > 1){
                System.out.println("ERROR: No puede ingresar mas de un carácter.");
                continue;
            }
            return text.charAt(0);
        } while (true);
    }

    public static boolean askYesOrNot(String message) {
        char answer;
        do {
            answer = readCharLowerCase(message);
            if (answer != 'n' && answer != 's') {
                System.out.println("ERROR: La entrada debe ser 'S' o 'N'.");
                continue;
            }
            return answer == 's';
        } while (true);
    }

    public static int readPositiveInt (String message) {
        int number;
        do {
            number = readInt(message);
            if (number > 0)
                return number;
            System.out.println("ERROR: El número ingresado no es positivo.");
        } while (true);
    }

    public static float readPositiveFloat (String message) {
        float number;
        do {
            number = readFloat(message);
            if (number > 0)
                return number;
            System.out.println("ERROR: El número ingresado no es positivo.");
        } while (true);
    }

    public static int readPositiveIntWithZero (String message) {
        int number;
        do {
            number = readInt(message);
            if (number >= 0)
                return number;
            System.out.println("ERROR: El número ingresado no es mayor o igual a cero.");
        } while (true);
    }

    public static float readPositiveFloatWithZero (String message) {
        float number;
        do {
            number = readFloat(message);
            if (number >= 0)
                return number;
            System.out.println("ERROR: El número ingresado no es mayor o igual a cero.");
        } while (true);
    }

    public static int readRangeInt(int min, int max, String message) {
        int number;
        do {
            number = readInt(message);
            if (number >= min && number <= max)
                return number;
            System.out.println("ERROR: El numero ingresado esta fuera del rango.");
        } while (true);
    }

    public static float readRangeFloat(float min, float max, String message) {
        float number;
        do {
            number = readFloat(message);
            if (number >= min && number <= max)
                return number;
            System.out.println("ERROR: El numero ingresado esta fuera del rango.");
        } while (true);
    }

    public static int randomIntNumber (int max) {
        return randomIntNumber(1,max);
    }

    public static int randomIntNumber (int min, int max) {
        return (int) Math.round((Math.random()*(max-min))+min);
    }

    public static float randomFloatNumber (int max) {
        return randomIntNumber((100), (max*100))/100f;
    }

    public static float randomFloatNumber (int min, int max) {
        return randomIntNumber((min*100), (max*100))/100f;
    }

    public static boolean randomBoolean () {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static LocalDate readLocalDate () {
        String date;
        do {
            date = readStringLine("Introduzca la fecha con formato yyyy-mm-dd: ");
            try {
                return LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println("ERROR: El fecha ingresada no corresponde a una formato valido o a una fecha existente.");
            }
        } while (true);
    }

    public static LocalDate readCurrentLocalDate () {
        LocalDate localDate;
        do {
            localDate = readLocalDate();
            if (!localDate.isBefore(LocalDate.now()))
                return localDate;
            System.out.println("ERROR: La fecha introducida no puede ser anterior a la fecha actual.");
        } while (true);
    }

}