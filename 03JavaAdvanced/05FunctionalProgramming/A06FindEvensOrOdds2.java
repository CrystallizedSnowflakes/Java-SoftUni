package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class A06FindEvensOrOdds2 {
    public static void main(String[] args) {
        final String odd = "odd";

        Scanner scanner = new Scanner(System.in);
        int startNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();
        scanner.nextLine();
        String filter = scanner.nextLine();

        Predicate<Integer> condition = null;
        if (filter.equals(odd)){
            condition = n -> n % 2 != 0;
        }else {
            condition = n -> n % 2 == 0;
        }

        IntStream.range(startNumber, endNumber + 1)
                .boxed()
                .filter(condition)
                .forEach(n -> System.out.print(n + " "));
    }
}
