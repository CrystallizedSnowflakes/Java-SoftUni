package e02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            try {
                switch (tokens[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            System.out.println(car.drive(distance));
                        } else if (tokens[1].equals("Truck")) {
                            System.out.println(truck.drive(distance));
                        } else {
                            System.out.println(bus.drive(distance));
                        }
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            car.refuel(liters);
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(liters);
                        } else {
                            bus.refuel(liters);
                        }
                        break;
                    case "DriveEmpty":
                        distance = Double.parseDouble(tokens[2]);
                        System.out.println(bus.drive(distance));
                        break;
                }
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
