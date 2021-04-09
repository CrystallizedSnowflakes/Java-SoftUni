package carTrip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS CAR
    private Car car;

    @Before
    public void setUp(){
        this.car = new Car("Ford", 50.50, 10.50, 1.5);
    }

    //getModel
    @Test
    public void testGetModelWorkProperly(){
        String actual = this.car.getModel();
        assertEquals("Ford", actual);
    }

    //setModel
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullModelShouldThrowEx(){
        this.car.setModel(null);
    }

    @Test
    public void testSetModelWorkProperly(){
        this.car.setModel("Renault");
        assertEquals("Renault", this.car.getModel());
    }

    //getTankCapacity
    @Test
    public void testGetTankCapacityWorkProperly(){
        double tankCapacity = this.car.getTankCapacity();
        assertEquals(50.50, tankCapacity, 0.00);
    }

    //setTankCapacity
    @Test
    public void testSetTankCapacityWorkProperly(){
        this.car.setTankCapacity(100.50);
        assertEquals(100.50, this.car.getTankCapacity(), 0.00);
    }

    //getFuelAmount
    @Test
    public void testGetFuelAmountWorkProperly(){
        double fuelAmount = this.car.getFuelAmount();
        assertEquals(10.50, fuelAmount, 0.00);
    }

    //setFuelAmount
    @Test(expected = IllegalArgumentException.class)
    public void testSetMoreFuelAmountThanCapacityShouldThrowEx(){
        this.car.setFuelAmount(60.50);
    }

    @Test
    public void testSetLessFuelAmountThanCapacityWorkProperly(){
        this.car.setFuelAmount(40.50);
        assertEquals(40.50, this.car.getFuelAmount(), 0.00);
    }

    //getFuelConsumptionPerKm
    @Test
    public void testGetFuelConsumptionPerKmWorkProperly(){
        double fuelConsumptionPerKm = this.car.getFuelConsumptionPerKm();
        assertEquals(1.5, fuelConsumptionPerKm, 0.00);
    }

    //setFuelConsumptionPerKm
    @Test(expected = IllegalArgumentException.class)
    public void testSetZeroFuelConsumptionPerKmShouldThrowEx(){
        this.car.setFuelConsumptionPerKm(0);
    }

    @Test
    public void testSetFuelConsumptionPerKmWorkProperly(){
        this.car.setFuelConsumptionPerKm(3.00);
        assertEquals(3.00, this.car.getFuelConsumptionPerKm(), 0.00);
    }

    //drive
    @Test(expected = IllegalStateException.class)
    public void testDriveDistanceWithNotEnoughFuelAmountShouldThrowEx(){
        int distance = 10;
        this.car.drive(distance);
    }

    @Test
    public void testDriveDistanceWorkProperly(){
        this.car = new Car("Toyota", 250, 250, 0.50);
        int distance = 100;
        String message = this.car.drive(distance);
        double fuelAmount = this.car.getFuelAmount();
        assertEquals(200, fuelAmount, 0.00);
        assertEquals("Have a nice trip", message);
    }

    //refuel
    @Test(expected = IllegalStateException.class)
    public void testRefuelMoreThanTankCapacityShouldThrowEx(){
        this.car.refuel(50);
    }

    @Test
    public void testRefuelWithNoMoreThanTankCapacityWorkProperly(){
        this.car.refuel(20);
        assertEquals(30.50, this.car.getFuelAmount(), 0.00);
    }
}