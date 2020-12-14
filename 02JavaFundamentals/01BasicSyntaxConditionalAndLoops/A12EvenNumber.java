package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A12EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(!(num % 2 == 0)){
            System.out.println("Please write an even number.");
            num = sc.nextInt();
        }
        System.out.printf("The number is: %d", Math.abs(num));
    }
}
