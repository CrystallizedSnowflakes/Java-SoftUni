package bg.softuni.javafundamentals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ME02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"no more time".equals(input)) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);


            contests.putIfAbsent(contest, new LinkedHashMap<>());
            contests.get(contest).putIfAbsent(username, points);

            if (contests.get(contest).get(username) < points) {
                contests.get(contest).put(username, points);
            }

            input = scanner.nextLine();
        }

        AtomicInteger num = new AtomicInteger(1);
        contests.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            num.set(1);
            value.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int result = s.getValue().compareTo(f.getValue());
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    })
                    .forEach(entry ->
                            System.out.printf("%d. %s <::> %d%n", num.getAndIncrement(), entry.getKey(), entry.getValue()));
        });

        System.out.println("Individual standings:");

        Map<String, Integer> scoring = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> contest : contests.entrySet()) {
            for (Map.Entry<String, Integer> user : contest.getValue().entrySet()) {
                scoring.putIfAbsent(user.getKey(), 0);
                scoring.put(user.getKey(), scoring.get(user.getKey()) + user.getValue());
            }
        }
        num.set(1);
        scoring.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0){
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(entry -> System.out.printf("%d. %s -> %d%n",
                        num.getAndIncrement(),
                        entry.getKey(),
                        entry.getValue()));

    }
}
