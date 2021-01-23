package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E07FixEmails {
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

                String domain = email.split("\\.")[1];
                if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")){
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
