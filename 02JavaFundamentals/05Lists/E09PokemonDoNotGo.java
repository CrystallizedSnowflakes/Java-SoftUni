package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distance = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!distance.isEmpty()) {

            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                index = 0;
                distance.add(index + 1, distance.get(distance.size() - 1));
            }

            if (index >= distance.size()) {
                index = distance.size() - 1;
                distance.add(index + 1, distance.get(0));
            }

            int pokemon = distance.get(index);
            distance.remove(index);
            sum += pokemon;

            for (int i = 0; i < distance.size(); i++) {
                int element = distance.get(i);
                if (element <= pokemon) {
                    distance.set(i, element + pokemon);
                } else {
                    distance.set(i, element - pokemon);
                }
            }
        }
        System.out.println(sum);
    }
}
