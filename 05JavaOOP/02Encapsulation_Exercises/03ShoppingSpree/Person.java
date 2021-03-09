package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (!hasEnoughMoney(product)) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

        this.money -= product.getCost();
        this.products.add(product);
    }

    private boolean hasEnoughMoney(Product product) {
        return this.money >= product.getCost();
    }
}
