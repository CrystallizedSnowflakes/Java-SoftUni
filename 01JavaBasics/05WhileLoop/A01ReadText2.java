package bg.softuni.basics;

import java.util.Scanner;

public class A01ReadText2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        while (!word.equals("Stop")){
            System.out.println(word);
            word = scanner.nextLine();
        }
    }
}
