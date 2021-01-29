package catLady_09;

public abstract class Cat {
    private String name;
    private double specialField;

    public Cat(String name, double specialField) {
        this.name = name;
        this.specialField = specialField;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.specialField);
    }
}
