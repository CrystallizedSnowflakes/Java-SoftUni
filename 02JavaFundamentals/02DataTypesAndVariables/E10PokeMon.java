package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int powerOfPokeMon = scanner.nextInt();
        int distance = scanner.nextInt();
        int exhaustionFactor = scanner.nextInt();

        int pokes = 0;
        int halfPowerOfPokeMon = powerOfPokeMon / 2;
        while(powerOfPokeMon >= distance){
            powerOfPokeMon -=distance;
            pokes++;
            if ((powerOfPokeMon == halfPowerOfPokeMon) && (exhaustionFactor != 0)){
                powerOfPokeMon /= exhaustionFactor;
            }
        }

        System.out.println(powerOfPokeMon);
        System.out.println(pokes);
    }
}
