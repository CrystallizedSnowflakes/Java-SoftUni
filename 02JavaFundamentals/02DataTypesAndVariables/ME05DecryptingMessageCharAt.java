package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME05DecryptingMessageCharAt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte key = Byte.parseByte(scanner.nextLine());
        byte inputs = Byte.parseByte(scanner.nextLine());

        String decryptedMessage = "";
        for (int i = 0; i < inputs; i++) {
            String letter = scanner.nextLine();
            char symbol = (char) (letter.charAt(0) + key);
            decryptedMessage += symbol;
        }
        System.out.print(decryptedMessage);
    }
}
