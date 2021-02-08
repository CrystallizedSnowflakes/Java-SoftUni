package E11Threeuple;

public class Threeuple<K, V, E> {
    private K firstElement;
    private V secondElement;
    private E thirdElement;

    public Threeuple(K firstElement, V secondElement, E thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstElement, this.secondElement, this.thirdElement);
    }
}
