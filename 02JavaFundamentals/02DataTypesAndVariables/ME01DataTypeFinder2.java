package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME01DataTypeFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();

        while(!input.equals("end")) {
            String type = "";

            boolean isNegative = false;
            int integers = 0;
            int dots = 0;
            char firstChar = input.charAt(0);
            int zero = 0;

            if(input.length() == 1){
                if(firstChar >= '0' && firstChar <= '9'){
                    type = "integer";
                }else{
                    type = "character";
                }

            }else {
                for (int i = 0; i < input.length(); i++) {
                    char currentChar = input.charAt(i);

                    if (firstChar == '-') {
                        isNegative = true;
                    }
                    if (currentChar == '.') {
                        dots++;
                    }
                    if (currentChar == '0'){
                        zero++;
                    }
                    if (currentChar >= '0' && currentChar <= '9') {
                        integers++;
                        if (((dots == 0 && input.length() == integers) && (zero != integers))||
                                ((dots == 0 && (input.length() == (integers + 1)) && isNegative
                                && (zero != integers)))) {
                            type = "integer";
                        } else if ((dots == 1 && input.length() == integers + 1) ||
                                (dots == 1 && (input.length() == integers + 2) && isNegative
                                && (zero != integers))) {
                            type = "floating point";
                        } else {
                            type = "string";
                        }
                    } else {
                        if (input.equals("true") || input.equals("false")) {
                            type = "boolean";
                        }else{
                            type = "string";
                        }
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);
            input = scanner.nextLine().trim().toLowerCase();
        }
    }
}
