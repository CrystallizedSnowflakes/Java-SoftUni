package bg.softuni.javabasics;

import java.util.Scanner;

public class E05TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentHours = Integer.parseInt(scanner.nextLine());
        int currentMinutes = Integer.parseInt(scanner.nextLine());

        int currentTimeInMinutes = currentHours * 60 + currentMinutes;
        int timePlus15Minutes = currentTimeInMinutes + 15;

        int finalHour = timePlus15Minutes / 60;
        int finalMinutes = timePlus15Minutes % 60;

        if (finalHour == 24){
            finalHour = 0;
        }
        System.out.printf("%d:%02d", finalHour, finalMinutes);
    }
}
