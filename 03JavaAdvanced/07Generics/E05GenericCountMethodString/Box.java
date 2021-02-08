package E05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element){
        this.values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public void swap(int firstIndex, int secondIndex) {
        validateIndexes(firstIndex, secondIndex);
        T firstElement = this.values.get(firstIndex);
        T secondElement = this.values.get(secondIndex);

        values.add(firstIndex, secondElement);
        this.values.remove(firstIndex + 1);
        values.add(secondIndex, firstElement);
        this.values.remove(secondIndex + 1);
    }

    public int getLength(){
        return this.values.size();
    }

    private void validateIndexes(int index1, int index2){
        if (index1 > this.values.size() || index2 > this.values.size()){
            throw new IndexOutOfBoundsException("Invalid indexes!");
        } else if (index1 < 0 || index2 < 0){
            throw new IllegalArgumentException("Negative indexes!");
        }
    }

    public int countGreaterThan(T element){
        int count = (int)this.values.stream().filter(e -> e.compareTo(element) > 0).count();
        return count;
    }
}
