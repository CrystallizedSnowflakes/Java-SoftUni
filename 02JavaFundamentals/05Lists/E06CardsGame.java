package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(!(firstDeck.isEmpty() || secondDeck.isEmpty())){

            int firstCurrent = firstDeck.get(0);
            int secondCurrent = secondDeck.get(0);

            if(firstCurrent > secondCurrent){
                firstDeck.add(firstCurrent);
                firstDeck.add(secondCurrent);
;
            }else if(firstCurrent < secondCurrent){
                secondDeck.add(secondCurrent);
                secondDeck.add(firstCurrent);

            }
            firstDeck.remove((Integer)firstCurrent);
            secondDeck.remove((Integer)secondCurrent);
        }

        int sum = 0;
        if (!firstDeck.isEmpty()){
            for (Integer integer : firstDeck) {
                sum += integer;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }else{
            for (Integer integer : secondDeck) {
                sum += integer;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
