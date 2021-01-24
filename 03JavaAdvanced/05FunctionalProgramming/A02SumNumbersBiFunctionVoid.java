package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class A02SumNumbersBiFunctionVoid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AtomicInteger sum = new AtomicInteger();
        BiFunction<Integer, int[], Void> biFunctional =
                (e, count) -> {
                    sum.addAndGet(e);
                    ++count[0];
                    return null;
                };

        int[] count = new int[1];
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(e -> biFunctional.apply(e, count));

        System.out.println("Count = " + count[0]);
        System.out.println("Sum = " + sum);
    }
}
