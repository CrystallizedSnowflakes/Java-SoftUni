package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A08AcademyGraduationTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> students = new TreeMap<>();

        while ( n-- > 0){
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            students.put(studentName, grades);
        }

        students.forEach((key, value) -> {
            String studentName = key;

            String gradesAsString = "";
            double[] studentGrades = value;
            for (double studentGrade : studentGrades) {
                gradesAsString += studentGrade + " ";
            }

            double avg = Arrays.stream(studentGrades).average().getAsDouble();

            System.out.printf("# Student: %s%n", studentName);
            System.out.printf("## Grades: %s%n", gradesAsString);
            System.out.printf("## Average: %.2f%n", avg);
        });
    }
}
