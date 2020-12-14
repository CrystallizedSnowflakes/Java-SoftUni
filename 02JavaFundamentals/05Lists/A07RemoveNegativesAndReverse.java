package bg.softuni.javafundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class A07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

//        numbers.removeIf(n -> n < 0);
//        Collections.reverse(numbers);
//        if (numbers.isEmpty()){
//            System.out.println("empty");
//        }else{
//            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
//        }

        List<Integer> nonNegativeNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (number >= 0){
                nonNegativeNumbers.add(number);
            }
        }

        if (nonNegativeNumbers.isEmpty()){
            System.out.println("empty");
        }else{
            Collections.reverse(nonNegativeNumbers);

            for (Integer nonNegativeNumber : nonNegativeNumbers) {
                System.out.print(nonNegativeNumber + " ");
            }
        }
    }
}
