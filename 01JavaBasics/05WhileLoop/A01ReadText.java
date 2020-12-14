package bg.softuni.basics;

import java.util.Scanner;

public class A01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String words = scanner.nextLine();
            if (words.equals("Stop")){
                break;
            }
            System.out.println(words);
        }
    }
}
