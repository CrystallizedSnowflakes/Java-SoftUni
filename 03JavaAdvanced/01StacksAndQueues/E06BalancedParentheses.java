package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stackOfOpenParentheses = new ArrayDeque<>();

        boolean areBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            // open
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '('){
                stackOfOpenParentheses.push(currentBracket);
                // closed
            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')'){
                if (stackOfOpenParentheses.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char open = stackOfOpenParentheses.pop();
                if (currentBracket == '}' && open != '{'){
                    areBalanced = false;
                } else if (currentBracket == ']' && open != '['){
                    areBalanced = false;
                } else if (currentBracket == ')' && open != '('){
                    areBalanced = false;
                }
            }

        }
        System.out.println(areBalanced ? "YES" : "NO");
    }
}
