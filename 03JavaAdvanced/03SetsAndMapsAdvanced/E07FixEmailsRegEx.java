package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07FixEmailsRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();
        ArrayDeque<String> data = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            data.offer(input);
            if (data.size() == 2){
                String name = data.poll();
                String email = data.poll();

                String regEx = ".[us|com|uk]+$";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(email);
                if (!matcher.find()){
                    contacts.put(name, email);
                }
            }
            input = scanner.nextLine();
        }

        contacts.forEach((k, v) -> {
            System.out.printf("%s -> %s%n", k, v);
        });
    }
}
