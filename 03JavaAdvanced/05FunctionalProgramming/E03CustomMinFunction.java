package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMinValue = E03CustomMinFunction::getMinValue;

        int minValue = findMinValue.apply(numbers);

        System.out.println(minValue);
    }

    private static int getMinValue(int[] intArr) {
        int min = Integer.MAX_VALUE;
        for (int x : intArr) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
}
