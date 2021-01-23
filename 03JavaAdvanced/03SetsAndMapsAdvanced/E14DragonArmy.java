package bg.softuni.javaadvanced;

import java.util.*;

public class E14DragonArmy {
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

        for (Map.Entry<String, TreeMap<String, double[]>> colors : dragonsByColor.entrySet()) {
            String color = colors.getKey();

            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmor = 0;
            TreeMap<String, double[]> dragons = colors.getValue();
            for (Map.Entry<String, double[]> dragon : dragons.entrySet()) {
                sumDamage += dragon.getValue()[0];
                sumHealth += dragon.getValue()[1];
                sumArmor += dragon.getValue()[2];
            }

            double avgDamage = sumDamage / dragons.size();
            double avgHealth = sumHealth / dragons.size();
            double avgArmor = sumArmor / dragons.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", color, avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, double[]> names : colors.getValue().entrySet()) {
                String name = names.getKey();
                double damage = names.getValue()[0];
                double health = names.getValue()[1];
                double armor = names.getValue()[2];
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                        name, damage, health, armor);
            }
        }
    }
}
