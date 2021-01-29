package speedRacing_03;

public class Car {
    private final String model;
    private double fuel;
    private final double fuelCostPerKm;
    private int distance;

    public Car(String model, double fuel, double fuelCostPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distance = 0;
    }


    public boolean drive(int distanceToDrive) {
        double neededFuelForTheDistance = distanceToDrive * this.fuelCostPerKm;
        if (neededFuelForTheDistance <= this.fuel){
            this.distance += distanceToDrive;
            this.fuel -= neededFuelForTheDistance;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
