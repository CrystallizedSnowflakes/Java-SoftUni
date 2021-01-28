package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class E09ListOfPredicatesBePredicateRecursive {

    public static BiPredicate<Integer, Integer> isNumDivisibleByNumInSet = (f, s) -> f % s == 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNum = Integer.parseInt(scanner.nextLine());

        Set<Integer> setSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        areDivisibleToSetSequence(1, setSequence, lastNum);
    }

    private static void areDivisibleToSetSequence(int startNum, Set<Integer> setSequence, int lastNum) {
        // TOP
        if (startNum > lastNum){
            return;
        }

        boolean isValid = true;

        for (Integer numberInSet: setSequence) {
            if (!isNumDivisibleByNumInSet.test(startNum, numberInSet)){
                isValid = false;
                break;
            }
        }

        if (isValid){
            System.out.print(startNum + " ");
        }

        areDivisibleToSetSequence(startNum + 1, setSequence, lastNum);
    }
}
