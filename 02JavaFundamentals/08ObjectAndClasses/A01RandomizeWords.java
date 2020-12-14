package bg.softuni.javafundamentals;

import java.util.Random;
import java.util.Scanner;

public class A01RandomizeWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //I.	Using the Built-in Java Classes

        String[]words = scanner.nextLine().split("\\s+");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int x = rnd.nextInt(words.length);
            int y = rnd.nextInt(words.length);
            String oldWordsX = words[x];
            words[x] = words[y];
            words[y] = oldWordsX;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
