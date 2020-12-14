package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true){
            String[] tokens = scanner.nextLine().toLowerCase().split(" ");
            if (tokens[0].equals("end")){
                break;
            }else if(tokens[0].equals("add")){
                int nextWagon = Integer.parseInt(tokens[1]);
                wagons.add(nextWagon);
            }else{
                int passengers = Integer.parseInt(tokens[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentPassengers = wagons.get(i);
                    int emptySpots = maxCapacity - currentPassengers;
                    if (emptySpots >= passengers){
                        wagons.set(i, currentPassengers + passengers);
                        break;
                    }
                }
            }
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
