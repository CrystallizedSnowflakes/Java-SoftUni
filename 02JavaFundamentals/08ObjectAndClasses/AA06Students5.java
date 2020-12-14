package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AA06Students5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("end")) {

            Student alumni = Student.parseStudent(line);

            Student student = students
                    .stream()
                    .filter(a -> a.getFirstName().equals(alumni.firstName) && a.getLastName().equals(alumni.lastName))
                    .findFirst()
                    .orElse(null);

            if (student == null){
                Student studentToAdd = new Student();
                studentToAdd.setFirstName(alumni.firstName);
                studentToAdd.setLastName(alumni.lastName);
                studentToAdd.setAge(alumni.age);
                studentToAdd.setHometown(alumni.hometown);
                students.add(studentToAdd);
            }else{
                student.setFirstName(alumni.firstName);
                student.setLastName(alumni.lastName);
                student.setAge(alumni.age);
                student.setHometown(alumni.hometown);
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

    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        Student(){
        }

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
