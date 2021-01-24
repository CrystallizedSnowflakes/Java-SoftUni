package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.function.Predicate;

public class A06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();
        scanner.nextLine();
        String filter = scanner.nextLine();

        Predicate<Integer> condition = createTester(filter);

        printNumbers(startNumber, endNumber, condition);
    }

    private static void printNumbers(int startNumber, int endNumber, Predicate<Integer> condition) {
        for (int i = startNumber; i <= endNumber ; i++) {
            if (condition.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createTester(String filter) {
        Predicate<Integer> condition = null;
        switch (filter){
            case "odd":
                condition = n -> n % 2 != 0;
                break;
            case "even":
                condition = n -> n % 2 == 0;
                break;
        }
        return condition;
    }
}
