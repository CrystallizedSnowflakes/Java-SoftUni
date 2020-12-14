package bg.softuni.javabasics;

import java.util.Scanner;

public class E07WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double distanceInMetres = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double personalSwimmingTime = distanceInMetres * secondsPerMeter;
        double delayTime = Math.floor(distanceInMetres / 15) * 12.5;
        double totalPersonalTime = personalSwimmingTime + delayTime;

        if (totalPersonalTime < worldRecord){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalPersonalTime);
        }else{
            double neededSeconds = totalPersonalTime - worldRecord;
            System.out.printf("No, he failed! He was %.2f seconds slower.", neededSeconds);
        }
    }
}
