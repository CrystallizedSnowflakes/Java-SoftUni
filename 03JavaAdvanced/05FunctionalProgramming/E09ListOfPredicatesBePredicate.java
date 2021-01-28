package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class E09ListOfPredicatesBePredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        BiPredicate<Set<Integer>, Integer> isNumberDivisibleByEachSetElement = (set, number) -> {

            for (Integer divisor: set) {
                if (number % divisor != 0){
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= n; number++) {
            if (isNumberDivisibleByEachSetElement.test(divisors, number)){
                System.out.print(number + " ");
            }
        }
    }
}
