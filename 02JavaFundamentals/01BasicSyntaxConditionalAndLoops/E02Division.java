package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E02Division {
    public static void main(String[] args) {
        int age = new Scanner(System.in).nextInt();
        int divisor = 0;

        if (age % 10 == 0){
            divisor = 10;
        } else if (age % 7 == 0){
            divisor = 7;
        }else if (age % 6 == 0){
            divisor = 6;
        }else if (age % 3 == 0){
            divisor = 3;
        }else if (age % 2 == 0) {
            divisor = 2;
        }
        if((age % 2 == 0) || (age % 3 == 0) || (age % 6 == 0) || (age % 7 == 0) || (age % 10 == 0)){
            System.out.printf("The number is divisible by %d", divisor);
        }else {
            System.out.println("Not divisible");
        }
    }
}
