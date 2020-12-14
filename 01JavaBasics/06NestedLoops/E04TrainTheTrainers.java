package bg.softuni.javabasics;

import java.util.Scanner;

public class E04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countJury = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        // "Finish" or presentation = command
        double sumAllGrades = 0;
        int countAllGrades = 0;
        while (!"Finish".equals(command)){
            // presentation
            String presentation = command;
            double sumGradePerPresentation = 0; // reset !!!
            for (int jury = 1; jury <= countJury ; jury++) {
                double grade = Double.parseDouble(scanner.nextLine());
                countAllGrades++;
                sumGradePerPresentation += grade;
                sumAllGrades += grade;
            }
            double averageGrade = sumGradePerPresentation / countJury;
            System.out.printf("%s - %.2f.%n", presentation, averageGrade);

            command = scanner.nextLine();
        }
        double averageAll = sumAllGrades / countAllGrades;
        System.out.printf("Student's final assessment is %.2f.%n", averageAll);
    }
}
