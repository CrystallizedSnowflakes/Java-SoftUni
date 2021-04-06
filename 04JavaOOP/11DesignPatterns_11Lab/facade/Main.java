package facade;

public class Main {

    /** Facade Structural Design Pattern

     https://en.wikipedia.org/wiki/Facade_pattern

     A facade is an object that serves as a front-facing interface masking more complex underlying or structural code.*/

    public static void main(String[] args) {

        Car car = new CarBuilderFacade()
                .info()
                    .withType("BMW")
                    .withColor("black")
                    .withNumberOfDoors(5)
                .built()
                    .inCity("Munich")
                    .atAddress("Some address 123")
                .build();

        System.out.println(car);
    }
}
