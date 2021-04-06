package e01Vehicles;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle{
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance){
        double fuelNeeded = distance * this.fuelConsumption;
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";
        if (this.fuelQuantity >= fuelNeeded){
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }
        return result;
    }


    @Override
    public void refuel(double liters){
        this.fuelQuantity += liters;
    }

    // reflection allows inspection of classes, interfaces, fields and methods at runtime
    // without knowing the names of the interfaces, fields, methods at compile time.
    // It also allows instantiation of new objects and invocation of methods.
    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity); // reflection
    }
}
