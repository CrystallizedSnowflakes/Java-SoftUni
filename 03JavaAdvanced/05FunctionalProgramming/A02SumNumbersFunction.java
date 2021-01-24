package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class A02SumNumbersFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCountStr =
                arr -> String.format("Count = %d", arr.length);

        System.out.println(getCountStr.apply(nums));

        Function<int[], String> getSumStr =
                arr -> "Sum = " + Arrays.stream(arr).sum();

        System.out.println(getSumStr.apply(nums));
    }
}
