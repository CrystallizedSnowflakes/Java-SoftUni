package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01ReverseNumbersWithAStackPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackOfNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(stackOfNumbers::push);

        while (stackOfNumbers.size() > 1){
            System.out.print(stackOfNumbers.pop() + " ");
        }
        System.out.print(stackOfNumbers.pop());
    }
}
