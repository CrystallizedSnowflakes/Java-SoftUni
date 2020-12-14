package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> allStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String firstName = data[0];
            String secondName = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(firstName, secondName, grade);
            allStudents.add(student);
        }

        // order by grade descending
        // s -> student

        allStudents.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
                .forEach(student -> System.out.println(student.toString()));

    }

    public static class Student{
        //FIELDS
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }
    }
}
