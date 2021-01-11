package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06BalancedParenthesesLookUpTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stackOfOpenParentheses = new ArrayDeque<>();
        String lookUpTable = "({[";

        boolean areBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            // open
            if (lookUpTable.contains(String.valueOf(currentBracket))){ // currentBracket + ""
                stackOfOpenParentheses.push(currentBracket);
                // closed
            } else {
                if (stackOfOpenParentheses.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char open = stackOfOpenParentheses.pop();

                if (open != '{' && currentBracket == '}'){
                    areBalanced = false;
                } else if (open != '[' && currentBracket == ']'){
                    areBalanced = false;
                } else if (open != '(' && currentBracket == ')'){
                    areBalanced = false;
                }
            }

        }
        String output = areBalanced ? "YES" : "NO";
        System.out.println(output);
    }
}
