package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        printMiddlecharacter(str);
    }

    private static void printMiddlecharacter(String str) {

        if (str.length() % 2 != 0){
            char middleCharacter = str.charAt(str.length() / 2);
            System.out.println(middleCharacter);
        }else{
            String firstMiddleCharacter = Character.toString(str.charAt((str.length() / 2) - 1));
            String secondMiddleCharacter = Character.toString(str.charAt(str.length() / 2));
            System.out.println(firstMiddleCharacter+secondMiddleCharacter);
        }
    }
}
