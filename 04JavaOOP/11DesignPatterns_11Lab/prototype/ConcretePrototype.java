package prototype;

public class ConcretePrototype extends Prototype{

    public ConcretePrototype(String id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return this.clone();
    }
}
