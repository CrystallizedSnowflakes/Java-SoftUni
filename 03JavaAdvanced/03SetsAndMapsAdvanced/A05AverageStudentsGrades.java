package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class A05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentRecords = new TreeMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentRecords.putIfAbsent(name, new ArrayList<>());
            studentRecords.get(name).add(grade);
        }

        studentRecords.forEach((key, value) -> {
                    System.out.printf("%s -> %s (avg: %.2f)%n",
                            key,

                            //getGradesAsString(value),
                            value.stream()
                                    .map(grade -> String.format("%.2f", grade))
                                    .collect(Collectors.joining(" ")),

                            getAvgGrade(value));
//                            value.stream()
//                                    .mapToDouble(grade -> grade)
//                                    .average()
//                                    .orElse(0.00));
                });
    }

    private static String getGradesAsString(ArrayList<Double> values){
            return values.stream()
                    .map(grade -> String.format("%.2f", grade))
                    .collect(Collectors.joining(" "));

    }

    private static double getAvgGrade(ArrayList<Double> values){
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        double avgSum = sum / values.size();
        return avgSum;
    }
}
