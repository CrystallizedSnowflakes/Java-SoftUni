package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A03PassedOrFailed {
    public static void main(String[] args) {
        //double grade = Double.parseDouble(new Scanner(System.in).nextLine());
        double grade = new Scanner(System.in).nextDouble();
        if (grade >= 3){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
    }
}
