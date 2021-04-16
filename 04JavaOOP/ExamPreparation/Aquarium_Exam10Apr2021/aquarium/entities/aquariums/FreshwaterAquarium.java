package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }
}
