package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04PasswordValidator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isBetween = checkIfIsBetween(password);
        boolean consists = checkIfConsist(password);
        boolean hasTwoDigits = checkIfHasTwoDigits(password);

        if (isBetween && consists && hasTwoDigits){
            System.out.println("Password is valid");
        }

        if (!isBetween){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!consists){
            System.out.println("Password must consist only of letters and digits");
        }

        if (!hasTwoDigits){
            System.out.println("Password must have at least 2 digits");
        }
    }

    private static boolean checkIfIsBetween(String password){
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean checkIfConsist(String password){
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isLetter = Character.isLetter(symbol);
            boolean isDigit = Character.isDigit(symbol);
            if (!isDigit && !isLetter){
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfHasTwoDigits(String password){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)){
                count++;
            }
        }
        if (count >= 2){
            return true;
        }
        return false;
    }
}
