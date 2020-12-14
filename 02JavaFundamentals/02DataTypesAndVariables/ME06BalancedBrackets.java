package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME06BalancedBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        int closingBrackets = 0;
        int openingBrackets = 0;
        boolean isBalanced = true;

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine().trim();

            if (input.equals("(")) {
                openingBrackets++;

            }else if (input.equals(")")){
                closingBrackets++;
                if (openingBrackets - closingBrackets != 0){
                    isBalanced = false;
                }
            }
        }
        if (closingBrackets == openingBrackets && isBalanced){
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }
    }
}
