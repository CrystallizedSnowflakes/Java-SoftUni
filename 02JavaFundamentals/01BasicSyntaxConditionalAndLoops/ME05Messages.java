package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfInputs; i++) {
            String input = scanner.nextLine();
            int mainDigit = input.charAt(0) - 48; // if "2" return 2  if "0" return 0
            if (mainDigit == 0){
                System.out.print(" ");
                continue;
            }
            int offset;
            if (mainDigit == 8 || mainDigit == 9){
                offset = ((mainDigit - 2) * 3) + 1;
            }else{
                offset = (mainDigit - 2) * 3;
            }
            int letterIndex = offset + input.length() - 1;
            char letter = (char) ('a' + letterIndex);
            System.out.print(letter);
        }
    }
}
