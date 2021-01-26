package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E04AppliedArithmeticsList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addOne = arr -> arr.stream().map(e -> e += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyByTwo = arr -> arr.stream().map(e -> e *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractOne = arr -> arr.stream().map(e -> e -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printer = arr -> arr.forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
