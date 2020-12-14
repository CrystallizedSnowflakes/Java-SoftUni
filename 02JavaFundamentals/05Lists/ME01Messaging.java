package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01Messaging {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String text = scanner.nextLine();

        String output = "";

        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i);
            int sum = 0;
            while (element != 0){
                int lastDigit = element % 10;
                element /= 10;
                sum += lastDigit;
            }

            if (sum > text.length()){
                sum -= text.length();
            }

            output += String.valueOf(text.charAt(sum));

            String firstPart = text.substring(0, sum);
            String secondPart = text.substring(sum + 1);

            text = firstPart + secondPart;
        }

        System.out.println(output);
    }
}
