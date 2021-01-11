package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N -> representing the number of elements to enqueue (add)
        // S -> representing the number of elements to dequeue (remove/poll) from the queue
        // X -> an element that you should check whether is present in the queue

        ArrayDeque<Integer> queueOfNumbers = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+"); // N, S, X // 5 2 13
        int numberToOffer = Integer.parseInt(firstLine[0]);
        int numberToPoll = Integer.parseInt(firstLine[1]);
        int lookUpNumber = Integer.parseInt(firstLine[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numberToOffer; i++) {
            queueOfNumbers.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numberToPoll; i++) {
            queueOfNumbers.poll();
        }

        //System.out.println(stackOfNumbers.stream().mapToInt(e -> e).min().orElse(0);
        if (queueOfNumbers.isEmpty()){
            System.out.println(0);
        } else {
            if (queueOfNumbers.contains(lookUpNumber)) {
                System.out.println("true");
            } else {
                // min element
                //System.out.println(stackOfNumbers.stream().mapToInt(e -> e).min().getAsInt());  // stream
                //System.out.println(Collections.min(stackOfNumbers));                            // Collection
                System.out.println(getMinElement(queueOfNumbers));                                // Algorithm for min element
            }
        }
    }

    private static int getMinElement(ArrayDeque<Integer> stackOfNumbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : stackOfNumbers) {
            if (number < min){
                min = number;
            }
        }
        return min;
    }
}
