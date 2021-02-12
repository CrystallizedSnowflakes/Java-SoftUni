package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01Scheduling_25Oct2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasksStack::push);

        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int task = Integer.parseInt(scanner.nextLine());
        while (!threadsQueue.isEmpty()){
            int thread = threadsQueue.peek();
            int currentTask = tasksStack.peek();
            if (currentTask == task){
                System.out.printf("Thread with value %d killed task %d%n", thread, task);
                break;
            }

            threadsQueue.poll();
            if (thread >= currentTask){
                tasksStack.pop();
            }
        }

        while (!threadsQueue.isEmpty()){
            System.out.print(threadsQueue.poll() + " ");
        }
    }
}
