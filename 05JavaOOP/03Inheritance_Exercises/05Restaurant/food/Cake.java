package restaurant.food;

import java.math.BigDecimal;

public class Cake extends Dessert {
    final static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);
    final static double CAKE_GRAMS = 250;
    final static double CAKE_CALORIES = 1000;

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
