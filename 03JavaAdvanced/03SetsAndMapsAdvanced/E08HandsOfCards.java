package bg.softuni.javaadvanced;

import java.util.*;

public class E08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")){
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");

            if (!playersCards.containsKey(name))
            playersCards.put(name, new HashSet<>());
            for (String card : cards) {
                playersCards.get(name).add(card.trim());
            }

            input = scanner.nextLine();
        }

        HashMap<String, Integer> participants = getPoints(playersCards);
        participants.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });
    }

    private static LinkedHashMap<String, Integer> getPoints(LinkedHashMap<String, HashSet<String>> players){

        LinkedHashMap<String, Integer> playersPoints = new LinkedHashMap<>();

        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {
            String name = player.getKey();
            int sum = 0;
            for (String value : player.getValue()) {
                String card = value.substring(0, value.length()-1);
                char type = value.charAt(value.length()-1);
                int num;
                switch (card) {
                    case "J":
                        num = 11;
                        break;
                    case "Q":
                        num = 12;
                        break;
                    case "K":
                        num = 13;
                        break;
                    case "A":
                        num = 14;
                        break;
                    default:
                        num = Integer.parseInt(card);
                        break;
                }

                switch (type){
                    case 'S':
                        sum += num * 4;
                        break;
                    case 'H':
                        sum += num * 3;
                        break;
                    case 'D':
                        sum += num * 2;
                        break;
                    case 'C':
                        sum += num;
                        break;
                }

            }
            playersPoints.put(name, sum);
        }
        return playersPoints;
    }
}
