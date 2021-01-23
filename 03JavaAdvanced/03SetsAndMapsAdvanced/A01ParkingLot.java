package bg.softuni.javaadvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class A01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Set
        LinkedHashSet<String> plates = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            //String command = input.split(", ")[0];
            //String carNumber = input.split(", ")[1];

            int indexOf = input.indexOf(", ");
            String command = input.substring(0, indexOf);
            String carNumber = input.substring(indexOf + 2);

            switch (command){
                case "IN":
                    plates.add(carNumber);
                    break;
                case "OUT":
                    plates.remove(carNumber);
                    break;
            }

            input =scanner.nextLine();
        }

        if (!plates.isEmpty()) {
            /*for (String carNumber : plates) {
                System.out.println(carNumber);
            }*/
            System.out.println(String.join(System.lineSeparator(), plates));
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
