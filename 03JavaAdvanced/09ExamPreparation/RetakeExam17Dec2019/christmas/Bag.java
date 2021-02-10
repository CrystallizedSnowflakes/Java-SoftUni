package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor(){
        return this.color;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int count(){
        return this.data.size();
    }

    public void add(Present present){
        if (this.data.size() < capacity){
            this.data.add(present);
        }
    }

    public boolean remove(String name){
        return this.data.removeIf(present -> present.getName().equals(name)); // true
    }

    public Present heaviestPresent(){
        Present heaviestOne = this.data.stream()
                .sorted((f, s) -> Double.compare(s.getWeight(), f.getWeight()))
                .findFirst()
                .orElse(null);

        return heaviestOne;
    }

    public Present getPresent(String name){
        Present presentByName = null;
        for (Present present : this.data) {
            if (present.getName().equals(name)){
                presentByName = present;
                break;
            }
        }
        return presentByName;
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:", this.color))
                .append(System.lineSeparator());
        for (Present present : this.data) {
            sb.append(present).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
