package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class E10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countries.entrySet().stream()
                .sorted((f, s) -> {
                    long sumFirst = f.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long sumSecond = s.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(sumSecond, sumFirst);
                }).forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(),
                    entry.getValue().values().stream().mapToLong(Long::longValue).sum());

                    entry.getValue().entrySet().stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        });

/*        countries.entrySet().stream()
                .sorted((f, s) -> s.getValue().values().stream().reduce(0L, Long::sum)
                        .compareTo(f.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(),
                            entry.getValue().values().stream().reduce(0L, Long::sum));
                    entry.getValue().entrySet().stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(l -> System.out.printf("=>%s: %d%n", l.getKey(), l.getValue()));
                });*/
    }
}
