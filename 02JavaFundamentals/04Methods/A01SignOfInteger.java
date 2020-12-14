package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A01SignOfInteger {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        getSignOfInteger(n);
    }

    //I.	Declaring and Invoking Methods (void = print)
    private static void getSignOfInteger(int number){
        if (number < 0){
            System.out.printf("The number %d is negative.%n", number);
        }else if(number > 0){
            System.out.printf("The number %d is positive.%n", number);
        }else{
            System.out.printf("The number %d is zero.%n", number);
        }
    }
}
