package catLady_09;

public class Cymric extends Cat{

    public Cymric(String name, double specialField){
        super(name, specialField);
    }

    @Override
    public String toString() {
        return "Cymric " + super.toString();
    }
}
