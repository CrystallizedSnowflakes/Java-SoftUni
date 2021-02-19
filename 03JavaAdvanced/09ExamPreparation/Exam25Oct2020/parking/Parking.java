package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (this.data.size() < capacity){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar(){
        return this.data.stream()
                .sorted((f, s) -> Integer.compare(s.getYear(), f.getYear()))
                .findFirst()
                .orElse(null);

        //return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getLatestCar2() {
        Car result = null;
        for (Car car : data) {
            if (result == null || result.getYear() < car.getYear()) {
                result = car;
            }
        }
        return result;
    }

    public Car getCar(String manufacturer, String model){
        Car carByManufacturerAndModel = null;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                carByManufacturerAndModel = car;
                break;
            }
        }
        return carByManufacturerAndModel;
    }

    public Car getCar2(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder(String.format("The cars are parked in %s:", this.type))
                .append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
