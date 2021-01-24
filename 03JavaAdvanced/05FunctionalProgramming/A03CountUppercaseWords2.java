package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A03CountUppercaseWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textAsList = scanner.nextLine().split("\\s+");

        Predicate<String> isFirstLetterWithUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < textAsList.length; i++) {
            if (isFirstLetterWithUpperCase.test(textAsList[i])){
                result.add(textAsList[i]);
            }
        }

        System.out.println(result.size());
        System.out.println(result.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
