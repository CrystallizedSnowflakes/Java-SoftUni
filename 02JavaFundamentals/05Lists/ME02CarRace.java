package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int stop = numbers.size() / 2;

        double leftRacerTime = 0.0;
        for (int i = 0; i < stop; i++) {
            leftRacerTime += numbers.get(i);
            if (numbers.get(i) == 0){
                leftRacerTime *= 0.8;
            }
        }
        double rightRacerTime = 0.0;
        for (int i = numbers.size() - 1; i > stop; i--) {
            rightRacerTime += numbers.get(i);
            if (numbers.get(i) == 0){
                rightRacerTime *= 0.8;
            }
        }

        if (leftRacerTime < rightRacerTime){
            System.out.printf("The winner is left with total time: %.1f", leftRacerTime);
        }else if(leftRacerTime > rightRacerTime){
            System.out.printf("The winner is right with total time: %.1f", rightRacerTime);
        }
    }
}
