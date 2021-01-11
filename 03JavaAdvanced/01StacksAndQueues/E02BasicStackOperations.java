package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N -> representing the number of elements to push onto the stack
        // S -> representing the number of elements to pop from the stack
        // X -> an element that you should check whether is present in the stack

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+"); // N, S, X // 5 2 13
        int numberToPush = Integer.parseInt(firstLine[0]);
        int numberToPop = Integer.parseInt(firstLine[1]);
        int lookUpNumber = Integer.parseInt(firstLine[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numberToPush; i++) {
            stackOfNumbers.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numberToPop; i++) {
            stackOfNumbers.pop();
        }

        if (stackOfNumbers.contains(lookUpNumber)) {
            System.out.println("true");
        } else {
            if (!stackOfNumbers.isEmpty()) {
                // min element
                System.out.println(Collections.min(stackOfNumbers)); // Collection
            } else {
                System.out.println(0);
            }
        }
    }
}
