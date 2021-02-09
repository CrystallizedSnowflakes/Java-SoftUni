package bg.softuni.javaadvanced;

import java.util.*;

public class Ex01SantaSPresentFactory_17Dec19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> presents = new TreeMap<>();

        int[] materials = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] magicValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        for (int material : materials) {
            materialStack.push(material);
        }

        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        for (int magicValue : magicValues) {
            magicQueue.offer(magicValue);
        }

        while (!materialStack.isEmpty() && !magicQueue.isEmpty()){

            if (materialStack.peek() == 0 && magicQueue.peek() == 0){
                materialStack.pop();
                magicQueue.poll();
                continue;
            } else if (materialStack.peek() == 0){
                materialStack.pop();
                continue;
            } else if (magicQueue.peek() == 0){
                magicQueue.poll();
                continue;
            }

            int totalMagic = materialStack.peek() * magicQueue.peek();
            switch (totalMagic){
                case 150:
                    presents.putIfAbsent("Doll", 0);
                    presents.put("Doll", presents.get("Doll") + 1);
                    materialStack.pop();
                    magicQueue.poll();
                    break;
                case 250:
                    presents.putIfAbsent("Wooden train", 0);
                    presents.put("Wooden train", presents.get("Wooden train") + 1);
                    materialStack.pop();
                    magicQueue.poll();
                    break;
                case 300:
                    presents.putIfAbsent("Teddy bear", 0);
                    presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                    materialStack.pop();
                    magicQueue.poll();
                    break;
                case 400:
                    presents.putIfAbsent("Bicycle", 0);
                    presents.put("Bicycle", presents.get("Bicycle") + 1);
                    materialStack.pop();
                    magicQueue.poll();
                    break;
                default:
                    if (totalMagic <= 0){
                        break;
                    }
                    magicQueue.poll();
                    int increasedMaterial = 15 + materialStack.pop();
                    materialStack.push(increasedMaterial);
                    break;
            }

            if (totalMagic < 0){
                int result = materialStack.pop() + magicQueue.poll();
                materialStack.push(result);
            }
        }

        if ((presents.containsKey("Doll") && presents.containsKey("Wooden train"))||
                (presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"))){
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        StringBuilder materialsLeft = new StringBuilder("Materials left: ");
        if (!materialStack.isEmpty()){
            while (materialStack.size() > 1){
                materialsLeft.append(String.format("%d, ", materialStack.pop()));
            }
            materialsLeft.append(String.format("%d", materialStack.pop()));
            System.out.println(materialsLeft.toString());
        }

        StringBuilder magicLeft = new StringBuilder("Magic left: ");
        if (!magicQueue.isEmpty()){
            while (magicQueue.size() > 1){
                magicLeft.append(String.format("%d, ", magicQueue.poll()));
            }
            magicLeft.append(String.format("%d", magicQueue.poll()));
            System.out.println(magicLeft.toString());
        }

        presents.forEach((k, v) ->
                System.out.println(k + ": " + v));
    }
}
