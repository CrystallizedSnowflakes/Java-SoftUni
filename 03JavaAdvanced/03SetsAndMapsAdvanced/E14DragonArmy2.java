package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class E14DragonArmy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, double[]>> dragonsByColor = new LinkedHashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String color = tokens[0];
            String name = tokens[1];
            double damage = 45;
            double health = 250;
            double armor = 10;
            if (!tokens[2].equals("null")){
                damage = Integer.parseInt(tokens[2]);
            }
            if (!tokens[3].equals("null")){
                health = Integer.parseInt(tokens[3]);
            }
            if (!tokens[4].equals("null")){
                armor = Integer.parseInt(tokens[4]);
            }

            dragonsByColor.putIfAbsent(color, new TreeMap<>());
            double[] data = new double[]{damage, health, armor};
            dragonsByColor.get(color).put(name, data);
        }

        dragonsByColor.forEach((k, v) -> {
            double avgDamage = v.values()
                    .stream()
                    .mapToDouble(doubles -> doubles[0])
                    .average()
                    .orElse(0.00);
            double avgHealth = v.values()
                    .stream()
                    .mapToDouble(doubles -> doubles[1])
                    .average()
                    .orElse(0.00);

            double avgArmor = v.values()
                    .stream()
                    .mapToDouble(doubles -> doubles[2])
                    .average()
                    .orElse(0.00);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", k, avgDamage, avgHealth, avgArmor);

            v.forEach((key, value) -> {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                        key, value[0], value[1], value[2]);
            });
        });
    }
}
