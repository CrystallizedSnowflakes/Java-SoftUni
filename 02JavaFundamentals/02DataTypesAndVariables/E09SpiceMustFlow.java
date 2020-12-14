package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {

        int source = new Scanner(System.in).nextInt();

        int workingDays = 0;
        int minedSpice = 0;

        while(source >= 100){
            int crewConsumption = source - 26;
            minedSpice += crewConsumption;
            source -= 10;
            if (source < 100){
                minedSpice -= 26;
            }
            workingDays++;
        }
        System.out.println(workingDays);
        System.out.println(minedSpice);
    }
}
