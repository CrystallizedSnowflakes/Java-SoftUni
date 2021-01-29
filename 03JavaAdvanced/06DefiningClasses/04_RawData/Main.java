package rawData_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        //List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);

            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);

            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);

            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            List<Tire> tires = new LinkedList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            cars.put(model, car);
            //cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                //Cargo Type is "fragile" with a tire whose pressure is  < 1

                cars.values().stream()
                        .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                        .filter(car -> car.getTires().removeIf(tire -> tire.getTirePressure() < 1))
                        .forEach(car -> System.out.println(car.getModel()));

/*                Predicate<List<Tire>> predicate = tires -> {
                    boolean isLowOnPressure = false;
                    for (Tire tire : tires) {
                        if (tire.getTirePressure () < 1) {
                            isLowOnPressure = true;
                            break;
                        }
                    }
                    return isLowOnPressure;
                };

                cars.stream().filter(car -> car.getCargo().getCargoType().equals("fragile"))
                        .filter(car -> predicate.test(car.getTires()))
                        .forEach(car -> System.out.println(car.getModel()));*/

                break;
            case "flamable":
                // Cargo Type is "flamable" and have Engine Power > 250

                cars.values().stream().filter (car -> car.getCargo().getCargoType().equals("flamable"))
                        .filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));

/*                cars.stream().filter (car -> car.getCargo().getCargoType().equals("flamable"))
                        .filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));*/
                break;
        }
    }
}
