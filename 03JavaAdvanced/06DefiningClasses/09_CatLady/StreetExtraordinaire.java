package catLady_09;

public class StreetExtraordinaire extends Cat{
    public StreetExtraordinaire(String name, double specialField){
        super(name, specialField);
    }

    @Override
    public String toString() {
        return "StreetExtraordinaire " + super.toString();
    }
}
