package bg.softuni.javafundamentals;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05NetherRealms3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> demonsAndHealth = new TreeMap<>();
        Map<String, Double> demonsAndDamage = new TreeMap<>();

        String[] demonNames = scanner.nextLine().split(",\\s*");

        String healthExpression = "(?<health>[^\\d*/+\\-.])"; // [^0-9*/+\-.]
        Pattern healthPattern = Pattern.compile(healthExpression);

        String damageExpression = "(?<damage>[+-]?\\d+\\.?\\d*)";
        Pattern damagePattern = Pattern.compile(damageExpression);

        String symbolExpression = "(?<symbol>[*/])";
        Pattern symbolPattern = Pattern.compile(symbolExpression);


        for (int i = 0; i < demonNames.length; i++) {
            String demonName = demonNames[i].replaceAll(" ", "");
            Matcher matcher = healthPattern.matcher(demonName);
            int health = 0;
            double damage = 0.0;

            while (matcher.find()){
                String letter = matcher.group("health");
                health += letter.charAt(0);
            }

            matcher = damagePattern.matcher(demonName);
            while (matcher.find()){
                double number = Double.parseDouble(matcher.group("damage"));
                damage += number;
            }

            matcher = symbolPattern.matcher(demonName);
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
            demonsAndHealth.put(demonName, health);
            demonsAndDamage.put(demonName, damage);
        }
        demonsAndHealth.entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(demon -> System.out.printf("%s - %d health, %.2f damage%n",
                        demon.getKey(),
                        demon.getValue(),
                        demonsAndDamage.get(demon.getKey())));
    }
}
