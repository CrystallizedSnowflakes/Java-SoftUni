package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> bracketIndexesStack = new ArrayDeque();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '('){
                bracketIndexesStack.push(i);
            } else if (symbol == ')'){
                int openingIndex = bracketIndexesStack.pop();
                int closingIndex = i;
                System.out.println(expression.substring(openingIndex, closingIndex + 1));
            }
        }
    }
}
