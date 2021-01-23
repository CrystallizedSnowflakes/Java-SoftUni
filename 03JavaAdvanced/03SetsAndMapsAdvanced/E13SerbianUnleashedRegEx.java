package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13SerbianUnleashedRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String text = scanner.nextLine();
        while (!text.equals("End")){

            String regEx = "^(?<singer>\\D+)\\s@(?<venue>\\D+)\\s(?<price>\\d+)\\s(?<tickets>\\d+)$";
            Pattern pattern = Pattern.compile(regEx);
            Matcher data = pattern.matcher(text);

            while (data.find()){
                String singer = data.group("singer");
                String venue = data.group("venue");
                int price = Integer.parseInt(data.group("price"));
                int tickets = Integer.parseInt(data.group("tickets"));

                int money =  price * tickets;

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                int currentMoney = venues.get(venue).get(singer);
                venues.get(venue).put(singer, currentMoney + money);

                //System.out.printf("Singer:%s, Venue:%s, Price:%d, Tickets:%d%n", singer, venue, price, tickets);
            }

            text = scanner.nextLine();
        }

        venues.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(entry -> {
                        System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
                    });
        });

    }
}
