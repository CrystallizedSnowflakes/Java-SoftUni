package needForSpeed;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(30, 50);
        SportCar sportCar = new SportCar(34.5, 190);
        FamilyCar familyCar = new FamilyCar(25, 100);
        CrossMotorcycle cm = new CrossMotorcycle(50, 250);
        car.drive(10);
        System.out.println(car.getFuel());


        System.out.println(car.getFuelConsumption());
        System.out.println(familyCar.getFuelConsumption());
        System.out.println(sportCar.getFuelConsumption());
    }
}
