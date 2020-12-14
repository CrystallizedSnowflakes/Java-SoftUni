package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String valueType = scanner.nextLine().toLowerCase();

        switch(valueType){
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNum,secondNum));
                break;
            case "char":
                char firstCh = scanner.nextLine().charAt(0);
                char secondCh = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstCh, secondCh));
                break;
            case "string":
                String firstStr = scanner.nextLine();
                String secondStr = scanner.nextLine();
                System.out.println(getMax(firstStr, secondStr));
                break;
            default:
                break;
        }
    }

    //II.	Returning Values and Overloading
    private static int getMax(int firstNumber, int secondNumber){
        if (firstNumber > secondNumber){
            return firstNumber;
        }
        return secondNumber;
    }
    private static char getMax(char firstChar, char secondChar){
        if (firstChar > secondChar){
            return firstChar;
        }
        return secondChar;
    }
    private static String getMax(String firstString, String secondString){
        if (firstString.compareTo(secondString) >= 0){
            return firstString;
        }
        return secondString;
    }
}
