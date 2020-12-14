package bg.softuni.javafundamentals;

import java.util.*;

public class E07StudentAcademy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        Map<String, Double> studentsWithAvgGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double avg = entry.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();
            if (avg >= 4.50){
                studentsWithAvgGrade.put(entry.getKey(), avg);
            }
        }

        studentsWithAvgGrade.entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .map(grade -> String.format("%s -> %.2f", grade.getKey(), grade.getValue()))
                .forEach(System.out::println);


        /*Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double average = entry.getValue()
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .getAsDouble();
            if (average >= 4.50) {
                averageGrade.put(entry.getKey(), average);
            }
        }

        averageGrade.entrySet().stream()
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.println(String.format("%s -> %.2f", grade.getKey(), grade.getValue()));
                });*/
    }
}
