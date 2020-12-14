package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04PasswordValidator {
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

        //isPasswordValid(password);
    }

//    private static void isPasswordValid(String password) {
//        if (isLengthOfPasswordNotValid(password)) {
//            System.out.println("Password must be between 6 and 10 characters");
//        }
//        if(isPasswordNotOnlyOfLettersAndDigits(password)) {
//            System.out.println("Password must consist only of letters and digits");
//        }
//        if(doesPasswordHaveNotAtLeastTwoDigits(password)){
//            System.out.println("Password must have at least 2 digits");
//        }
//        if (!isLengthOfPasswordNotValid(password) && !isPasswordNotOnlyOfLettersAndDigits(password)
//                && !doesPasswordHaveNotAtLeastTwoDigits(password)){
//            System.out.println("Password is valid");
//        }
//    }

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

//    private static boolean isPasswordNotOnlyOfLettersAndDigits(String password) {
//        boolean isPasswordNotOnlyOfLettersAndDigits = false;
//
//        for (int i = 0; i < password.length(); i++) {
//            int number = password.charAt(i);
//            if (!((number >= 48 && 57 >= number) || (number >= 65 && 90 >= number)
//                    || (number >= 97 && 122 >= number))) {
//                isPasswordNotOnlyOfLettersAndDigits = true;
//            }
//        }
//        return isPasswordNotOnlyOfLettersAndDigits;
//    }
//
//    private static boolean isLengthOfPasswordNotValid(String password) {
//        boolean isLengthOfPasswordNotValid = false;
//        if (password.length() < 6 || 10 < password.length()){
//            isLengthOfPasswordNotValid = true;
//        }
//        return isLengthOfPasswordNotValid;
//    }
//
//    private static boolean doesPasswordHaveNotAtLeastTwoDigits(String password) {
//        boolean doesPasswordHaveNotAtLeastTwoDigits = false;
//        String[]symbols = password.split("");
//        int numbers = 0;
//        for (int i = 0; i < symbols.length; i++) {
//            if (symbols[i].equals("0") || symbols[i].equals("1")
//                    || symbols[i].equals("2") || symbols[i].equals("3")
//                    || symbols[i].equals("4") || symbols[i].equals("5")
//                    || symbols[i].equals("6") || symbols[i].equals("7")
//                    || symbols[i].equals("8") || symbols[i].equals("9")){
//                numbers++;
//            }
//        }
//        if (numbers < 2){
//            doesPasswordHaveNotAtLeastTwoDigits = true;
//        }
//        return doesPasswordHaveNotAtLeastTwoDigits;
//    }
}
