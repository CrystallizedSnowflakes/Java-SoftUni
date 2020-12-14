package bg.softuni.javabasics;

import java.util.Scanner;

public class E08Scholarship2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship = minSalary * 0.35;
        double excellentAchievementScholarship = averageGrade * 25;

        if (income >= minSalary){
            if (averageGrade >= 5.5){
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentAchievementScholarship));
            }else{
                System.out.println("You cannot get a scholarship!");
            }
        }else{
            if (averageGrade <= 4.5){
                System.out.println("You cannot get a scholarship!");
            }else if(averageGrade < 5.5){
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
            }else{
                if (excellentAchievementScholarship >= socialScholarship){
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentAchievementScholarship));
                }else{
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
                }
            }
        }
    }
}
