package garage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    //TODO: Test Garage class

    private Garage garage;
    private Car car;

    @Before
    public void setUp(){
        this.garage = new Garage();
        this.car = new Car("Ford", 220, 25000.00);
    }

    // getCars test unmodifiableList
    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsByModifyingTheMapShouldThrowEx(){
        this.garage.getCars().add(null);
    }

    //getCount
    @Test
    public void testGetCountShouldWorkProperly(){
        this.garage.addCar(car);
        int count = this.garage.getCount();
        assertEquals(1, count);
    }

    // findAllCarsWithMaxSpeedAbove
    @Test
    public void testFindAllCarsWithMaxSpeedAboveWorkProperly(){
        this.garage.addCar(car);
        List<Car> allCarsWithMaxSpeedAbove = this.garage.findAllCarsWithMaxSpeedAbove(100);
        assertEquals(1, allCarsWithMaxSpeedAbove.size());
    }

    //addCar
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCarShouldThrowEx(){
        this.garage.addCar(null);
    }

    //getTheMostExpensiveCar
    @Test
    public void testGetTheMostExpensiveCarWorkProperly(){
        Car car2 = new Car("Lamborghini", 450, 300000.00);
        this.garage.addCar(car);
        this.garage.addCar(car2);
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();
        double actual = theMostExpensiveCar.getPrice();
        assertEquals(300000.00, actual, 0.00);
    }

    //findAllCarsByBrand
    @Test
    public void testFindAllCarsByBrandWorkProperly(){
        Car car2 = new Car("Lamborghini", 450, 300000.00);
        Car car3 = new Car("Ford", 130, 25000.00);
        this.garage.addCar(car);
        this.garage.addCar(car2);
        this.garage.addCar(car3);
        List<Car> fordCars = this.garage.findAllCarsByBrand(car.getBrand());
        assertEquals(2, fordCars.size());
        List<Car> LamborghiniCars = this.garage.findAllCarsByBrand(car2.getBrand());
        assertEquals(1, LamborghiniCars.size());
    }
}