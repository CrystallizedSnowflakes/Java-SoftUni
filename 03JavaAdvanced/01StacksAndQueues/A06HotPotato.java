package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
//        Collections.addAll(childrenQueue, children);
        for (String child : children) {
            childrenQueue.offer(child);
        }

        while (childrenQueue.size() > 1){
            for (int i = 1; i < n; i++) {
                String child = childrenQueue.poll(); // delete first child
                childrenQueue.offer(child); // put it behind
            }
            System.out.println("Removed " + childrenQueue.poll());
        }
        System.out.println("Last is " + childrenQueue.poll());
    }
}
