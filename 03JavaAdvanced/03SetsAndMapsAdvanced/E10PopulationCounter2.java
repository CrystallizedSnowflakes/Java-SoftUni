package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class E10PopulationCounter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = scanner.nextLine())){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    long p1 = c1.getValue().values().stream().mapToLong(l -> l).sum();
                    long p2 = c2.getValue().values().stream().mapToLong(l -> l).sum();
                    return Long.compare(p2, p1);
                })
                .forEach(c -> {
                    long totalPopulation = c.getValue().values().stream().mapToLong(Long::longValue).sum();
                    System.out.printf("%s (total population: %d)%n", c.getKey(), totalPopulation);

                    LinkedHashMap<String, Long> cityInfo = c.getValue();
                    cityInfo.entrySet().stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
