package bg.softuni.javabasics;

import java.util.Scanner;

public class E06OperationsBetweenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        switch (operator){
            case "+":
                int sum = number1 + number2;
                if (sum % 2 == 0){
                    System.out.printf("%d + %d = %d - even", number1, number2, sum);
                }else{
                    System.out.printf("%d + %d = %d - odd", number1, number2, sum);
                }
                break;
            case "-":
                int diff = number1 - number2;
                if (diff % 2 == 0){
                    System.out.printf("%d - %d = %d - even", number1, number2, diff);
                }else{
                    System.out.printf("%d - %d = %d - odd", number1, number2, diff);
                }
                break;
            case "*":
                int product = number1 * number2;
                if (product % 2 == 0){
                    System.out.printf("%d * %d = %d - even", number1, number2, product);
                }else{
                    System.out.printf("%d * %d = %d - odd", number1, number2, product);
                }
                break;
            case "/":
                if (number2 == 0){
                    System.out.printf("Cannot divide %d by zero", number1);
                }else {
                    double division = (double) number1 / number2;
                    System.out.printf("%d / %d = %.2f", number1, number2, division);
                }
                break;
            case "%":
                if (number2 == 0){
                    System.out.printf("Cannot divide %d by zero", number1);
                }else{
                    int leftover = number1 % number2;
                    System.out.printf("%d %% %d = %d", number1, number2, leftover);
                }
                break;
        }
    }
}
