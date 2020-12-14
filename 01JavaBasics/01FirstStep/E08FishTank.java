package bg.softuni.javabasics;

import java.util.Scanner;

public class E08FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthFishTank = Integer.parseInt(scanner.nextLine());
        int widthFishTank = Integer.parseInt(scanner.nextLine());
        int heightFishTank = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int volumeFishTank = lengthFishTank * widthFishTank * heightFishTank;
        // 1 liter = 1 dm3 = 0.001
        double totalLitresFishTank = volumeFishTank * 0.001;
        // 1 percent = (1 / 100) = 0.01
        percent = percent * 0.01; //17%
        //double volumeNoWater = totalLitresFishTank * percent;
        //double neededLiters = totalLitresFishTank - volumeNoWater;

        //299.625 * (1 - 0.17)
        double neededLiters = totalLitresFishTank * (1 - percent);
        System.out.printf("%.2f", neededLiters);
    }
}
