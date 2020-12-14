package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A02MatchPhoneNumber {
    public static void main(String[] args) {
        String expression = "\\+359([- ])2(\\1)[\\d]{3}(\\1)\\d{4}\\b";
        String text = new Scanner(System.in).nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        List<String> matchedPhones = new ArrayList<>();
        while (matcher.find()){
            matchedPhones.add(matcher.group());
        }
        System.out.print(String.join(", ", matchedPhones));
    }
}
