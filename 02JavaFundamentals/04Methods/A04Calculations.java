package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine().toLowerCase();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        switch (command){
            case "add":
                add(a,b);
                break;
            case "multiply":
                multiply(a, b);
                break;
            case "subtract":
                subtract(a,b);
                break;
            case "divide":
                divide(a,b);
                break;
            default:
                break;
        }
    }

    //I.	Declaring and Invoking Methods (void = print)
    private static void add(int a, int b) {
        System.out.println(a + b);
    }
    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }
    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }
    private static void divide(int a, int b) {
        System.out.println(a / b);
    }
}
