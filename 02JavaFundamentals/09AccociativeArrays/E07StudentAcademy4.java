package bg.softuni.javafundamentals;

import java.util.*;

public class E07StudentAcademy4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }

        studentsGrades.entrySet()
                .stream()
                .filter(s-> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.5)
                .sorted((f, s) -> Double.compare(s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble(),
                        f.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()))
                .forEach(grade -> System.out.println(String.format("%s -> %.2f", grade.getKey(),
                        grade.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));
    }
}
