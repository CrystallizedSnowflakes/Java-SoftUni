package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class A02SimpleCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+"); //
        // 2 - 2 + 5
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        // 0 = "2"
        // 1 = "-"
        // 2 = "2"
        // 3 = "+"
        // 4 = "5"

        while (stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            switch (operator){
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
                default:
                    System.out.println("The operator is invalid " + operator);
                    break;
            }
        }
    }
}
