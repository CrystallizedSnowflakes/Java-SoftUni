package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class E07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((f, s) -> {
                    double firstAv = f.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    double secondAv = s.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    return Double.compare(secondAv, firstAv);

                }).forEach(s -> {
                    double average = s.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    System.out.printf("%s -> %.2f%n", s.getKey(), average);
        });
    }
}
