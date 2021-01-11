package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]){
                case "1":
                    int number = Integer.parseInt(command[1]);
                    stack.push(number);
                    break;
                case  "2":
                    stack.pop();
                    break;
                case "3":
                    //System.out.println(Collections.max(stack));
                    //System.out.println(stack.stream().mapToInt(e -> e).max().getAsInt());
                    System.out.println(getMaxNumber(stack));
                    break;
            }
        }
    }

    private static int getMaxNumber(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer number : stack) {
            if (number > max){
                max = number;
            }
        }
        return max;
    }
}
