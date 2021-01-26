package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E03CustomMinConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> printMinValue = intArr -> System.out.println(Arrays.stream(intArr).min().getAsInt());

        printMinValue.accept(numbers);
    }
}
