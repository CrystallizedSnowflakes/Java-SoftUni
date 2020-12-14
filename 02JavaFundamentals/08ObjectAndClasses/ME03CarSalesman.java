package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < linesOfEngines; i++) {
            String line = scanner.nextLine();
            Engine engine = Engine.parseEngine(line);
            engines.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String line = scanner.nextLine();
           //Car car = Car.parseCar(line);
           // cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    public static class Car{
        String model;
        Engine engine;
        String weight;
        String color;

        public Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }

/*        public static Car parseCar(String text){
            String[] input = text.split("\\s+");

            String model = input[0];
            String currentEngineModel = input[1];

            String weight = "n/a";
            String color = "n/a";

            if (input.length == 3){
                weight = input[2];
            }else if (input.length == 4){
                weight = input[2];
                color = input[3];
            }
            return new Car(model, engine, weight, color);
        }*/

        @Override
        public String toString() {
            return this.model + ":" +"\n"+ String.format("%s" +
                    "  Weight: %s%n" +
                    "  Color: %s",this.engine,this.weight,this.color);
        }
    }

    public static class Engine{
        private String engineModel;
        private String power;
        private String displacement;
        private String efficiency;

        public Engine(String engineModel, String power, String displacement, String efficiency) {
            this.engineModel = engineModel;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public Engine(String engineModel){
            this.engineModel = engineModel;
        }

        public static Engine parseEngine(String text){
            String[] input = text.split("\\s+");
            String engineModel = input[0];
            String power = input[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (input.length == 3){
                displacement = input[2];
            }else if(input.length == 4){
                displacement = input[2];
                efficiency = input[3];
            }
            return new Engine(engineModel, power, displacement, efficiency);
        }

        @Override
        public String toString() {
            return "  " + this.engineModel + ":" + "\n"+String.format(
                    "    Power: %s%n" +
                            "    Displacement: %s%n" +
                            "    Efficiency: %s%n", this.power, this.displacement, this.efficiency);
        }

        public String getModel() {
            return engineModel;
        }

        public String getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setModel(String model) {
            this.engineModel = model;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }
}
