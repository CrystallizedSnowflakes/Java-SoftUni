package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class A05AverageStudentsGrades2 {
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
            double sum = 0;
            for (Double aDouble : value) {
                sum += aDouble;
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}
