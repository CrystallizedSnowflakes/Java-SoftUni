package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E02BasicStackOperationsStreamMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N -> representing the number of elements to push onto the stack
        // S -> representing the number of elements to pop from the stack
        // X -> an element that you should check whether is present in the stack

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))  // N, S, X // 5 2 13
                        .mapToInt(Integer::parseInt)
                        .toArray();

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")) // 1 13 45 32 4
                .mapToInt(Integer::parseInt)
                .limit(tokens[0])
                .forEach(stackOfNumbers::push); // 4 32 45 13 1

        for (int i = 0; i < tokens[1]; i++) {
            stackOfNumbers.pop();
        }

        if (stackOfNumbers.contains(tokens[2])) {
            System.out.println("true");
        } else {
            // min element
            System.out.println(stackOfNumbers.stream().mapToInt(e -> e).min().orElse(0));  // stream
        }
    }
}
