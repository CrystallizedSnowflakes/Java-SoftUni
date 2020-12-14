package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A02Grades {
    public static void main(String[] args) {
        double grade = new Scanner(System.in).nextDouble();

        printInWords(grade);
    }

    //I.	Declaring and Invoking Methods (void = print)
    private static void printInWords(double grade){
        if (2.00 <= grade && grade <= 2.99){
            System.out.println("Fail");
        }else if(3.00 <= grade && grade <= 3.49){
            System.out.println("Poor");
        }else if(3.50 <= grade && grade <= 4.49){
            System.out.println("Good");
        }else if(4.50 <= grade && grade <= 5.49){
            System.out.println("Very good");
        }else if(5.50 <= grade && grade <= 6.00){
            System.out.println("Excellent");
        }
    }
}
