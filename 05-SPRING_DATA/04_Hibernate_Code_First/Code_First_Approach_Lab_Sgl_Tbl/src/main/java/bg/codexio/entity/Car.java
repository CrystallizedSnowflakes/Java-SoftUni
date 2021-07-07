package bg.codexio.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "car")
public class Car extends PassengerVehicle{

    private String model;

    public Car() {
    }

    public Car(int numOfPassengers, String model, String ownerName) {
        super("CARS", numOfPassengers, ownerName);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
