package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (this.data.size() < capacity){
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model));
    }

    public Car getLatestCar(){
        return this.data.stream()
                .sorted((f, s) -> Integer.compare(s.getYear(), f.getYear()))
                .findFirst()
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) &&
                    car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder(String.format("The cars are in a car dealership %s:", this.name))
                .append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
