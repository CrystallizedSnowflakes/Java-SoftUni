package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int repetitionCount = scanner.nextInt();

        String repeatedString = repeatString(s, repetitionCount);
        System.out.println(repeatedString);

    }

    //II.	Returning Values and Overloading
    private static String repeatString(String str, int count) {
        //StringBuilder result = new StringBuilder();
        //String result = "";
        String[]repetitions = new String[count];
        for (int i = 0; i < count; i++) {
            //result.append(str);  // DO NOT USE
            //result += str;       // DO NOT USE
            repetitions[i] = str;
        }
        //return result.toString();
        String repeated = String.join("", repetitions);
        return repeated;

    }
}
