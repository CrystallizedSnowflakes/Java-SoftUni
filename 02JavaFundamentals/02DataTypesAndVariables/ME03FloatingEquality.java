package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();

        double eps = 0.000001;
        double difference = Math.abs(firstNum - secondNum);
        if (difference >= eps){
            System.out.println("False");
        }else{
            System.out.println("True");
        }
    }
}
