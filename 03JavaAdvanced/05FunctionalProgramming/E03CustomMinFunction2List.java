package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E03CustomMinFunction2List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //Function<List<Integer>, Integer> getMinValue = Collections::min;

        Function<List<Integer>, Integer> getMinValue = list ->
                list.stream().min(Integer::compareTo).orElse(-1);
                //list.stream().min(Integer::compareTo).get();

        int minValue = getMinValue.apply(numbers);

        System.out.println(minValue);
    }
}
