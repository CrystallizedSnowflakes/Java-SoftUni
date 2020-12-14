package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A01StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        double grade = scanner.nextDouble();

        System.out.printf("Name: %s, Age: %d, Grade: %.2f%n", name, age, grade);
        // %s -> String
        // %d -> Digit / %03d  5->005 | 500->500
        // %f -> Floating Point Number / %.2f  2->2.00 | 5.533334->5.53

        //nextInt()
        //nextLine() -> empty row / DO NOT USE

        //nextLine()
        //nextInt() -> OK
    }
}
