package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A06Students4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {

            Student s = Student.parseStudent(line);

            if (isStudentExisting(students, s.firstName, s.lastName)){
                Student student = getStudent(students, s.firstName, s.lastName);
                student.setFirstName(s.firstName);
                student.setLastName(s.lastName);
                student.setAge(s.age);
                student.setHometown(s.hometown);
            }else{
                Student student = new Student(s.firstName, s.lastName, s.age,s.hometown);
                students.add(student);
            }
            line = scanner.nextLine();
        }

        String searchTownName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(searchTownName)) {
                System.out.println(student);
            }
        }
    }

    private static boolean isStudentExisting(List<Student>students, String firstName, String lastName){
        for (Student student : students) {
            if (student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName){
        Student existingStudent = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)){
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static Student getStudent1(List<Student> students, String firstName, String lastName) {
        for (Student student : students){
            if(student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName))
                return student;
        }
        return null;
    }


    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public static Student parseStudent(String text) {
            String[] studentParameters = text.split(" ");
            return new Student(studentParameters[0],
                    studentParameters[1], Integer.parseInt(studentParameters[2]),
                    studentParameters[3]);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHometown() {
            return hometown;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getAge());
        }
    }
}
