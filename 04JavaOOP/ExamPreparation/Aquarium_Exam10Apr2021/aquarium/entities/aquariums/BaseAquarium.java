package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{

    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream()
                .mapToInt(Decoration::getComfort)
                .sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity == this.fish.size()){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }

        String fishWatertype = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if (!this.getClass().getSimpleName().contains(fishWatertype)){
            throw new IllegalStateException(ConstantMessages.WATER_NOT_SUITABLE);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : this.fish){
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        String fishOutput = this.fish.isEmpty()
                ? "none"
                :  this.fish.stream()
                        .map(Fish::getName)
                        .collect(Collectors.joining(" "));
        sb.append(String.format("%s (%s):%n" +
                        "Fish: %s%n" +
                        "Decorations: %d%n" +
                        "Comfort: %d",
                this.name,
                this.getClass().getSimpleName(),
                fishOutput,
                this.decorations.size(),
                calculateComfort()));
        return sb.toString().trim();
    }

    @Override
    public List<Fish> getFish() {
        return this.fish;
    }

    @Override
    public List<Decoration> getDecorations() {
        return this.decorations;
    }
}
