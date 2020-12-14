package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println(calculate(a, operator, b));
    }

    //II.	Returning Values and Overloading
    private static int calculate(int firstNumber, String operator, int secondNumber) {
        int result = 0;
        switch (operator){
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            default:
                break;
        }
        return result;
    }
}
