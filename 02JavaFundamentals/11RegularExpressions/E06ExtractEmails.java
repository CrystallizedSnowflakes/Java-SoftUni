package bg.softuni.javafundamentals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String emailExpression = "(^|\\s+)(?<user>([A-Za-z\\d]+)(\\.|_|-)?([A-Za-z\\d]+))@(?<host>[A-Za-z]+((\\.|_|-)[A-Za-z]+)+)(\\b|\\s+)";
        // (^|(?<=\s) is this the beginning of the string or there is whitespaces
        // (\b|(?=\s)) is this the boundary /end/ or positive lookahead /there is whitespaces/
        Pattern emailPattern = Pattern.compile(emailExpression);
        Matcher emailMatcher = emailPattern.matcher(input);

        while (emailMatcher.find()){
            System.out.println(emailMatcher.group(0));
        }
    }
}
