package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        minutes += 30;
        if (minutes >= 60){
            minutes -= 60;
            hours++;
            if (hours >= 24){
                hours -= 24;
            }
        }
        System.out.printf("%d:%02d%n", hours, minutes);
    }
}
