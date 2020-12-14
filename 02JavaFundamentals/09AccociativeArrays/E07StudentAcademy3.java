package bg.softuni.javafundamentals;

import java.util.*;

public class E07StudentAcademy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> studentsGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            int count = 1;
            Double currentGrade = studentsGrades.get(name);
            if (currentGrade == null){
                currentGrade = 0.0;
            }
            if (studentsGrades.containsKey(name)){
                count ++;
            }
            studentsGrades.put(name, (currentGrade + grade) / count);
        }

        studentsGrades.entrySet()
                .stream()
                .filter(g -> g.getValue() >= 4.5)
                .sorted((f, s) -> Double.compare(s.getValue(), f.getValue()))
                .forEach(grade -> System.out.println(String.format("%s -> %.2f", grade.getKey(),
                        grade.getValue())));
    }
}
