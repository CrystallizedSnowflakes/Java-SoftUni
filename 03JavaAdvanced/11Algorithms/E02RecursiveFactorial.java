package bg.softuni.javaadvanced;

import java.util.Scanner;

public class E02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(fact(number));
    }

    // n! = 5 * 4 * 3 * 2 * 1
    private static long fact(int number) {
        if (number == 1){
            return number;
        }
        return number * fact(number - 1);
    }
}