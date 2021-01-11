package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A02SimpleCalculator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> digits = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))){
                digits.push(Integer.parseInt(input[i]));
            } else if (input[i].charAt(0) == '+'){
                addOrSubtract(digits, input[i + 1], '+');
                i++;
            } else if (input[i].charAt(0) == '-'){
                addOrSubtract(digits, input[i + 1], '-');
                i++;
            }
        }
        System.out.println(digits.peek());
    }

    private static void addOrSubtract(ArrayDeque<Integer> digits, String s, char operation) {
        Integer left = digits.pop();
        Integer right = Integer.parseInt(s);
        Integer result = 0;
        if (operation == '+') {
            result = left + right;
        } else {
            result = left - right;
        }
        digits.push(result);
    }
}
