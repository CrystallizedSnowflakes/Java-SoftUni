package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<Integer> list = Arrays
//                .stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split("\\s+");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        List<Integer> newList = new ArrayList<>();
        int i = 0;
        while (i < list.size() / 2) {
            int sum = list.get(i) + list.get(list.size() - 1 - i);
            newList.add(sum);
            i++;
        }
        if (list.size() % 2 != 0) {
            newList.add(list.get(list.size() / 2));
        }
        for (int j = 0; j < newList.size(); j++) {
            System.out.print(newList.get(j) + " ");
        }
    }
}
