package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();
        int fourthNum = scanner.nextInt();

        secondNum += firstNum;
        secondNum /= thirdNum;
        secondNum *= fourthNum;

        System.out.println(secondNum);

    }
}
