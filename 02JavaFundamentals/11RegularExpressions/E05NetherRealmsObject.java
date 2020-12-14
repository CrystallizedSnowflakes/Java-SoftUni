package bg.softuni.javafundamentals;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05NetherRealmsObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Demon> demonsBook = new TreeMap<>();

        String[] input = scanner.nextLine().split("\\s*,\\s*");
        for (int i = 0; i < input.length; i++) {
            String demonsName = input[i];
            int health = Demon.calculateHealth(demonsName);
            double damage = Demon.calculateDamage(demonsName);
            Demon demon = new Demon(demonsName, health, damage);
            demonsBook.put(demon.getName(), demon);
        }

        demonsBook.values()
                .stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .map(Demon::toString)
                .forEach(System.out::println);
    }

    private static class Demon{
        private final String name;
        private final int health;
        private final double damage;

        public Demon(String name, int health, double damage){
            this.name = name;
            this.health = health;
            this.damage = damage;
        }

        public static int calculateHealth(String demonsName){
            Pattern healthPattern = Pattern.compile("(?<health>[^\\d*/+\\-.])"); // [^0-9*/+\-.]
            int health = 0;
            Matcher matcher = healthPattern.matcher(demonsName);
            while (matcher.find()){
                String letter = matcher.group("health");
                health += letter.charAt(0);
            }
            return health;
        }

        public static double calculateDamage(String demonsName){
            Pattern damagePattern = Pattern.compile("(?<damage>[+-]?\\d+\\.?\\d*)");
            double damage = 0.0;
            Matcher matcher = damagePattern.matcher(demonsName);
            while (matcher.find()){
                double number = Double.parseDouble(matcher.group("damage"));
                damage += number;
            }
            Pattern symbolPattern = Pattern.compile("(?<symbol>[*/])");
            matcher = symbolPattern.matcher(demonsName);
            while (matcher.find()){
                String symbol = matcher.group("symbol");
                switch (symbol){
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }
            return damage;
        }

        @Override
        public String toString() {
            return String.format("%s - %d health, %.2f damage",
                    name, health, damage);
        }

        public String getName() {
            return name;
        }
    }
}
