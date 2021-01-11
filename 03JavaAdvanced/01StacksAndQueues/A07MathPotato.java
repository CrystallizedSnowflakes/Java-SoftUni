package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        // only for queue as stream use add // not applicable for stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(childrenQueue::offer);

        //String[] children = scanner.nextLine().split("\\s+");
        //Collections.addAll(childrenQueue, children);
        //for (String child : children) {
        //    childrenQueue.offer(child);
        //}
        int n = Integer.parseInt(scanner.nextLine());

        int cycles = 1; // 0 and 1 are not prime nums in the task
        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = childrenQueue.poll(); // delete first child
                childrenQueue.offer(child); // put it behind
            }
            if (isPrime(cycles)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            cycles++;
        }
        System.out.println("Last is " + childrenQueue.poll());
    }

    private static boolean isPrime(int number) { // 20=2*10, 4*5 ... 5*4, 10*2 => Math.sqrt(number)
        boolean primeCheck = true;
        if (number == 0 || number == 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }
}
