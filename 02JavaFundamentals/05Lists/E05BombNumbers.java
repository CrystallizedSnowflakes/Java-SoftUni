package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        while (numbers.contains(bomb)){
            int indexBomb = numbers.indexOf(bomb);
            int detonationStart = indexBomb - power;
            int detonationEnd = indexBomb + power;
            if(detonationStart < 0){
                detonationStart = 0;
            }
            if (detonationEnd > numbers.size()-1){
                detonationEnd = numbers.size()-1;
            }

            for (int i = detonationEnd; i >= detonationStart; i--){
                numbers.remove(i);
            }
//            int i = detonationStart;
//            while (i <= detonationEnd){
//                numbers.remove(i);
//                i = detonationStart;
//                detonationEnd--;
//            }
        }

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
//        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.println(sum);
    }
}
