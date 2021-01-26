package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMinValue = intArr ->
                Arrays.stream(intArr).min().getAsInt();


        int minValue = findMinValue.apply(numbers);

        System.out.println(minValue);
    }
}
