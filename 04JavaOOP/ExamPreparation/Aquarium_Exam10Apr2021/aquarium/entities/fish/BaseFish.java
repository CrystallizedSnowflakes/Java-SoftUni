package aquarium.entities.fish;

import aquarium.common.ExceptionMessages;

public abstract class BaseFish implements Fish{

    private static final int INCREASE_VALUE = 5;

    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }

    private void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException((ExceptionMessages.FISH_PRICE_BELOW_OR_EQUAL_ZERO));
        }
        this.price = price;
    }

    private void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    protected void setSize(int size){
        this.size = size;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.FISH_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void eat() {
        this.size += INCREASE_VALUE;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
