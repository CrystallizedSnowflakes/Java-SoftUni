package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testWhenNotSortedArrayPassedToSortThenArraySortedAsc(){
        int[] array = new int[]{5, 14, -2, 20, 32, 0};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-2, 0, 5, 14, 20, 32};
        assertEquals(array.length, expectedArray.length);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWhenSortedArrayPassedToSortThenSameArray(){
        int[] array = new int[]{-2, 0, 5, 14, 20, 32};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-2, 0, 5, 14, 20, 32};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWhenEmptyArrayPassedToSortThenEmptyArray(){
        int[] array = new int[]{};
        Bubble.sort(array);
        assertEquals(array.length, 0);
    }
}