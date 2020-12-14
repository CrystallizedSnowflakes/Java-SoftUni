package bg.softuni.javafundamentals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A01MatchFullName {
    public static void main(String[] args) {
        String expression = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String text = new Scanner(System.in).nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
