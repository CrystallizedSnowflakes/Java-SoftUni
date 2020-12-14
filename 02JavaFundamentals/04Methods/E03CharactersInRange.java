package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstCh = scanner.next().charAt(0);
        char secondCh = scanner.next().charAt(0);

        //printASCIICharactersBetweenTwo(firstCh, secondCh);
        printCharactersInRange(firstCh, secondCh);
    }

    public static void printCharactersInRange(char first, char second){
        //int number = first;
        if (first < second){
            for (char i = (char)(first + 1); i < second; i++) {
                System.out.print(i + " ");
            }
        }else{
            for (char i = (char)(second + 1); i < first; i++) {
                System.out.print(i + " ");
            }
        }
    }

//    private static void printASCIICharactersBetweenTwo(String firstChar, String lastChar) {
//        int minNum = Math.min(firstChar.charAt(0),lastChar.charAt(0));
//        int maxNum = Math.max(firstChar.charAt(0),lastChar.charAt(0));
//        int startNumber = minNum + 1;
//        int length = maxNum - startNumber;
//
//        String[]repetitions = new String[length];
//
//        for (int i = 0; i < repetitions.length; i++) {
//            int number = startNumber + i;
//            repetitions[i] = String.valueOf((char)number);
//        }
//        System.out.println(String.join(" ", repetitions));
//    }
}
