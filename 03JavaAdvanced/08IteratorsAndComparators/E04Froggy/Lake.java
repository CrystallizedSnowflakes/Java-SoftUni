package E04Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int lastEvenIndex = stones.length % 2 == 0
                    ? stones.length - 2
                    : stones.length - 1;
            @Override
            public boolean hasNext() {
                return index < stones.length;
            }

            @Override
            // jumps
            public Integer next() {
                if (index == lastEvenIndex){
                    int element = stones[lastEvenIndex];
                    index = 1;
                    return element;
                }
                int element = stones[index];
                this.index += 2;
                return element;
            }
        };
    }
}
