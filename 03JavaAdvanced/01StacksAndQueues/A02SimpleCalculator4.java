package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A02SimpleCalculator4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> digits = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))){
                digits.push(Integer.parseInt(input[i]));
            } else if (input[i].charAt(0) == '+'){
                Integer left = digits.pop();
                Integer right = Integer.parseInt(input[i + 1]);
                Integer result = left + right;
                digits.push(result);
                i++;
            } else if (input[i].charAt(0) == '-'){
                Integer left = digits.pop();
                Integer right = Integer.parseInt(input[i + 1]);
                Integer result = left - right;
                digits.push(result);
                i++;
            }
        }
        System.out.println(digits.peek());
    }
}
