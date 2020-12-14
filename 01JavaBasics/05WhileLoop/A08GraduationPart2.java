package bg.softuni.basics;

import java.util.Scanner;

public class A08GraduationPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();

        double sum = 0.0;
        int repetitions = 0;
        boolean isExcluded = false;

        int grade = 1;
        while (grade <= 12){
            double currentMark = Double.parseDouble(scanner.nextLine());

            if (currentMark < 4.00){
                repetitions++;
                if (repetitions == 2){
                    System.out.printf("%s has been excluded at %d grade", studentName, grade);
                    isExcluded = true;
                    break;
//                    return;
                }
                continue;
            }

            sum += currentMark;
            grade++;
        }

        if (!isExcluded){
            double avgMark = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f", studentName, avgMark);
        }
    }
}
