package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E06TriplesOfLatinLetters {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    char firstChar = (char)('a'+ i);
//                    char secondChar = (char)('a' + j);
//                    char thirdChar = (char)('a' + k);
//                    String output = String.format("%s%s%s%n", firstChar, secondChar, thirdChar);
//                    System.out.printf(output);
//            }
//        }
//    }

        for (char i = 'a'; i < 'a' + n; i++) {
            for (char j = 'a'; j < 'a' + n; j++) {
                for (char k = 'a'; k < 'a' + n; k++) {
                    System.out.printf("%s%s%s%n", i, j, k);
                }
            }
        }
//        for (char i = 97; i < 97 + n; i++) {
//            for (char j = 97; j < 97 + n; j++) {
//                for (char k = 97; k < 97 + n; k++) {
//                    System.out.printf("%s%s%s%n", i, j, k);
//                }
//            }
//        }
    }
}
