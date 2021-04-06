package factory;

public class Main {

    /** Factory Creational Design Pattern

     https://en.wikipedia.org/wiki/Factory_method_pattern

     In Factory pattern, we create object without exposing the creation logic to the client and
     refer to newly created object using a common interface. */

    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(new PizzaFactory());
        pizzeria.orderPizza(PizzaType.CHEESE, 30);
        pizzeria.orderPizza(PizzaType.MEAT, 50);
    }
}
