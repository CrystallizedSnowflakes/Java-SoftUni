package bg.softuni.javaadvanced;

import java.util.*;

public class A08AcademyGraduationListAndMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> students = new TreeMap<>();

        while ( n-- > 0){
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            students.putIfAbsent(studentName, new ArrayList<>());
            for (double grade : grades) {
                students.get(studentName).add(grade);
            }
        }

        students.forEach((key, value) -> {
            System.out.println(key + " is graduated with " + getAvgAsString(value));
        });
    }

    private static String getAvgAsString(List<Double> values) {
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        double avg = sum / values.size();

        return String.valueOf(avg);
        //return "" + avg;
    }
}
