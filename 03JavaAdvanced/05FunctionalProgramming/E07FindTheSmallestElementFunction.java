package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07FindTheSmallestElementFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getRightmostIndexOfMinValue = list -> {
            int min = Collections.min(list);
            return list.lastIndexOf(min);

        };

        System.out.println(getRightmostIndexOfMinValue.apply(numbers));
    }
}
