package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
    public static final int CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}
