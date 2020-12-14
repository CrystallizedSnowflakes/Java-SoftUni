package bg.softuni.javafundamentals;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class E03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> materialAndQuantity = new HashMap<>();
        TreeMap<String, Integer> junkAndQuantity = new TreeMap<>();

        materialAndQuantity.put("shards", 0);
        materialAndQuantity.put("fragments", 0);
        materialAndQuantity.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained){
            int quantity = Integer.parseInt(scanner.next());
            String material = scanner.next().toLowerCase();

            Integer currentQuantity = materialAndQuantity.get(material);
            if (currentQuantity == null){
                currentQuantity = 0;
            }

            switch (material){

                case "shards":
                    materialAndQuantity.put(material, currentQuantity + quantity);
                    if (materialAndQuantity.get(material) >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        materialAndQuantity.put(material, materialAndQuantity.get(material) - 250);
                        isObtained = true;
                    }
                    break;
                case "fragments":
                    materialAndQuantity.put(material, currentQuantity + quantity);
                    if (materialAndQuantity.get(material) >= 250) {
                        System.out.println("Valanyr obtained!");
                        materialAndQuantity.put(material, materialAndQuantity.get(material) - 250);
                        isObtained = true;

                    }
                    break;
                case "motes":
                    materialAndQuantity.put(material, currentQuantity + quantity);
                    if (materialAndQuantity.get(material) >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        materialAndQuantity.put(material, materialAndQuantity.get(material) - 250);
                        isObtained = true;
                    }
                    break;
                default:
                    Integer currentJunk = junkAndQuantity.get(material);
                    if (currentJunk == null){
                        currentJunk = 0;
                    }
                    junkAndQuantity.put(material, currentJunk + quantity);
                    break;
            }
        }

        materialAndQuantity.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junkAndQuantity.forEach((k, v) -> System.out.printf("%s: %d%n",k, v));
    }
}
