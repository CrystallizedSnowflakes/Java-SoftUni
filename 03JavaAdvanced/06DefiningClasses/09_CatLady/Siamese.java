package catLady_09;

public class Siamese extends Cat{
    public Siamese(String name, double specialField){
        super(name, specialField);
    }

    @Override
    public String toString() {
        return "Siamese " + super.toString();
    }
}
