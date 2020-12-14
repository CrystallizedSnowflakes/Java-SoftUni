package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte snowballs = scanner.nextByte();
        int biggestSnowballSnow = 0;
        int biggestSnowballTime = 0;
        int biggestSnowballQuality = 0;
        long biggestSnowballValue = 0;
        for (int i = 0; i < snowballs; i++) {
            int snowballSnow = scanner.nextInt();
            int snowballTime = scanner.nextInt();
            int snowballQuality = scanner.nextInt();
            long snowballValue = 1;
            for (int j = 0; j < snowballQuality; j++) {
                snowballValue *= (snowballSnow / snowballTime);
            }
            if (biggestSnowballValue < snowballValue){
                biggestSnowballValue = snowballValue;
                biggestSnowballSnow = snowballSnow;
                biggestSnowballTime = snowballTime;
                biggestSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", biggestSnowballSnow, biggestSnowballTime, biggestSnowballValue, biggestSnowballQuality);
    }
}
