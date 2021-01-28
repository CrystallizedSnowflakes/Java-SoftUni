package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E07FindTheSmallestElementConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printRightmostIndexOfMinValue = list -> {
            //int min = Collections.min(list);
            int min = list.stream().min(Integer::compareTo).orElse(-1);
            System.out.println(list.lastIndexOf(min));

        };

        printRightmostIndexOfMinValue.accept(numbers);
    }
}
