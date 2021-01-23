package bg.softuni.javaadvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08HandsOfCards2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")){
            String[] tokens = input.split(":\\s+");

            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");

            playersCards.putIfAbsent(name, new HashSet<>());
            playersCards.get(name).addAll(Arrays.asList(cards));

            input = scanner.nextLine();
        }

        String regEx = "(?<power>[0-9]+|[JQKA])(?<type>[CHDS]){1}";
        Pattern pattern = Pattern.compile(regEx);

        for (Map.Entry<String, HashSet<String>> playerCard : playersCards.entrySet()) {
            String name = playerCard.getKey();
            int playersScore = 0;
            for (String card : playerCard.getValue()) {
                Matcher matcher = pattern.matcher(card);
                if (matcher.find()){
                    String power = matcher.group("power");
                    String type = matcher.group("type");

                    int value = getValueByPower(power);
                    int multiplier = getMultiplierByType(type);
                    int score = value * multiplier;
                    playersScore += score;
                }
            }

            System.out.printf("%s: %d%n", name, playersScore);
        }
    }

    private static int getMultiplierByType(String type) {
        int multiplier = 0;
        switch (type){
            case "S":
                multiplier = 4;
                break;
            case "H":
                multiplier = 3;
                break;
            case "D":
                multiplier = 2;
                break;
            case "C":
                multiplier = 1;
                break;
        }
        return multiplier;
    }

    private static int getValueByPower(String power) {
        int value;
        switch (power) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
                break;
        }
        return value;
    }
}
