package bg.softuni.javafundamentals;

import java.util.Random;
import java.util.Scanner;

public class A01RandomizeWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //I.	Using the Built-in Java Classes

        String[]words = scanner.nextLine().split("\\s+");

        Random rnd = new Random();

        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            String swap = words[pos1];
            words[pos1] = words[pos2];
            words[pos2] = swap;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
