package bg.softuni.basics;

import java.util.Scanner;

public class E02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedThresholds = Integer.parseInt(scanner.nextLine());

        int failedTimes = 0;
        int solvedProblemsCount = 0;
        double gradesSum = 0.0;
        String lastProblem = "";
        boolean isFailed = true;

        while (failedTimes < failedThresholds){
            String problemName = scanner.nextLine();
            if ("Enough".equals(problemName)){
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4){
                failedTimes++;
            }
            gradesSum += grade;
            solvedProblemsCount++;
            lastProblem = problemName;
        }
        if (isFailed){
            System.out.printf("You need a break, %d poor grades.", failedThresholds);
        }else{
            System.out.printf("Average score: %.2f%n", gradesSum / solvedProblemsCount);
            System.out.printf("Number of problems: %d%n", solvedProblemsCount);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
