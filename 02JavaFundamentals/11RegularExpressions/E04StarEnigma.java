package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        String countExpression = "(?i)[star]"; //flag match UpperCase or LowerCase
        Pattern countPattern = Pattern.compile(countExpression);

        String validMsgExpression = "@(?<name>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<type>[A|D])![^@!:>-]*->(?<soldiers>\\d+)";
        Pattern validMsgPattern = Pattern.compile(validMsgExpression);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher countMatcher = countPattern.matcher(input);
            int counter = 0;
            while (countMatcher.find()){
                counter++;
            }
            StringBuilder decryptedMsg = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                decryptedMsg.append((char) (input.charAt(j) - counter));
            }

            countMatcher = validMsgPattern.matcher(decryptedMsg.toString()); // reuse of matcher
            if (countMatcher.find()){
                String planet = countMatcher.group("name");
                String type = countMatcher.group("type");
                if (type.equals("A")){
                    attacked.add(planet);
                }else {
                    destroyed.add(planet);
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.stream()
                .sorted(String::compareTo)
//                .sorted((a, b) -> a.compareTo(b))
                .forEach(a -> System.out.printf("-> %s%n", a));
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.stream()
                .sorted(String::compareTo)
                .forEach(d -> System.out.printf("-> %s%n", d));
    }
}
