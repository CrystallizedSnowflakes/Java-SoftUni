package bg.softuni.basics;

import java.util.Scanner;

public class E04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSteps = 0;
        String command = scanner.nextLine();

        while (!command.equals("Going home")){
            int steps = Integer.parseInt(command);
            totalSteps += steps;
            if (totalSteps >= 10000){
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;
        }

        if (totalSteps >= 10000){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", totalSteps - 10000);
        }else{
            System.out.printf("%d more steps to reach goal.", 10000 - totalSteps);
        }
    }
}
