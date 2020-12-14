package bg.softuni.javabasics;

import java.util.Scanner;

public class E06Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        boolean isSpent = false;
        for (int i = 0; i < tabs; i++) {
            String currentTab = scanner.nextLine();
            switch (currentTab){
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }

            if (salary <= 0){
                isSpent = true;
                break;
            }
        }

        if (isSpent){
            System.out.println("You have lost your salary.");
        }else{
            System.out.println(salary);
        }
    }
}
