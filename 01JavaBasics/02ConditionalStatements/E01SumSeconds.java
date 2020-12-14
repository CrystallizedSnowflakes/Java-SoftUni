package bg.softuni.javabasics;

import java.util.Scanner;

public class E01SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTimeInSeconds = Integer.parseInt(scanner.nextLine());
        int secondTimeInSeconds = Integer.parseInt(scanner.nextLine());
        int thirdTimeInSeconds = Integer.parseInt(scanner.nextLine());

        int totalTimeInSeconds = firstTimeInSeconds + secondTimeInSeconds + thirdTimeInSeconds;
        int minutes = totalTimeInSeconds / 60;
        int seconds = totalTimeInSeconds % 60;

        if (seconds < 10){
            System.out.printf("%d:%02d", minutes, seconds);
        }else{
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}
