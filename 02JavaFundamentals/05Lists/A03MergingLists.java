package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> second = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> merged = new ArrayList<>();

        int indexInFirst = 0;
        int indexInSecond = 0;

        while(indexInFirst < first.size() || indexInSecond < second.size()){
            if (indexInFirst < first.size()){
                merged.add(first.get(indexInFirst));
            }
            if (indexInSecond < second.size()){
                merged.add(second.get(indexInSecond));
            }
            indexInFirst++;
            indexInSecond++;
        }

        for (Integer integer : merged) {
            System.out.print(integer + " ");
        }
    }
}
