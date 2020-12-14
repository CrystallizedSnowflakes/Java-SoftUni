package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A03Substring3Contains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(key)){
            text = text.replace(key, "");

        }
        System.out.println(text);
    }
}
