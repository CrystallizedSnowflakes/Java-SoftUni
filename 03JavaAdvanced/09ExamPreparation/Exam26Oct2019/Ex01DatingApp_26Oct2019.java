package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex01DatingApp_26Oct2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] males = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        for (int male : males) {
            stackMales.push(male);
        }

        ArrayDeque<Integer> queueFemales = new ArrayDeque<>();
        for (int female : females) {
            queueFemales.offer(female);
        }

        int matchesCount = 0;
        while (!queueFemales.isEmpty() && !stackMales.isEmpty()) {

            if (queueFemales.peek() <= 0){
                queueFemales.poll();
                continue;
            }

            if (stackMales.peek() <= 0){
                stackMales.pop();
                continue;
            }

            if (queueFemales.peek() % 25 == 0) {
                queueFemales.poll();
                if (!queueFemales.isEmpty()) {
                    queueFemales.poll();
                }
                continue;
            }

            if (stackMales.peek() % 25 == 0){
                stackMales.pop();
                if (!stackMales.isEmpty()){
                    stackMales.pop();
                }
                continue;
            }

            if (queueFemales.peek() == stackMales.peek()) {
                matchesCount++;
                queueFemales.poll();
                stackMales.pop();
            } else {
                queueFemales.poll();
                int decreasedMale = stackMales.pop() - 2;
                if (decreasedMale > 0) {
                    stackMales.push(decreasedMale);
                }
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);

        if (stackMales.isEmpty()){
            System.out.println("Males left: none");
        } else {
            StringBuilder sbMales = new StringBuilder("Males left: ");
            while (stackMales.size() > 1){
                sbMales.append(stackMales.pop()).append(", ");
            }
            sbMales.append(stackMales.pop());
            System.out.println(sbMales.toString());
            /*System.out.printf("Males left: %s%n",
                    stackMales.stream().map(String::valueOf).collect(Collectors.joining(", ")));*/
        }

        if (queueFemales.isEmpty()){
            System.out.println("Females left: none");
        } else {
            StringBuilder sbFemales = new StringBuilder("Females left: ");
            while (queueFemales.size() > 1){
                sbFemales.append(queueFemales.poll()).append(", ");
            }
            sbFemales.append(queueFemales.poll());
            System.out.println(sbFemales.toString());
        }
    }
}
