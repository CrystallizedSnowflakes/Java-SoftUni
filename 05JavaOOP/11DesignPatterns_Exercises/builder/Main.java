package builder;

public class Main {
    /** Builder Creational Design Pattern

     https://en.wikipedia.org/wiki/Builder_pattern

     It is used to construct a complex object step by step and the final step will return the object.
     The process of constructing an object should be generic
     so that it can be used to create different representations of the same object. */

     public static void main(String[] args) {

        Car newCar = new Car().withFancyRims(true).withColor("purple").withFancyRims(false);
        System.out.println(newCar.toString());

        Car car = new Car().withElectricCharge(true).withLightsColor("white");
        System.out.println(car);
    }
}
