package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class E12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> junks = new TreeMap<>();
        TreeMap<String, Integer> materials = new TreeMap<>();

        materials.putIfAbsent("shards", 0);
        materials.putIfAbsent("fragments", 0);
        materials.putIfAbsent("motes", 0);

        boolean isObtained = false;

        while (!isObtained) {
            int quantity = Integer.parseInt(scanner.next());
            String material = scanner.next().toLowerCase();

            switch (material) {
                case "shards":
                    materials.put(material, materials.get(material) + quantity);
                    int currentMaterial = materials.get(material);
                    if (currentMaterial >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        materials.put(material, currentMaterial - 250);
                        isObtained = true;
                    }
                    break;
                case "fragments":
                    materials.put(material, materials.get(material) + quantity);
                    currentMaterial = materials.get(material);
                    if (currentMaterial >= 250) {
                        System.out.println("Valanyr obtained!");
                        materials.put(material, currentMaterial - 250);
                        isObtained = true;
                    }
                    break;
                case "motes":
                    materials.put(material, materials.get(material) + quantity);
                    currentMaterial = materials.get(material);
                    if (currentMaterial >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        materials.put(material, currentMaterial - 250);
                        isObtained = true;
                    }
                    break;
                default:
                    junks.putIfAbsent(material, 0);
                    junks.put(material, junks.get(material) + quantity);
                    break;
            }
        }

        materials.entrySet().stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0){
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

        junks.entrySet().stream()
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

    }
}
