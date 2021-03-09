package e04FoodShortage;

public class Rebel implements Buyer{
    private static final int INCREASE_FOOD_WITH_FIVE = 5;

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public void buyFood() {
        this.increaseFoodWith(INCREASE_FOOD_WITH_FIVE);
    }

    @Override
    public int getFood() {
        return this.food;
    }

    private void increaseFoodWith(int amount) {
        this.food += amount;
    }
}
