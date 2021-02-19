package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(Rabbit rabbit){
        if (this.capacity > this.data.size()){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species){
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
/*        List<Rabbit> soldRabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                soldRabbits.add(rabbit);
            }
        }
        this.data.removeIf(r -> r.getSpecies().equals(species));
        return soldRabbits;*/

        Predicate<Rabbit> filter = rabbit -> rabbit.getSpecies().equals(species);
        data.stream()
                .filter(filter)
                .forEach(rabbit -> rabbit.setAvailable(false));

        return data.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("Rabbits available at %s:", this.name))
                .append(System.lineSeparator());
        data.stream().filter(Rabbit::isAvailable)
                .forEach(rabbit -> sb.append(rabbit).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
