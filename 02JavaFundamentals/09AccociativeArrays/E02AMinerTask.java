package bg.softuni.javafundamentals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resourceAndQuantity = new LinkedHashMap<>();

        while (true){
            String resource = scanner.next();
            if (resource.equals("stop")){
                break;
            }
            int nextQuantity = scanner.nextInt();
            Integer currentQuantity = resourceAndQuantity.get(resource);
            if (currentQuantity == null){
                currentQuantity = 0;
            }
            resourceAndQuantity.put(resource, currentQuantity + nextQuantity);
        }

        for (Map.Entry<String, Integer> entry : resourceAndQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
