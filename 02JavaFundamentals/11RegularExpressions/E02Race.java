package bg.softuni.javafundamentals;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        for (String participant : participants) {
            racers.put(participant, 0);
        }

        String nameExpression = "[A-Za-z]";
        Pattern namePattern = Pattern.compile(nameExpression);

        String distanceExpression = "\\d";
        Pattern distancePattern = Pattern.compile(distanceExpression);

        String input = scanner.nextLine();
        while (!"end of race".equals(input)){
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder name = new StringBuilder();

            while (nameMatcher.find()){
                name.append(nameMatcher.group()); // takes all letters
            }
            if (racers.containsKey(name.toString())){
                int currentDistance = racers.get(name.toString());
                Matcher distanceMatcher = distancePattern.matcher(input);
                while (distanceMatcher.find()){
                    currentDistance += Integer.parseInt(distanceMatcher.group());
                }
                racers.put(name.toString(), currentDistance);
            }

            input = scanner.nextLine();
        }

        List<String> winners = racers.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int count = 1;
        for (String winner : winners) {
            switch (count++){
                case 1:
                    System.out.println("1st place: " + winner);
                    break;
                case 2:
                    System.out.println("2nd place: " + winner);
                    break;
                case 3:
                    System.out.println("3rd place: " + winner);
                    break;
            }
        }
    }
}
