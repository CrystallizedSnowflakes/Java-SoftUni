package e03ShoppingSpree2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!StringValidator.isNameValid(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (!NumericValidator.isNonNegative(money)) {
            throw new IllegalArgumentException(ConstantMessages.NEGATIVE_VALUE_EXCEPTION_MESSAGE);
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money -= product.getCost();
    }

    @Override
    public String toString() {

        String productsOutput = this.products.isEmpty()
                ? "Nothing bought"
                : this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        return this.getName() + " - " + productsOutput;
    }
}
